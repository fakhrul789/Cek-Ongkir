package com.app.cekongkir.model.province;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by islam on 18/09/17.
 */

public class ProvinceRajaOngkir {
    @SerializedName("query")
    @Expose
    private ProvinceQuery query = null;
    @SerializedName("status")
    @Expose
    private ProvinceStatus status;
    @SerializedName("results")
    @Expose
    private List<ProvinceResults> results = null;

    public ProvinceQuery getQuery() {
        return query;
    }

    public void setQuery(ProvinceQuery query) {
        this.query = query;
    }

    public ProvinceStatus getStatus() {
        return status;
    }

    public void setStatus(ProvinceStatus status) {
        this.status = status;
    }

    public List<ProvinceResults> getResults() {
        return results;
    }

    public void setResults(List<ProvinceResults> results) {
        this.results = results;
    }

}
