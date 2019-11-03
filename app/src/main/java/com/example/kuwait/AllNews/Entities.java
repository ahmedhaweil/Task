
package com.example.kuwait.AllNews;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entities implements Parcelable {

    @SerializedName("persons")
    @Expose
    private List<Object> persons = null;
    @SerializedName("organizations")
    @Expose
    private List<Object> organizations = null;
    @SerializedName("locations")
    @Expose
    private List<Object> locations = null;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.persons);
        dest.writeList(this.organizations);
        dest.writeList(this.locations);
    }

    public Entities() {
    }

    Entities(Parcel in) {
        this.persons = new ArrayList<>();
        in.readList(this.persons, Object.class.getClassLoader());
        this.organizations = new ArrayList<>();
        in.readList(this.organizations, Object.class.getClassLoader());
        this.locations = new ArrayList<>();
        in.readList(this.locations, Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<Entities> CREATOR = new Parcelable.Creator<Entities>() {
        @Override
        public Entities createFromParcel(Parcel source) {
            return new Entities(source);
        }

        @Override
        public Entities[] newArray(int size) {
            return new Entities[size];
        }
    };
}
