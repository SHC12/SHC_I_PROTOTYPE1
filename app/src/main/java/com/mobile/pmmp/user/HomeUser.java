package com.mobile.pmmp.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mobile.pmmp.AccountActivity;
import com.mobile.pmmp.LoginActivity;
import com.mobile.pmmp.MenuLoginActivity;
import com.mobile.pmmp.R;
import com.mobile.pmmp.admin.HomeAdmin;

public class HomeUser extends AppCompatActivity {
    String kategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        kategori = getIntent().getStringExtra("kategori");

    }

    public void toJadwalPetugas(View view) {
        startActivity(new Intent(HomeUser.this,JadwalPetugasUser.class));
    }

    public void toAbsenPetugas(View view) {
        startActivity(new Intent(HomeUser.this,AbsenPetugasUser.class));
    }

    public void toCheckStatusMesin(View view) {
        Toast.makeText(this, "Tidak ada keterangan tentang activity ini di pdf", Toast.LENGTH_LONG).show();
    }

    public void toLaporanUser(View view) {
        Intent intent = new Intent(HomeUser.this, LaporanUser.class);
        intent.putExtra("kategori", kategori);
        startActivity(intent);

    }

    public void toAkunUser(View view) {
        startActivity(new Intent(HomeUser.this, AccountActivity.class));
    }

    public void toLogoutUser(View view) {
        startActivity(new Intent(HomeUser.this, MenuLoginActivity.class));
    }
}