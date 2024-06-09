package com.example.roomshowcase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


// Database. Room keyword for defining class which represents DB
@Database(entities = {Programmer.class}, version = 1)
public abstract class ProgrammersDB extends RoomDatabase {

    // creating Dao instance to connect DB with all defined queries
    public abstract ProgrammerDAO programmerDAO();

    // Here you need to create DB instance, but only if it wasn't defined yet.
    private static ProgrammersDB instance;

    // finally DB builder. Here you can define all needed options for your DB
    public static ProgrammersDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ProgrammersDB.class, "programmers").build();
        }
        return instance;
    }
}
