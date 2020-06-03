package com.mobile.pmmp.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobile.pmmp.R;
import com.mobile.pmmp.adapter.TableAdapterJadwal;
import com.mobile.pmmp.model.Jadwal;
import com.mobile.pmmp.user.DetailJadwalPetugas;
import com.mobile.pmmp.user.JadwalPetugasUser;

import java.util.ArrayList;
import java.util.List;

public class JadwalPetugasMaintenance extends AppCompatActivity {
    private RecyclerView rv_jadwalUser;
    private TableAdapterJadwal adapter;
    private TableAdapterJadwal.RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_petugas_maintenance);
        rv_jadwalUser = findViewById(R.id.rv_jadwal_petugas_user);

        listener = new TableAdapterJadwal.RecyclerViewClickListener() {
            @Override
            public void onRowClick(View view, int position) {
                Intent i = new Intent(JadwalPetugasMaintenance.this, DetailJadwalPetugas.class);
                i.putExtra(DetailJadwalPetugas.DETAIL_JADWAL_PETUGAS,getJadwal().get(position-1));
                startActivity(i);
            }
        };
        adapter = new TableAdapterJadwal(getJadwal(),getApplicationContext(),listener);
        rv_jadwalUser.setLayoutManager(new LinearLayoutManager(this));
        rv_jadwalUser.setHasFixedSize(true);
        rv_jadwalUser.setAdapter(adapter);

    }

    private List<Jadwal> getJadwal(){
        List<Jadwal> jadwals = new ArrayList<>();
        jadwals.add(new Jadwal("1","02-01-2020","Jl.Juanda Raya","Kertas Selip","M. Aditya", "Shift 1"));
        jadwals.add(new Jadwal("2","02-04-2020","Jl.Pencenogan","Mesin Struk Rusak","Andika Pratama","Shift 2"));
        jadwals.add(new Jadwal("3","01-02-2020","Jl.Pintu Air","Mesin Struk Rusak","Hariyanto","Shift 1"));
        jadwals.add(new Jadwal("4","08-01-2020","Jl.Batu Tulis","Mesin Struk Rusak","Reni Wulandari","Shift 2"));
        jadwals.add(new Jadwal("5","12-01-2020","Jl.H.Agus Salim","Mesin Struk Rusak","Nurvita Widiyanti","Shift 2"));
        return jadwals;
    }

    public void toInputJadwal(View view) {
        startActivity(new Intent(JadwalPetugasMaintenance.this,SubmitJadwalPetugas.class));
    }
}