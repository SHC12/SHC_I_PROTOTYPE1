package com.mobile.pmmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.mobile.pmmp.admin.HomeAdmin;
import com.mobile.pmmp.kaop.HomeKaop;
import com.mobile.pmmp.user.HomeUser;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private MaterialButton btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.in_username_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mUsername = username.getText().toString();
                if(mUsername.equals("user")){
                    Intent intent = new Intent(LoginActivity.this, HomeUser.class);
                    intent.putExtra("kategori", "user");
                    startActivity(intent);
                } else if(mUsername.equals("admin")){
                    Intent intent = new Intent(LoginActivity.this, HomeAdmin.class);
                    intent.putExtra("kategori", "admin");
                    startActivity(intent);
                } else if(mUsername.equals("kaop")){
                    Intent intent = new Intent(LoginActivity.this, HomeKaop.class);
                    intent.putExtra("kategori", "kaop");
                    startActivity(intent);
                }
            }
        });
    }
}