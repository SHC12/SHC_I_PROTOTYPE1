package com.mobile.pmmp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobile.pmmp.AccountActivity;
import com.mobile.pmmp.MenuLoginActivity;
import com.mobile.pmmp.R;
import com.mobile.pmmp.RiwayatLaporan;
import com.mobile.pmmp.user.HomeUser;
import com.mobile.pmmp.user.LaporanUser;

public class HomeAdmin extends AppCompatActivity {

    String kategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        kategori = getIntent().getStringExtra("kategori");
    }

    public void toJadwalPetugasAdmin(View view) {
        startActivity(new Intent(this,JadwalPetugasMaintenance.class));
    }

    public void toAbsenPetugasAdmin(View view) {
        startActivity(new Intent(this,AbsenPetugasAdmin.class));

    }

    public void toDataPetugas(View view) {
        startActivity(new Intent(this,DataPetugas.class));
    }

    public void toLaporanAdmin(View view) {
        Intent intent = new Intent(HomeAdmin.this, LaporanUser.class);
        intent.putExtra("kategori", kategori);
        startActivity(intent);
    }

    public void toAkunAdmin(View view) {
        startActivity(new Intent(this, AccountActivity.class));
    }

    public void toLogoutAdmin(View view) {
        startActivity(new Intent(this, MenuLoginActivity.class));
    }
}