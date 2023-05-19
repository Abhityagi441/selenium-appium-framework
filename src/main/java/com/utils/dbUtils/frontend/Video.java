package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Video {

    @JsonIgnoreProperties("url")
    private String url;
    @JsonIgnoreProperties("body")
    private String body;
    @JsonIgnoreProperties("embedUrl")
    private String embedUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnoreProperties("url")
    public String getUrl() {
        return url;
    }

    @JsonIgnoreProperties("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnoreProperties("body")
    public String getBody() {
        return body;
    }

    @JsonIgnoreProperties("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonIgnoreProperties("embedUrl")
    public String getEmbedUrl() {
        return embedUrl;
    }

    @JsonIgnoreProperties("embedUrl")
    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
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