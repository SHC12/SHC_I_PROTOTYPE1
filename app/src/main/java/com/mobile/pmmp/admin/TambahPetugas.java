package com.mobile.pmmp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobile.pmmp.R;

public class TambahPetugas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_petugas);
    }

    public void toDataPetugas(View view) {
        startActivity(new Intent(TambahPetugas.this,DataPetugas.class));
    }
}