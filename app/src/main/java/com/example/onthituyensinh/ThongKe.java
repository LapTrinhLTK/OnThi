package com.example.onthituyensinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThongKe extends AppCompatActivity {
    Button btnvtt, btnhtcs;
    TextView txttongsocau, txtsocaudung, txtsocausai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        final Intent chuyenthongke = getIntent();
        //Nhan thong ke
//        int kt = chuyenthongke.getIntExtra("check", 0);
        String socau = chuyenthongke.getStringExtra("socau");
        String tongsocau = chuyenthongke.getStringExtra("tongcau");
        String socaudung = chuyenthongke.getStringExtra("caudung");
        String socausai = chuyenthongke.getStringExtra("causai");
//        String keytn = chuyenthongke.getStringExtra("keytunhien");
//        String keyxh = chuyenthongke.getStringExtra("keyxahoi");

        //Nhan bo mang HTCS ôn luyện
//        ArrayList<Integer> Index_cau = chuyenthongke.getIntegerArrayListExtra("index_cau_array");
//        ArrayList<String> selection = chuyenthongke.getStringArrayListExtra("selection_array");
//        int [][] mixed_position = (int[][]) getIntent().getSerializableExtra("mixed_position_array");

//        //Nhận bộ mảng Anh
//        ArrayList<Integer> Index_cau_Anh = chuyenthongke.getIntegerArrayListExtra("index_cau_array_anh");
//        ArrayList<String> selection_Anh = chuyenthongke.getStringArrayListExtra("selection_array_anh");
//        int [][] mixed_position_Anh = (int[][]) getIntent().getSerializableExtra("mixed_position_array_anh");
//
//        //Nhận bộ mảng tự nhiên
//        ArrayList<Integer> Index_cau_tn = chuyenthongke.getIntegerArrayListExtra("index_cau_array_tn");
//        ArrayList<String> selection_tn = chuyenthongke.getStringArrayListExtra("selection_array_tn");
//        int [][] mixed_position_tn = (int[][]) getIntent().getSerializableExtra("mixed_position_array_tn");
//
//        //Nhận bộ mảng xã hội
//        ArrayList<Integer> Index_cau_xh = chuyenthongke.getIntegerArrayListExtra("index_cau_array_xh");
//        ArrayList<String> selection_xh = chuyenthongke.getStringArrayListExtra("selection_array_xh");
//        int [][] mixed_position_xh = (int[][]) getIntent().getSerializableExtra("mixed_position_array_xh");

//        String keynodemon = chuyenthongke.getStringExtra("keynodemon");


        final Intent chuyenthongke2 = getIntent();

        //Nhận bộ mảng ôn luyện truyền về
//        Index_cau= chuyenthongke2.getIntegerArrayListExtra("index_cau_array");
//        selection = chuyenthongke2.getStringArrayListExtra("selection_array");
//        mixed_position = (int[][]) getIntent().getSerializableExtra("mixed_position_array");

//        //Nhận bộ mảng môn Anh truyền về
//        Index_cau_Anh = chuyenthongke2.getIntegerArrayListExtra("index_cau_array_anh");
//        selection_Anh = chuyenthongke2.getStringArrayListExtra("selection_array_anh");
//        mixed_position_Anh = (int[][]) getIntent().getSerializableExtra("mixed_position_array_anh");
//
//        //Nhận bộ mảng tự nhiên truyền về
//        Index_cau_tn = chuyenthongke2.getIntegerArrayListExtra("index_cau_array_tn");
//        selection_tn = chuyenthongke2.getStringArrayListExtra("selection_array_tn");
//        mixed_position_tn = (int[][]) getIntent().getSerializableExtra("mixed_position_array_tn");
//
//        //Nhận bộ mảng xã hội truyền về
//        Index_cau_xh = chuyenthongke2.getIntegerArrayListExtra("index_cau_array_xh");
//        selection_xh = chuyenthongke2.getStringArrayListExtra("selection_array_xh");
//        mixed_position_xh = (int[][]) getIntent().getSerializableExtra("mixed_position_array_xh");

//        kt = chuyenthongke2.getIntExtra("check", 0);
        socau = chuyenthongke2.getStringExtra("socau");
        tongsocau = chuyenthongke2.getStringExtra("tongcau");
        socaudung = chuyenthongke2.getStringExtra("caudung");
        socausai = chuyenthongke2.getStringExtra("causai");
//        keynodemon = chuyenthongke2.getStringExtra("keynodemon");
//        keytn = chuyenthongke.getStringExtra("keytunhien");
//        keyxh = chuyenthongke.getStringExtra("keyxahoi");

        //Đẩy các mảng sang HTCS.java
        btnhtcs = (Button) findViewById((R.id.btnhtcs));

        final String finalSocaudung = socaudung;
        final String finalTongsocau = tongsocau;
        final String finalSocausai = socausai;
        final String finalSocau = socau;
//        final int finalKt = kt;
//        final String finalKeynodemon = keynodemon;

        //Final mảng ôn luyện
//        final int[][] finalMixed_position = mixed_position;
//        final ArrayList<Integer> finalIndex_cau = Index_cau;
//        final ArrayList<String> finalSelection = selection;

//        //Final mảng Anh
//        final int[][] finalMixed_position_Anh = mixed_position_Anh;
//        final ArrayList<Integer> finalIndex_cau_Anh = Index_cau_Anh;
//        final ArrayList<String> finalSelection_Anh = selection_Anh;
//
//        //Final mảng tự nhiên
//        final ArrayList<Integer> finalIndex_cau_tn = Index_cau_tn;
//        final ArrayList<String> finalSelection_tn = selection_tn;
//        final int[][] finalMixed_position_tn = mixed_position_tn;
//
//        //Final mảng xã hội
//        final int[][] finalMixed_position_xh = mixed_position_xh;
//        final ArrayList<String> finalSelection_xh = selection_xh;
//        final ArrayList<Integer> finalIndex_cau_xh = Index_cau_xh;

//        final String finalKeytn = keytn;
//        final String finalKeyxh = keyxh;
        btnhtcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenhtcs = new Intent(ThongKe.this, HTCS.class);

                chuyenhtcs.putExtra("socau", String.valueOf(finalSocau));
                chuyenhtcs.putExtra("tongcau", String.valueOf(finalTongsocau));
                chuyenhtcs.putExtra("caudung", String.valueOf(finalSocaudung));
                chuyenhtcs.putExtra("causai", String.valueOf(finalSocausai));
//                chuyenthongke.putExtra("check", finalKt);

//                //Truyền bộ mảng Ôn Luyện
//                chuyenhtcs.putExtra("index_cau_array", finalIndex_cau);
//                chuyenhtcs.putExtra("selection_array", finalSelection);
//                chuyenhtcs.putExtra("mixed_position_array", finalMixed_position);

//                //Truyền bộ mảng Anh
//                chuyenhtcs.putExtra("index_cau_array_anh", finalIndex_cau_Anh);
//                chuyenhtcs.putExtra("selection_array_anh", finalSelection_Anh);
//                chuyenhtcs.putExtra("mixed_position_array_anh", finalMixed_position_Anh);
//
//                //Truyền bộ mảng tự nhiên
//                chuyenhtcs.putExtra("index_cau_array_tn", finalIndex_cau_tn);
//                chuyenhtcs.putExtra("selection_array_tn", finalSelection_tn);
//                chuyenhtcs.putExtra("mixed_position_array_tn", finalMixed_position_tn);
//
//                //Truyền bộ mảng xã hội
//                chuyenhtcs.putExtra("index_cau_array_xh", finalIndex_cau_xh);
//                chuyenhtcs.putExtra("selection_array_xh", finalSelection_xh);
//                chuyenhtcs.putExtra("mixed_position_array_xh", finalMixed_position_xh);

//                chuyenthongke.putExtra("keyxahoi", finalKeyxh);
//                chuyenthongke.putExtra("keytunhien", finalKeytn);

//                chuyenhtcs.putExtra("keynodemon", finalKeynodemon);
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



        if (Arrays.kt == 1){ txttongsocau.setText("Tổng số câu đã làm: " + tongsocau + "/" + "50");}
        else {txttongsocau.setText("Tổng số câu đã làm: " + tongsocau + "/" + socau);}
        txtsocaudung.setText("Số câu đúng: " + socaudung + "/" + tongsocau);
        txtsocausai.setText("Số câu sai: " + socausai + "/" + tongsocau);



    }
}