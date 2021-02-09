package com.example.npcspawn;

public class NPCModelClass {

    Integer id;
    String name;
    String race;
    String gender;
    String age;
    String persquirk;
    String physquirk;
    String plot;

    // Functions to check if NPC is expanded on View screen
    public boolean isExpand() {

        return expand;
    }
    public void setExpand(boolean expand) {

        this.expand = expand;
    }

    // For expansion of NPCs on View Screen
    boolean expand;

    public NPCModelClass(String name, String race, String gender, String age, String persquirk, String physquirk, String plot) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.age = age;
        this.persquirk = persquirk;
        this.physquirk = physquirk;
        this.plot = plot;

        // For expandable NPCs on View screen
        this.expand = false;
    }

    public NPCModelClass(Integer id, String name, String race, String gender, String age, String persquirk, String physquirk, String plot) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.age = age;
        this.persquirk = persquirk;
        this.physquirk = physquirk;
        this.plot = plot;
    }

    // Getters and setters for each field
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPersquirk() {
        return persquirk;
    }

    public void setPersquirk(String persquirk) {
        this.persquirk = persquirk;
    }

    public String getPhysquirk() {
        return physquirk;
    }

    public void setPhysquirk(String physquirk) {
        this.physquirk = physquirk;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}

