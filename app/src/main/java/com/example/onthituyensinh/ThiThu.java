package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThiThu extends AppCompatActivity {
    Button btnreturn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_thu);

        btnreturn1 = (Button) findViewById(R.id.return1);

        btnreturn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenmain1 = new Intent(ThiThu.this, MainActivity.class);
                startActivity(chuyenmain1);
            }
        });
    }
}