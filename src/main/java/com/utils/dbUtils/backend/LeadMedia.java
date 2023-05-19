package com.utils.dbUtils.backend;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class LeadMedia {

    @SerializedName("elements")
    @Expose
    private List<Object> elements = null;
    @SerializedName("defaultImage")
    @Expose
    private Boolean defaultImage;
    @SerializedName("autotagged")
    @Expose
    private Boolean autotagged;

    public List<Object> getElements() {
        return elements;
    }

    public void setElements(List<Object> elements) {
        this.elements = elements;
    }

    public Boolean getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(Boolean defaultImage) {
        this.defaultImage = defaultImage;
    }

    public Boolean getAutotagged() {
        return autotagged;
    }

    public void setAutotagged(Boolean autotagged) {
        this.autotagged = autotagged;
    }

}