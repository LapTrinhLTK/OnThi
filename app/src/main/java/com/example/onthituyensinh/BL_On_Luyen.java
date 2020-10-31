package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class BL_On_Luyen extends AppCompatActivity {
    TextView cauhoi, btna,btnb,btnc,btnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_l__on__luyen);

        //Anh xa cac view
        cauhoi = (TextView) findViewById(R.id.cauhoi);
        btna = (Button) findViewById(R.id.btnA);
        btnb = (Button) findViewById(R.id.btnB);
        btnc = (Button) findViewById(R.id.btnC);
        btnd = (Button) findViewById(R.id.btnD);

        //Lay node mon on luyen da chon (string)
            Intent chuyencb = getIntent();
            String keynodemon = chuyencb.getStringExtra("monol");

        //Lay du lieu mon on luyen da chon

        Query mononluyen = FirebaseDatabase.getInstance().getReference().child(keynodemon);

        //Mang chua node cac cau hoi cua mon da chon
        String numcau;
        ArrayList<String> cauhoi = new ArrayList<>();

        for (int socau = 1; socau<=15; socau++ ){
            numcau = String.valueOf(socau);
            cauhoi.add("Câu " + socau);
        }








        

    }
}