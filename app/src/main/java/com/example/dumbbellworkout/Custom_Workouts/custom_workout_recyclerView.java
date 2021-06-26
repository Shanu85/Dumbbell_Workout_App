package com.example.dumbbellworkout.Custom_Workouts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dumbbellworkout.All_exercise.Custom_Training;
import com.example.dumbbellworkout.R;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class custom_workout_recyclerView extends RecyclerView.Adapter<custom_workout_recyclerView.ViewHolder>{

    public Context context;
    private ArrayList<Custom_Training> container=new ArrayList<>();
    public custom_workout_recyclerView(Context context)
    {
        this.context=context;
    }

    public void setContainer(ArrayList<Custom_Training> container) {
        notifyDataSetChanged();
        this.container = container;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_training,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Custom_Training custom_training=container.get(position);
        holder.training_name.setText(custom_training.getName());
        String val=custom_training.getExercises().size()+" Exercise";
        holder.training_no.setText(val);
        holder.mytraingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Start Exercise",Toast.LENGTH_SHORT).show();
            }
        });
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("User");
        holder.mytraingEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dropdownmenu=new PopupMenu(context,holder.mytraingEdit);
                dropdownmenu.getMenuInflater().inflate(R.menu.my_training_edit_dropdown,dropdownmenu.getMenu());
                dropdownmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId()==R.id.Delete)
                        {
                            AlertDialog.Builder builder=new AlertDialog.Builder(context);
                            builder.setMessage("Are you sure you want to delete it?");
                            builder.setCancelable(true);
                            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });

                            builder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String str=holder.training_name.getText().toString();
                                    reference.child(str).removeValue();
                                    Intent intent=new Intent(context,custom_workout_activity.class);
                                    context.startActivity(intent);
                                }
                            });

                            AlertDialog alertDialog=builder.create();
                            alertDialog.show();
                        }

                        return true;
                    }
                });
                dropdownmenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return container.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private MaterialCardView mytraingCard;
        private TextView training_name,training_no;
        private ImageView mytraingEdit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mytraingCard=itemView.findViewById(R.id.mytraingCard);
            training_name=itemView.findViewById(R.id.training_name);
            training_no=itemView.findViewById(R.id.training_no);
            mytraingEdit=itemView.findViewById(R.id.mytraingEdit);
        }
    }

}

