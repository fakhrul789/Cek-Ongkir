package com.app.cekongkir.model.province;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by islam on 18/09/17.
 */

public class ProvinceResults {
    @SerializedName("province_id")
    @Expose
    private String provinceId;
    @SerializedName("province")
    @Expose
    private String province;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
