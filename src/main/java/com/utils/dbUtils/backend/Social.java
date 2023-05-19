package com.utils.dbUtils.backend;

import javax.annotation.Generated;
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
    @SerializedName("web")
    @Expose
    private Boolean web;
    @SerializedName("mobile")
    @Expose
    private Boolean mobile;

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

    public Boolean getWeb() {
        return web;
    }

    public void setWeb(Boolean web) {
        this.web = web;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

}
