package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeadMedia {

    @JsonIgnoreProperties("mediaType")
    private String mediaType;
    @JsonIgnoreProperties("image")
    private Image image;
    @JsonIgnoreProperties("video")
    private Video video;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnoreProperties("mediaType")
    public String getMediaType() {
        return mediaType;
    }

    @JsonIgnoreProperties("mediaType")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @JsonIgnoreProperties("image")
    public Image getImage() {
        return image;
    }

    @JsonIgnoreProperties("image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonIgnoreProperties("video")
    public Video getVideo() { return video;  }

    @JsonIgnoreProperties("video")
    public void setVideo(Video video) { this.video = video; }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
