package com.example.kuwait.AllNews;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import io.realm.RealmObject;

public class PostStorage extends RealmObject implements Parcelable {

    @Expose
    private String title;
    private String site;

    private String Details;

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public static Creator<PostStorage> getCREATOR() {
        return CREATOR;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Expose
    private String main_image;

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
    }

    @Expose
    private String auth;
    @Expose
    private String url;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.site);
        dest.writeString(this.main_image);
        dest.writeString(this.auth);
        dest.writeString(this.url);
    }

    public PostStorage() {
    }

    PostStorage(Parcel in) {
        this.title = in.readString();
        this.site = in.readString();
        this.main_image = in.readString();
        this.auth = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<PostStorage> CREATOR = new Parcelable.Creator<PostStorage>() {
        @Override
        public PostStorage createFromParcel(Parcel source) {
            return new PostStorage(source);
        }

        @Override
        public PostStorage[] newArray(int size) {
            return new PostStorage[size];
        }
    };
}
