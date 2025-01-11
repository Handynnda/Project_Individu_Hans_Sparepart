package com.example.hanssparepart;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Register extends AppCompatActivity {

    // Deklarasi variabel
    private EditText editTextFullName, editTextEmail, editTextPassword, editTextConfirmPassword;
    private AppCompatButton buttonRegister;
    private TextView tombolMasuk;
    private FirebaseAuth mAuth; // Firebase Authentication
    private DatabaseReference databaseReference; // Firebase Realtime Database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Inisialisasi komponen UI
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonRegister = findViewById(R.id.daftar);
        tombolMasuk = findViewById(R.id.tombol_1);

        // Set listener untuk tombol "Daftar Sekarang"
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai input dari EditText
                String fullName = editTextFullName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                // Validasi input
                if (TextUtils.isEmpty(fullName)) {
                    Toast.makeText(Register.this, "Nama lengkap tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Register.this, "Alamat email tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this, "Kata sandi tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(Register.this, "Kata sandi harus memiliki minimal 6 karakter", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(Register.this, "Kata sandi dan konfirmasi kata sandi tidak cocok", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Proses registrasi dengan Firebase Authentication
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                // Registrasi berhasil
                                FirebaseUser user = mAuth.getCurrentUser();
                                if (user != null) {
                                    String userId = user.getUid(); // Dapatkan UID pengguna dari FirebaseAuth

                                    // Dapatkan tanggal saat ini dalam format DD/MM/YYYY
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                    String registrationDate = dateFormat.format(new Date());

                                    // Simpan data ke Firebase Realtime Database
                                    databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId);

                                    // Buat HashMap untuk menyimpan data pengguna
                                    HashMap<String, String> userMap = new HashMap<>();
                                    userMap.put("fullName", fullName);
                                    userMap.put("email", email);
                                    userMap.put("registrationDate", registrationDate); // Gunakan format tanggal DD/MM/YYYY

                                    // Simpan data ke Firebase
                                    databaseReference.setValue(userMap)
                                            .addOnCompleteListener(dbTask -> {
                                                if (dbTask.isSuccessful()) {
                                                    Toast.makeText(Register.this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show();
                                                    // Pindah ke halaman login
                                                    Intent intent = new Intent(Register.this, Login.class);
                                                    startActivity(intent);
                                                    finish();
                                                } else {
                                                    Toast.makeText(Register.this, "Gagal menyimpan data pengguna.", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                }
                            } else {
                                // Registrasi gagal
                                Toast.makeText(Register.this, "Registrasi gagal: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        // Set listener untuk teks "Masuk"
        tombolMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman login
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}