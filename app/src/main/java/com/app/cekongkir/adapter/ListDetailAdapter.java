package com.app.cekongkir.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.cekongkir.CekOngkirApp;
import com.app.cekongkir.R;
import com.app.cekongkir.model.cost.Cost;
import com.app.cekongkir.model.cost.Results;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by islam on 19/09/17.
 */

public class ListDetailAdapter extends RecyclerView.Adapter<ListDetailAdapter.ViewHolder> {
    Context context;
    List<Results> data;

    public ListDetailAdapter(List<Results> data) {
        this.context = CekOngkirApp.getContext();
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cost result = data.get(0).getCosts().get(position);
        holder.txtService.setText(result.getService() + " (" + result.getDescription() + ")");
        holder.cost.setText("Biaya Rp." + result.getCost().get(0).getValue());
        holder.estimasi.setText("Estimasi " + result.getCost().get(0).getEtd() + " Hari");
        holder.note.setText(result.getCost().get(0).getNote());
    }

    @Override
    public int getItemCount() {
        return data.get(0).getCosts().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtService)
        TextView txtService;
        @BindView(R.id.cost)
        TextView cost;
        @BindView(R.id.estimasi)
        TextView estimasi;
        @BindView(R.id.note)
        TextView note;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
