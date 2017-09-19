package com.app.cekongkir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.app.cekongkir.model.city.CityResults;
import com.app.cekongkir.model.province.ProvinceResults;
import com.app.cekongkir.presenter.MainPresenter;
import com.app.cekongkir.view.ViewMain;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewMain, AdapterView.OnItemSelectedListener, View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    @BindView(R.id.provAsal)
    Spinner provAsal;
    @BindView(R.id.provTujuan)
    Spinner provTujuan;
    @BindView(R.id.kotaAsal)
    Spinner kotaAsal;
    @BindView(R.id.kotaTujuan)
    Spinner kotaTujuan;
    @BindView(R.id.txtBeratBrg)
    EditText txtBeratBrg;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this, this);

        presenter.getProvince();
    }

    @Override
    protected void onStart() {
        super.onStart();
        provAsal.setOnItemSelectedListener(this);
        provTujuan.setOnItemSelectedListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void showProvince(List<String> data) {
        Log.d(TAG, "showProvince: " + data);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provAsal.setAdapter(dataAdapter);
        provTujuan.setAdapter(dataAdapter);
    }

    @Override
    public void showCity(List<String> data, String params) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (params == "asal") {
            kotaAsal.setAdapter(dataAdapter);
        } else {
            kotaTujuan.setAdapter(dataAdapter);
        }
    }

    @Override
    public void onBtnClick(String kotaasal, String kotatujuan, String weight, String courier) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        String[] data = {kotaasal,kotatujuan,weight,courier};
        intent.putExtra("data", data);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        presenter.btnClick(kotaAsal.getSelectedItem().toString(),
                kotaTujuan.getSelectedItem().toString(),
                txtBeratBrg.getText().toString(),
                "jne");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.provAsal:
                presenter.getCity(adapterView.getSelectedItem().toString(), "asal");
                break;
            case R.id.provTujuan:
                presenter.getCity(adapterView.getSelectedItem().toString(), "tujuan");
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
