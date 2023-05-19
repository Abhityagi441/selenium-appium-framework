package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authors {

    @JsonIgnoreProperties("_id")
    private Id_ id;
    @JsonIgnoreProperties("name")
    private String name;
    @JsonIgnoreProperties("slugName")
    private String slugName;
    @JsonIgnoreProperties("type")
    private List<String> type = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnoreProperties("_id")
    public Id_ getId() {
        return id;
    }

    @JsonIgnoreProperties("_id")
    public void setId(Id_ id) {
        this.id = id;
    }

    @JsonIgnoreProperties("name")
    public String getName() {
        return name;
    }

    @JsonIgnoreProperties("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnoreProperties("slugName")
    public String getSlugName() {
        return slugName;
    }

    @JsonIgnoreProperties("slugName")
    public void setSlugName(String slugName) {
        this.slugName = slugName;
    }

    @JsonIgnoreProperties("type")
    public List<String> getType() {
        return type;
    }

    @JsonIgnoreProperties("type")
    public void setType(List<String> type) {
        this.type = type;
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
