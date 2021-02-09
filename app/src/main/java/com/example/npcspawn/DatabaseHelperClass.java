package com.example.npcspawn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "c_database";
    // Database Table name
    private static final String TABLE_NAME = "NPC";
    // Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String RACE = "race";
    public static final String GENDER = "gender";
    public static final String AGE = "age";
    public static final String PERSQUIRK = "persquirk";
    public static final String PHYSQUIRK = "physquirk";
    public static final String PLOT = "plot";

    private SQLiteDatabase sqLiteDatabase;

    // Create the table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+RACE+" TEXT NOT NULL," +
            ""+GENDER+" TEXT NOT NULL,"+AGE+" TEXT NOT NULL,"+PERSQUIRK+" TEXT NOT NULL,"+PHYSQUIRK+" TEXT NOT NULL,"+PLOT+" TEXT NOT NULL);";
    // Database Constructor
    public DatabaseHelperClass(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add NPC Data
    public void addNPC(NPCModelClass npcModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME, npcModelClass.getName());
        contentValues.put(DatabaseHelperClass.RACE, npcModelClass.getRace());
        contentValues.put(DatabaseHelperClass.GENDER, npcModelClass.getGender());
        contentValues.put(DatabaseHelperClass.AGE, npcModelClass.getAge());
        contentValues.put(DatabaseHelperClass.PERSQUIRK, npcModelClass.getPersquirk());
        contentValues.put(DatabaseHelperClass.PHYSQUIRK, npcModelClass.getPhysquirk());
        contentValues.put(DatabaseHelperClass.PLOT, npcModelClass.getPlot());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
    }

    public List<NPCModelClass> getNPCList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<NPCModelClass> storeNPC = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String race = cursor.getString(2);
                String gender = cursor.getString(3);
                String age = cursor.getString(4);
                String persquirk = cursor.getString(5);
                String physquirk = cursor.getString(6);
                String plot = cursor.getString(7);

                storeNPC.add(new NPCModelClass(id,name,race,gender,age,persquirk,physquirk,plot));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeNPC;
    }

    // Update the NPC in the database
    public void updateNPC(NPCModelClass npcModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME,npcModelClass.getName());
        contentValues.put(DatabaseHelperClass.RACE,npcModelClass.getRace());
        contentValues.put(DatabaseHelperClass.GENDER,npcModelClass.getGender());
        contentValues.put(DatabaseHelperClass.AGE,npcModelClass.getAge());
        contentValues.put(DatabaseHelperClass.PERSQUIRK,npcModelClass.getPersquirk());
        contentValues.put(DatabaseHelperClass.PHYSQUIRK,npcModelClass.getPhysquirk());
        contentValues.put(DatabaseHelperClass.PLOT,npcModelClass.getPlot());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(npcModelClass.getId())});
    }

    // Delete NPC from database
    public void deleteNPC(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }
}