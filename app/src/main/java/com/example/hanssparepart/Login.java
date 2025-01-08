package com.example.hanssparepart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText textEmail, textPass;
    private LinearLayout buttonLogin;
    private TextView lupaSandi, daftar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // Inisialisasi komponen
        textEmail = findViewById(R.id.TextEmail);
        textPass = findViewById(R.id.TextPass);
        buttonLogin = findViewById(R.id.buttonLogin);
        lupaSandi = findViewById(R.id.LupaSandi);
        daftar = findViewById(R.id.textView4);

        // Set listener untuk tombol Login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString().trim();
                String password = textPass.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Email atau password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    loginWithFirebase(email, password);
                }
            }
        });

        // Set listener untuk "Lupa Kata Sandi"
        lupaSandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Lupasandi.class);
                startActivity(intent);
            }
        });

        // Set listener untuk "Register"
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private void loginWithFirebase(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login berhasil
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(Login.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, Dashboard.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Login gagal
                        Toast.makeText(Login.this, "Login gagal: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
