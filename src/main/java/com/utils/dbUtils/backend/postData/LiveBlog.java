package com.utils.dbUtils.backend.postData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class LiveBlog {
    @SerializedName("body")
    @Expose
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LiveBlog withLiveBlog(String body) {
        this.body = body;
        return this;
    }
}
