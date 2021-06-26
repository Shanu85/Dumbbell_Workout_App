package com.example.dumbbellworkout.Custom_Workouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dumbbellworkout.All_exercise.Custom_Training;
import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.All_exercise.Exercise;
import com.example.dumbbellworkout.MainActivity;
import com.example.dumbbellworkout.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class custom_workout_activity extends AppCompatActivity {

    DatabaseReference reference;
    private RecyclerView custom_workout_recycler;
    private FloatingActionButton add_custom_workout_recyclerView;
    private custom_workout_recyclerView adpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_workout_activity);
        reference= FirebaseDatabase.getInstance().getReference("User");

        custom_workout_recycler=findViewById(R.id.custom_workout_recyclerView);
        all_plans();

        custom_workout_recycler.setLayoutManager(new GridLayoutManager(this,1));

        add_custom_workout_recyclerView=findViewById(R.id.add_custom_workout_recyclerView);
        add_custom_workout_recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(custom_workout_activity.this,all_db_training.class);
                startActivity(intent);
            }
        });
    }

    public void all_plans()
    {
        ArrayList<Custom_Training> container=new ArrayList<>();
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    container.clear();
                    for (DataSnapshot child : snapshot.getChildren()) {
                        String plan_name=child.getKey();

                        ArrayList<String> arrayList=(ArrayList<String>) (child.getValue());

                        ArrayList<Exercise> db=new ArrayList<>();
                        for(String str:arrayList)
                        {
                            db.add(DataBase.all_exercise_database.get(str));
                            //Log.d("exercise name",str);
                        }
                        container.add(new Custom_Training(plan_name,db));

                    }
                    adpater=new custom_workout_recyclerView(custom_workout_activity.this);
                    adpater.setContainer(container);
                    custom_workout_recycler.setAdapter(adpater);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(custom_workout_activity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}