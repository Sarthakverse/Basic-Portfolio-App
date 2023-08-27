package com.example.portfolioapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Education implements Parcelable
{
    private String secondary_college;
    private String secondary_degree;
    private String secondary_education_year;

    public Education(String secondary_college, String secondary_degree, String secondary_education_year) {
        this.secondary_college = secondary_college;
        this.secondary_degree = secondary_degree;
        this.secondary_education_year = secondary_education_year;
    }

    protected Education(Parcel in) {
        secondary_college = in.readString();
        secondary_degree = in.readString();
        secondary_education_year = in.readString();
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getSecondary_college() {
        return secondary_college;
    }

    public void setSecondary_college(String secondary_college) {
        this.secondary_college = secondary_college;
    }

    public String getSecondary_degree() {
        return secondary_degree;
    }

    public void setSecondary_degree(String secondary_degree) {
        this.secondary_degree = secondary_degree;
    }

    public String getSecondary_education_year() {
        return secondary_education_year;
    }

    public void setSecondary_education_year(String secondary_education_year) {
        this.secondary_education_year = secondary_education_year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(secondary_college);
        parcel.writeString(secondary_degree);
        parcel.writeString(secondary_education_year);
    }
}
