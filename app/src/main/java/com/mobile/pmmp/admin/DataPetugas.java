package com.mobile.pmmp.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobile.pmmp.PDFViewer;
import com.mobile.pmmp.R;
import com.mobile.pmmp.adapter.TableAdapterDataPetugas;
import com.mobile.pmmp.model.Petugas;

import java.util.ArrayList;
import java.util.List;

public class DataPetugas extends AppCompatActivity {
    private RecyclerView rvDataPetugas;
    private TableAdapterDataPetugas adapterDataPetugas;
    private TableAdapterDataPetugas.RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_petugas);
        rvDataPetugas = findViewById(R.id.rv_data_petugas_admin);
        listener = new TableAdapterDataPetugas.RecyclerViewClickListener() {
            @Override
            public void onRowClick(View view, int position) {
                Intent i = new Intent(DataPetugas.this,DetailDataPetugas.class);
                i.putExtra(DetailDataPetugas.DETAIL_PETUGAS,getPetugas().get(position-1));
                startActivity(i);
            }
        };
        adapterDataPetugas = new TableAdapterDataPetugas(getPetugas(),getApplicationContext(),listener);
        rvDataPetugas.setLayoutManager(new LinearLayoutManager(this));
        rvDataPetugas.setHasFixedSize(true);
        rvDataPetugas.setAdapter(adapterDataPetugas);

    }

    private List<Petugas> getPetugas(){
        List<Petugas> petugases = new ArrayList<>();
        petugases.add(new Petugas("1","001","M. Aditya ","aditya","123"));
        petugases.add(new Petugas("2","002","Andika Pratama","andika","123"));
        petugases.add(new Petugas("3","003","Slamet Hariyanto","slamet","123"));


        return petugases;

    }

    public void toInsertDataPetugas(View view) {
        startActivity(new Intent(DataPetugas.this,TambahPetugas.class));
    }

    public void ExportDataPetugas(View view) {
        Intent intent =  new Intent(DataPetugas.this, PDFViewer.class);
        intent.putExtra("trigger", "data_petugas");
        startActivity(intent);
    }
}