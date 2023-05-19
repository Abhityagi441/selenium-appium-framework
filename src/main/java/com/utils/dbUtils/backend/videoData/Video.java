package com.utils.dbUtils.backend.videoData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utils.dbUtils.backend.postData.LiveBlog;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Video {
    @SerializedName("body")
    @Expose
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Video withLiveBlog(String body) {
        this.body = body;
        return this;
    }

    @SerializedName("embedUrl")
    @Expose
    private String embedUrl;

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public Video withEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
        return this;
    }

}
