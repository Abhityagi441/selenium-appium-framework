package com.utils.dbUtils.backend.paragraphData;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Social {

    @SerializedName("twitter")
    @Expose
    private boolean twitter;
    @SerializedName("facebook")
    @Expose
    private boolean facebook;

    public boolean isTwitter() {
        return twitter;
    }

    public void setTwitter(boolean twitter) {
        this.twitter = twitter;
    }

    public Social withTwitter(boolean twitter) {
        this.twitter = twitter;
        return this;
    }

    public boolean isFacebook() {
        return facebook;
    }

    public void setFacebook(boolean facebook) {
        this.facebook = facebook;
    }

    public Social withFacebook(boolean facebook) {
        this.facebook = facebook;
        return this;
    }

}
