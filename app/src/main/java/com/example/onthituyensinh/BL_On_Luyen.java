package com.example.onthituyensinh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Random;

public class BL_On_Luyen extends AppCompatActivity {
    TextView txtquestion, btna,btnb,btnc,btnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_l__on__luyen);

        //Anh xa cac view
        txtquestion = (TextView) findViewById(R.id.cauhoi);
        btna = (Button) findViewById(R.id.btnA);
        btnb = (Button) findViewById(R.id.btnB);
        btnc = (Button) findViewById(R.id.btnC);
        btnd = (Button) findViewById(R.id.btnD);

        //Lay node mon on luyen da chon (string)
            Intent chuyencb = getIntent();
            String keynodemon = chuyencb.getStringExtra("monol");

        //Xet so cau (sau nay bien so nguyen trong phan nay se la tham so cho random)
        int sc;
        if (keynodemon == "Anh Văn"){
            sc = 20;
        } else {
            sc = 15;
        }



        }
        





        

    }
