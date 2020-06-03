package com.mobile.pmmp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mobile.pmmp.R;
import com.mobile.pmmp.model.Jadwal;

public class DetailJadwalPetugasAdmin extends AppCompatActivity {


    public static final String DETAIL_JADWAL_PETUGAS = "detail_jadwal" ;
    private TextView tanggal,lokasi,status,nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal_petugas_admin);

        tanggal = findViewById(R.id.tanggalDetailJadwalAdmin);
        lokasi = findViewById(R.id.lokasiDetailJadwalAdmin);
        status = findViewById(R.id.statusMesinDetailJadwalAdmin);
        nama = findViewById(R.id.namaDetailJadwalAdmin);

        Jadwal jadwal = getIntent().getParcelableExtra(DETAIL_JADWAL_PETUGAS);
        String mTanggal = jadwal.getTanggal();
        String mStatus = jadwal.getStatusMesin();
        String mLokasi = jadwal.getLokasi();
        String mNama = jadwal.getNama();

        tanggal.setText(mTanggal);
        lokasi.setText(mLokasi);
        status.setText(mStatus);
        nama.setText(mNama);

    }

    public void toSubmitJadwal(View view) {
        startActivity(new Intent(DetailJadwalPetugasAdmin.this,SubmitJadwalPetugas.class));
    }
}