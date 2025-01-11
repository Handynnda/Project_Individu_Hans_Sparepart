package com.example.hanssparepart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProdukFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_produk_fragment, container, false);

        // Menambahkan OnClickListener untuk layout produk 1
        LinearLayout productLayout1 = view.findViewById(R.id.productLayout1);
        productLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(getActivity(), Detail_Produk.class);
                detailIntent.putExtra("productName", "Hugger Airblade PNP Honda Vario");
                detailIntent.putExtra("productRating", "4.0 ★★★★☆ (2.890 Penilaian)");
                detailIntent.putExtra("productStock", "200 Tersisa");
                detailIntent.putExtra("productDescription", "Hugger Airblade Vario 125/150\nOriginal Vietnam\nFullset dengan Tabung");
                detailIntent.putExtra("productImage", R.drawable.hugger_1);
                detailIntent.putExtra("galleryImage1", R.drawable.hugger_1);
                detailIntent.putExtra("galleryImage2", R.drawable.hugger_2);
                detailIntent.putExtra("galleryImage3", R.drawable.hugger_3);
                startActivity(detailIntent);
            }
        });

        // Menambahkan OnClickListener untuk layout produk 2
        LinearLayout productLayout2 = view.findViewById(R.id.productLayout2);
        productLayout2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent detailIntent = new Intent(getActivity(), Detail_Produk.class);
                detailIntent.putExtra("productName", "Oli Enduro Racing  1L");
                detailIntent.putExtra("productRating", "4.0 ★★★★☆ (2.000 Penilaian)");
                detailIntent.putExtra("productStock", "150 Tersisa");
                detailIntent.putExtra("productDescription", "Oli Enduro racing 1L\nOriginal Dari Pertamina\nCocok untuk motor sport");
                detailIntent.putExtra("productImage", R.drawable.olienduro1);
                detailIntent.putExtra("galleryImage1", R.drawable.olienduro1);
                detailIntent.putExtra("galleryImage2", R.drawable.olienduro2);
                detailIntent.putExtra("galleryImage3", R.drawable.olienduro3);
                startActivity(detailIntent);
            }
        });

        // Tambahkan listener untuk produk 3
        LinearLayout productLayout3 = view.findViewById(R.id.productLayout3);
        productLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(getActivity(), Detail_Produk.class);
                detailIntent.putExtra("productName", "Mounting ARM Honda Vario +6CM");
                detailIntent.putExtra("productRating", "4.0 ★★★★☆ (1.000 Penilaian)");
                detailIntent.putExtra("productStock", "250 Tersisa");
                detailIntent.putExtra("productDescription", "Mounting Vario 125/150 Merk ARM panjang +6cm\nPemasangan PNP\nFullset dengan boshnya");
                detailIntent.putExtra("productImage", R.drawable.mounting1);
                detailIntent.putExtra("galleryImage1", R.drawable.mounting1);
                detailIntent.putExtra("galleryImage2", R.drawable.mounting2);
                detailIntent.putExtra("galleryImage3", R.drawable.mounting3);
                startActivity(detailIntent);
            }
        });

        // Tambahkan listener untuk produk 4
        LinearLayout productLayout4 = view.findViewById(R.id.productLayout4);
        productLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(getActivity(), Detail_Produk.class);
                detailIntent.putExtra("productName", "Oli Shell Advance");
                detailIntent.putExtra("productRating", "4.0 ★★★★☆ (3.000 Penilaian)");
                detailIntent.putExtra("productStock", "400 Tersisa");
                detailIntent.putExtra("productDescription", "Oli Mesin Merk Shell Advance Ax7 ini cocok untuk motor yang sudah di upgade(borup) karena oli ini memiliki kandungan full syntetic yang bagus untuk mesin");
                detailIntent.putExtra("productImage", R.drawable.olishel1);
                detailIntent.putExtra("galleryImage1", R.drawable.olishel1);
                detailIntent.putExtra("galleryImage2", R.drawable.olishel2);
                detailIntent.putExtra("galleryImage3", R.drawable.olishel3);
                startActivity(detailIntent);
            }
        });

        return view;
    }
}
