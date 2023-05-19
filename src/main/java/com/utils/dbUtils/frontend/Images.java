package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Images {

    @JsonIgnoreProperties("original")
    private String original;
    @JsonIgnoreProperties("bigImage")
    private String bigImage;
    @JsonIgnoreProperties("mediumImage")
    private String mediumImage;
    @JsonIgnoreProperties("ampImage")
    private String ampImage;
    @JsonIgnoreProperties("thumbnailImage")
    private String thumbnailImage;
    @JsonIgnoreProperties("fullImage")
    private String fullImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnoreProperties("original")
    public String getOriginal() {
        return original;
    }

    @JsonIgnoreProperties("original")
    public void setOriginal(String original) {
        this.original = original;
    }

    @JsonIgnoreProperties("bigImage")
    public String getBigImage() {
        return bigImage;
    }

    @JsonIgnoreProperties("bigImage")
    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    @JsonIgnoreProperties("mediumImage")
    public String getMediumImage() {
        return mediumImage;
    }

    @JsonIgnoreProperties("mediumImage")
    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    @JsonIgnoreProperties("ampImage")
    public String getAmpImage() {
        return ampImage;
    }

    @JsonIgnoreProperties("ampImage")
    public void setAmpImage(String ampImage) {
        this.ampImage = ampImage;
    }

    @JsonIgnoreProperties("thumbnailImage")
    public String getThumbnailImage() {
        return thumbnailImage;
    }

    @JsonIgnoreProperties("thumbnailImage")
    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    @JsonIgnoreProperties("fullImage")
    public String getFullImage() {
        return fullImage;
    }

    @JsonIgnoreProperties("fullImage")
    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
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