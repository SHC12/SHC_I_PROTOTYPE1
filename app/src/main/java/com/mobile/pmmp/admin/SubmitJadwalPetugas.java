package com.mobile.pmmp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.mobile.pmmp.R;

public class SubmitJadwalPetugas extends AppCompatActivity {
    private String[] shift = {"Shift 1","Shift 2"};
    private AutoCompleteTextView spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_jadwal_petugas);

        spinner = findViewById(R.id.in_shift);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.spinner_list_item,shift);
        spinner.setAdapter(adapter);
    }

    public void toJadwalPetugas(View view) {
        startActivity(new Intent(SubmitJadwalPetugas.this,JadwalPetugasMaintenance.class));
    }
}