package com.app.cekongkir.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by islam on 18/09/17.
 */

public class CityDiscover {
    @SerializedName("rajaongkir")
    @Expose
    private CityRajaOngkir rajaongkir;

    public CityRajaOngkir getRajaongkir() {
        return rajaongkir;
    }

    public void setRajaongkir(CityRajaOngkir rajaongkir) {
        this.rajaongkir = rajaongkir;
    }
}
