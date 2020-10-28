package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class ThiThu extends AppCompatActivity {
    Button btnreturn1, btndeso;

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

        btndeso = (Button) findViewById(R.id.deso1);
        btndeso = (Button) findViewById(R.id.deso2);
        btndeso = (Button) findViewById(R.id.deso3);
        btndeso = (Button) findViewById(R.id.deso4);
        btndeso = (Button) findViewById(R.id.deso5);
        btndeso = (Button) findViewById(R.id.deso6);
        btndeso = (Button) findViewById(R.id.deso7);
        btndeso = (Button) findViewById(R.id.deso8);
        btndeso = (Button) findViewById(R.id.deso9);
        btndeso = (Button) findViewById(R.id.deso10);

        btndeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyencbtt = new Intent(ThiThu.this, CB_ThiThu.class);
                Random montn = new Random();
                Random monxh = new Random();

                //Lay ngau nhien mon tu nhien
                int tn = montn.nextInt(3);
                tn += 1;
                String tunhien;
                switch (tn){
                    case 1: tunhien = "vật lý";
                            break;
                    case 2: tunhien = "hoá học";
                            break;
                    case 3: tunhien = "sinh học";
                            break;
                    default: tunhien = "";
                            break;
                }

                //Lay ngau nhien mon xa hoi
                int xh = monxh.nextInt(3);
                xh += 1;
                String xahoi;
                switch (xh){
                    case 1: xahoi = "lịch sử";
                        break;
                    case 2: xahoi = "địa lý";
                        break;
                    case 3: xahoi = "GDCD";
                        break;
                    default: xahoi = "";
                            break;

                }


                chuyencbtt.putExtra("monthi", "Môn: Anh Văn, " + tunhien + ", " + xahoi);
                startActivity(chuyencbtt);
            }
        });
    }
}