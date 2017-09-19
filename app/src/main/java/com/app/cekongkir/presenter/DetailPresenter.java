package com.app.cekongkir.presenter;

import android.util.Log;

import com.app.cekongkir.CekOngkirApp;
import com.app.cekongkir.adapter.ListDetailAdapter;
import com.app.cekongkir.api.ApiClient;
import com.app.cekongkir.model.cost.CostDiscover;
import com.app.cekongkir.model.cost.Results;
import com.app.cekongkir.view.ViewDetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by islam on 18/09/17.
 */

public class DetailPresenter {
    private static final String TAG = DetailPresenter.class.getSimpleName();
    ViewDetail view;
    ApiClient apiClient;


    public DetailPresenter(ViewDetail view) {
        this.view = view;
        apiClient = new ApiClient();
    }

    public void getData(String kotaasal, String kotatujuan, String weight, String courier) {
        apiClient.getClient().getCost(kotaasal,kotatujuan,weight,courier).enqueue(new Callback<CostDiscover>() {
            @Override
            public void onResponse(Call<CostDiscover> call, Response<CostDiscover> response) {
                List<Results> data = new ArrayList<Results>();
                data.addAll(response.body().getRajaongkir().getResults());
                view.showData(data);
            }

            @Override
            public void onFailure(Call<CostDiscover> call, Throwable throwable) {

            }
        });
    }

}
