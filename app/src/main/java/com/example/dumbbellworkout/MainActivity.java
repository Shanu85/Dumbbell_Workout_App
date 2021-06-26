package com.example.dumbbellworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mainActivityParent;
    private MaterialCardView cardView1;
    private ImageView cardView1Strength,cardView1Play,card2play,card3play;
    private TextView cardView1Workouts,cardView1set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DataBase(this);
        cardView1=findViewById(R.id.homePageCardView1);
        cardView1Strength=findViewById(R.id.homecard1Strength);
        cardView1Play=findViewById(R.id.card1Play);
        cardView1Workouts=findViewById(R.id.card1Workout);
        cardView1set=findViewById(R.id.card1sets);
        card2play=findViewById(R.id.card2play);
        card3play=findViewById(R.id.card3play);

        cardView1Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SelectWorkoutActivity.class);
                startActivity(intent);
            }
        });

        card2play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,com.example.dumbbellworkout.Challenge.daily_challenges.class);
                startActivity(intent);
            }
        });

        card3play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,com.example.dumbbellworkout.Custom_Workouts.custom_workout_activity.class);
                startActivity(intent);
            }
        });
    }


}
