package com.app.cekongkir.api;

import com.app.cekongkir.model.city.CityDiscover;
import com.app.cekongkir.model.cost.CostDiscover;
import com.app.cekongkir.model.province.ProvinceDiscover;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by islam on 16/07/17.
 */

public interface ApiInterface {

    @Headers("Key: c5d79564b951756d346a870178a16bbb")
    @GET("province")
    Call<ProvinceDiscover> getProvince(@Query("id") String id);

    @Headers("Key: c5d79564b951756d346a870178a16bbb")
    @GET("city")
    Call<CityDiscover> getCity(@Query("id") String id, @Query("province") String province);

    @Headers("Key: c5d79564b951756d346a870178a16bbb")
    @FormUrlEncoded
    @POST("cost")
    Call<CostDiscover> getCost(@Field("origin") String origin,
                               @Field("destination") String destination,
                               @Field("weight") String weight,
                               @Field("courier") String courier);
}
