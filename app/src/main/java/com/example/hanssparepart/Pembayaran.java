package com.example.hanssparepart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Pembayaran extends AppCompatActivity {

    private TextView tvProductName, tvProductPrice, tvJumlahBeli, tvTotalPrice;
    private TextView etBuyerName, etBuyerAddress;
    private Spinner spinnerPaymentMethod;
    private Button btnConfirmPayment;
    private ImageView btnBack;

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
        spinnerPaymentMethod = findViewById(R.id.spinnerPaymentMethod);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);
        btnBack = findViewById(R.id.btnBack);

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

        // Atur Spinner untuk Metode Pembayaran
        String[] paymentMethods = {"Transfer Bank", "COD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, paymentMethods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaymentMethod.setAdapter(adapter);

        // Tombol Konfirmasi Pembayaran
        btnConfirmPayment.setOnClickListener(v -> {
            String buyerName = etBuyerName.getText().toString().trim();
            String buyerAddress = etBuyerAddress.getText().toString().trim();
            String paymentMethod = spinnerPaymentMethod.getSelectedItem().toString();

            // Validasi input
            if (buyerName.isEmpty()) {
                etBuyerName.setError("Nama pembeli harus diisi!");
                return;
            }
            if (buyerAddress.isEmpty()) {
                etBuyerAddress.setError("Alamat harus diisi!");
                return;
            }

            // Pindah ke Form Konfirmasi Pembayaran
            Intent intent = new Intent(Pembayaran.this, KonfirmasiPembayaran.class);
            intent.putExtra("buyerName", buyerName);
            intent.putExtra("buyerAddress", buyerAddress);
            intent.putExtra("paymentMethod", paymentMethod);
            intent.putExtra("totalPrice", tvTotalPrice.getText().toString());
            startActivity(intent);
        });

        // Tombol Back
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}
