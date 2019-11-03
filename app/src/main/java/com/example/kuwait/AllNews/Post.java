
package com.example.kuwait.AllNews;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post implements  Parcelable {

    @SerializedName("thread")
    @Expose
    private Thread thread;
//@Required
//@PrimaryKey
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("ord_in_thread")
    @Expose
    private int ordInThread;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("highlightText")
    @Expose
    private String highlightText;
    @SerializedName("highlightTitle")
    @Expose
    private String highlightTitle;
    @SerializedName("language")
    @Expose
    private String language;


    @SerializedName("crawled")
    @Expose
    private String crawled;

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrdInThread() {
        return ordInThread;
    }

    public void setOrdInThread(int ordInThread) {
        this.ordInThread = ordInThread;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHighlightText() {
        return highlightText;
    }

    public void setHighlightText(String highlightText) {
        this.highlightText = highlightText;
    }

    public String getHighlightTitle() {
        return highlightTitle;
    }

    public void setHighlightTitle(String highlightTitle) {
        this.highlightTitle = highlightTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }




    public String getCrawled() {
        return crawled;
    }

    public void setCrawled(String crawled) {
        this.crawled = crawled;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.thread, flags);
        dest.writeString(this.uuid);
        dest.writeString(this.url);
        dest.writeInt(this.ordInThread);
        dest.writeString(this.author);
        dest.writeString(this.published);
        dest.writeString(this.title);
        dest.writeString(this.text);
        dest.writeString(this.highlightText);
        dest.writeString(this.highlightTitle);
        dest.writeString(this.language);
        dest.writeString(this.crawled);
    }

    public Post() {
    }

    private Post(Parcel in) {
        this.thread = in.readParcelable(Thread.class.getClassLoader());
        this.uuid = in.readString();
        this.url = in.readString();
        this.ordInThread = in.readInt();
        this.author = in.readString();
        this.published = in.readString();
        this.title = in.readString();
        this.text = in.readString();
        this.highlightText = in.readString();
        this.highlightTitle = in.readString();
        this.language = in.readString();

        this.crawled = in.readString();
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
