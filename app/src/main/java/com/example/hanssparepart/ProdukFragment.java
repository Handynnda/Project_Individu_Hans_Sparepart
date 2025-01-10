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
                Intent intent = new Intent(getActivity(), Detail_Produk.class);
                intent.putExtra("product_id", 1); // Kirimkan ID produk jika diperlukan
                startActivity(intent);
            }
        });

        // Menambahkan OnClickListener untuk layout produk 2
        LinearLayout productLayout2 = view.findViewById(R.id.productLayout2);
        productLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Detail_Produk.class);
                intent.putExtra("product_id", 2); // Kirimkan ID produk jika diperlukan
                startActivity(intent);
            }
        });

        // Tambahkan listener untuk produk lainnya
        LinearLayout productLayout3 = view.findViewById(R.id.productLayout3);
        productLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Detail_Produk.class);
                intent.putExtra("product_id", 3); // Kirimkan ID produk jika diperlukan
                startActivity(intent);
            }
        });

        return view;
    }
}
