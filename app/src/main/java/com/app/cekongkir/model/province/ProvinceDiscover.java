package com.app.cekongkir.model.province;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by islam on 18/09/17.
 */

public class ProvinceDiscover {
    @SerializedName("rajaongkir")
    @Expose
    private ProvinceRajaOngkir rajaongkir;

    public ProvinceRajaOngkir getRajaongkir() {
        return rajaongkir;
    }

    public void setRajaongkir(ProvinceRajaOngkir rajaongkir) {
        this.rajaongkir = rajaongkir;
    }
}
