package com.utils.dbUtils.backend.highlightsData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utils.dbUtils.backend.videoData.Video;

public class Listicle {
    @SerializedName("body")
    @Expose
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Listicle withListicle(String body) {
        this.body = body;
        return this;
    }
}
