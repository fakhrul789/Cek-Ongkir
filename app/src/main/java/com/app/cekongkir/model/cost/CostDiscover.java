package com.app.cekongkir.model.cost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by islam on 18/09/17.
 */

public class CostDiscover {
    @SerializedName("rajaongkir")
    @Expose
    private RajaOngkir rajaongkir;

    public RajaOngkir getRajaongkir() {
        return rajaongkir;
    }

    public void setRajaongkir(RajaOngkir rajaongkir) {
        this.rajaongkir = rajaongkir;
    }
}
