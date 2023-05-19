package com.utils.dbUtils.backend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class Authors {
    @SerializedName("_id")
    @Expose
    private Id_ id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slugName")
    @Expose
    private String slugName;
    @SerializedName("userTypes")
    @Expose
    private List<Object> userTypes = null;
    @SerializedName("twitter")
    @Expose
    private String twitter;

    public Id_ getId() {
        return id;
    }

    public void setId(Id_ id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlugName() {
        return slugName;
    }

    public void setSlugName(String slugName) {
        this.slugName = slugName;
    }

    public List<Object> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<Object> userTypes) {
        this.userTypes = userTypes;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }


}
