package com.example.roomshowcase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Here you can write blueprint for yours "programmer" table

// Entity is like keyword for table
// Here you can write name of your table
@Entity(tableName = "programmers")
public class Programmer {

    // Primary key, standard knowledge in terms of DB
    // autogenerate here means that every single programmer
    // will get its own id based on auto-incrementing id
    @PrimaryKey(autoGenerate = true)

    // columnInfo is like keyword for column
    // Here you can write name of your column
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "surname")
    private String surname;

    @ColumnInfo(name = "experienceLevel")
    private int experienceLevel;

    @ColumnInfo(name = "Lazy")
    private boolean lazy;


    // Create constructor for object "programmer" to make sure that every column will be filled
    public Programmer(String name, String surname, int experienceLevel, boolean lazy){
        id = 0;
        this.name = name;
        this.surname = surname;
        this.experienceLevel = experienceLevel;
        this.lazy = lazy;
    }


    // here are just getters and setters, nothing special
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public boolean isLazy() {
        return lazy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public void setLazy(boolean lazy) {
        this.lazy = lazy;
    }
}
