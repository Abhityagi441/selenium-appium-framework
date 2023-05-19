package com.utils.dbUtils.frontend;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParentElementId {

    @JsonIgnoreProperties("$numberLong")
    private String $numberLong;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnoreProperties("$numberLong")
    public String get$numberLong() {
        return $numberLong;
    }

    @JsonIgnoreProperties("$numberLong")
    public void set$numberLong(String $numberLong) {
        this.$numberLong = $numberLong;
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