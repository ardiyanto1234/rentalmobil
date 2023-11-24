package com.kelompokc4.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompokc4.myapplication.R;
import com.kelompokc4.myapplication.koneksi.ModelNotifikasi;
import com.kelompokc4.myapplication.koneksi.ResponHistori;

import java.util.ArrayList;
import java.util.List;

public class AdapterHistori extends RecyclerView.Adapter<AdapterHistori.RecycleViewHolder> {

    private ArrayList<ModelNotifikasi> data;

    public AdapterHistori(ArrayList<ModelNotifikasi> data) {
        this.data= data;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new RecycleViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        ModelNotifikasi item = data.get(position);
        holder.judul.setText(item.getMerk());
        holder.jam.setText(item.getJam());
        holder.tanggal.setText(item.getTanggal());

    }

    @Override
    public int getItemCount() {
        return (data != null) ? data.size() : 0;

    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        public TextView judul, jam, tanggal;


        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            jam = itemView.findViewById(R.id.jam);
            tanggal = itemView.findViewById(R.id.tanggal);
        }
    }
}
