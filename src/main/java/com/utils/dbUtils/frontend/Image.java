package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {

    @JsonIgnoreProperties("images")
    private Images images;
    @JsonIgnoreProperties("caption")
    private String caption;
    @JsonIgnoreProperties("name")
    private String name;
    @JsonIgnoreProperties("imageCredit")
    private String imageCredit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnoreProperties("images")
    public Images getImages() {
        return images;
    }

    @JsonIgnoreProperties("images")
    public void setImages(Images images) {
        this.images = images;
    }

    @JsonIgnoreProperties("caption")
    public String getCaption() {
        return caption;
    }

    @JsonIgnoreProperties("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @JsonIgnoreProperties("name")
    public String getName() {
        return name;
    }

    @JsonIgnoreProperties("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnoreProperties("imageCredit")
    public String getImageCredit() {
        return imageCredit;
    }

    @JsonIgnoreProperties("imageCredit")
    public void setImageCredit(String imageCredit) {
        this.imageCredit = imageCredit;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}