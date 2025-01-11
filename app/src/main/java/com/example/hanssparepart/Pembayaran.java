package com.example.hanssparepart;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Pembayaran extends AppCompatActivity {

    private TextView tvProductName, tvProductPrice, tvJumlahBeli, tvTotalPrice;
    private TextView etBuyerName, etBuyerAddress, etPaymentMethod;
    private Button btnConfirmPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        // Inisialisasi Views
        tvProductName = findViewById(R.id.tvProductName);
        tvProductPrice = findViewById(R.id.tvProductPrice);
        tvJumlahBeli = findViewById(R.id.tvJumlahBeli);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        etBuyerName = findViewById(R.id.etBuyerName);
        etBuyerAddress = findViewById(R.id.etBuyerAddress);
        etPaymentMethod = findViewById(R.id.etPaymentMethod);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);

        // Ambil Data dari Intent
        String productName = getIntent().getStringExtra("productName");
        String productHarga = getIntent().getStringExtra("productHarga");
        String jumlahBeli = getIntent().getStringExtra("jumlahBeli");

        // Hitung Total Harga
        int hargaSatuan = Integer.parseInt(productHarga.replace("Rp. ", "").replace(".", ""));
        int totalHarga = Integer.parseInt(jumlahBeli) * hargaSatuan;

        // Tampilkan Data di UI
        tvProductName.setText("Nama Produk: " + productName);
        tvProductPrice.setText("Harga Satuan: " + productHarga);
        tvJumlahBeli.setText("Jumlah Pembelian: " + jumlahBeli);
        tvTotalPrice.setText("Total Harga: Rp. " + totalHarga);

        // Tombol Konfirmasi Pembayaran
        btnConfirmPayment.setOnClickListener(v -> {
            String buyerName = etBuyerName.getText().toString().trim();
            String buyerAddress = etBuyerAddress.getText().toString().trim();
            String paymentMethod = etPaymentMethod.getText().toString().trim();

            // Validasi input
            if (buyerName.isEmpty()) {
                etBuyerName.setError("Nama pembeli harus diisi!");
                return;
            }
            if (buyerAddress.isEmpty()) {
                etBuyerAddress.setError("Alamat harus diisi!");
                return;
            }
            if (paymentMethod.isEmpty()) {
                etPaymentMethod.setError("Metode pembayaran harus diisi!");
                return;
            }

            // Simulasi konfirmasi pembayaran
            Toast.makeText(Pembayaran.this,
                    "Pembayaran berhasil!\nTerima kasih, " + buyerName,
                    Toast.LENGTH_LONG).show();

            // Tutup halaman setelah konfirmasi
            finish();
        });
    }
}
