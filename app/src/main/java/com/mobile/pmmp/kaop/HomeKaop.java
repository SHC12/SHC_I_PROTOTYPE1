package com.mobile.pmmp.kaop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mobile.pmmp.AccountActivity;
import com.mobile.pmmp.MenuLoginActivity;
import com.mobile.pmmp.R;
import com.mobile.pmmp.RiwayatLaporan;

public class HomeKaop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kaop);
    }

    public void toLaporanKaop(View view) {
        startActivity(new Intent(this, RiwayatLaporan.class));
    }

    public void toAkunKaop(View view) {
        startActivity(new Intent(this, AccountActivity.class));
    }

    public void toLogoutKaop(View view) {
        startActivity(new Intent(this, MenuLoginActivity.class));
    }
}