package com.example.hanssparepart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Detail_Produk extends AppCompatActivity {

    private ImageView btnBack, productImage, galleryImage1, galleryImage2, galleryImage3;
    private TextView productName, productRating, productStock, productHarga, tvDescription;
    private EditText etJumlahBeli;
    private Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

        btnBack = findViewById(R.id.btnBack);
        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productRating = findViewById(R.id.productRating);
        productStock = findViewById(R.id.productStock);
        tvDescription = findViewById(R.id.tvDescription);
        productHarga = findViewById(R.id.productHarga);
        etJumlahBeli = findViewById(R.id.beliproduk);
        btnBuy = findViewById(R.id.btnBuy);
        galleryImage1 = findViewById(R.id.galleryImage1);
        galleryImage2 = findViewById(R.id.galleryImage2);
        galleryImage3 = findViewById(R.id.galleryImage3);

        // Ambil Data dari Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("productName");
        String harga = intent.getStringExtra("productHarga");
        String rating = intent.getStringExtra("productRating");
        String stock = intent.getStringExtra("productStock");
        String description = intent.getStringExtra("productDescription");
        int imageRes = intent.getIntExtra("productImage", R.drawable.hugger_1);
        int gallery1Res = intent.getIntExtra("galleryImage1", R.drawable.hugger_1);
        int gallery2Res = intent.getIntExtra("galleryImage2", R.drawable.hugger_2);
        int gallery3Res = intent.getIntExtra("galleryImage3", R.drawable.hugger_3);

        // Set Data ke Views
        productName.setText(name);
        productHarga.setText(harga);
        productRating.setText(rating);
        productStock.setText(stock);
        tvDescription.setText(description);
        productImage.setImageResource(imageRes);
        galleryImage1.setImageResource(gallery1Res);
        galleryImage2.setImageResource(gallery2Res);
        galleryImage3.setImageResource(gallery3Res);

        // Tombol Back
        btnBack.setOnClickListener(view -> finish());

        // Tombol Beli Sekarang
        btnBuy.setOnClickListener(view -> {
            String jumlahBeli = etJumlahBeli.getText().toString().trim();

            // Validasi input jumlah pembelian
            if (jumlahBeli.isEmpty()) {
                etJumlahBeli.setError("Jumlah pembelian harus diisi!");
                return;
            }
            if (Integer.parseInt(jumlahBeli) <= 0) {
                etJumlahBeli.setError("Jumlah pembelian harus lebih dari 0!");
                return;
            }

            // Aksi untuk tombol Beli Sekarang
            Intent buyIntent = new Intent(Detail_Produk.this, Pembayaran.class);
            buyIntent.putExtra("productName", name);
            buyIntent.putExtra("productHarga", harga);
            buyIntent.putExtra("jumlahBeli", jumlahBeli);
            startActivity(buyIntent);
        });
    }
}
