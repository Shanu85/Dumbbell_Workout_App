package com.example.dumbbellworkout;

import com.example.dumbbellworkout.All_exercise.Exercise;

public class workout {
    private String workoutName;
    private int workoutImageId;
    private Exercise exercise1;
    private Exercise exercise2;
    private Exercise exercise3;
    private Exercise exercise4;
    private Exercise exercise5;
    private Exercise exercise6;

    public workout(String workoutName, int workoutImageId, Exercise exercise1, Exercise exercise2, Exercise exercise3, Exercise exercise4, Exercise exercise5, Exercise exercise6) {
        this.workoutName = workoutName;
        this.workoutImageId = workoutImageId;
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
        this.exercise3 = exercise3;
        this.exercise4 = exercise4;
        this.exercise5 = exercise5;
        this.exercise6 = exercise6;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public int getWorkoutImageId() {
        return workoutImageId;
    }

    public void setWorkoutImageId(int workoutImageId) {
        this.workoutImageId = workoutImageId;
    }

    public Exercise getExercise1() {
        return exercise1;
    }

    public void setExercise1(Exercise exercise1) {
        this.exercise1 = exercise1;
    }

    public Exercise getExercise2() {
        return exercise2;
    }

    public void setExercise2(Exercise exercise2) {
        this.exercise2 = exercise2;
    }

    public Exercise getExercise3() {
        return exercise3;
    }

    public void setExercise3(Exercise exercise3) {
        this.exercise3 = exercise3;
    }

    public Exercise getExercise4() {
        return exercise4;
    }

    public void setExercise4(Exercise exercise4) {
        this.exercise4 = exercise4;
    }

    public Exercise getExercise5() {
        return exercise5;
    }

    public void setExercise5(Exercise exercise5) {
        this.exercise5 = exercise5;
    }

    public Exercise getExercise6() {
        return exercise6;
    }

    public void setExercise6(Exercise exercise6) {
        this.exercise6 = exercise6;
    }
}
