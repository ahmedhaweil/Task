
package com.example.kuwait.AllNews;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsModel  {
    @SerializedName("posts")
    @Expose
    private
    List<Post> posts = null;

    @SerializedName("totalResults")
    @Expose
    private int totalResults;
    @SerializedName("moreResultsAvailable")
    @Expose
    private int moreResultsAvailable;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("requestsLeft")
    @Expose
    private int requestsLeft;
    @SerializedName("warnings")
    @Expose
    private Object warnings;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getMoreResultsAvailable() {
        return moreResultsAvailable;
    }

    public void setMoreResultsAvailable(int moreResultsAvailable) {
        this.moreResultsAvailable = moreResultsAvailable;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getRequestsLeft() {
        return requestsLeft;
    }

    public void setRequestsLeft(int requestsLeft) {
        this.requestsLeft = requestsLeft;
    }

    public Object getWarnings() {
        return warnings;
    }

    public void setWarnings(Object warnings) {
        this.warnings = warnings;
    }

}
