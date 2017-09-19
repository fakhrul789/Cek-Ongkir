package com.app.cekongkir.presenter;

import android.content.Context;
import android.util.Log;

import com.app.cekongkir.CekOngkirApp;
import com.app.cekongkir.MainActivity;
import com.app.cekongkir.api.ApiClient;
import com.app.cekongkir.model.city.CityDiscover;
import com.app.cekongkir.model.province.ProvinceDiscover;
import com.app.cekongkir.view.ViewMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by islam on 18/09/17.
 */

public class MainPresenter {
    private static final String TAG = MainPresenter.class.getSimpleName();
    ViewMain viewMain;
    ApiClient apiClient;
    Context context;
    HashMap<String, String> map;
    HashMap<String, String> mapKotaAsal;
    HashMap<String, String> mapKotaTujuan;

    public MainPresenter(ViewMain viewMain, Context context) {
        this.viewMain = viewMain;
        this.context = context;
        apiClient = new ApiClient();
        map = new HashMap<String, String>();
        mapKotaAsal = new HashMap<>();
        mapKotaTujuan = new HashMap<>();
    }

    public void getProvince() {
        apiClient.getClient().getProvince("").enqueue(new Callback<ProvinceDiscover>() {
            @Override
            public void onResponse(Call<ProvinceDiscover> call, Response<ProvinceDiscover> response) {
                map.clear();
                List<String> data = new ArrayList<String>();
                int size = response.body().getRajaongkir().getResults().size();
                for (int i = 0; i < size; i++) {
                    map.put(response.body().getRajaongkir().getResults().get(i).getProvince(),
                            response.body().getRajaongkir().getResults().get(i).getProvinceId());

                    data.add(response.body().getRajaongkir().getResults().get(i).getProvince());
                }
                viewMain.showProvince(data);
            }

            @Override
            public void onFailure(Call<ProvinceDiscover> call, Throwable throwable) {
                Log.e(TAG, "onFailure: ", throwable);
            }
        });
    }

    public void getCity(String provId, final String params) {
        apiClient.getClient().getCity("",map.get(provId)).enqueue(new Callback<CityDiscover>() {
            @Override
            public void onResponse(Call<CityDiscover> call, Response<CityDiscover> response) {
                List<String> data = new ArrayList<String>();
                int size = response.body().getRajaongkir().getResults().size();
                for (int i = 0; i < size; i++) {
                    if (params == "asal") {
                        mapKotaAsal.put(response.body().getRajaongkir().getResults().get(i).getCityName(),
                                response.body().getRajaongkir().getResults().get(i).getCityId());
                    } else if (params == "tujuan"){
                        mapKotaTujuan.put(response.body().getRajaongkir().getResults().get(i).getCityName(),
                                response.body().getRajaongkir().getResults().get(i).getCityId());
                    }

                    data.add(response.body().getRajaongkir().getResults().get(i).getCityName());
                }
                viewMain.showCity(data,params);
            }

            @Override
            public void onFailure(Call<CityDiscover> call, Throwable throwable) {
                Log.e(TAG, "onFailure: ", throwable);
            }
        });
    }

    public void btnClick(String kotaasal, String kotatujuan, String weight, String courier) {
        String ktAsal = mapKotaAsal.get(kotaasal);
        String ktTujuan = mapKotaTujuan.get(kotatujuan);
        viewMain.onBtnClick(ktAsal, ktTujuan, weight, courier);
    }
}
