package com.example.dumbbellworkout.Challenge;

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
import com.example.dumbbellworkout.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class Daily_challenges_recyclerView extends RecyclerView.Adapter<Daily_challenges_recyclerView.ViewHolder>{

    private ArrayList<Exercise> exerciseArrayList=new ArrayList<>();
    private Context context;

    public Daily_challenges_recyclerView(Context context) {
        this.context = context;
    }

    public void setExerciseArrayList(ArrayList<Exercise> exerciseArrayList) {
        this.exerciseArrayList = exerciseArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_workout_exercise,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.workout_exercise_name.setText(exerciseArrayList.get(position).getName());
        holder.workout_exercise_image.setImageResource(exerciseArrayList.get(position).getImage());
        String rounds="x"+daily_challenges.random(21,14);
        holder.workout_no_rounds.setText(rounds);

        holder.all_workout_exerciseParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Show Info",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView workout_exercise_name;
        private ImageView workout_exercise_image;
        private MaterialCardView all_workout_exerciseParent;
        private TextView workout_no_rounds;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workout_exercise_image=itemView.findViewById(R.id.workout_exercise_image);
            workout_exercise_name=itemView.findViewById(R.id.workout_exercise_nameTxt);
            all_workout_exerciseParent=itemView.findViewById(R.id.all_workout_exerciseParent);
            workout_no_rounds=itemView.findViewById(R.id.workout_no_rounds);
        }
    }
}
