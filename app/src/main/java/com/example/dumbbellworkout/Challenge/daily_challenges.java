package com.example.dumbbellworkout.Challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.All_exercise.Exercise;
import com.example.dumbbellworkout.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.*;

public class daily_challenges extends AppCompatActivity {

    private RecyclerView daily_challenge_recyclerView;
    private FloatingActionButton change_challenge_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_challenges);
        daily_challenge_recyclerView=findViewById(R.id.daily_challenge_recyclerView);
        change_challenge_btn=findViewById(R.id.change_challenge_btn);

        ArrayList<Exercise> exerciseArrayList=createExercises();
        final Daily_challenges_recyclerView recyclerView=new Daily_challenges_recyclerView(this);
        recyclerView.setExerciseArrayList(exerciseArrayList);
        daily_challenge_recyclerView.setAdapter(recyclerView);
        daily_challenge_recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        change_challenge_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setExerciseArrayList(createExercises());
            }
        });
    }

    private ArrayList<Exercise> createExercises() {
        ArrayList<Exercise> arrayList=new ArrayList<>();
        HashMap<String,Exercise> database= DataBase.all_exercise_database;

        int random=random(8,4);


        Collection<Exercise> values = database.values();
        List<Exercise> arrayList1 = new ArrayList<>(values);

        Collections.shuffle(arrayList1);

        for(int i=0;i<random;i++)
        {
            arrayList.add(arrayList1.get(i));
        }

        return arrayList;
    }

    public static int random(int max,int min)
    {
        Random random = new Random();
        return random.nextInt((max - min) ) + min;
    }


}