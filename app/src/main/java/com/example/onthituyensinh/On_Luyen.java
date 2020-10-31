package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class On_Luyen extends AppCompatActivity {
    Button btnreturn2, btnLy, btnHoa, btnSinh, btnDia, btnSu, btnGD, btnAnh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on__luyen);

        btnreturn2 = (Button) findViewById(R.id.return2);
        btnreturn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenmain2 = new Intent(On_Luyen.this, MainActivity.class);
                startActivity(chuyenmain2);
            }
        });

        btnLy = (Button) findViewById(R.id.btnLy);
        btnLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyencb = new Intent(On_Luyen.this, CB_On_Luyen.class);
                chuyencb.putExtra("monol","Vật Lý");
                startActivity(chuyencb);
            }
        });

        btnHoa = (Button) findViewById(R.id.btnHoa);
        btnHoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyencb = new Intent(On_Luyen.this, CB_On_Luyen.class);
                chuyencb.putExtra("monol","Hoá Học");
                startActivity(chuyencb);
            }
        });

        btnSinh = (Button) findViewById(R.id.btnSinh);
        btnSinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyencb = new Intent(On_Luyen.this, CB_On_Luyen.class);
                chuyencb.putExtra("monol","Sinh Học");
                startActivity(chuyencb);
            }
        });

        btnDia = (Button) findViewById(R.id.btnDia);
        btnDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyencb = new Intent(On_Luyen.this, CB_On_Luyen.class);
                chuyencb.putExtra("monol","Địa Lý");
                startActivity(chuyencb);
            }
        });

        btnSu = (Button) findViewById(R.id.btnSu);
        btnSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyencb = new Intent(On_Luyen.this, CB_On_Luyen.class);
                chuyencb.putExtra("monol","Lịch Sử");
                startActivity(chuyencb);
            }
        });

        btnGD = (Button) findViewById(R.id.btnGD);
        btnGD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyencb = new Intent(On_Luyen.this, CB_On_Luyen.class);
                chuyencb.putExtra("monol","GDCD");
                startActivity(chuyencb);
            }
        });

        btnAnh = (Button) findViewById(R.id.btnAnh);
        btnAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyencb = new Intent(On_Luyen.this, CB_On_Luyen.class);
                chuyencb.putExtra("monol","Anh Văn");
                startActivity(chuyencb);
            }
        });
    }
}