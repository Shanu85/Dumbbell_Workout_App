package com.example.dumbbellworkout.Custom_Workouts;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.All_exercise.Exercise;
import com.example.dumbbellworkout.ExerciseRecyclerView;
import com.example.dumbbellworkout.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class new_training_save extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton new_training_addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_training_save);
        recyclerView=findViewById(R.id.new_training_recyclerView);
        new_training_addbtn=findViewById(R.id.new_training_addbtn);

       ArrayList<Exercise> arrayList=workouts();
       ExerciseRecyclerView viewholderApdater=new ExerciseRecyclerView(this);
        viewholderApdater.setExercise_detailsArrayList(arrayList);

       recyclerView.setAdapter(viewholderApdater);
       recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        new_training_addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(new_training_save.this,all_db_training.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Exercise> workouts()
    {
        ArrayList<String> arrayList= DataBase.read();
        ArrayList<Exercise> answer=new ArrayList<>();
        for(String val:arrayList)
        {
            answer.add(DataBase.all_exercise_database.get(val));
        }
        return answer;
    }


    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(new_training_save.this);
        builder.setMessage("Save changes?");
        builder.setCancelable(true);
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                DataBase.clear();
                Intent intent=new Intent(new_training_save.this,custom_workout_activity.class);
                startActivity(intent);
            }
        });

        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                save_popUp();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_new_training_save,menu);

        int positionOfMenuItem = 0;
        MenuItem item = menu.getItem(positionOfMenuItem);
        SpannableString s = new SpannableString("Save");
        s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, s.length(), 0);
        item.setTitle(s);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.savebtn)
        {
            save_popUp();
        }
        return super.onOptionsItemSelected(item);
    }

    public void save_popUp()
    {
        ArrayList<String> arrayList=DataBase.read();
        savePopUp savePopUp=new savePopUp(new_training_save.this,arrayList);
        savePopUp.show(getSupportFragmentManager(),"Save PopUp");
    }
}