package com.example.dumbbellworkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dumbbellworkout.All_exercise.Exercise;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ExerciseRecyclerView extends RecyclerView.Adapter<ExerciseRecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<Exercise> exercise_detailsArrayList=new ArrayList<>();

    public ExerciseRecyclerView(Context context) {
        this.context = context;
    }

    public void setExercise_detailsArrayList(ArrayList<Exercise> exercise_detailsArrayList) {
        this.exercise_detailsArrayList = exercise_detailsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_workout_exercise,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.workout_exercise_name.setText(exercise_detailsArrayList.get(position).getName());
        holder.workout_exercise_image.setImageResource(exercise_detailsArrayList.get(position).getImage());
        holder.all_workout_exerciseParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Show exercise information",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return exercise_detailsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView workout_exercise_name;
        private ImageView workout_exercise_image;
        private MaterialCardView all_workout_exerciseParent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workout_exercise_image=itemView.findViewById(R.id.workout_exercise_image);
            workout_exercise_name=itemView.findViewById(R.id.workout_exercise_nameTxt);
            all_workout_exerciseParent=itemView.findViewById(R.id.all_workout_exerciseParent);
        }
    }
}
