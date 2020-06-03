package com.mobile.pmmp.user;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.mobile.pmmp.R;
import com.mobile.pmmp.RiwayatLaporan;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LaporanUser extends AppCompatActivity {
    private AutoCompleteTextView spinner;
    private String[] status_mesin = {"Mesin Mati","Kertas Selip","Kertas Habis"};
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat simpleDateFormat;
    private EditText edtTanggal,edtLokasi,edtKeterangan,edtFile;
    private MaterialButton btnAbsen;

    String kategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_user);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        edtKeterangan = findViewById(R.id.in_keterangan_laporan);
        edtLokasi = findViewById(R.id.in_lokasi_mesin);
        edtTanggal = findViewById(R.id.in_tgl_laporan);
        edtFile = findViewById(R.id.in_file_laporan);
        btnAbsen = findViewById(R.id.btn_submit_laporan);

        kategori = getIntent().getStringExtra("kategori");

        spinner = findViewById(R.id.in_status_mesin);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.spinner_list_item,status_mesin);
        spinner.setAdapter(adapter);

        edtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(edtTanggal);
            }
        });

        btnAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LaporanUser.this, "Berhasil Input Laporan", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LaporanUser.this, RiwayatLaporan.class);
                i.putExtra("flagRiwayatLaporan","user");
                startActivity(i);
            }
        });

    }

    private void showDateDialog(final EditText edt_target) {

        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                edt_target.setText(simpleDateFormat.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    public void toRiwayatLaporan(View view) {
        Intent i = new Intent(LaporanUser.this, RiwayatLaporan.class);
        i.putExtra("flagRiwayatLaporan","user");
        i.putExtra("kategori",kategori);
        startActivity(i);
    }
}