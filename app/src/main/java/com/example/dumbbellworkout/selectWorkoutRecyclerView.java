package com.example.dumbbellworkout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.All_exercise.Exercise;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class selectWorkoutRecyclerView extends RecyclerView.Adapter<selectWorkoutRecyclerView.ViewHolder>{

    private ArrayList<workout> workoutArrayList=new ArrayList<>();
    private Context context;

    public selectWorkoutRecyclerView(Context context) {
        this.context = context;
    }

    public void setWorkoutArrayList(ArrayList<workout> workoutArrayList) {
        this.workoutArrayList = workoutArrayList;
        notifyDataSetChanged(); // alter data if this array list changes
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.allexercise,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.workoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Exercise> all_exercise_in_workout=exercise_in_workout(position);

                Intent intent=new Intent(context,startWorkout_activity.class);
                Log.d("position", String.valueOf(position));
                Bundle bundle=new Bundle();
                bundle.putParcelableArrayList(startWorkout_activity.startWorkout_Key,all_exercise_in_workout);
                intent.putExtra("bundle",bundle);

                Log.d("Exercise Arraylist size",all_exercise_in_workout.toString());
                context.startActivity(intent); //TODO:How to start activity

                Toast.makeText(context,"Change page to next",Toast.LENGTH_SHORT).show();
            }
        });
        holder.workoutnameTxt.setText(workoutArrayList.get(position).getWorkoutName());
        holder.exerciseIcon.setImageResource(workoutArrayList.get(position).getWorkoutImageId());
        holder.firstexerciseImage.setImageResource(workoutArrayList.get(position).getExercise1().getImage());
        holder.secondexerciseImage.setImageResource(workoutArrayList.get(position).getExercise2().getImage());
        holder.thirdexerciseImage.setImageResource(workoutArrayList.get(position).getExercise3().getImage());
        holder.fourthexerciseImage.setImageResource(workoutArrayList.get(position).getExercise4().getImage());
        holder.fifthexerciseImage.setImageResource(workoutArrayList.get(position).getExercise5().getImage());
        if(workoutArrayList.get(position).getExercise6()!=null)
        {
            holder.sixthexerciseImage.setImageResource(workoutArrayList.get(position).getExercise6().getImage());
        }

    }

    @Override
    public int getItemCount() {
        return workoutArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private MaterialCardView workoutCard;
        private ImageView exerciseIcon,firstexerciseImage,secondexerciseImage,thirdexerciseImage,fourthexerciseImage,fifthexerciseImage,sixthexerciseImage;
        private TextView workoutnameTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutCard=itemView.findViewById(R.id.allexerciseParent);
            workoutnameTxt=itemView.findViewById(R.id.workoutnameTxt);
            exerciseIcon=itemView.findViewById(R.id.exerciseIcon);
            firstexerciseImage=itemView.findViewById(R.id.firstexerciseImage);
            secondexerciseImage=itemView.findViewById(R.id.secondexerciseImage);
            thirdexerciseImage=itemView.findViewById(R.id.thirdexerciseImage);
            fourthexerciseImage=itemView.findViewById(R.id.fourthexerciseImage);
            fifthexerciseImage=itemView.findViewById(R.id.fifthexerciseImage);
            sixthexerciseImage=itemView.findViewById(R.id.sixthexerciseImage);
        }
    }

    public ArrayList<Exercise> exercise_in_workout(int position)
    {
        ArrayList<Exercise> exercises=new ArrayList<>();
        HashMap<String,Exercise> hashMap=DataBase.all_exercise_database;
        if(position==0)
        {
            Exercise exercise1=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_PRESSES_LYING)));
            Exercise exercise2=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.CURLING_DUMBBELL_SITTING)));
            Exercise exercise3=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_FLYES_LYING)));
            Exercise exercise4=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_CONCENTRATION_CURL_SITTING)));
            Exercise exercise5=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SIT_UPS_WITH_ROTATION)));
            Exercise exercise6=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SLOPES_WITH_DUMBBELL)));
            exercises.add(exercise1);
            exercises.add(exercise2);
            exercises.add(exercise3);
            exercises.add(exercise4);
            exercises.add(exercise5);
            exercises.add(exercise6);
            return exercises;
        }
        if(position==1)
        {
            Exercise exercise1=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.RENEGADE_ROWS_STANDING)));
            Exercise exercise2=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.FRENCH_DUMBBELL_PRESSES)));
            Exercise exercise3=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.EXTEND_ARM_SLOPES)));
            Exercise exercise4=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SIT_UPS_WITH_ROTATION)));
            Exercise exercise5=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SLOPES_WITH_DUMBBELL)));
            exercises.add(exercise1);
            exercises.add(exercise2);
            exercises.add(exercise3);
            exercises.add(exercise4);
            exercises.add(exercise5);
            return exercises;
        }
        if(position==2)
        {
            Exercise exercise1=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_FLYES_STANDING)));
            Exercise exercise2=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_FRONT_RAISES)));
            Exercise exercise3=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_LUNGE)));
            Exercise exercise4=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.ROMANIAN_ROD_LEG)));
            Exercise exercise5=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.LEGS_RISES)));
            exercises.add(exercise1);
            exercises.add(exercise2);
            exercises.add(exercise3);
            exercises.add(exercise4);
            exercises.add(exercise5);
            return exercises;
        }
        if(position==3)
        {
            Exercise exercise1=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_SQUATS)));
            Exercise exercise2=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SPLIT_SQUATS)));
            Exercise exercise3=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.RENEGADE_ROWS_STANDING)));
            Exercise exercise4=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.ONE_ARM_DUMBBELL_PRESSES)));
            Exercise exercise5=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SIT_UPS_WITH_ROTATION)));
            Exercise exercise6=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.LEGS_RISES)));
            exercises.add(exercise1);
            exercises.add(exercise2);
            exercises.add(exercise3);
            exercises.add(exercise4);
            exercises.add(exercise5);
            exercises.add(exercise6);
            return exercises;
        }
        if(position==4)
        {
            Exercise exercise1=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SLOPES_WITH_DUMBBELL)));
            Exercise exercise2=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_LUNGE)));
            Exercise exercise3=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_PRESSES_LYING)));
            Exercise exercise4=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.CURLING_DUMBBELL_STANDING)));
            Exercise exercise5=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.HAMMER)));
            exercises.add(exercise1);
            exercises.add(exercise2);
            exercises.add(exercise3);
            exercises.add(exercise4);
            exercises.add(exercise5);
            return exercises;
        }
        if(position==5)
        {
            Exercise exercise1=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_SHRUG)));
            Exercise exercise2=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_FLYES_LYING)));
            Exercise exercise3=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SEATED_DUMBBELL_PRESSES)));
            Exercise exercise4=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_FRONT_RAISES)));
            Exercise exercise5=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_FLYES_STANDING)));
            Exercise exercise6=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.LEGS_RISES)));
            exercises.add(exercise1);
            exercises.add(exercise2);
            exercises.add(exercise3);
            exercises.add(exercise4);
            exercises.add(exercise5);
            exercises.add(exercise6);
            return exercises;
        }
        if(position==6)
        {
            Exercise exercise1=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.CURLING_DUMBBELL_STANDING)));
            Exercise exercise2=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_CHECK_PRESSES)));
            Exercise exercise3=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.CURLING_DUMBBELL_SITTING)));
            Exercise exercise4=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.SNATCH_FROM_FLOOR)));
            Exercise exercise5=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.HAMMER)));
            Exercise exercise6=new Exercise(Objects.requireNonNull(hashMap.get(DataBase.DUMBBELL_FLYES_STANDING)));
            exercises.add(exercise1);
            exercises.add(exercise2);
            exercises.add(exercise3);
            exercises.add(exercise4);
            exercises.add(exercise5);
            exercises.add(exercise6);
            return exercises;
        }
        return exercises;
    }

}
