package com.example.dumbbellworkout.Custom_Workouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.All_exercise.Exercise;
import com.example.dumbbellworkout.R;
import com.google.android.material.button.MaterialButton;

public class training_info_activtity extends AppCompatActivity {

    private TextView training_exercise_name_info,training_exercise_dis_info;
    private VideoView training_exercise_video_info;
    private MaterialButton add_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_info_activtity);

        training_exercise_name_info=(TextView) findViewById(R.id.training_exercise_name_info);
        training_exercise_dis_info=(TextView) findViewById(R.id.training_exercise_dis_info);
        training_exercise_video_info=findViewById(R.id.training_exercise_video_info);
        add_btn=(MaterialButton)findViewById(R.id.training_exercise_add_btn);

        String name=getIntent().getStringExtra("Exercise");

        if(name!=null)
        {
            Exercise exercise=DataBase.all_exercise_database.get(name);
            if(exercise!=null)
            {
                training_exercise_name_info.setText(exercise.getName());
                training_exercise_dis_info.setText(exercise.getAbout());
                add_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DataBase.write(name);
                        Intent intent=new Intent(training_info_activtity.this,new_training_save.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(training_info_activtity.this,all_db_training_recyclerView.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        super.onBackPressed();
    }


}