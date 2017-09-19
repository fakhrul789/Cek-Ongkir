package com.app.cekongkir.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by islam on 18/09/17.
 */

public class CityQuery {
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("id")
    @Expose
    private String id;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
