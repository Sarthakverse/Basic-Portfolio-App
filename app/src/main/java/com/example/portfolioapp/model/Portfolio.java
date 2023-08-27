package com.example.portfolioapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Portfolio implements Parcelable
{
    private String secondary_name;
    private String secondary_position;

    private Education education;
    private Courses courses;
    private String gitHubUserName;

    public Portfolio(String secondary_name, String secondary_position, Education education, Courses courses, String gitHubUserName) {
        this.secondary_name = secondary_name;
        this.secondary_position = secondary_position;
        this.education = education;
        this.courses = courses;
        this.gitHubUserName = gitHubUserName;
    }

    protected Portfolio(Parcel in) {
        secondary_name = in.readString();
        secondary_position = in.readString();
        education = in.readParcelable(Education.class.getClassLoader());
        courses = in.readParcelable(Courses.class.getClassLoader());
        gitHubUserName = in.readString();
    }

    public static final Creator<Portfolio> CREATOR = new Creator<Portfolio>() {
        @Override
        public Portfolio createFromParcel(Parcel in) {
            return new Portfolio(in);
        }

        @Override
        public Portfolio[] newArray(int size) {
            return new Portfolio[size];
        }
    };

    public String getSecondary_name() {
        return secondary_name;
    }

    public void setSecondary_name(String secondary_name) {
        this.secondary_name = secondary_name;
    }

    public String getSecondary_position() {
        return secondary_position;
    }

    public void setSecondary_position(String secondary_position) {
        this.secondary_position = secondary_position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public String getGitHubUserName() {
        return gitHubUserName;
    }

    public void setGitHubUserName(String gitHubUserName) {
        this.gitHubUserName = gitHubUserName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(secondary_name);
        parcel.writeString(secondary_position);
        parcel.writeParcelable(education, i);
        parcel.writeParcelable(courses, i);
        parcel.writeString(gitHubUserName);
    }
}
