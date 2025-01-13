package com.example.hanssparepart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class KonfirmasiPembayaran extends AppCompatActivity {

    private TextView tvBuyerName, tvBuyerAddress, tvPaymentMethod, tvTotalPrice;
    private Button btnBackToHome;
    private ImageView ivQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_pembayaran);

        // Inisialisasi Views
        tvBuyerName = findViewById(R.id.tvBuyerName);
        tvBuyerAddress = findViewById(R.id.tvBuyerAddress);
        tvPaymentMethod = findViewById(R.id.tvPaymentMethod);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnBackToHome = findViewById(R.id.btnBackToHome);
        ivQrCode = findViewById(R.id.ivQrCode);

        // Ambil Data dari Intent
        String buyerName = getIntent().getStringExtra("buyerName");
        String buyerAddress = getIntent().getStringExtra("buyerAddress");
        String paymentMethod = getIntent().getStringExtra("paymentMethod");
        String totalPrice = getIntent().getStringExtra("totalPrice");

        // Tampilkan Data di UI
        tvBuyerName.setText("Nama Pembeli: " + buyerName);
        tvBuyerAddress.setText("Alamat: " + buyerAddress);
        tvPaymentMethod.setText("Metode Pembayaran: " + paymentMethod);
        tvTotalPrice.setText(" " + totalPrice);

        // Periksa Metode Pembayaran dan Tampilkan Kode QR
        if ("Transfer Bank".equals(paymentMethod)) {
            ivQrCode.setVisibility(ImageView.VISIBLE); // Tampilkan kode QR jika Transfer Bank
        } else {
            ivQrCode.setVisibility(ImageView.GONE); // Sembunyikan kode QR untuk metode lain
        }

        // Tombol Kembali ke Home
        btnBackToHome.setOnClickListener(v -> {
            // Pindah ke halaman utama (Home)
            Intent intent = new Intent(KonfirmasiPembayaran.this, Dashboard.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
