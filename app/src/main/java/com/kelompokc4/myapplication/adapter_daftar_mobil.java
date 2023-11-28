package com.kelompokc4.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.response.GetMobil;
import com.kelompokc4.myapplication.response.model_det_mobil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class adapter_daftar_mobil extends RecyclerView.Adapter<adapter_daftar_mobil.viewholder_daftar_mobil> {

    private String imageUrl;

    public String getImageUrl() {
        // Tambahkan skema http/https jika belum ada
            RetrofitClient retrofitClient = new RetrofitClient();
            return retrofitClient.BASE_URL + imageUrl;

    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    private Context context;
    ArrayList<GetMobil> modelitem = new ArrayList<>();

    public adapter_daftar_mobil(Context context, ArrayList<GetMobil> ambil) {
        this.context = context;
        this.modelitem = ambil;
        Toast.makeText(context, "CONSTRUCTOR -> " + ambil.size(), Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public adapter_daftar_mobil.viewholder_daftar_mobil onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder_daftar_mobil(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_rc_mobil, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_daftar_mobil.viewholder_daftar_mobil holder, int position) {

        GetMobil list = modelitem.get(position);

        imageUrl = list.getGambar_mobil();
        // Load gambar menggunakan Glide
        Glide.with(context)
                .load(getImageUrl())  // Ganti dengan metode getter yang benar dari GetMobil
                .into(holder.gambarmobil);
        Toast.makeText(context, getImageUrl(), Toast.LENGTH_SHORT).show();

        Log.e("TES", "" + list.getId_mobil());
        //menampilkan data recyclerview
        holder.tv_merk.setText(list.getType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //data yang di klik
                String type = list.getType();
                String kursi = list.getJumlah_kursi();
                String bahan_bakar = list.getBahan_bakar();
                String isi_silinder = list.getIsi_silinder();
                String warna = list.getWarna();
                String thn_produksi = list.getThn_produksi();
                String plat = list.getPlat();
                String gambar_mobil = list.getGambar_mobil();

                Intent intent = new Intent(v.getContext(), detailmobil.class);
                intent.putExtra("type", type);
                intent.putExtra("kursi", kursi);
                intent.putExtra("bahan_bakar", bahan_bakar);
                intent.putExtra("isi_silinder", isi_silinder);
                intent.putExtra("warna", warna);
                intent.putExtra("thn_produksi", thn_produksi);
                intent.putExtra("plat", plat);
                intent.putExtra("gambar_mobil",gambar_mobil);
                v.getContext().startActivity(intent);


                Toast.makeText(context, bahan_bakar, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return modelitem != null ? modelitem.size() : 0;
    }
    public class viewholder_daftar_mobil extends RecyclerView.ViewHolder {

        TextView tv_merk, button;
        ImageView gambarmobil;
        public viewholder_daftar_mobil(@NonNull View itemView) {
            super(itemView);

            tv_merk = itemView.findViewById(R.id.merk_mobil);
            button = itemView.findViewById(R.id.btnpesan);
            gambarmobil = itemView.findViewById(R.id.gambar_mobil);

        }
    }
}
