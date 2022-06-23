package com.yunhasnawa.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Buat property dulu
    private EditText edtNama;
    private EditText edtNoTelepon;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hubungkan properti class dengan components yang ada di layout.xml
        this.edtNama = this.findViewById(R.id.edtNama);
        this.edtNoTelepon = this.findViewById(R.id.edtNoTelepon);
        this.btnLogin = this.findViewById(R.id.btnLogin);
        this.edtPassword = this.findViewById(R.id.edtPassword);

        // Mengatur event listener untuk button login ketika diklik
        this.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        // Pastikan yang diklik adalah komponen yang sesuai dengan kemauan kita
        if (((Button) view) == this.btnLogin)
        {
            this.login();
        }
        else
        {
            // Lakukan proses yanng lain..
        }
    }

    private void login()
    {
        // Ambil isi dari edtNama
        String nama = this.edtNama.getText().toString();
        String noTelepon = this.edtNoTelepon.getText().toString();
        String password = this.edtPassword.getText().toString();


        validasi(nama, noTelepon, password);
    }

    private void validasi(String name, String noTelepon, String password){
        if(!name.isEmpty()){
            if(!noTelepon.isEmpty()){
                if(!password.isEmpty()){
                    Intent intent = new Intent(this, HomeActivity.class);
                    intent.putExtra("nama", name);
                    intent.putExtra("noTelepon", noTelepon);
                    clearInput();
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Password Tidak Boleh Kososng", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "No Telepon Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearInput(){
        this.edtPassword.setText("");
        this.edtNama.setText("");
        this.edtNoTelepon.setText("");
    }
}