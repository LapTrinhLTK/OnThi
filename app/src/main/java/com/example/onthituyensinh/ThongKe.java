package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThongKe extends AppCompatActivity {
    Button btnvtt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        btnvtt = (Button) findViewById(R.id.btnbackmain);
        btnvtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenmain4 = new Intent(ThongKe.this, MainActivity.class);
                startActivity(chuyenmain4);
            }
        });
    }
}