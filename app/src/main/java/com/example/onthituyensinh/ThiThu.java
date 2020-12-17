package com.example.onthituyensinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ThiThu extends AppCompatActivity {
    Button btnreturn1, btndeso1, btndeso2, btndeso3, btndeso4, btndeso5, btndeso6, btndeso7, btndeso8,btndeso9, btndeso10;

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

        Arrays.kt = 1;

        btndeso1 = (Button) findViewById(R.id.deso1);
        btndeso2 = (Button) findViewById(R.id.deso2);
        btndeso3 = (Button) findViewById(R.id.deso3);
        btndeso4 = (Button) findViewById(R.id.deso4);
        btndeso5 = (Button) findViewById(R.id.deso5);
        btndeso6 = (Button) findViewById(R.id.deso6);
        btndeso7 = (Button) findViewById(R.id.deso7);
        btndeso8 = (Button) findViewById(R.id.deso8);
        btndeso9 = (Button) findViewById(R.id.deso9);
        btndeso10 = (Button) findViewById(R.id.deso10);

        btndeso1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });

        btndeso10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Randommon();
            }
        });
    }

    public void Randommon()
    {
        Intent chuyencbtt = new Intent(ThiThu.this, CB_ThiThu.class);
        Random montn = new Random();
        Random monxh = new Random();

        //Lay ngau nhien mon tu nhien
        int tn = montn.nextInt(3);
        tn += 1;
        String tunhien;
        switch (tn)
        {
            case 1: tunhien = "Vật Lý";
                break;
            case 2: tunhien = "Hoá Học";
                break;
            case 3: tunhien = "Sinh Học";
                break;
            default: tunhien = "";
                break;
        }

        //Lay ngau nhien mon xa hoi
        int xh = monxh.nextInt(3);
        xh += 1;
        String xahoi;
        switch (xh)
        {
            case 1: xahoi = "Lịch Sử";
                break;
            case 2: xahoi = "Địa Lý";
                break;
            case 3: xahoi = "GDCD";
                break;
            default: xahoi = "";
                break;

        }


        chuyencbtt.putExtra("monthi", "Môn: Anh Văn, " + tunhien + ", " + xahoi);
        Arrays.keytn = tunhien;
        Arrays.keyxh = xahoi;

//        chuyencbtt.putExtra("montn", tunhien);
//        chuyencbtt.putExtra("monxh", xahoi);
        startActivity(chuyencbtt);
    }
}