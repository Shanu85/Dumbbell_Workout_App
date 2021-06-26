package com.example.dumbbellworkout.All_exercise;

import com.example.dumbbellworkout.R;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase{
    public static HashMap<String,Exercise> all_exercise_database=new HashMap<>();
    public static String FILE_NAME="internalDataExample.txt";
    private static Context context;
    private static Files files;

    public static String DUMBBELL_CHECK_PRESSES="Dumbbell Check Presses";
    public static String DUMBBELL_PRESSES_LYING="Dumbbell presses lying";
    public static String CURLING_DUMBBELL_SITTING="Curling a Dumbbell Sitting";
    public static String DUMBBELL_FLYES_LYING="Dumbbell Flyes Lying";
    public static String DUMBBELL_CONCENTRATION_CURL_SITTING="Dumbbell Concentration Curls Sitting";
    public static String SIT_UPS_WITH_ROTATION="Sit up with rotations";
    public static String SLOPES_WITH_DUMBBELL="Slope with dumbbells";
    public static String RENEGADE_ROWS_STANDING="Renegade Rows Standing";
    public static String FRENCH_DUMBBELL_PRESSES="French Dumbbell Presses";
    public static String EXTEND_ARM_SLOPES="Extend Arms back in the Slope";
    public static String DUMBBELL_FLYES_STANDING="Dumbbell Flyes Standing";
    public static String DUMBBELL_FRONT_RAISES="Dumbbell front raise";
    public static String DUMBBELL_LUNGE="Dumbbell Lunges";
    public static String ROMANIAN_ROD_LEG="Romanian Rod on one leg";
    public static String LEGS_RISES="Leg raises";
    public static String DUMBBELL_SQUATS="Dumbbell Squats";
    public static String SPLIT_SQUATS="Split Squats";
    public static String ONE_ARM_DUMBBELL_PRESSES="One Arm Dumbbell Presses";
    public static String CURLING_DUMBBELL_STANDING="Curling a Dumbbell Standing";
    public static String HAMMER="Hammer";
    public static String DUMBBELL_SHRUG="Dumbbell Shrug";
    public static String SEATED_DUMBBELL_PRESSES="Seated Dumbbell Presses";
    public static String SNATCH_FROM_FLOOR="Snatch from Floor";
    public static String TWO_ARMS_DUMBBELL_PRESSES="Two arms Dumbbell Presses";
    public static String SQUATS_WITH_JUMPS="Squats with jumps";
    public static String PLAMS_UP_WRIST_CURL="Palms-up wrist curl";
    public static String TRICEPS_DIP="Triceps dip";

    public DataBase(Context context) {
        this.context=context;
        addExercise();
        files=new Files(context);
        files.clear(FILE_NAME);
    }


    private void addExercise()
    {
        Exercise exercise1=new Exercise(CURLING_DUMBBELL_STANDING, R.mipmap.ic_launcher,"Biceps",exercise1Dis());
        Exercise exercise2=new Exercise(CURLING_DUMBBELL_SITTING,R.mipmap.ic_launcher,"Biceps",exercise2Dis());
        Exercise exercise3=new Exercise(HAMMER,R.mipmap.ic_launcher,"Biceps",exercise3Dis());
        Exercise exercise4=new Exercise(DUMBBELL_CONCENTRATION_CURL_SITTING,R.mipmap.ic_launcher,"Biceps",exercise4Dis());
        Exercise exercise5=new Exercise(ONE_ARM_DUMBBELL_PRESSES,R.mipmap.ic_launcher,"Triceps",exercise5Dis());
        Exercise exercise6=new Exercise(TWO_ARMS_DUMBBELL_PRESSES,R.mipmap.ic_launcher,"Triceps",exercise6Dis());
        Exercise exercise7=new Exercise(FRENCH_DUMBBELL_PRESSES,R.mipmap.ic_launcher,"Triceps",exercise7Dis());
        Exercise exercise8=new Exercise(EXTEND_ARM_SLOPES,R.mipmap.ic_launcher,"Triceps",exercise8Dis());
        Exercise exercise9=new Exercise(SEATED_DUMBBELL_PRESSES,R.mipmap.ic_launcher,"Triceps",exercise9Dis());
        Exercise exercise10=new Exercise(DUMBBELL_CHECK_PRESSES,R.mipmap.ic_launcher,"Shoulders",exercise10Dis());
        Exercise exercise11=new Exercise(DUMBBELL_FLYES_STANDING,R.mipmap.ic_launcher,"Shoulders",exercise11Dis());
        Exercise exercise12=new Exercise(DUMBBELL_PRESSES_LYING,R.mipmap.ic_launcher,"Chest",exercise12Dis());
        Exercise exercise13=new Exercise(DUMBBELL_FLYES_LYING,R.mipmap.ic_launcher,"Chest",exercise13Dis());
        Exercise exercise14=new Exercise(DUMBBELL_SHRUG,R.mipmap.ic_launcher,"Back",exercise14Dis());
        Exercise exercise15=new Exercise(RENEGADE_ROWS_STANDING,R.mipmap.ic_launcher,"Back",exercise15Dis());
        Exercise exercise16=new Exercise(DUMBBELL_SQUATS,R.mipmap.ic_launcher,"Legs",exercise16Dis());
        Exercise exercise17=new Exercise(DUMBBELL_LUNGE,R.mipmap.ic_launcher,"Legs",exercise17Dis());
        Exercise exercise18=new Exercise(SNATCH_FROM_FLOOR,R.mipmap.ic_launcher,"Shoulders Legs Back",exercise18Dis());
        Exercise exercise19=new Exercise(SQUATS_WITH_JUMPS,R.mipmap.ic_launcher,"Legs",exercise19Dis());
        Exercise exercise20=new Exercise(SPLIT_SQUATS,R.mipmap.ic_launcher,"Legs",exercise20Dis());
        Exercise exercise21=new Exercise(ROMANIAN_ROD_LEG,R.mipmap.ic_launcher,"Legs Buttocks",exercise21Dis());
        Exercise exercise22=new Exercise(SIT_UPS_WITH_ROTATION,R.mipmap.ic_launcher,"abs",exercise22Dis());
        Exercise exercise23=new Exercise(LEGS_RISES,R.mipmap.ic_launcher,"abs",exercise23Dis());
        Exercise exercise24=new Exercise(PLAMS_UP_WRIST_CURL,R.mipmap.ic_launcher,"Forearms",exercise24Dis());
        Exercise exercise25=new Exercise(DUMBBELL_FRONT_RAISES,R.mipmap.ic_launcher,"Shoulder Chest Biceps",exercise25Dis());
        Exercise exercise26=new Exercise(TRICEPS_DIP,R.mipmap.ic_launcher,"Triceps",exercise26Dis());
        Exercise exercise27=new Exercise(SLOPES_WITH_DUMBBELL,R.mipmap.ic_launcher,"Back Buttocks",exercise27Dis());

        all_exercise_database.put(CURLING_DUMBBELL_STANDING,exercise1);
        all_exercise_database.put(CURLING_DUMBBELL_SITTING,exercise2);
        all_exercise_database.put(HAMMER,exercise3);
        all_exercise_database.put(DUMBBELL_CONCENTRATION_CURL_SITTING,exercise4);
        all_exercise_database.put(ONE_ARM_DUMBBELL_PRESSES,exercise5);
        all_exercise_database.put(TWO_ARMS_DUMBBELL_PRESSES,exercise6);
        all_exercise_database.put(FRENCH_DUMBBELL_PRESSES,exercise7);
        all_exercise_database.put(EXTEND_ARM_SLOPES,exercise8);
        all_exercise_database.put(SEATED_DUMBBELL_PRESSES,exercise9);
        all_exercise_database.put(DUMBBELL_CHECK_PRESSES,exercise10);
        all_exercise_database.put(DUMBBELL_FLYES_STANDING,exercise11);
        all_exercise_database.put(DUMBBELL_PRESSES_LYING,exercise12);
        all_exercise_database.put(DUMBBELL_FLYES_LYING,exercise13);
        all_exercise_database.put(DUMBBELL_SHRUG,exercise14);
        all_exercise_database.put(RENEGADE_ROWS_STANDING,exercise15);
        all_exercise_database.put(DUMBBELL_SQUATS,exercise16);
        all_exercise_database.put(DUMBBELL_LUNGE,exercise17);
        all_exercise_database.put(SNATCH_FROM_FLOOR,exercise18);
        all_exercise_database.put(SQUATS_WITH_JUMPS,exercise19);
        all_exercise_database.put(SPLIT_SQUATS,exercise20);
        all_exercise_database.put(ROMANIAN_ROD_LEG,exercise21);
        all_exercise_database.put(SIT_UPS_WITH_ROTATION,exercise22);
        all_exercise_database.put(LEGS_RISES,exercise23);
        all_exercise_database.put(PLAMS_UP_WRIST_CURL,exercise24);
        all_exercise_database.put(DUMBBELL_FRONT_RAISES,exercise25);
        all_exercise_database.put(TRICEPS_DIP,exercise26);
        all_exercise_database.put(SLOPES_WITH_DUMBBELL,exercise27);

    }

    private String exercise27Dis() {
        return "Stand straight with dumbbells in both of your hand.Now slowly bend your upper body without moving lower lower body. Bend till dumbbells in your hand just touch the floor, then slowly start moving to starting position. Don't use heavy weight without waist belt.";
    }

    private String exercise26Dis() {
        return "Sit on a sturdy chair. Place your arms at your sides and your feet flat on the floor.Place your palms facing down beside your hips and grip the front of the seat.Move your body off the chair while gripping the seat. Knees should be slightly bent and your glutes should hover over the floor. Your arms should be fully extended, supporting your weight."
                +"Inhale and lower your body until your elbows form a 90-degree angle.Pause at the bottom, exhale, then push your body up to the starting position, squeezing your triceps at the top.";
    }

    private String exercise25Dis() {
        return "Sit or stand with a dumbbell in each hand.Position your arms in front of you, with your palms facing your thighs.Slowly raise the dumbbells up, keeping your arms straight, until your arms are parallel to the ground.Slowly return the dumbbells to the starting position.";
    }

    private String exercise24Dis() {
        return "While seated, rest your wrists on your knees or a flat surface with your palms facing up, holding a dumbbell in each hand.With a dumbbell in each hand, raise your hands as high as you can, keeping your arms still.After a slight pause, lower your hands to the starting position.";
    }

    private String exercise23Dis() {
        return "Lying on your back, hold the Dumbbells in front of you with your arms outstretched, pull up your legs and push up, and after touching the dumbbells return to the starting position and repeat.";
    }

    private String exercise22Dis() {
        return "Lie faceup, feet planted on the floor with your knees bent, hands clasped above your chest. Perform a sit-up and rotate to the right, right knee coming to meet left elbow. Slowly lower down to starting position. Then, perform a sit-up and rotate to the left, left knee coming to meet right elbow. Slowly lower down to starting position. Continue alternating sides.";
    }

    private String exercise21Dis() {
        return "Stand with your feet shoulder-width apart and knees slightly bent and raise one leg off the floor.Without changing the bend in your knee, keep your back naturally arched, bend (hinge) at your hips, and lower your torso until it’s almost parallel to the floor"
                +"Briefly pause at the bottom, then squeeze you glutes, thrust your hips forward, and raise your torso back to the starting position.Be sure to hold the weight in the opposite hand of your work leg";
    }

    private String exercise20Dis() {
        return "From a standing position, take a long step forwards as if performing a lunge. The heel of your back foot should be raised. Keeping your torso straight, lower slowly until your back knee almost touches the floor, then push back up. Complete all your reps on one leg, then switch to the other. Keep your knees in line with your toes, especially on the front leg, and don’t let the front knee stray past your foot as you lower."
                +"Initiate the movement with the back leg rather than front. This reduces the risk of injury on your front knee.";
    }

    private String exercise19Dis() {
        return "Use a dumbbell or kettlebell that is challenging but still allows you to be explosive (about 10-20% of your bodyweight is ideal)Hold the dumbbell with straight arms and jump as high as you can. Land, tap the dumbbell to the floor and explode up into your jump as fast as possible. We are aiming for max jump height and max speed"
                +"dumbbell squat jump is a free weights and plyometrics exercise that primarily targets the glutes and to a lesser degree also targets the calves, hamstrings, outer thighs and quads.";
    }

    private String exercise18Dis() {
        return "Stand with your feet shoulder-width apart, holding a dumbbell in an overhand grip. Sit your hips back and lower into a squat, letting the dumbbell hang down to touch the floor directly beneath your chest. "
                +"Return to standing and lift the dumbbell explosively using your legs and back. Once it reaches the level of your hips, start pulling the dumbbell up with your arm, using the momentum created by your legs. As the dumbbell reaches shoulder height, quickly flip your elbow underneath the weight and press it overhead, locking out your elbow.Reverse the movement to return to the start, moving more slowly than in the explosive lifting phase. ";
    }

    private String exercise17Dis() {
        return "Stand up straight with a dumbbell in each hand. Hang your arms at your sides. Palms should face the thighs and Feet should be a little less than shoulder-width apart.Take a big step forward with either leg, bending at the knee until the front thigh approaches parallel to the ground,"+
                " landing on the heel. Inhale as you go down. The rear leg is bent at the knee and balanced on the toes. For the leg you step forward with, don't let the knee go past the tip of the toes.Step back to your standing starting position while exhaling.";
    }

    private String exercise16Dis() {
        return "The dumbbell squat targets the quads and glutes, but also works the hamstrings and calves.For performing, dumbbell squats stand with your feet hip to shoulder-width apart, holding a pair of dumbbells at arm’s length by your sides."
                +"Keeping your back flat and core braced, push your hips back, bend your knees, and lower your body until your thighs are parallel to the floor. Pause, then push yourself back up to the starting position.";
    }

    private String exercise15Dis() {
        return "Stand with feet shoulder-width apart and hold a dumbbell in each hand.Bend the knees slightly and bend over at the waist with your back straight.Let dumbbells hand in front of back with arms fully extended. Contract your back bend the arms and pull both bumbbells up to your ribcage."
                +"Hold for one second in the top position, then lower the dumbbells to the starting position.";
    }

    private String exercise14Dis() {
        return "Assume a standing position with the dumbbells on both sides of your body.Hinge forward, inhale, and grab the dumbbells with a neutral grip.Stand up tall and ensure your spine remains neutral."
                +"Contract the traps to elevate the shoulders. Squeeze hard at the top and slowly lower the dumbbells back to the starting position.Repeat for the desired number of repetitions.";
    }

    private String exercise13Dis() {
        return "Start by lying on your back with your feet placed flat on the floor. Grasp the dumbbells with your palms facing inward.Push the dumbbells directly above your chest with lightly bent elbows, keeping your wrists straight.Inhale and slowly lower the dumbbells toward the floor at shoulder height, maintaining a soft roundness with your arms. Stop when the backs of your upper arms touch the mat."+
                "Exhale and slowly raise the dumbbells back to the starting position while maintaining the arc in your arms.";
    }

    private String exercise12Dis() {
        return "Lie back on a bench holding a dumbbell in each hand just to the sides of your shoulders. Your palms should be facing towards your feet in the starting position, although if you have shoulder issues then switch to a neutral grip, where the palms face each other. Press the weights above your chest by extending your elbows until your arms are straight,"+
                "then bring the weights back down slowly. To take advantage of the range of movement offered by using dumbbells rather than a barbell, take the weights down past your shoulders and bring them closer together at the top of the movement. Don’t touch them at the top, though, because that will take some of the strain off your muscles.";
    }

    private String exercise11Dis() {
        return "For this exercise low weight is recommended.Take the weight stand up straight and slightly bend your elbows.Vigorously mix the dumbbells to the sides until the level of the head.Hold on a second. Now gradually lower the hands and raise again."+
                "Repeat recommended number of times.Exercise is allowed in the sitting position.";
    }

    private String exercise10Dis() {
        return "Stand holding a pair of dumbbells, palms facing each other and raise arms to shoulder-level in front of you.Bend your elbows 90 degrees.Press the weights straight up then rotate your arms outward until your palms face forward."+
                "Lower the weights to the sides of your body until they are just outside the shoulder-width.";
    }

    private String exercise9Dis() {
        return "Pick up the dumbbells from the floor using a neutral grip (palms facing in). Position the end of the dumbbells on your knees and sit down on the bench.Take a deep breath then press the dumbbells overhead by extending the elbows and contracting the deltoids." +
                "Slowly lower the dumbbells back to the starting position (the arms should be roughly 90 degrees or slightly lower depending upon limb lengths).";
    }

    private String exercise8Dis() {
        return "Stand with your feet hip-distance apart with your knees slightly bent and your hips hinging forward. Hold a dumbbell in each hand at the sides by your chest so your elbows are bent at about 90 degrees. Engaging your triceps, straighten your arms behind you with your palms facing in. Your arms should be fully extended in a straight line parallel to your torso.";
    }

    private String exercise7Dis() {
        return "Lie on a sturdy bench with your knees bent and feet flat. Hold five to 10 pounds dumbbells in each hand and straighten your arms directly over your chest (A). Keeping your palms facing each other, bend your elbows, and slowly lower the dumbbells toward your shoulders until your lower arm is at a 45-degree angle to your upper arm (B)."+
                "Pause here for two seconds, press back to the starting position.The amount of weight and the number of repetitions you start with is up to you, but 10-12 reps for three sets is ideal.";
    }

    private String exercise6Dis() {
        return "Before performing presses check out the dumbbell on the reliability of locks. If the dumbbell is heavy, use a dumbbell belt around waist. Take the weight plate with both hands.For more safety put your thumb around a barbell.Stand up straight,feet shoulder width apart."+
                "Lift the dumbbell over your head.Slowly lower the dumbbell behind your head bending elbows, do not breed them to the side. Don't use body momentum.";
    }

    private String exercise5Dis() {
        return "Start by having a dumbbell in one hand with your arm fully extended to the side using a neutral grip.The other hand can be kept fully extended to the side, by the waist or grabbing a fixed surface. Rotate the wrist so that the plam of your hand is facing forward."+
                "Slowly lower the dumbbell behind your head as you hold the upper arm stationary.The Upper arm does not move, only works forearm.Pause when your triceps are fully stretched. You can do this exercise sitting and standing.";
    }

    private String exercise4Dis() {
        return "Sit on a bench,Pick up a dumbbell in your hand and place the back of your upper right arm on the inner part of your right thigh. Slowly curl the weight up, only moving your forearms – the position of your upper arm on your thigh will help you keep it still during the exercise. At the top of the move, pause for a beat and squeeze your biceps, "+
                "then slowly lower the weight back to the start. Do all your reps on one arm, then switch to the other.";
    }

    private String exercise3Dis() {
        return "Stand with your feet shoulder-width apart and a slight bend in your knees. Hold a pair of dumbbells in your hands with your palms facing towards your body – this is the main difference from the standard curl, which you start with your palms facing forwards. Keeping your elbows close to your body,"+
                "slowly curl the dumbbell up to your shoulders. Pause for a second at the top of the lift, squeeze your biceps, then lower the weights under control.";
    }

    private String exercise2Dis() {
        return "Sitting on a bench, hold a pair of dumbbells at your sides with your arms fully extended and your palms facing forward.Without moving your upper arms, bend your elbows and curl the dumbbells to your shoulders. Pause, then lower the weights to the starting position."+
                "Keep a controlled pace throughout the movement to avoid using momentum.Lower the weight all the way until your arms are fully extended.Make sure to squeeze the biceps at the top of the lift.";
    }

    private String exercise1Dis() {
        return "Assume the starting position for the standing dumbbell curl by grasping a pair of dumbbells and standing straight up, feet together and dumbbells by your side. The dumbbells should not be touching your body. " +
                "Your palms should facing upwards.Take up the slack by bending the elbows slightly. Tension should be on the biceps.Slowly curl the dumbbells up as far as possible.Squeeze the biceps hard, and then slowly lower the dumbbells back down to the starting position.";
    }

    public static void write(String str)
    {
        files.append(FILE_NAME,str);
    }

    public static ArrayList<String> read()
    {
        return files.readArr(FILE_NAME);
    }

    public static void clear()
    {
        files.clear(FILE_NAME);
    }
}
