package com.example.dumbbellworkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.All_exercise.Exercise;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectWorkoutActivity extends AppCompatActivity {

    private RecyclerView workoutRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectworkout);
        workoutRecyclerView=findViewById(R.id.workout_recyclerView);

        ArrayList<workout> workouts=createAllWorkouts();
        selectWorkoutRecyclerView workoutadapter=new selectWorkoutRecyclerView(this);
        workoutadapter.setWorkoutArrayList(workouts);
        workoutRecyclerView.setAdapter(workoutadapter);
        workoutRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    private ArrayList<workout> createAllWorkouts()
    {
        HashMap<String, Exercise> database= DataBase.all_exercise_database;
        ArrayList<workout> arrayList=new ArrayList<>();
        workout workout1=new workout("Chest and biceps",R.mipmap.ic_launcher,database.get(DataBase.DUMBBELL_PRESSES_LYING),database.get(DataBase.CURLING_DUMBBELL_SITTING),database.get(DataBase.DUMBBELL_FLYES_LYING),database.get(DataBase.DUMBBELL_CONCENTRATION_CURL_SITTING),database.get(DataBase.SIT_UPS_WITH_ROTATION),database.get(DataBase.SLOPES_WITH_DUMBBELL));
        workout workout2=new workout("Back and triceps",R.mipmap.ic_launcher,database.get(DataBase.RENEGADE_ROWS_STANDING),database.get(DataBase.FRENCH_DUMBBELL_PRESSES),database.get(DataBase.EXTEND_ARM_SLOPES),database.get(DataBase.SIT_UPS_WITH_ROTATION),database.get(DataBase.SLOPES_WITH_DUMBBELL),null);
        workout workout3=new workout("Delta and legs",R.mipmap.ic_launcher,database.get(DataBase.DUMBBELL_FLYES_STANDING),database.get(DataBase.DUMBBELL_FRONT_RAISES),database.get(DataBase.DUMBBELL_LUNGE),database.get(DataBase.ROMANIAN_ROD_LEG),database.get(DataBase.LEGS_RISES),null);
        workout workout4=new workout("Complex 1",R.mipmap.ic_launcher,database.get(DataBase.DUMBBELL_SQUATS),database.get(DataBase.SPLIT_SQUATS),database.get(DataBase.RENEGADE_ROWS_STANDING),database.get(DataBase.ONE_ARM_DUMBBELL_PRESSES),database.get(DataBase.SIT_UPS_WITH_ROTATION),database.get(DataBase.LEGS_RISES));
        workout workout5=new workout("Complex 2",R.mipmap.ic_launcher,database.get(DataBase.SLOPES_WITH_DUMBBELL),database.get(DataBase.DUMBBELL_LUNGE),database.get(DataBase.DUMBBELL_PRESSES_LYING),database.get(DataBase.CURLING_DUMBBELL_STANDING),database.get(DataBase.HAMMER),null);
        workout workout6=new workout("Complex 3",R.mipmap.ic_launcher,database.get(DataBase.ROMANIAN_ROD_LEG),database.get(DataBase.DUMBBELL_SHRUG),database.get(DataBase.DUMBBELL_FLYES_LYING),database.get(DataBase.SEATED_DUMBBELL_PRESSES),database.get(DataBase.DUMBBELL_FRONT_RAISES),database.get(DataBase.DUMBBELL_FLYES_STANDING));
        workout workout7=new workout("Shoulders and arms",R.mipmap.ic_launcher,database.get(DataBase.CURLING_DUMBBELL_STANDING),database.get(DataBase.DUMBBELL_CHECK_PRESSES),database.get(DataBase.CURLING_DUMBBELL_SITTING),database.get(DataBase.SNATCH_FROM_FLOOR),database.get(DataBase.HAMMER),database.get(DataBase.DUMBBELL_FLYES_STANDING));
        arrayList.add(workout1);
        arrayList.add(workout2);
        arrayList.add(workout3);
        arrayList.add(workout4);
        arrayList.add(workout5);
        arrayList.add(workout6);
        arrayList.add(workout7);
        return arrayList;
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(SelectWorkoutActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}