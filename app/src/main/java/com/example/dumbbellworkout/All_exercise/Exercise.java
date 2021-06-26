package com.example.dumbbellworkout.All_exercise;

import android.os.Parcel;
import android.os.Parcelable;

public class Exercise implements Parcelable {
    private String Name;
    private int image;
    private String target_bodypart;
    private String about;

    public Exercise(String name, int image, String target_bodypart, String about) {
        Name = name;
        this.image = image;
        this.target_bodypart = target_bodypart;
        this.about = about;
    }

    public Exercise(Exercise exercise)
    {
        this.Name=exercise.Name;
        this.image=exercise.image;
        this.target_bodypart=exercise.target_bodypart;
        this.about=exercise.about;
    }
    protected Exercise(Parcel in) {
        Name = in.readString();
        image = in.readInt();
        target_bodypart = in.readString();
        about = in.readString();
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTarget_bodypart() {
        return target_bodypart;
    }

    public void setTarget_bodypart(String target_bodypart) {
        this.target_bodypart = target_bodypart;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeInt(image);
        parcel.writeString(target_bodypart);
        parcel.writeString(about);
    }
}
