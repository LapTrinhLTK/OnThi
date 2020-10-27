package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    Button btnthithu, btnonluyen, btnintro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnthithu = (Button) findViewById(R.id.btnthithu);
        btnonluyen = (Button) findViewById(R.id.btnonluyen);
        btnintro = (Button) findViewById(R.id.btnhuongdan);

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


    }
}