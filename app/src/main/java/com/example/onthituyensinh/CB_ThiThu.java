package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CB_ThiThu extends AppCompatActivity {
    Button btnreturn4;
    TextView tbmon2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_b__thi_thu);

        btnreturn4 = (Button) findViewById(R.id.return4);
        btnreturn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyentt2 = new Intent(CB_ThiThu.this, ThiThu.class);
                startActivity(chuyentt2);
            }
        });

        tbmon2 = (TextView) findViewById(R.id.tbmon2);

        //Nhan thong bao cac mon
        Intent chuyencbtt = getIntent();
        String cacmon = chuyencbtt.getStringExtra("monthi");
        tbmon2.setText(cacmon);
        int k = 5;
    }
}