package com.example.portfolioapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Courses implements Parcelable
{
    private String secondary_organisation_name;
    private String secondary_course_name;

    private String secondary_course_year;

    public Courses(String secondary_organisation_name, String secondary_course_name, String secondary_course_year) {
        this.secondary_organisation_name = secondary_organisation_name;
        this.secondary_course_name = secondary_course_name;
        this.secondary_course_year = secondary_course_year;
    }

    protected Courses(Parcel in) {
        secondary_organisation_name = in.readString();
        secondary_course_name = in.readString();
        secondary_course_year = in.readString();
    }

    public static final Creator<Courses> CREATOR = new Creator<Courses>() {
        @Override
        public Courses createFromParcel(Parcel in) {
            return new Courses(in);
        }

        @Override
        public Courses[] newArray(int size) {
            return new Courses[size];
        }
    };

    public String getSecondary_organisation_name() {
        return secondary_organisation_name;
    }

    public void setSecondary_organisation_name(String secondary_organisation_name) {
        this.secondary_organisation_name = secondary_organisation_name;
    }

    public String getSecondary_course_name() {
        return secondary_course_name;
    }

    public void setSecondary_course_name(String secondary_course_name) {
        this.secondary_course_name = secondary_course_name;
    }

    public String getSecondary_course_year() {
        return secondary_course_year;
    }

    public void setSecondary_course_year(String secondary_course_year) {
        this.secondary_course_year = secondary_course_year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(secondary_organisation_name);
        parcel.writeString(secondary_course_name);
        parcel.writeString(secondary_course_year);
    }
}
