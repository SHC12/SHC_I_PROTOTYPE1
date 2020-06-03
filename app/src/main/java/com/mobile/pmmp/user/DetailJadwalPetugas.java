package com.mobile.pmmp.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mobile.pmmp.R;
import com.mobile.pmmp.model.Jadwal;

public class DetailJadwalPetugas extends AppCompatActivity {

    public static final String DETAIL_JADWAL_PETUGAS = "detail_jadwal" ;
    private TextView tanggal,lokasi,status, shift, petugas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal_petugas);

        tanggal = findViewById(R.id.tanggalDetailJadwal);
        lokasi = findViewById(R.id.lokasiDetailJadwal);
        status = findViewById(R.id.statusMesinDetailJadwal);
        shift = findViewById(R.id.shiftDetailJadwal);
        petugas = findViewById(R.id.petugasDetailJadwal);



        Jadwal jadwal = getIntent().getParcelableExtra(DETAIL_JADWAL_PETUGAS);
        String mTanggal = jadwal.getTanggal();
        String mStatus = jadwal.getStatusMesin();
        String mLokasi = jadwal.getLokasi();
        String mNama = jadwal.getNama();
        String mShift = jadwal.getShift();

        tanggal.setText(mTanggal);
        lokasi.setText(mLokasi);
        status.setText(mStatus);
        shift.setText(mShift);
        petugas.setText(mNama);

    }
}