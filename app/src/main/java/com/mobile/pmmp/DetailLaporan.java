package com.mobile.pmmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mobile.pmmp.R;
import com.mobile.pmmp.model.Laporan;

public class DetailLaporan extends AppCompatActivity {

    public static final String DETAIL_LAPORAN = "detail_laporan" ;
    private TextView tanggal,lokasi,statusMesin,file,keterangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laporan);

        Laporan  laporan = getIntent().getParcelableExtra(DETAIL_LAPORAN);
        String mTanggal = laporan.getTanggal();
        String mLokasi = laporan.getLokasi();
        String mStatusMesin = laporan.getStatusMesin();
        String mFile = laporan.getFile();
        String mKeterangan = laporan.getKeterangan();

        tanggal = findViewById(R.id.tanggalDetailLaporan);
        lokasi = findViewById(R.id.lokasiDetailLaporan);
        statusMesin = findViewById(R.id.statusMesinDetailLaporan);
        file = findViewById(R.id.fileDetailLaporan);
        keterangan = findViewById(R.id.keterangan_laporan);
        tanggal.setText(mTanggal);
        lokasi.setText(mLokasi);
        statusMesin.setText(mStatusMesin);
        file.setText(mFile);
        keterangan.setText(mKeterangan);

    }
}