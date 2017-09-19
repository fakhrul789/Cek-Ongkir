package com.app.cekongkir.model.cost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by islam on 18/09/17.
 */

public class RajaOngkir {
    @SerializedName("query")
    @Expose
    private Query query;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("origin_details")
    @Expose
    private OriginDetails originDetails;
    @SerializedName("destination_details")
    @Expose
    private DestinationDetails destinationDetails;
    @SerializedName("results")
    @Expose
    private List<Results> results = null;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OriginDetails getOriginDetails() {
        return originDetails;
    }

    public void setOriginDetails(OriginDetails originDetails) {
        this.originDetails = originDetails;
    }

    public DestinationDetails getDestinationDetails() {
        return destinationDetails;
    }

    public void setDestinationDetails(DestinationDetails destinationDetails) {
        this.destinationDetails = destinationDetails;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

}
