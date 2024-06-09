package com.example.roomshowcase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


// Dao is sth like a set of methods which you can use on a database
// every method is a query to DB
@Dao
public interface ProgrammerDAO {

    // Every query is based on SQL language
    @Insert
    void insertProgrammerToDB(Programmer programmer);

    @Delete
    void deleteProgrammerFromDB(Programmer programmer);

    @Query("DELETE FROM programmers")
    void deleteAll();

    @Query("SELECT * FROM programmers")
    List<Programmer> allProgrammers();
}
