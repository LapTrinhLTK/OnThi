package com.example.onthituyensinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThongKe extends AppCompatActivity {
    Button btnvtt, btnhtcs;
    TextView txttongsocau, txtsocaudung, txtsocausai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        final Intent chuyenthongke = getIntent();

        //Nhan thong ke
        int kt = chuyenthongke.getIntExtra("check", 0);
        String socau = chuyenthongke.getStringExtra("socau");
        String tongsocau = chuyenthongke.getStringExtra("tongcau");
        String socaudung = chuyenthongke.getStringExtra("caudung");
        String socausai = chuyenthongke.getStringExtra("causai");

        //Nhan bo mang HTCS
        final ArrayList<Integer> Index_cau = chuyenthongke.getIntegerArrayListExtra("index_cau_array");
        final ArrayList<String> selection = chuyenthongke.getStringArrayListExtra("selection_array");
        final int [][] mixed_position = (int[][]) getIntent().getSerializableExtra("mixed_position_array");
        final String keynodemon = chuyenthongke.getStringExtra("keynodemon");

        //Đẩy các mảng sang HTCS.java
        btnhtcs = (Button) findViewById((R.id.btnhtcs));
        btnhtcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenhtcs = new Intent(ThongKe.this, HTCS.class);

                chuyenhtcs.putExtra("index_cau_array", Index_cau);
                chuyenhtcs.putExtra("selection_array", selection);
                chuyenhtcs.putExtra("mixed_position_array", mixed_position);

                chuyenhtcs.putExtra("keynodemon", keynodemon);
                startActivity(chuyenhtcs);
            }
        });


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



        if (kt == 1){ txttongsocau.setText("Tổng số câu đã làm: " + tongsocau + "/" + "50");}
        else {txttongsocau.setText("Tổng số câu đã làm: " + tongsocau + "/" + socau);}
        txtsocaudung.setText("Số câu đúng: " + socaudung + "/" + tongsocau);
        txtsocausai.setText("Số câu sai: " + socausai + "/" + tongsocau);



    }
}