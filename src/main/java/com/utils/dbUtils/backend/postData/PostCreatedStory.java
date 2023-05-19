package com.utils.dbUtils.backend.postData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utils.dbUtils.backend.paragraphData.ParagraphInCreatedStory;
import com.utils.dbUtils.frontend.Id;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class PostCreatedStory {

    @SerializedName("_id")
    @Expose
    private Id id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("liveBlog")
    @Expose
    private LiveBlog liveBlog;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public PostCreatedStory withId(Id id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostCreatedStory withId(String title) {
        this.title = title;
        return this;
    }


    public LiveBlog getLiveBlog() {
        return liveBlog;
    }

    public void setLiveBlog(LiveBlog liveBlog) {
        this.liveBlog = liveBlog;
    }

    public PostCreatedStory withLiveBlog(LiveBlog liveBlog) {
        this.liveBlog = liveBlog;
        return this;
    }


}
