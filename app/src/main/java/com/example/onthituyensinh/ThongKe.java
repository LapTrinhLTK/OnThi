package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThongKe extends AppCompatActivity {
    Button btnvtt, btnhtcs;
    TextView txttongsocau, txtsocaudung, txtsocausai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        btnhtcs = (Button) findViewById((R.id.btnhtcs));
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
        int kt = chuyenthongke.getIntExtra("check", 0);
        String socau = chuyenthongke.getStringExtra("socau");
        String tongsocau = chuyenthongke.getStringExtra("tongcau");
        String socaudung = chuyenthongke.getStringExtra("caudung");
        String socausai = chuyenthongke.getStringExtra("causai");

        if (kt == 1){ txttongsocau.setText("Tổng số câu đã làm: " + tongsocau + "/" + "50");}
        else {txttongsocau.setText("Tổng số câu đã làm: " + tongsocau + "/" + socau);}
        txtsocaudung.setText("Số câu đúng: " + socaudung + "/" + tongsocau);
        txtsocausai.setText("Số câu sai: " + socausai + "/" + tongsocau);



    }
}