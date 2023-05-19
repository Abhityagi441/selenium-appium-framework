package com.utils.dbUtils.backend.videoData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utils.dbUtils.backend.postData.LiveBlog;
import com.utils.dbUtils.backend.postData.PostCreatedStory;
import com.utils.dbUtils.frontend.Id;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class VideoStory {
    @SerializedName("_id")
    @Expose
    private Id id;

    @SerializedName("video")
    @Expose
    private Video video;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public VideoStory withId(Id id) {
        this.id = id;
        return this;
    }


    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public VideoStory withVideo(Video video) {
        this.video = video;
        return this;
    }
}
