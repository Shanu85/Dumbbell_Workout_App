package com.example.dumbbellworkout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dumbbellworkout.All_exercise.Exercise;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class startWorkout_activity extends AppCompatActivity {

    public static final String startWorkout_Key="All_workout_exercise";
    private RecyclerView workout_all_exercise_recyclerView;
    private FloatingActionButton selectWorkoutTimeButton;
    private ArrayList<Exercise> exercise_detailsArrayList=new ArrayList<>();

    private AlertDialog.Builder popUp_dialogBuilder;
    private AlertDialog popUp_dialog;

    private Button selecttime_popUp_cancel,selecttime_popUp_start;
    private MaterialButton time_countTime_subsec,time_countTime_addsec,time_prepareTime_subsec,time_prepareTime_addsec,no_of_round_subRounds,no_of_round_addRounds,reduce_round_restTime,increase_round_restTime;
    private TextView time_countTime,time_countTime_sec,time_prepareTime,time_prepareTime_sec,no_of_round,round_rest_time,round_rest_time_unit,total_workout_time,calories_lost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);
        workout_all_exercise_recyclerView=findViewById(R.id.workout_all_exercise_recyclerView);

        ExerciseRecyclerView exerciseRecyclerView=new ExerciseRecyclerView(this);
        getIncomingContent();

        exerciseRecyclerView.setExercise_detailsArrayList(exercise_detailsArrayList);
        workout_all_exercise_recyclerView.setAdapter(exerciseRecyclerView);
        workout_all_exercise_recyclerView.setLayoutManager(new GridLayoutManager(this,1));


        selectWorkoutTimeButton=findViewById(R.id.selectWorkoutTimeButton);

        selectWorkoutTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_setTime_popUp();
            }
        });
    }


    private void getIncomingContent()
    {
        Bundle bundle= Objects.requireNonNull(getIntent().getExtras()).getBundle("bundle");
        if(bundle!=null)
        {
            exercise_detailsArrayList=bundle.getParcelableArrayList(startWorkout_Key);
            assert exercise_detailsArrayList != null;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(startWorkout_activity.this,SelectWorkoutActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        super.onBackPressed();
    }

    private void create_setTime_popUp()
    {
        popUp_dialogBuilder=new AlertDialog.Builder(this);
        final View setTimePopUpView=getLayoutInflater().inflate(R.layout.activity_select_workout_time_pop_up,null);
        popUp_dialogBuilder.setView(setTimePopUpView);
        popUp_dialog=popUp_dialogBuilder.create();
        popUp_dialog.show();

        selecttime_popUp_cancel=(Button) setTimePopUpView.findViewById(R.id.selecttime_popUp_cancel);
        selecttime_popUp_start=(Button)setTimePopUpView.findViewById(R.id.selecttime_popUp_start);

        time_countTime_subsec=(MaterialButton)setTimePopUpView.findViewById(R.id.time_countTime_subsec);
        time_countTime_addsec=(MaterialButton)setTimePopUpView.findViewById(R.id.time_countTime_addsec);
        time_prepareTime_subsec=(MaterialButton)setTimePopUpView.findViewById(R.id.time_prepareTime_subsec);
        time_prepareTime_addsec=(MaterialButton)setTimePopUpView.findViewById(R.id.time_prepareTime_addsec);
        no_of_round_subRounds=(MaterialButton)setTimePopUpView.findViewById(R.id.no_of_round_subRounds);
        no_of_round_addRounds=(MaterialButton)setTimePopUpView.findViewById(R.id.no_of_round_addRounds);
        reduce_round_restTime=(MaterialButton)setTimePopUpView.findViewById(R.id.reduce_round_restTime);
        increase_round_restTime=(MaterialButton)setTimePopUpView.findViewById(R.id.increase_round_restTime);


        time_countTime=(TextView) setTimePopUpView.findViewById(R.id.time_countTime);
        time_countTime_sec=(TextView)setTimePopUpView.findViewById(R.id.time_countTime_sec);
        time_prepareTime=(TextView)setTimePopUpView.findViewById(R.id.time_prepareTime);
        time_prepareTime_sec=(TextView)setTimePopUpView.findViewById(R.id.time_prepareTime_sec);
        no_of_round=(TextView)setTimePopUpView.findViewById(R.id.no_of_round);
        round_rest_time=(TextView)setTimePopUpView.findViewById(R.id.round_rest_time);
        round_rest_time_unit=(TextView)setTimePopUpView.findViewById(R.id.round_rest_time_unit);
        total_workout_time=(TextView)setTimePopUpView.findViewById(R.id.total_workout_time);
        calories_lost=(TextView)setTimePopUpView.findViewById(R.id.calories_lost);

        totalWorkoutTime();
        setCalories();
        selecttime_popUp_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popUp_dialog.dismiss();
            }
        });
        time_countTime_subsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrease_time(time_countTime,time_countTime_sec);
                int rounds=Integer.parseInt(no_of_round.getText().toString());
                String calories=String.valueOf(rounds*One_Round_calories());
                calories_lost.setText(calories);
            }
        });
        time_countTime_addsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increase_changeTime(time_countTime,time_countTime_sec,time_countTime_addsec,time_countTime_subsec);
                int rounds=Integer.parseInt(no_of_round.getText().toString());
                String calories=String.valueOf(rounds*One_Round_calories());
                calories_lost.setText(calories);
            }
        });
        time_prepareTime_subsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrease_time(time_prepareTime,time_prepareTime_sec);
            }
        });
        time_prepareTime_addsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increase_changeTime(time_prepareTime,time_prepareTime_sec,time_prepareTime_addsec,time_prepareTime_subsec);
            }
        });
        no_of_round_subRounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_rounds=Integer.parseInt(no_of_round.getText().toString())-1;
                if(new_rounds>0)
                {
                    int one_round_calories=One_Round_calories();
                    int val=Integer.parseInt(calories_lost.getText().toString())-one_round_calories;
                    if(val>0)
                    {
                        String txt=String.valueOf(val);
                        calories_lost.setText(txt);
                    }

                }
                if(new_rounds<=0)
                {
                    new_rounds=1;
                }
                no_of_round.setText(String.valueOf(new_rounds));

                totalWorkoutTime();
            }
        });
        no_of_round_addRounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_rounds=Integer.parseInt(no_of_round.getText().toString())+1;
                no_of_round.setText(String.valueOf(new_rounds));
                totalWorkoutTime();

                int one_round_calories=One_Round_calories();
                String txt=String.valueOf(Integer.parseInt(calories_lost.getText().toString())+one_round_calories);
                calories_lost.setText(txt);

            }
        });
        reduce_round_restTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrease_time(round_rest_time,round_rest_time_unit);
            }
        });
        increase_round_restTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increase_changeTime(round_rest_time,round_rest_time_unit,increase_round_restTime,reduce_round_restTime);
            }
        });
    }

    private void setCalories() {
        int calories=One_Round_calories();
        int rounds=Integer.parseInt(no_of_round.getText().toString());
        String txt=String.valueOf(rounds*(Integer.parseInt(calories_lost.getText().toString())+calories));
        calories_lost.setText(txt);
    }

    private void increase_changeTime(TextView textView, TextView time_unit_measure, MaterialButton add_button, MaterialButton minus_button)
    {
        String time_unit=time_unit_measure.getText().toString();
        if(time_unit.equals("sec"))
        {
            int current_time=Integer.parseInt(textView.getText().toString());
            current_time+=5;
            int minutes=current_time/60;
            int seconds=current_time-minutes*60;
            if(minutes==0)
            {
                textView.setText(String.valueOf(current_time));
            }
            if(minutes!=0)
            {
                String time=minutes+":"+seconds;
                textView.setText(time);
                String new_unit="min";
                time_unit_measure.setText(new_unit);

                ViewGroup.LayoutParams params = add_button.getLayoutParams();
                if(params.height>155 && params.width>138)
                {
                    params.height-=20;
                    params.width-=20;
                    add_button.setLayoutParams(params);

                    ViewGroup.LayoutParams params1=minus_button.getLayoutParams();
                    params1.width-=20;
                    params1.height-=20;
                    minus_button.setLayoutParams(params1);


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        add_button.setIcon(getResources().getDrawable(R.drawable.small_add,this.getTheme()));
                        minus_button.setIcon(getResources().getDrawable(R.drawable.small_minus,this.getTheme()));
                    }
                }
            }
        }
        if(time_unit.equals("min"))
        {
            String[] time=textView.getText().toString().split(":");
            int minutes=Integer.parseInt(time[0]);
            int seconds=Integer.parseInt(time[1]);
            int total_time=minutes*60+seconds+5;
            minutes=total_time/60;
            seconds=total_time-minutes*60;

            String Time=minutes+":"+seconds;
            textView.setText(Time);
        }
        totalWorkoutTime();
    }

    private void decrease_time(TextView textView, TextView time_unit_measure)
    {
        String time_unit=time_unit_measure.getText().toString();
        if(time_unit.equals("sec"))
        {
            int current_time=Integer.parseInt(textView.getText().toString());
            current_time-=5;
            if(current_time<10)
            {
                current_time=10;
            }
            textView.setText(String.valueOf(current_time));
        }
        if(time_unit.equals("min"))
        {
            String[] time=textView.getText().toString().split(":");
            int minutes=Integer.parseInt(time[0]);
            int seconds=Integer.parseInt(time[1]);

            int total_time=minutes*60+seconds-5;
            minutes=total_time/60;
            seconds=total_time-minutes*60;

            if(minutes==0)
            {
                textView.setText(String.valueOf(total_time));
                String unit="sec";
                time_unit_measure.setText(unit);
            }
            else
            {
                String Time=minutes+":"+seconds;
                textView.setText(Time);
            }
        }
        totalWorkoutTime();
    }

    private void totalWorkoutTime()
    {
        int totalTime=0;
        int total_exercise=exercise_detailsArrayList.size();
        Log.d(total_exercise+"->", "totalWorkoutTime:size");

        String timeCountTime=time_countTime.getText().toString();
        String time_countTime_unit=time_countTime_sec.getText().toString();

        totalTime+=Total_workout_time_helper(timeCountTime,time_countTime_unit,0)*total_exercise;
        Log.d(totalTime+"->","totalTime1");

        String prepareTime=time_prepareTime.getText().toString();
        String prepareTimeUnit=time_prepareTime_sec.getText().toString();

        totalTime+=Total_workout_time_helper(prepareTime,prepareTimeUnit,0)*total_exercise;
        Log.d(totalTime+"->","totalTime2");

        String restTime=round_rest_time.getText().toString();
        String restTime_Unit=round_rest_time_unit.getText().toString();

        totalTime+=Total_workout_time_helper(restTime,restTime_Unit,0)*(total_exercise-1);
        Log.d(totalTime+"->","totalTime4");

        int totalRounds=Integer.parseInt(no_of_round.getText().toString());

        totalTime=totalTime*totalRounds;
        Log.d(totalTime+"->", "totalTime:");
        int minutes=totalTime/60;
        int sec=totalTime-minutes*60;
        if(minutes==0)
        {
            String time=timeCountTime+" sec";
            total_workout_time.setText(time);
        }
        else
        {
            String time=minutes+":"+sec+" min";
            total_workout_time.setText(time);
        }
    }

    private int Total_workout_time_helper(String time,String timeUnit,int Time)
    {
        if(timeUnit.equals("sec"))
        {
            Time=Integer.parseInt(time);
        }
        if(timeUnit.equals("min"))
        {
            String[] time1=time.split(":");
            int minutes=Integer.parseInt(time1[0]);
            int sec=Integer.parseInt(time1[1]);
            Time=minutes*60+sec;
        }
        return Time;
    }

    private int One_Round_calories()
    {
        String unit=time_countTime_sec.getText().toString();
        int each_exercise_time=0;
        if(unit.equals("sec"))
        {
            each_exercise_time=Integer.parseInt(time_countTime.getText().toString());

        }
        else
        {
            String[] str=time_countTime.getText().toString().split(":");
            each_exercise_time=Integer.parseInt(str[0])*60+Integer.parseInt(str[1]);
        }
        int times=each_exercise_time/10;
        if(each_exercise_time%10==0)
        {
            return times*exercise_detailsArrayList.size();
        }
        else {
            return times*exercise_detailsArrayList.size()+(exercise_detailsArrayList.size())/2;
        }
    }

}