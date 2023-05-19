package com.utils.dbUtils.frontend;

import javax.annotation.Generated;
//import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Social {

    @SerializedName("twitter")
    @Expose
    private Boolean twitter;
    @SerializedName("facebook")
    @Expose
    private Boolean facebook;

    public Boolean getTwitter() {
        return twitter;
    }

    public void setTwitter(Boolean twitter) {
        this.twitter = twitter;
    }

    public Boolean getFacebook() {
        return facebook;
    }

    public void setFacebook(Boolean facebook) {
        this.facebook = facebook;
    }

}
