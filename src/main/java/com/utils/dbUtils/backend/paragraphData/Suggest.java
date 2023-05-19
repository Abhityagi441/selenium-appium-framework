package com.utils.dbUtils.backend.paragraphData;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Suggest {

    @SerializedName("input")
    @Expose
    private List<Object> input = null;

    public List<Object> getInput() {
        return input;
    }

    public void setInput(List<Object> input) {
        this.input = input;
    }

    public Suggest withInput(List<Object> input) {
        this.input = input;
        return this;
    }

}
