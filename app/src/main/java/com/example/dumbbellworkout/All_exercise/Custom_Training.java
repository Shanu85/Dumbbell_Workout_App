package com.example.dumbbellworkout.All_exercise;

import java.util.ArrayList;

public class Custom_Training {
    private String Name;
    private ArrayList<Exercise> exercises;

    public Custom_Training(String name, ArrayList<Exercise> exercises) {
        Name = name;
        this.exercises = exercises;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
}
