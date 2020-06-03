package com.mobile.pmmp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mobile.pmmp.R;
import com.mobile.pmmp.model.Petugas;

public class DetailDataPetugas extends AppCompatActivity {

    public static final String DETAIL_PETUGAS = "detail_petugas" ;
    private TextView id,nama,username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_petugas);
        id = findViewById(R.id.idDetailPetugas);
        nama = findViewById(R.id.namaDetailPetugas);
        username = findViewById(R.id.usernameDetailPetugas);
        password = findViewById(R.id.passwordDetailPetugas);

        Petugas petugas = getIntent().getParcelableExtra(DETAIL_PETUGAS);
        String mId = petugas.getIdPetugas();
        String mNama = petugas.getNamaLengkap();
        String mUsername = petugas.getUsername();
        String mPassword = petugas.getPassword();

        id.setText(mId);
        nama.setText(mNama);
        username.setText(mUsername);
        password.setText(mPassword);
    }
}