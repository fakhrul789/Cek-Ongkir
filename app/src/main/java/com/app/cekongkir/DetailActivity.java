package com.app.cekongkir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.app.cekongkir.adapter.ListDetailAdapter;
import com.app.cekongkir.model.cost.Results;
import com.app.cekongkir.presenter.DetailPresenter;
import com.app.cekongkir.view.ViewDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements ViewDetail {
    private static final String TAG = DetailActivity.class.getSimpleName();
    @BindView(R.id.rcv_detail)
    RecyclerView rcvdetail;

    DetailPresenter presenter;
    ListDetailAdapter adapter;

    String kotaAsal,kotaTujuan,weight,courier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        String[] data = this.getIntent().getStringArrayExtra("data");

        kotaAsal = data[0];
        kotaTujuan = data[1];
        weight = data[2];
        courier = data[3];

        presenter = new DetailPresenter(this);

        presenter.getData(kotaAsal,kotaTujuan,weight,courier);
    }

    @Override
    public void showData(List<Results> data) {
        adapter = new ListDetailAdapter(data);
        rcvdetail.setLayoutManager(new LinearLayoutManager(CekOngkirApp.getContext()));
        rcvdetail.setAdapter(adapter);
    }
}
