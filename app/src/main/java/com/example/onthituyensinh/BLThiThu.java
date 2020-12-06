package com.example.onthituyensinh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
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

public class BLThiThu extends AppCompatActivity {
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
    String keytn, keyxh;
    DatabaseReference datacauhoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_l_thi_thu);

        //Anh xa cac view
        txtquestion = (TextView) findViewById(R.id.cauhoitt);
        timer = (TextView) findViewById(R.id.timer);
        btna = (Button) findViewById(R.id.btnA);
        btnb = (Button) findViewById(R.id.btnB);
        btnc = (Button) findViewById(R.id.btnC);
        btnd = (Button) findViewById(R.id.btnD);

        Intent chuyencbtt = getIntent();
        keytn = chuyencbtt.getStringExtra("getmontunhien");
        keyxh = chuyencbtt.getStringExtra("getmonxahoi");

        for(int a = 0; a<=120; a++) { dd.add(false); }


        TaoCauHoi("Anh Văn");

        CountDownTimer(150*60, timer);


    }

    public void TaoCauHoi(final String mon)
    {
        dem++;

        if (mon.equals("Anh Văn")){socau = 20;} else{socau = 15;}

        if (dem>socau)
        {
                Intent chuyenbltunhien = new Intent(BLThiThu.this, BLThiThu2.class);
                chuyenbltunhien.putExtra("tongcau", tongsocau);
                chuyenbltunhien.putExtra("caudung", socaudung);
                chuyenbltunhien.putExtra("causai", socausai);
                chuyenbltunhien.putExtra("timeminute", minutes);
                chuyenbltunhien.putExtra("timesecond", seconds);
                chuyenbltunhien.putExtra("keytunhien", keytn);
                chuyenbltunhien.putExtra("keyxahoi", keyxh);
                startActivity(chuyenbltunhien);
        }
        else
        {
            Random random = new Random();
            int numcau = random.nextInt(40);
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

                        //Tron cau chon
                        ArrayList<String> String_cau = new ArrayList<>();
                        ArrayList<Integer> Store_index = new ArrayList<Integer>();
                        int tg = 0;
                        int counter = 1;

                        //Add option into array
                        String_cau.add(getdata.getOptiona());
                        String_cau.add(getdata.getOptionb());
                        String_cau.add(getdata.getOptionc());
                        String_cau.add(getdata.getOptiond());


                        //Add value into Store_index
                        for (int k=0; k<=3; k++) { Store_index.add(k);}

                        //Get random times
                        Random random1 = new Random();
                        int times = random1.nextInt(10);
                        times++;

                        while (counter<=times)
                        {
                            Random rannum = new Random();
                            int num1 = rannum.nextInt(4);
                            int num2 = rannum.nextInt(4);

                            while (num2 == num1){ num2 = rannum.nextInt(4); }

                            tg = Store_index.get(num1);
                            Store_index.set(num1, Store_index.get(num2));
                            Store_index.set(num2, tg);

                            counter++;
                        }


                        txtquestion.setText(getdata.getCauhoi());
                        btna.setText(String_cau.get(Store_index.get(0)));
                        btnb.setText(String_cau.get(Store_index.get(1)));
                        btnc.setText(String_cau.get(Store_index.get(2)));
                        btnd.setText(String_cau.get(Store_index.get(3)));


                        btna.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "A";
                                if (btna.getText().toString().equals(getdata.getDapan())) {
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
                                if (btnb.getText().toString().equals(getdata.getDapan())) {
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
                                if (btnc.getText().toString().equals(getdata.getDapan())) {
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
                                if (btnd.getText().toString().equals(getdata.getDapan())){
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
                Intent chuyenthongke = new Intent(BLThiThu.this, ThongKe.class);
                chuyenthongke.putExtra("tongcau", String.valueOf(tongsocau));
                chuyenthongke.putExtra("caudung", String.valueOf(socaudung));
                chuyenthongke.putExtra("causai", String.valueOf(socausai));
                chuyenthongke.putExtra("check", kt);
                startActivity(chuyenthongke);
            }
        }.start();
    }

}