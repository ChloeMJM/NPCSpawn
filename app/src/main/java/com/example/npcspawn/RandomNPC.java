package com.example.npcspawn;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class RandomNPC extends AppCompatActivity {


    EditText editText_name,editText_race, editText_gender, editText_age,
            editText_persquirk, editText_physquirk, editText_plot;
    Button button_add,button_view;

    Context context;


    /* Arrays to hold previous and current values of all variables for the back button.
       Each index correlates to one of the randomizer functions in this order:
       [First Name][Last Name][Race][Gender][Age][PersQuirk][PhysQuirk][Plot] */
    String[] backArrayCurr = new String[8];
    String[] backArrayPrev= new String[8];

    // Used to create a flag for when the Generate All button is pressed (genAll function).
    boolean genAllPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_n_p_c);

        editText_name = findViewById(R.id.edittext_name);
        editText_race = findViewById(R.id.edittext_race);
        editText_gender = findViewById(R.id.edittext_gender);
        editText_age = findViewById(R.id.edittext_age);
        editText_persquirk = findViewById(R.id.edittext_persquirk);
        editText_physquirk = findViewById(R.id.edittext_physquirk);
        editText_plot = findViewById(R.id.edittext_plot);

        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        // Add button. OnClick will add an NPC to the database
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringRace = editText_race.getText().toString();
                String stringGender = editText_gender.getText().toString();
                String stringAge = editText_age.getText().toString();
                String stringPersquirk = editText_persquirk.getText().toString();
                String stringPhysquirk = editText_physquirk.getText().toString();
                String stringPlot = editText_plot.getText().toString();

                // If empty, sends message to user
                if (stringName.length() <=0 ){
                    Toast.makeText(context, "Please enter a name.", Toast.LENGTH_SHORT).show();
                }
                else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(RandomNPC.this);

                    NPCModelClass npcModelClass = new NPCModelClass(stringName,stringRace,stringGender,stringAge,
                            stringPersquirk, stringPhysquirk, stringPlot);

                    databaseHelperClass.addNPC(npcModelClass);
                    Toast.makeText(RandomNPC.this, "Added NPC Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        // View Button OnClick will open the ViewNPCActivity
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RandomNPC.this ,ViewNPCActivity.class);
                startActivity(intent);
            }
        });
    }

    //For random number generation
    Random rand = new Random();

    //Two random numbers
    int rNum = 0;
    int rNum2 = 0;

    //First name options. Count 100
    String[] name = {"Bob", "Jan", "Andari", "Fred", "Anya", "Chloe", "Aragona", "Alcid", "Baldi", "Ralph",
            "Bennis", "Bolin", "Bosa", "Brogan", "Byrne", "Cai", "Chelatar", "Colvin", "Croto", "Coren",
            "Dees", "Domoff", "Driggs", "Dushaya", "Elga", "Ermi", "Esra", "Finlay", "Fama", "Feek",
            "Frisk", "Galis", "Gavin", "Gotti", "Gwin", "Hina", "Hale", "Horak", "Ina", "Jabro",
            "Jaya", "Joslin", "Kali", "Korbin", "Kosla", "Kyra", "Leif", "Lew", "Luri", "Luka",

            "Maja", "Mears", "Merle", "Manuk", "Mashon", "Nem", "Nima", "Nack", "Nyst", "Odell",
            "Obra", "Ossa", "Orin", "Pall", "Pepin", "Quist", "Rishi", "Rev", "Rowan", "Rok",
            "Sabin", "Sada", "Shain", "Saul", "Talos", "Tamsin", "Tany", "Tomie", "Taya", "Tulin",
            "Uri", "Ula", "Valo", "Voris", "Vlad", "Vlada", "Zana", "Zell", "Mae", "Dian",
            "Fenton", "Axim", "Ortos", "Katya", "Hazel", "Pippi", "Niko", "Aaro", "Glorianna", "Luke"
    };

    //Last name options. Count 100
    String[] lName = {"Baker", "Ales", "Appletree", "Browne", "Barr", "Byggs", "Coates", "Frost", "Furrs", "Berry",
            "Berryman", "Dunes", "Beans", "Barnes", "Canyon", "Blacksky", "Redsky", "Beanstalk", "Blooms", "Fox",
            "Nyberg", "Hills", "Gray", "Brewer", "Hardy", "Hill", "Hopper", "Butcher", "Hunter", "Icewind",
            "Cotton", "Moon", "Palmer", "Gardner", "Glimmerian", "Fields", "Redd", "Rider", "Northman", "Kettles",
            "Rock", "Sands", "Miller", "Pickles", "Silver", "Greene", "Smalls", "Singer", "Stone", "Peppers",

            "Snow", "Star", "Grovemen", "Sunn", "Strider", "Potts", "Henman", "White", "Winters", "Meadows",
            "Slaughter", "Simms", "Salt", "Landers", "Oats", "Peabody", "Rains", "Shepherd", "Root", "Tate",
            "Vines", "Winnows", "Yards", "Arch", "Beacher", "Bolte", "Button", "Builder", "Bolder", "Blue",
            "Crest", "Crab", "Bricks", "Cole", "Coleman", "Fisher", "Hatter", "Glover", "Mast", "Digger",
            "Shellman", "Hoards", "Waterman", "Bellows", "Copper", "Bowman", "Isles", "Poundstone", "Shields", "Helms"
    };

    //Race options. Count 25
    String[] race = {
            "Human", "Orc", "Half-Orc", "Elf", "Half-elf", "Halfling", "Tiefling", "Dwarf", "Centaur", "Firbolg",
            "Tabaxi", "Dragonborn", "Drow", "Gnoll", "Gnome", "Goblin", "Lizardfolk", "Merfolk", "Aasimar", "Goliath",
            "Genasi", "Kenku", "Triton", "Yuan-Ti", "Duergar"
    };

    //Gender options. Count 10. Duplicates added in to increase likelihood.
    String[] gender = {
            "Male", "Female", "Non-Binary", "Gender-Fluid", "Male", "Female", "Male", "Female", "Male", "Female"
    };

    //Age options. Count 10
    String[] age = {
            "Child", "Young", "Teen", "Teen", "Adult", "Adult", "Adult", "Old", "Old", "Very old"
    };

    //Personality quirk options. Count 110
    String[] persquirk = {
            //Loves
            "Loves Elves", "Loves Humans", "Loves Orcs", "Loves Half-Orcs", "Loves Half-elves",
            "Loves Halflings", "Loves Tieflings", "Loves Dwarves", "Loves Tabaxi", "Loves Dragonborns",
            "Loves Drows", "Loves Gnomes", "Loves Goblins", "Loves Lizardfolk", "Loves Merfolk",
            "Loves Aasimar", "Loves Kenku", "Loves a good bourbon.", "Loves a good story.", "Loves a nice steak.",
            //Hates
            "Hates Elves", "Hates Humans", "Hates Orcs", "Hates Half-Orcs", "Hates Half-elves",
            "Hates Halflings", "Hates Tieflings", "Hates Dwarves", "Hates Tabaxi", "Hates Dragonborns",
            "Hates Drows", "Hates Goblins", "Hates Lizardfolk", "Hates Merfolk", "Hates Aasimar",
            "Hates Goliaths", "Hates Kenku", "Hates Yuan-Ti", "Hates loud people.", "Hates being corrected.",
            //Unique
            "Refuses to wear shoes.", "Refuses to wear a shirt", "Obsessed with cats.", "Obsessed with dogs.", "Obsessed with money.",
            "Obsessed with feet.", "Obsessed with food.", "Vegetarian", "Vegan", "Likes turtles.",
            "Has a lisp.", "Has a stutter.", "Really loves their mom.", "Afraid of the dark.", "Extremely rude.",
            "Germophobe.", "Afraid of spiders.", "Is a beekeeper.", "Is a trapeze artist.", "Is a world class wrestler.",
            "Is an arm wrestling champion.", "Is a master juggler.", "Reads fortunes for a price.", "Reads palms for a price.", "Lies constantly.",

            "Seems crazy.", "Seems off.", "Never lies.", "Extremely religious.", "Hates religious folk.",
            "Loves to talk about their cats.", "Uses way too much fingerguns.", "Overtly sexual.", "Starts all sentences with 'like.'", "Ends all sentences with 'you know?'",
            "Talks in a whisper.", "Laughs awkwardly. Constantly.", "Talks way too fast.", "Talks painfully slow.", "Way too excited about life.",
            "Seems depressed.", "Obvious hoarder.", "Acts like a child.", "Extremely vain.", "Has very low self-esteem.",
            "Seems nervous.", "Afraid of small spaces.", "Afraid of water.", "Afraid of dolls.", "Hard of hearing.",

            "Acts like a Bro.", "Is an obsessive gambler and will never turn down a bet.", "Perfectionist.", "Bisexual.", "Homosexual.",
            "Asexual.", "Pansexual.", "Very aggressive.", "Very non-materalistic.", "Cannot keep a secret.",
            "Atheist.", "Plays a mean game of poker.", "They love to spy on other people", "Really bad at math.", "Very quick to trust people.",
            "They think everyone else is an idiot.", "Refuses to speak common.", "They are a constant traveler.", "They have a crude sense of humor.", "Reacts violently to drinking.",

            "Hates anyone looking better than them.", "Super impressionable meathead.", "Pretends to be of the noble class."
    };

    //Physical quirk options. Count 115
    String[] physquirk = {
            "Walks with a limp.", "Lazy left-eye.", "Lazy right-eye.", "Blind in left eye.", "Blind in right eye.",
            "Has white streak of hair.", "Missing left eye.", "Missing right eye.", "Missing front teeth.", "Has nose piercing.",
            "Has numerous piercings.", "Has a dragon tattoo on arm.", "Has a dragon tattoo on face.", "Has a tattoo that says MOMMY on neck.", "Has a tattoo that says DADDY on neck.",
            "Has a skull tattoo on arm", "Has a skull tattoo on chest.", "Has a tattoo that says LITCH4LYFE on forehead", "Has a tattoo that says FIGHT ME on forehead.", "Has a peg leg.",
            "Has two peg legs.", "Is missing their right hand.", "Is missing their left hand.", "Majorly balding", "Slightly balding and tries to cover it up with a hat.",

            "Slightly balding and tries to cover it up with a scarf", "Sounds like PeeWee Herman", "Sounds like Fran Drescher", "Sounds like Vin Diesel", "Sounds like Gilbert Godfrey",
            "Laughs like Fran Drescher", "Mole on left cheek.", "Mole on right cheek.", "Smells awful.", "Has a lisp.",
            "Has a stutter.", "Deaf", "Mute", "Blind", "Colorblind",
            "Morbidly obese.", "Extremely thin.", "Stumbles when walks.", "Has a nervous eye twitch.", "Smells intoxicating.",
            "Has an amazing mohawk.", "Has an amazing faux-hawk.", "Has an amazing soul-patch.", "Has an amazing mullet.", "Has an amazing moustache.",

            "Has an amazing beard.", "Has really long nails.", "Has piercing red eyes.", "Has piercing blue eyes.", "Has a really large nose.",
            "Has an extreme amount of chest hair.", "Extremely hairy.", "Has a huge unibrow.", "Has no eyebrows.", "Has pointed teeth.",
            "Has a tail uncharacteristic of their race and is very sensitive about it.", "Has an extra finger and is very sensitive about it.", "Has a secret third nipple.", "Has an extra toe and is very sensitive about it.", "Has a Hitler moustache.",
            "Has blue hair.", "Has a really bad dandruff problem.", "Has a mouse living in the disgusting mess of hair on their head.", "Farts when they walk.", "Has really bad breath.",
            "Wheezes in between words while speaking.", "Is unbelievably gorgeous.", "Has a burn scar over half their face.", "Their hips don't lie.", "Wears very thick spectacles.",

            "Has an exceptional butt and knows it.", "Has noticeably large ears.", "Has a large scar on their chest.", "Itches constantly due to a scabies infestation.", "Their voice is extremely monotone.",
            "Has very poor eyesight.", "Very stout.", "Has trouble keeping eye contact.", "Is a hunchback.", "Has a large gut.",
            "Shuffles when they walk.", "Walks very softly.", "Walks very loudly.", "Has a very hoarse voice.", "Has a buzz-cut.",
            "Talks extremely loudly.", "Extremely muscular.", "Very pretty.", "Has a contagious disease that is transferred by touch.", "Extremely dirty.",
            "Dresses in all white.", "Dresses in all black.", "Looks extremely clean.", "Has a bald head.", "Has no hair on their body.",

            "Walks on their hands like a chimpanzee.", "Has a hook for a hand.", "Smells awful.", "Has very small hands and is very insecure about it.", "Has very full lips.",
            "Has large boobs.", "Wears clothes that may be opposite of their gender.", "Covered in gold jewelry.", "Is wearing very revealing clothing.", "They cannot feel pain.",
            "Has a voice like Morgan Freeman.", "Allergic to Humans.", "Has scars covering their hands.", "Has a wiry neckbeard.", "Their eyes are too far apart."

    };

    //Plot hook options. Count 75
    String[] plot = {
            "None.", "None.", "None.", "None.", "None.",
            "None.", "None.", "None.", "None.", "None.",
            "None.", "None.", "None.", "None.", "None.",
            "None.", "None.", "None.", "None.", "None.",
            "None.", "None.", "None.", "None.", "None.",

            "Undercover spy for the government.",
            "Undercover spy for the local religious officials.",
            "Undercover spy for the BBEG.",
            "Part of an underground militia.",
            "Part of a secret cult that sacrifices virgins.",

            "Part of a secret cult that worships the BBEG.",
            "Part of a secret cult that abducts villagers for slaves.",
            "Looking for lost sister.",
            "Looking for lost brother.",
            "Is an orphan and looking for their parents.",

            "Lives in a haunted house and needs help getting rid of a ghost. (MM, pg. 147)",
            "Unknown to them, they are being fed off of by a VAMPIRE at night. Very tired and pale looking. (MM, pg. 297)",
            "Their farm is being attacked by a SHAMBLING MOUND and they need help killing it. (MM, pg. 270)",
            "They recently found the graves of their ancestors dug out and are worried. They've risen as SKELETONS. (MM, pg. 272)",
            "Late at night they've been seeing lights in the woods by their house. Woods are infested with WILL-O-WISP. (MM, pg. 301)",

            "Unknown to them, they are possessed by a DEMON. They will try to lead the players to its layer. (MM, pg. 50)",
            "They wear a beautiful hat that can be bought for the right price. It is a mimic that has grown to like the NPC. (MM, pg. 220)",
            "They know where to find a unicorn and have been blabbing about it to everyone. No one believes them, but it is true. (MM, pg. 293)",
            "They need virginal blood and will pay very well for it.",
            "They know where to find an entrance to the Underdark.",

            "They will sell the players a map to a dragon's treasure for a large sum. It is 100% fake.",
            "They work for the drow and will attempt to lure the players to a cave for kidnapping.",
            "They have been cursed and can no longer speak. Will pay well for curse removal.",
            "They are on the run from the law. The players may notice they are standing right next to a wanted poster.",
            "They are on the run from an abusive partner.",

            "They have been challenged to a duel to the death at noon that they don't think they'll survive.",
            "They are in need of protection from a gang of miscreants.",
            "They are in need of the blood of an OwlBear to complete a ritual.",
            "Their blood is as effective as a potion of greater healing.",
            "They are the local drug dealer.",

            "They will give the PCs a magical axe in exchange for 50GP. The axe was owned by the town mayor who will stop at nothing to get it back.",
            "They are a local wrestling hero and are organizing a fight tonight.",
            "They are in possession of a special ring that they need delivered to the local clergy.",
            "They are missing their cat, Ser Pounce, and will pay heavily if he can be found. Ser Pounce is actually a druid that does not wish to be found.",
            "They are a serial killer by the name of The Tavern Butcher.",

            "Their house recently collapsed upon itself. Beneath it can be found an entrance to the Underdark.",
            "Their spouse has recently turned into a zombie and they are keeping them tied up in their room. If the NPCs don't interfere, they will get loose.",
            "They have nothing left to lose and will challenge a PC to a fight to the death.",
            "They have recently obtained a treasure map and will let it go for 100GP. It leads to nothing.",
            "They have recently obtained a treasure map and will let it go for 100GP. It leads to a chest of treasure buried under a lake.",

            "They are actually a doppleganger pretending to be the person they say they are.",
            "If they get upset they will accidentally create magic as if they rolled on the Sorcerer's wild magic table.",
            "They are patient zero of a horrible plague.",
            "They are secretly killing people in order to feed them to their pet wyvern.",
            "They mumble incoherently before suddenly dropping dead. They have been poisoned.",

            "They were tricked into wearing a cursed bracelet that makes them a constant kleptomaniac.",
            "They are a professional axe thrower and will challenge anyone to a competition.",
            "They are secretly a vigilante for good.",
            "They have discovered a secret passage in the woods leading to a cave system.",
            "They are a time traveler from the future.",

            "They are secretly killing people and feeding them to their giant plant.",
            "They believe they are the God Emperor.",
            "They are a worthless drunk whose only goal in life is to get to the next tavern.",
            ""

    };

    // Linked to back button. Will revert Strings to previous value.
    public void back(View v) {


            TextView tvName = findViewById(R.id.edittext_name);
            TextView tvRace = findViewById(R.id.edittext_race);
            TextView tvGender = findViewById(R.id.edittext_gender);
            TextView tvAge = findViewById(R.id.edittext_age);
            TextView tvPersquirk = findViewById(R.id.edittext_persquirk);
            TextView tvPhysquirk = findViewById(R.id.edittext_physquirk);
            TextView tvPlot = findViewById(R.id.edittext_plot);
            // Sets each TextView to the previous value from the array holding previous values.
            tvName.setText(backArrayPrev[0] + " " + backArrayPrev[1]);
            tvRace.setText(backArrayPrev[2]);
            tvGender.setText(backArrayPrev[3]);
            tvAge.setText(backArrayPrev[4]);
            tvPersquirk.setText(backArrayPrev[5]);
            tvPhysquirk.setText(backArrayPrev[6]);
            tvPlot.setText(backArrayPrev[7]);

            // Moves previous value to the current value at each index.
            backArrayCurr[0] = backArrayPrev[0];
            backArrayCurr[1] = backArrayPrev[1];
            backArrayCurr[2] = backArrayPrev[2];
            backArrayCurr[3] = backArrayPrev[3];
            backArrayCurr[4] = backArrayPrev[4];
            backArrayCurr[5] = backArrayPrev[5];
            backArrayCurr[6] = backArrayPrev[6];
            backArrayCurr[7] = backArrayPrev[7];

    }

    /* Used in individual generator functions to lock in all variables in case of
        individual rerolls. Forces only the last rerolled variable to roll back
        if back button is pressed. */
    public void currToPrev(View v) {
        backArrayPrev[0] = backArrayCurr[0];
        backArrayPrev[1] = backArrayCurr[1];
        backArrayPrev[2] = backArrayCurr[2];
        backArrayPrev[3] = backArrayCurr[3];
        backArrayPrev[4] = backArrayCurr[4];
        backArrayPrev[5] = backArrayCurr[5];
        backArrayPrev[6] = backArrayCurr[6];
        backArrayPrev[7] = backArrayCurr[7];
    }

    //Generate random name
    public void genName(View v){
        TextView tvName = findViewById(R.id.edittext_name);

        // Supplies 2 random numbers out of 100 for first name(name) and last name(lname)
        int rNum = rand.nextInt(100);
        int rNum2 = rand.nextInt(100);
        tvName.setText(name[rNum] + " " + lName[rNum2]);

        // In case only this variable is rerolled. Locks in all variables.
        if (genAllPressed == false) {
            currToPrev(v);
        }
        // In case Generate All button is pressed (genAll function)
        else {
            backArrayPrev[0] = backArrayCurr[0];
            backArrayPrev[1] = backArrayCurr[1];
        }

        // Stores newly generated random values in the current array.
        backArrayCurr[0] = name[rNum];
        backArrayCurr[1] = lName[rNum2];

    }

    //Generate random race
    public void genRace(View v)
    {
        TextView tvRace = findViewById(R.id.edittext_race);

        int rNum = rand.nextInt(25);
        tvRace.setText(race[rNum]);

        // In case only this variable is rerolled. Locks in all variables.
        if (genAllPressed == false) {
            currToPrev(v);
        }
        // In case Generate All button is pressed (genAll function)
        else {
            backArrayPrev[2] = backArrayCurr[2];
        }
        backArrayCurr[2] = race[rNum];
    }

    //Generate random gender
    public void genGender(View v)
    {
        TextView tvGender = findViewById(R.id.edittext_gender);

        int rNum = rand.nextInt(10);
        tvGender.setText(gender[rNum]);

        // In case only this variable is rerolled. Locks in all variables.
        if (genAllPressed == false) {
            currToPrev(v);
        }
        // In case Generate All button is pressed (genAll function)
        else {
            backArrayPrev[3] = backArrayCurr[3];
        }

        backArrayCurr[3] = gender[rNum];
    }

    //Generate random age
    public void genAge(View v)
    {
        TextView tvAge = findViewById(R.id.edittext_age);

        int rNum = rand.nextInt(10);
        tvAge.setText(age[rNum]);

        // In case only this variable is rerolled. Locks in all variables.
        if (genAllPressed == false) {
            currToPrev(v);
        }
        // In case Generate All button is pressed (genAll function)
        else {
            backArrayPrev[4] = backArrayCurr[4];
        }
        backArrayCurr[4] = age[rNum];
    }

    //Generate random personality quirk
    public void genPersquirk(View v)
    {
        TextView tvPersquirk = findViewById(R.id.edittext_persquirk);

        int rNum = rand.nextInt(110);
        tvPersquirk.setText(persquirk[rNum]);

        // In case only this variable is rerolled. Locks in all variables.
        if (genAllPressed == false) {
            currToPrev(v);
        }
        // In case Generate All button is pressed (genAll function)
        else
        {
            backArrayPrev[5] = backArrayCurr[5];
        }
        backArrayCurr[5] = persquirk[rNum];
    }

    //Generate random physical quirk
    public void genPhysquirk(View v)
    {
        TextView tvPhysquirk = findViewById(R.id.edittext_physquirk);

        int rNum = rand.nextInt(115);
        tvPhysquirk.setText(physquirk[rNum]);

        // In case only this variable is rerolled. Locks in all variables.
        if (genAllPressed == false) {
            currToPrev(v);
        }
        // In case Generate All button is pressed (genAll function)
        else
        {
            backArrayPrev[6] = backArrayCurr[6];
        }
        backArrayCurr[6] = physquirk[rNum];
    }

    //Generate random plot
    public void genPlot(View v)
    {
        TextView tvPlot = findViewById(R.id.edittext_plot);

        int rNum = rand.nextInt(75);
        tvPlot.setText(plot[rNum]);

        // In case only this variable is rerolled. Locks in all variables.
        if (genAllPressed == false) {
            currToPrev(v);
        }
        // In case Generate All button is pressed (genAll function)
        else {
            backArrayPrev[7] = backArrayCurr[7];
        }
        backArrayCurr[7] = plot[rNum];
    }

    //Generate random variables in all text fields
    public void genAll(View v)
    {
        // Flag identifies that Generate All button has been pressed.
        genAllPressed = true;

        //Call all generator functions
        genRace(v);
        genName(v);
        genGender(v);
        genAge(v);
        genPersquirk(v);
        genPhysquirk(v);
        genPlot(v);

        // Sets flag back to false.
        genAllPressed = false;
    }

}