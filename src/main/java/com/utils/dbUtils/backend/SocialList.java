package com.utils.dbUtils.backend;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SocialList {

    @SerializedName("twitter")
    @Expose
    private List<Object> twitter = null;

    public List<Object> getTwitter() {
        return twitter;
    }

    public void setTwitter(List<Object> twitter) {
        this.twitter = twitter;
    }

}
