package com.example.onthituyensinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class CB_On_Luyen extends AppCompatActivity {
    Button btnreturn3, btnstart;
    TextView tbmon, tbtime;
    SeekBar time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_b__on__luyen);

        btnreturn3 = (Button) findViewById(R.id.return3);
        btnreturn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenol2 = new Intent(CB_On_Luyen.this, On_Luyen.class);
                startActivity(chuyenol2);
            }
        });

        tbmon = (TextView) findViewById(R.id.thongbao1);
        //Nhan thong bao mon
        Intent chuyencb = getIntent();
        final String mon = chuyencb.getStringExtra("monol");
        tbmon.setText("môn: " + mon);

        tbtime = (TextView) findViewById(R.id.thongbaotg);

        final int[] thoigian = new int[1];
        time = (SeekBar) findViewById(R.id.seekBartime);
        time.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int tg, boolean fromUser) {
                thoigian[0] = tg;
                tbtime.setText("thời gian: " + tg + " phút");

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnstart = (Button) findViewById(R.id.bdlb1);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenbl1 = new Intent(CB_On_Luyen.this, BL_On_Luyen.class);
                chuyenbl1.putExtra("thoigian", thoigian[0]);
                chuyenbl1.putExtra("monchon", mon);
                startActivity(chuyenbl1);
            }
        });


    }
}