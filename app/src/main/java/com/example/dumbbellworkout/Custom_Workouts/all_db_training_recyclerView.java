package com.example.dumbbellworkout.Custom_Workouts;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.R;

import java.util.ArrayList;
import java.util.Objects;

public class all_db_training_recyclerView extends RecyclerView.Adapter<all_db_training_recyclerView.ViewHolder>{

    private ArrayList<String> all_exercise_arrayList=new ArrayList<>();
    private Context context;

    public all_db_training_recyclerView(Context context)
    {
        this.context=context;
    }

    public void setAll_exercise_arrayList(ArrayList<String> all_exercise_arrayList) {
        notifyDataSetChanged();
        this.all_exercise_arrayList = all_exercise_arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_db_training_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name=all_exercise_arrayList.get(position);
        if(DataBase.all_exercise_database.get(name)!=null)
        {
            holder.all_training_image1.setImageResource(DataBase.all_exercise_database.get(name).getImage());
            holder.all_training_text1.setText(DataBase.all_exercise_database.get(name).getName());
        }
        String str="";
        String[] val= Objects.requireNonNull(DataBase.all_exercise_database.get(name)).getTarget_bodypart().split(" ");
        for(String s:val)
        {
            str+="#"+s+" ";
        }
        holder.all_training_text2.setText(str);

        holder.all_training_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,training_info_activtity.class);
                intent.putExtra("Exercise",name);
                context.startActivity(intent);

            }
        });

        Log.d("msg2","inside all_db_training_recyclerView");
    }

    @Override
    public int getItemCount() {
        return all_exercise_arrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView all_training_image1,all_training_image2;
        private TextView all_training_text1,all_training_text2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            all_training_image1=itemView.findViewById(R.id.all_training_image1);
            all_training_image2=itemView.findViewById(R.id.all_training_image2);
            all_training_text1=itemView.findViewById(R.id.all_training_text1);
            all_training_text2=itemView.findViewById(R.id.all_training_text2);
        }
    }
}