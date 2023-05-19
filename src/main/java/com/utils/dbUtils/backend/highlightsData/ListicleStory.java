package com.utils.dbUtils.backend.highlightsData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.utils.dbUtils.backend.videoData.Video;
import com.utils.dbUtils.backend.videoData.VideoStory;
import com.utils.dbUtils.frontend.Id;

public class ListicleStory {
    @SerializedName("_id")
    @Expose
    private Id id;

    @SerializedName("listicle")
    @Expose
    private Listicle listicle;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public ListicleStory withId(Id id) {
        this.id = id;
        return this;
    }


    public Listicle getListicle() {
        return listicle;
    }

    public void setListicle(Listicle listicle) {
        this.listicle = listicle;
    }

    public ListicleStory withListicle(Listicle listicle) {
        this.listicle = listicle;
        return this;
    }
}
