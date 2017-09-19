package com.app.cekongkir.model.cost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by islam on 18/09/17.
 */

public class Results {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("costs")
    @Expose
    private List<Cost> costs = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

}
