package com.app.cekongkir.view;

import com.app.cekongkir.model.city.CityResults;
import com.app.cekongkir.model.province.ProvinceResults;

import java.util.List;

/**
 * Created by islam on 16/07/17.
 */

public interface ViewMain {
    void showProvince(List<String> data);
    void showCity(List<String> data, String params);
    void onBtnClick(String kotaasal, String kotatujuan, String weight, String courier);
}
