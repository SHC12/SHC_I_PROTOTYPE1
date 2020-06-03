package com.mobile.pmmp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mobile.pmmp.adapter.TableAdapterRiwayatLaporan;
import com.mobile.pmmp.model.Laporan;
import com.mobile.pmmp.user.RiwayatAbsenUser;

import java.util.ArrayList;
import java.util.List;

public class RiwayatLaporan extends AppCompatActivity {
    private RecyclerView rvRiwayatLaporan;
    private TableAdapterRiwayatLaporan adapterRiwayatLaporan;
    private TableAdapterRiwayatLaporan.RecyclerViewClickListener listener;

    String kategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_laporan);
        rvRiwayatLaporan = findViewById(R.id.rv_riwayat_laporan_petugas_user);
        String flagRiwayat = getIntent().getStringExtra("flagRiwayatLaporan");
        kategori = getIntent().getStringExtra("kategori");
        listener = new TableAdapterRiwayatLaporan.RecyclerViewClickListener() {
            @Override
            public void onRowClick(View view, int position) {
                Intent i = new Intent(RiwayatLaporan.this,DetailLaporan.class);
                i.putExtra(DetailLaporan.DETAIL_LAPORAN,getLaporan().get(position-1));
                startActivity(i);
            }
        };
        adapterRiwayatLaporan = new TableAdapterRiwayatLaporan(getLaporan(),getApplicationContext(),listener);
        rvRiwayatLaporan.setLayoutManager(new LinearLayoutManager(this));
        rvRiwayatLaporan.setHasFixedSize(true);
        rvRiwayatLaporan.setAdapter(adapterRiwayatLaporan);




    }

    private List<Laporan> getLaporan(){
        List<Laporan> laporans = new ArrayList<>();
        laporans.add(new Laporan("1","2020-01-20","Jl.Juanda Raya","Kertas Selip","PT.jpg","normal"));
        laporans.add(new Laporan("2","2020-01-20","Jl.Pencenogan","Kertas Selip","PT.jpg","normal"));
        laporans.add(new Laporan("3","2020-01-20","Jl.Pintu Air","Kerusakan Kecil","PT.jpg","normal"));
        laporans.add(new Laporan("4","2020-01-20","Jl.Batu Tulis","Kerusakan Kecil","PT.jpg","Kerusakan sudah fix"));
        laporans.add(new Laporan("5","2020-01-20","Jl.H.Agus Salim","Kerusakan Kecil","PT.jpg","Kerusakan sudah fix"));
        return laporans;
    }

    public void ExportLaporanPetugas(View view) {

        if(kategori.equals("user")){
            Intent in = new Intent(RiwayatLaporan.this, PDFViewer.class);
            in.putExtra("trigger", "laporan_user");
            startActivity(in);
        }else if(kategori.equals("admin")){
            Intent in = new Intent(RiwayatLaporan.this, PDFViewer.class);
            in.putExtra("trigger", "laporan_admin");
            startActivity(in);
        }

    }
}