package com.app.cekongkir.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by islam on 18/09/17.
 */

public class CityRajaOngkir {
    @SerializedName("query")
    @Expose
    private CityQuery query;
    @SerializedName("status")
    @Expose
    private CityStatus status;
    @SerializedName("results")
    @Expose
    private List<CityResults> results = null;

    public CityQuery getQuery() {
        return query;
    }

    public void setQuery(CityQuery query) {
        this.query = query;
    }

    public CityStatus getStatus() {
        return status;
    }

    public void setStatus(CityStatus status) {
        this.status = status;
    }

    public List<CityResults> getResults() {
        return results;
    }

    public void setResults(List<CityResults> results) {
        this.results = results;
    }
}
