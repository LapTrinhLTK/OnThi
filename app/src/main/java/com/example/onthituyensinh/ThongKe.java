package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThongKe extends AppCompatActivity {
    Button btnvtt;
    TextView txttongsocau, txtsocaudung, txtsocausai;
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

        txttongsocau = (TextView) findViewById(R.id.kqsocau);
        txtsocaudung = (TextView) findViewById(R.id.kqdung);
        txtsocausai = (TextView) findViewById(R.id.kqsai);

        Intent chuyenthongke = getIntent();
        String socau = chuyenthongke.getStringExtra("socau");
        String tongsocau = chuyenthongke.getStringExtra("tongsocau");
        String socaudung = chuyenthongke.getStringExtra("socaudung");
        String socausai = chuyenthongke.getStringExtra("socausai");

        txttongsocau.setText("Tổng số câu đã làm: " + tongsocau + "/" + socau);
        txtsocaudung.setText("Số câu đúng: " + socaudung + "/" + tongsocau);
        txtsocausai.setText("Số câu sai: " + socausai + "/" + tongsocau);



    }
}