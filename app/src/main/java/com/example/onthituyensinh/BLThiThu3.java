package com.example.onthituyensinh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class BLThiThu3 extends AppCompatActivity {
    Button btna,btnb,btnc,btnd;
    TextView txtquestion, timer;

    ArrayList<Boolean> dd = new ArrayList<>();

    int socaudung = 0;
    int socausai = 0;
    int tongsocau = 0;
    int socau, k;
    int dem = 0;
    int minutes;
    int seconds;
    int kt = 1;
    String keyxh;
    DatabaseReference datacauhoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_l_thi_thu3);

        //Anh xa cac view
        txtquestion = (TextView) findViewById(R.id.cauhoitt3);
        timer = (TextView) findViewById(R.id.timer);
        btna = (Button) findViewById(R.id.btnA);
        btnb = (Button) findViewById(R.id.btnB);
        btnc = (Button) findViewById(R.id.btnC);
        btnd = (Button) findViewById(R.id.btnD);

        Intent chuyenbltunhien = getIntent();
        keyxh = chuyenbltunhien.getStringExtra("keyxahoi");
        minutes = chuyenbltunhien.getIntExtra("timeminute", 150);
        seconds = chuyenbltunhien.getIntExtra("timesecond", 0);
        tongsocau = chuyenbltunhien.getIntExtra("tongcau", 20);
        socaudung = chuyenbltunhien.getIntExtra("caudung", 20);
        socausai = chuyenbltunhien.getIntExtra("causai", 20);

        for(int a = 0; a<=120; a++) { dd.add(false); }

        TaoCauHoi(keyxh);
        CountDownTimer(minutes*60, timer);
    }

    public void TaoCauHoi(final String mon)
    {
        dem++;

        if (mon.equals("Anh Văn")){socau = 20;} else{socau = 15;}

        if (dem>socau)
        {
            Intent chuyenthongke = new Intent(BLThiThu3.this, ThongKe.class);
            chuyenthongke.putExtra("tongcau", String.valueOf(tongsocau));
            chuyenthongke.putExtra("caudung", String.valueOf(socaudung));
            chuyenthongke.putExtra("causai", String.valueOf(socausai));
            chuyenthongke.putExtra("check", kt);
            startActivity(chuyenthongke);
        }
        else
        {
            Random random = new Random();
            int numcau = random.nextInt(socau);
            numcau++;

            if (dd.get(numcau) == false)
            {
                dd.set(numcau, true);


                datacauhoi = FirebaseDatabase.getInstance().getReference().child(mon).child("Cau" + String.valueOf(numcau));

                tongsocau++;

                datacauhoi.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        final GetData getdata = snapshot.getValue(GetData.class);
                        assert getdata != null;
                        txtquestion.setText(getdata.getCauhoi());
                        btna.setText(getdata.getOptiona());
                        btnb.setText(getdata.getOptionb());
                        btnc.setText(getdata.getOptionc());
                        btnd.setText(getdata.getOptiond());

                        btna.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "A";
                                if (chon.equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi(mon);
                                } else {
                                    socausai++;
                                    TaoCauHoi(mon);
                                }

                            }
                        });

                        btnb.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "B";
                                if (chon.equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi(mon);
                                } else {
                                    socausai++;
                                    TaoCauHoi(mon);
                                }

                            }
                        });

                        btnc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "C";
                                if (chon.equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi(mon);
                                } else {
                                    socausai++;
                                    TaoCauHoi(mon);
                                }

                            }
                        });

                        btnd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "D";
                                if (chon.equals(getdata.getDapan())){
                                    socaudung++;
                                    TaoCauHoi(mon);
                                } else {
                                    socausai++;
                                    TaoCauHoi(mon);
                                }

                            }
                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

            }
            else {
                dem = dem-1;
                TaoCauHoi(mon);
            }

        }

    }

    public void CountDownTimer(int giay, final TextView tv)
    {
        new CountDownTimer(giay * 1000 + 1000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                seconds = (int) (millisUntilFinished/1000);
                minutes = seconds/60;
                int hours = minutes/60;

                seconds = seconds % 60;
                hours = hours % 60;
                tv.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
            }

            public void onFinish()
            {
                tv.setText("Hết thời gian làm bài");
                Intent chuyenthongke = new Intent(BLThiThu3.this, ThongKe.class);
                chuyenthongke.putExtra("tongcau", String.valueOf(tongsocau));
                chuyenthongke.putExtra("caudung", String.valueOf(socaudung));
                chuyenthongke.putExtra("causai", String.valueOf(socausai));
                chuyenthongke.putExtra("check", kt);
                startActivity(chuyenthongke);
            }
        }.start();
    }
}