package com.utils.dbUtils.backend;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class VideoMetadata {

    @SerializedName("youtubeMonetization")
    @Expose
    private Boolean youtubeMonetization;
    @SerializedName("dailyMotion")
    @Expose
    private Boolean dailyMotion;
    @SerializedName("Syndication")
    @Expose
    private Boolean syndication;
    @SerializedName("webcast")
    @Expose
    private Boolean webcast;
    @SerializedName("duration")
    @Expose
    private Id duration;

    public Boolean getYoutubeMonetization() {
        return youtubeMonetization;
    }

    public void setYoutubeMonetization(Boolean youtubeMonetization) {
        this.youtubeMonetization = youtubeMonetization;
    }

    public Boolean getDailyMotion() {
        return dailyMotion;
    }

    public void setDailyMotion(Boolean dailyMotion) {
        this.dailyMotion = dailyMotion;
    }

    public Boolean getSyndication() {
        return syndication;
    }

    public void setSyndication(Boolean syndication) {
        this.syndication = syndication;
    }

    public Boolean getWebcast() {
        return webcast;
    }

    public void setWebcast(Boolean webcast) {
        this.webcast = webcast;
    }

    public Id getDuration() {
        return duration;
    }

    public void setDuration(Id duration) {
        this.duration = duration;
    }

}
