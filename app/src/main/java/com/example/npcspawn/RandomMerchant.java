package com.example.npcspawn;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class RandomMerchant extends AppCompatActivity {

    EditText editText_gen1m, editText_gen2m, editText_gen1c, editText_gen2c, editText_gen1uc,
            editText_gen1r, editText_gen2r, editText_gen1vr, editText_gen1w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_merchant);

        editText_gen1m = findViewById(R.id.edittext_gen1m);
        editText_gen2m = findViewById(R.id.edittext_gen2m);
        editText_gen1c = findViewById(R.id.edittext_gen1c);
        editText_gen2c = findViewById(R.id.edittext_gen2c);
        editText_gen1uc = findViewById(R.id.edittext_gen1uc);
        editText_gen1r = findViewById(R.id.edittext_gen1r);
        editText_gen2r = findViewById(R.id.edittext_gen2r);
        editText_gen1vr = findViewById(R.id.edittext_gen1vr);
        editText_gen1w = findViewById(R.id.edittext_gen1w);
    }

    //For random number generation
    Random rand = new Random();

    // Random numbers
    int rNumC = 0;
    int rNumR = 0;
    int rNumM = 0;
    int rNumW = 0;
    int rNumUC = 0;
    int rNumVR = 0;

    // Mundane options. Count 125
    String[] mundane = {
            "An old leather belt.", "A thick woolen blanket.", "String of beaver pelts.", "Empty scroll", "Bone Dice",
            "A long needle made of bone.", "Three black candles", "Small wooden comb", "A piece of chalk", "A cooking pot",
            "A box of unidentifiable powder.", "A dried flower.", "Empty Vial", "Fishing tackle", "A cat statue.",
            "Flint and steel.", "Garlic.", "Broken glass.", "A hammer.", "A silver locket.",
            "A hematite gem.", "A tiger's eye gem.", "A shard of amethyst.", "A large quartz crystal.", "Hand mirror.",

            "A jar of honey.", "A bottle of mead.", "A flagon of ale.", "An unopened bottle of wine.", "An empty bottle.",
            "A bottle full of a clear liquid.", "A pound of jerky.", "Dried apple skins.", "A loaf of bread.", "A bottle of ink.",
            "An iron nail.", "A bucket of nails.", "A quill.", "A fake eye.", "A prosthetic leg.",
            "A sprig of mistletoe.", "Lead coins.", "A set of trick dice.", "A set of cards.", "A set of trick cards.",
            "A magnifying glass.", "A plain pewter ring.", "A lead cup.", "A pile of coal.", "A bear mask.",

            "A bunch of hemlock.", "A large piece of obsidian.", "An old hat.", "An old pouch.", "An old saddlebag.",
            "A broken shield.", "A broken sword.", "A flat river stone.", "A handsaw.", "A crowbar.",
            "A small mirror.", "A bar of soap.", "A bundle of fabric.", "One foot of steel chain.", "A silver necklace.",
            "A tin cup.", "A horn mug.", "An ocarina.", "A steel key.", "A steel lock.",
            "A silk handkerchief.", "A silver toothpick.", "A tinderbox.", "A pouch of tobacco.", "A walking stick.",

            "A waterskin.", "A wolf pelt.", "A bear pelt.", "A bear's claw.", "A rabbit's foot.",
            "An empty sketchbook.", "A holy book.", "A wooden whistle.", "A used whetstone.", "An unreadable note.",
            "A book on beer brewing.", "A book on wild mushrooms.", "A jawharp.", "A wooden spoon.", "A wool sweater.",
            "A red handkerchief.", "A pouch of unknown berries.", "A beaded bracelet.", "A kitchen knife.", "An old shoe.",
            "A wooden figurine of a wolf.", "A set of casting runes.", "A small stuffed bear.", "A child's doll.", "A portrait of a beautiful woman.",

            "A pitchfork.", "A farming hoe.", "A soup ladel.", "A mop.", "An oar.",
            "A set of marbles.", "An hourglass.", "A dead rat.", "A spool of string.", "An ornate axe head.",
            "A smoking pipe.", "A piglet.", "A chicken.", "A bedroll.", "A bloodstone.",
            "A bonesaw.", "A steel chamberpot.", "A torn shirt.", "An old skeleton.", "A rhino horn.",
            "A flask.", "A frying pan.", "A masquerade mask.", "A toy sword.", "A firepoker."
    };

    // Common options. Count 114.
    String[] common = {
            "Net", "A lantern", "50 feet of rope", "Torch", "Club",
            "Quarterstaff", "Fishing harpoon", "Dagger", "Poisoned throwing needles", "A poisoned dagger",
            "Brass knuckles", "Bronze Tower Shield", "Five bars of copper", "Five darts", "Double spear",
            "Wooden shield", "Greataxe", "Greatclub", "A golden signet ring", "Greatsword",
            "A holy symbol", "Holy water", "A jade pendant", "A knife vest that holds six knives", "A leather bag made of dragon scales",

            "A giant's sword", "Handaxe", "Medicinal herbs", "A pouch full of moonstones", "An onyx gemstone",
            "Potion of healing", "A bag of goodberries", "Potion of Climbing", "Javelin", "Mace",
            "Spear", "Light Crossbow", "Hand Crossbow", "Heavy Crossbow", "Battleaxe",
            "Sling", "Shortbow", "Sickle", "Light Hammer", "Mace",
            "Glaive", "Flail", "Halberd", "Lance", "Longsword",

            "Maul", "Morningstar", "Pike", "Rapier", "Scimitar",
            "Shortsword", "Trident", "War Pick", "Warhammer", "Whip",
            "Blowgun", "Longbow", "Acid", "Alchemist's Fire", "Antitoxin",
            "Ball Bearings", "Block and Tackle", "Caltrops", "Healer's Kit", "Candle",
            "Map", "Chain", "Climber's Kit", "Crowbar", "Hunting Trap",

            "Lamp", "Lock", "Manacles", "Mess Kit", "Oil",
            "Basic Poison", "Quiver", "Portable Ram", "Rations", "Spyglass",
            "Tent", "Tinderbox", "Barrel", "Backpack", "Common Clothes",
            "Fine Clothes", "Sealing Wax", "Shovel", "Ten Iron Spikes", "Iron Pot",
            "One Sheet of Paper", "Ten Foot Ladder", "Steel Mirror", "Ten Foot Pole", "Sack",

            "Bottle", "Drum", "Bagpipes", "Dulcimer", "Flute",
            "Lute", "Pan Flute", "Horn", "Thieves' Tools", "Cobbler's Tools",
            "Woodcarver's Tools", "Disguise Kit", "Mason's Tools", "Weaver's Tools"
    };

    // Uncommon Options. Count 50
    String[] uncommon = {
            "Adamantine Armor", "+1 Ammunition", "+2 Ammunition", "+3 Ammunition", "Immovable Rod",
            "Javelin of Lightning", "Medium Mithral Armor", "Heavy Mithral Armor", "Oil of Slipperiness", "Potion of Poison",
            "Philter of Love", "Potion of Animal Friendship", "Potion of Hill Giant Strength", "Potion of Growth", "Potion of Greater Healing",
            "Potion of Resistance", "Potion of Water Breathing", "Ring of Jumping", "Ring of Mind Shielding", "Ring of Swimming",
            "Ring of Warmth", "Ring of Water Walking", "+1 Shield", "Staff of the Python", "Trident of Fish Command",

            "Wand of Magic Detection", "Wand of Magic Missiles", "Wand of Secrets", "+1 Wand of the War Mage", "Wand of Web",
            "+1 Rapier", "+1 Greatsword", "+1 Club", "+1 Dagger", "+1 Handaxe",
            "+1 Javelin", "+1 Quarterstaff", "+1 Spear", "+1 Flail", "+1 Battleaxe",
            "+1 Crossbow", "+1 Shortbow", "+1 Longbow", "+1 Greataxe", "+1 Longsowrd",
            "+1 Morningstar", "+1 Shortsword", "+1 War Pick", "+1 Warhammer", "+1 Trident"

    };

    // Rare Options. Count 104
    String[] rare = {
            "+1 Light Armor", "+1 Medium Armor", "+1 Heavy Armor", "Armor of Resistance", "Arrow-Catching Shield",
            "Beserker Axe", "Dagger of Venom", "Dragon Slayer Sword", "Elven Chain", "Flame Tongue Sword",
            "Giant Slayer Sword", "Giant Slayer Axe", "Glamoured Studded Leather", "Silver Horn of Valhalla", "Brass Horn of Valhalla",
            "Mace of Disruption", "Mace of Smiting", "Mace of Terror", "Oil of Etherealness", "Potion of Clairvoyance",
            "Potion of Diminution", "Potion of Gaseous Form", "Potion of Heroism", "Potion of Frost Giant Strength", "Potion of Stone Giant Strength",

            "Potion of Fire Giant Strength", "Potion of Mind Reading", "Potion of Superior Healing", "Ring of Animal Influence", "Ring of Evasion",
            "Ring of Feather Falling", "Ring of Free Action", "Ring of Protection", "Ring of Acid Resistance", "Ring of Cold Resistance",
            "Ring of Fire Resistance", "Ring of Force Resistance", "Ring of Lightning Resistance", "Ring of Necrotic Resistance", "Ring of Poison Resistance",
            "Ring of Psychic Resistance", "Ring of Radiant Resistance", "Ring of Thunder Resistance", "Ring of Spell Storing", "Ring of the Ram",
            "Ring of X-ray Vision", "Rod of Rulership", "+2 Shield", "Shield of Missile Attraction", "Staff of Charming",

            "Staff of Healing", "Staff of Swarming Insects", "Staff of the Woodlands", "Staff of Withering", "Sword of Life Stealing",
            "Sword of Wounding", "Stone of Controlling Earth Elementals", "Sun Blade", "Vicious Sword", "Vicious Axe",
            "Vicious Quarterstaff", "Vicious Mace", "Vicious Dagger", "Vicious Hammer", "Vicious Great Sword",
            "Vicious Rapier", "Vicious Whip", "Wand of Binding", "Wand of Enemy Detection", "Wand of Fear",
            "Wand of Fireballs", "Wand of Lightning Bolts", "Wand of Paralysis", "+2 Wand of the War Mage", "Wand of Wonder",

            "+2 Rapier", "+2 Greatsword", "+2 Club", "+2 Dagger", "+2 Handaxe",
            "+2 Javelin", "+2 Quarterstaff", "+2 Spear", "+2 Flail", "+2 Battleaxe",
            "+2 Crossbow", "+2 Shortbow", "+2 Longbow", "+2 Greataxe", "+2 Longsowrd",
            "+2 Morningstar", "+2 Shortsword", "+2 War Pick", "+2 Warhammer", "+2 Trident",
            "+1 Studded Leather Armor", "+1 Leather Armor", "+1 Chain Shirt", "+1 Scale Mail", "+1 Breastplate",

            "+1 Ring Mail", "+1 Chain Mail", "+1 Splint Armor", "+1 Plate Mail",

    };

    // Very Rare Options. Count 63
    String[] veryrare = {
            "Animated Shield", "Sword of Sharpness", "Wand of Polymorph", "+3 Wand of the War Mage", "Arrow of Slaying",
            "Dancing Sword", "Demon Armor", "Dragon Scale Mail", "Dwarven Plate", "Dwarven Thrower Warhammer",
            "Frost Brand Sword", "Bronze Horn of Valhalla", "Nine Lives Stealer Sword", "Oathbow", "Oil of Sharpness",
            "Potion of Flying", "Potion of Cloud Giant Strength", "Potion of Invisibility", "Potion of Supreme Healing", "+3 Handaxe",
            "Potion of Speed", "Ring of Regeneration", "Ring of Shooting Stars", "Ring of Telekinesis", "Rod of Absorption",

            "Rod of Alertness", "Rod of Security", "Scimitar of Speed", "+3 Shield", "Spellguard Shield",
            "Staff of Fire", "Staff of Frost", "Staff of Power", "Staff of Striking", "Staff of Thunder and Lightning",
            "+2 Studded Leather Armor", "+2 Leather Armor", "+2 Chain Shirt", "+2 Scale Mail", "+2 Breastplate",
            "+2 Ring Mail", "+2 Chain Mail", "+2 Splint Armor", "+2 Plate Mail", "+3 Rapier",
            "+3 Javelin", "+3 Quarterstaff", "+3 Spear", "+3 Flail", "+3 Battleaxe",

            "+3 Crossbow", "+3 Shortbow", "+3 Longbow", "+3 Greataxe", "+3 Longsowrd",
            "+3 Morningstar", "+3 Shortsword", "+3 War Pick", "+3 Warhammer", "+3 Trident",
            "+3 Greatsword", "+3 Club", "+3 Dagger"

    };

    // Wonderous options. Count 146
    String[] wonderous = {
            "Amulet of Health", "Amulet of Proof against detection and Location", "Amulet of the Planes", "Apparatus of the Crab", "Bag of Beans",
            "Bag of Devouring", "Bag of Holding", "Bag of Tricks", "Bead of Force", "Belt of Dwarvenkind",
            "Belt of Giant Strength", "Boots of Elvenkind", "Boots of Levitation", "Boots of Speed", "Boots of Striding and Springing",
            "Boots of the Winterlands", "Bowl of Commanding Water Elementals", "Bracers of Archery", "Bracers of Defense", "Brazier of Commanding Fire Elementals",
            "Brooch of Shielding", "Broom of Flying", "Candle of Invocation", "Cape of the Mountebank", "Carpet of Flying",

            "Censer of Controlling Air Elementals", "Chime of Opening", "Circlet of Blasting", "Cloak of Arachnida", "Cloak of Displacement",
            "Cloak of Elvenkind", "Cloak of Protection", "Cloak of the Bat", "Cloak of the Manta Ray", "Crystal Ball",
            "Cube of Force", "Cubic Gate", "Decanter of Endless Water", "Deck of Illusions", "Deck of Many Things",
            "Dimensional Shackles", "Dust of Disappearance", "Dust of Dryness", "Dust of Sneezing and Choking", "Efficient Quiver",
            "Efreeti Bottle", "Elemental Gem", "Eversmoking Bottle", "Eyes of Charming", "Eyes of Minute Seeing",

            "Eyes of the Eagle", "Feather Token", "Figurine of Wondrous Power", "Folding Boat", "Gauntlets of Ogre Power",
            "Gem of Brightness", "Gem of Seeing", "Gloves of Missile Snaring", "Gloves of Swimming and Climbing", "Goggles of Night",
            "Handy Haversack", "Hat of Disguise", "Headband of Intellect", "Helm of Brilliance", "Helm of Comprehending Languages",
            "Helm of Telepathy", "Helm of Teleportation", "Horn of Blasting", "Horn of Valhalla", "Horseshoes of a Zephyr",
            "Horseshoes of Speed", "Instant Fortress", "Ioun Stone", "Iron Bands of Binding", "Iron Flask",

            "Lantern of Revealing", "Mantle of Spell Resistance", "Manual of Bodily Health", "Manual of Gainful Exercise", "Manual of Golems",
            "Manual of Quickness of Action", "Marvelous Pigments", "Medallion of Thoughts", "Mirror of Life Trapping", "Necklace of Adaptaion",
            "Necklace of Fireballs", "Necklace of Prayer Beads", "Pearl of Power", "Periapt of Health", "Periapt of Proof against Poison",
            "Periapt of Wound Closure", "Pipes of Haunting", "Pipes of the Sewers", "Portable Hole", "Restorative Ointment",
            "Robe of Eyes", "Robe of Scintillating Colors", "Robe of Stars", "Robe of the Archmagi", "Robe of Useful Items",

            "Rope of Climbing", "Rope of Entanglement", "Scarab of Protection", "Slippers of Spider Climbing", "Sovereign Glue",
            "Sphere of Annihilation", "Stone of Controlling Earth Elementals", "Stone of Good Luck", "Talisman of Pure Good", "Talisman of the Sphere",
            "Talisman of Ultimate Evil", "Tome of Clear Thought", "Tome of Leadership and Influence", "Tome of Understanding", "Universal Solvent",
            "Well of Many Worlds", "Wind Fan", "Winged Boots", "Wings of Flying", "+3 Plate Mail",
            "+3 Studded Leather Armor", "+3 Leather Armor", "+3 Chain Shirt", "+3 Scale Mail", "+3 Breastplate",

            "+3 Ring Mail", "+3 Chain Mail", "+3 Splint Armor",

            // Legendary
            "Armor of Invulnerability", "Defender Weapon", "Hammer of Thunderbolts", "Holy Avenger Sword", "Iron Horn of Valhalla",
            "Luck Blade Sword", "Potion of Storm Giant Strength", "Ring of Djinni Summoning", "Ring of Air Elemental Command", "Ring of Earth Elemental Command",
            "Ring of Fire Elemental Command", "Ring of Water Elemental Command", "Ring of Invisibility", "Ring of Spell Turning", "Ring of Three Wishes",
            "Rod of Lordly Might", "Staff of the Magi", "Vorpal Sword"

    };

    // Generator functions set the edittext field with a random value from array
    public void genMundane1(View v) {
        TextView tvName = findViewById(R.id.edittext_gen1m);

        int rNumM = rand.nextInt(125);
        tvName.setText(mundane[rNumM]);
    }
    public void genMundane2(View v) {
        TextView tvName = findViewById(R.id.edittext_gen2m);

        int rNumM = rand.nextInt(125);
        tvName.setText(mundane[rNumM]);
    }
    public void genCommon2(View v) {
        TextView tvName = findViewById(R.id.edittext_gen1c);

        int rNumC = rand.nextInt(114);
        tvName.setText(common[rNumC]);
    }
    public void genCommon3(View v) {
        TextView tvName = findViewById(R.id.edittext_gen2c);

        int rNumC = rand.nextInt(114);
        tvName.setText(common[rNumC]);
    }
    public void genUncommon1(View v) {
        TextView tvName = findViewById(R.id.edittext_gen1uc);

        int rNumUC = rand.nextInt(50);
        tvName.setText(uncommon[rNumUC]);
    }
    public void genRare1(View v) {
        TextView tvName = findViewById(R.id.edittext_gen1r);

        int rNumR = rand.nextInt(104);
        tvName.setText(rare[rNumR]);
    }
    public void genRare2(View v) {
        TextView tvName = findViewById(R.id.edittext_gen2r);

        int rNumR = rand.nextInt(104);
        tvName.setText(rare[rNumR]);
    }
    public void genVeryRare1(View v) {
        TextView tvName = findViewById(R.id.edittext_gen1vr);

        int rNumVR = rand.nextInt(63);
        tvName.setText(veryrare[rNumVR]);
    }
    public void genWonderous1(View v) {
        TextView tvName = findViewById(R.id.edittext_gen1w);

        int rNumW = rand.nextInt(146);
        tvName.setText(wonderous[rNumW]);
    }

    // Generate all function resets all edittext fields
    public void genAllMerch(View v) {
        genMundane1(v);
        genMundane2(v);
        genCommon2(v);
        genCommon3(v);
        genUncommon1(v);
        genRare1(v);
        genRare2(v);
        genVeryRare1(v);
        genWonderous1(v);
    }
}