package com.yunhasnawa.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txvNama, txvNoTelepon;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Hubungkan dengan layout
        this.txvNama = this.findViewById(R.id.txvNama);
        this.txvNoTelepon = this.findViewById(R.id.txvNoTelepon);
        this.button = findViewById(R.id.btnLogout);

        // Ambil data dari intent
        String namaDariLogin = this.getIntent().getStringExtra("nama");
        String noTelpDariLogin = this.getIntent().getStringExtra("noTelepon");

        // Di tampilkan di TextView
        this.txvNama.setText(namaDariLogin);
        this.txvNoTelepon.setText(noTelpDariLogin);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLogout){
            this.finish();
        }
    }
}

// Tugas
// Modifikasi aplikasi ini sehingga:
// 1. Ada tambahan satu edit text untuk memasukkan password.
// 2. Apabila password yang dimasukkan oleh pengguna:
//    - benar, maka halaman akan berpindah ke home.
//    - Kalau salah, muncul toast "Password Salah!"
// 3. Passwordnya dikoding manual saja di MainActivity -> 1234
// 4. Ketika diklik button logout, halaman akan kembali ke Login
//    - Gunakan method `this.finish();`

// Yang dikumpulkan:
// - File project dalam bentuk Zip.
// - Screenshot hasilnya dirangkum dalam sebuah file PDF.

// Pengumpulan: https://forms.gle/85fcwYW5fye15Dw8A