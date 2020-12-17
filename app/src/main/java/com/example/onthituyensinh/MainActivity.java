package com.example.onthituyensinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnthithu, btnonluyen, btnintro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnthithu = (Button) findViewById(R.id.btnthithu);
        btnonluyen = (Button) findViewById(R.id.btnonluyen);
        btnintro = (Button) findViewById(R.id.btnhuongdan);

        Arrays.kt = 0;

        btnthithu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenthithu = new Intent(MainActivity.this, ThiThu.class);
                startActivity(chuyenthithu);
            }
        });

        btnonluyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenol = new Intent(MainActivity.this, On_Luyen.class);
                startActivity(chuyenol);
            }
        });

        btnintro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenintro = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(chuyenintro);
            }
        });


    }
}