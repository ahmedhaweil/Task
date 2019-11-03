
package com.example.kuwait.AllNews;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thread implements Parcelable {

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("site_full")
    @Expose
    private String siteFull;
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("site_section")
    @Expose
    private String siteSection;
    @SerializedName("site_categories")
    @Expose
    private List<String> siteCategories = null;
    @SerializedName("section_title")
    @Expose
    private String sectionTitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_full")
    @Expose
    private String titleFull;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("replies_count")
    @Expose
    private int repliesCount;
    @SerializedName("participants_count")
    @Expose
    private int participantsCount;
    @SerializedName("site_type")
    @Expose
    private String siteType;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("spam_score")
    @Expose
    private double spamScore;
    @SerializedName("main_image")
    @Expose
    private String mainImage;
    @SerializedName("performance_score")
    @Expose
    private int performanceScore;
    @SerializedName("domain_rank")
    @Expose
    private Object domainRank;


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

    public String getSiteFull() {
        return siteFull;
    }

    public void setSiteFull(String siteFull) {
        this.siteFull = siteFull;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSiteSection() {
        return siteSection;
    }

    public void setSiteSection(String siteSection) {
        this.siteSection = siteSection;
    }

    public List<String> getSiteCategories() {
        return siteCategories;
    }

    public void setSiteCategories(List<String> siteCategories) {
        this.siteCategories = siteCategories;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleFull() {
        return titleFull;
    }

    public void setTitleFull(String titleFull) {
        this.titleFull = titleFull;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public int getRepliesCount() {
        return repliesCount;
    }

    public void setRepliesCount(int repliesCount) {
        this.repliesCount = repliesCount;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSpamScore() {
        return spamScore;
    }

    public void setSpamScore(double spamScore) {
        this.spamScore = spamScore;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    public Object getDomainRank() {
        return domainRank;
    }

    public void setDomainRank(Object domainRank) {
        this.domainRank = domainRank;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uuid);
        dest.writeString(this.url);
        dest.writeString(this.siteFull);
        dest.writeString(this.site);
        dest.writeString(this.siteSection);
        dest.writeStringList(this.siteCategories);
        dest.writeString(this.sectionTitle);
        dest.writeString(this.title);
        dest.writeString(this.titleFull);
        dest.writeString(this.published);
        dest.writeInt(this.repliesCount);
        dest.writeInt(this.participantsCount);
        dest.writeString(this.siteType);
        dest.writeString(this.country);
        dest.writeDouble(this.spamScore);
        dest.writeString(this.mainImage);
        dest.writeInt(this.performanceScore);
//        dest.writeParcelable(this.domainRank, flags);
//        dest.writeParcelable(this.social, flags);
    }

    public Thread() {
    }

    Thread(Parcel in) {
        this.uuid = in.readString();
        this.url = in.readString();
        this.siteFull = in.readString();
        this.site = in.readString();
        this.siteSection = in.readString();
        this.siteCategories = in.createStringArrayList();
        this.sectionTitle = in.readString();
        this.title = in.readString();
        this.titleFull = in.readString();
        this.published = in.readString();
        this.repliesCount = in.readInt();
        this.participantsCount = in.readInt();
        this.siteType = in.readString();
        this.country = in.readString();
        this.spamScore = in.readDouble();
        this.mainImage = in.readString();
        this.performanceScore = in.readInt();
//        this.domainRank = in.readParcelable(Object.class.getClassLoader());

    }

    public static final Parcelable.Creator<Thread> CREATOR = new Parcelable.Creator<Thread>() {
        @Override
        public Thread createFromParcel(Parcel source) {
            return new Thread(source);
        }

        @Override
        public Thread[] newArray(int size) {
            return new Thread[size];
        }
    };
}
