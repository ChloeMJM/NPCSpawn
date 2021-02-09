package com.example.npcspawn;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;



public class ViewNPCActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_npc);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<NPCModelClass> npcModelClasses = databaseHelperClass.getNPCList();

        if (npcModelClasses.size() > 0) {
            NPCAdapterClass npcadapterclass = new NPCAdapterClass(npcModelClasses, ViewNPCActivity.this);
            recyclerView.setAdapter(npcadapterclass);
        } else {
            Toast.makeText(this, "There is no NPC in the database", Toast.LENGTH_SHORT).show();
        }
    }

}

