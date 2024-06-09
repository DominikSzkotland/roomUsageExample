package com.example.roomshowcase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button insertNewButton;
    private Button showAllButton;
    private Button deleteOneButton;
    private ProgrammerAdapter adapter;
    private List<Programmer> programmerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView); // Sprawdź, czy ten identyfikator jest prawidłowy
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        insertNewButton = findViewById(R.id.insertNewButton);
        showAllButton = findViewById(R.id.showAllButton);
        deleteOneButton = findViewById(R.id.deleteOneButton);

        ProgrammersDB db = ProgrammersDB.getInstance(getApplicationContext());
        db.programmerDAO().deleteAll();

        Programmer p1 = new Programmer("Dominik", "Szkotland", 4, true);
        Programmer p2 = new Programmer("Lukasz", "Stalowy", 3, true);
        Programmer p3 = new Programmer("Kamil", "SquadBuster", 4, true);

        db.programmerDAO().insertProgrammerToDB(p1);
        db.programmerDAO().insertProgrammerToDB(p2);
        db.programmerDAO().insertProgrammerToDB(p3);




        insertNewButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Programmer p4 = new Programmer("Mateusz", "Duży", 7, false);
                        db.programmerDAO().insertProgrammerToDB(p4);
                        showAllButton.performClick();
                    }
                }
        );

        showAllButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        programmerList = db.programmerDAO().allProgrammers();
                        adapter = new ProgrammerAdapter(programmerList);
                        recyclerView.setAdapter(adapter);
                    }
                }
        );

        deleteOneButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(programmerList.size() > 0)
                        {
                            db.programmerDAO().deleteProgrammerFromDB(programmerList.get(programmerList.size() - 1));
                            showAllButton.performClick();
                        }
                    }
                }
        );
    }
}