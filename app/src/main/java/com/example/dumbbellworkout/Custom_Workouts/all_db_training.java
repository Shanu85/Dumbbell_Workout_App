package com.example.dumbbellworkout.Custom_Workouts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.R;

import java.util.ArrayList;

public class all_db_training extends AppCompatActivity {

    private RecyclerView all_db_training_recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_db_training);
        all_db_training_recyclerView=findViewById(R.id.all_db_training_recyclerView);

        ArrayList<String> arrayList=allWorkouts();
        all_db_training_recyclerView recyclerView=new all_db_training_recyclerView(this);
        recyclerView.setAll_exercise_arrayList(arrayList);

        all_db_training_recyclerView.setAdapter(recyclerView);
        all_db_training_recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    private ArrayList<String> allWorkouts() {
        return new ArrayList<>(DataBase.all_exercise_database.keySet());
    }
}