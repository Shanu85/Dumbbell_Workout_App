package com.example.dumbbellworkout.Custom_Workouts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.dumbbellworkout.All_exercise.DataBase;
import com.example.dumbbellworkout.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class savePopUp extends AppCompatDialogFragment {
    private EditText plan_name;
    private Context context;
    private ArrayList<String> data;
    public savePopUp(Context context, ArrayList<String> data)
    {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.save_popup,null);
        builder.setView(view)
                .setTitle("Please name your Plan")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataBase.clear();
                        Intent intent=new Intent(context,custom_workout_activity.class);
                        context.startActivity(intent);
                    }
                })
                .setPositiveButton("OK",null);

        plan_name=view.findViewById(R.id.save_popup_plan_name);
        Dialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        String str=plan_name.getText().toString();
                        if(str.length()==0)
                        {
                            plan_name.setError("Enter your plan name!");
                        }
                        else
                        {
                            Intent intent=new Intent(context,custom_workout_activity.class);
                            DataBase.clear();
                            DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("User").child(str);
                            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if(snapshot.exists())
                                    {
                                        plan_name.setError("Plan name already exists!");
                                    }
                                    else
                                    {
                                        reference.setValue(data)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if(task.isSuccessful())
                                                        {
                                                            Toast.makeText(context,"Saved!",Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                        startActivity(intent);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                        }
                    }
                });
            }
        });
        return dialog;
    }
}
