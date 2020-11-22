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

public class BLThiThu2 extends AppCompatActivity {
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
        setContentView(R.layout.activity_b_l_thi_thu2);

        //Anh xa cac view
        txtquestion = (TextView) findViewById(R.id.cauhoitt2);
        timer = (TextView) findViewById(R.id.timer);
        btna = (Button) findViewById(R.id.btnA);
        btnb = (Button) findViewById(R.id.btnB);
        btnc = (Button) findViewById(R.id.btnC);
        btnd = (Button) findViewById(R.id.btnD);

        Intent chuyenbltunhien = getIntent();
        keytn = chuyenbltunhien.getStringExtra("keytunhien");
        keyxh = chuyenbltunhien.getStringExtra("keyxahoi");
        minutes = chuyenbltunhien.getIntExtra("timeminute", 150);
        seconds = chuyenbltunhien.getIntExtra("timesecond", 0);
        tongsocau = chuyenbltunhien.getIntExtra("tongcau", 20);
        socaudung = chuyenbltunhien.getIntExtra("caudung", 20);
        socausai = chuyenbltunhien.getIntExtra("causai", 20);

        for(int a = 0; a<=120; a++) { dd.add(false); }


        TaoCauHoi(keytn);
        CountDownTimer(minutes*60, timer);
    }

    public void TaoCauHoi(final String mon)
    {
        dem++;

        if (mon.equals("Anh Văn")){socau = 20;} else{socau = 15;}

        if (dem>socau)
        {
            Intent chuyenblxahoi = new Intent(BLThiThu2.this, BLThiThu3.class);
            chuyenblxahoi.putExtra("tongcau", tongsocau);
            chuyenblxahoi.putExtra("caudung", socaudung);
            chuyenblxahoi.putExtra("causai", socausai);
            chuyenblxahoi.putExtra("timeminute", minutes);
            chuyenblxahoi.putExtra("timesecond", seconds);
            chuyenblxahoi.putExtra("keyxahoi", keyxh);
            startActivity(chuyenblxahoi);
        }
        else
        {
            Random random = new Random();
            int numcau = random.nextInt(30);
            numcau++;

            if (dd.get(numcau) == false)
            {
                dd.set(numcau, true);

                if (mon.equals("Hóa Học")) {
                    datacauhoi = FirebaseDatabase.getInstance().getReference().child("Hóa Học").child("Cau" + String.valueOf(numcau));
                }
                else { datacauhoi = FirebaseDatabase.getInstance().getReference().child(mon).child("Cau" + String.valueOf(numcau));}
                tongsocau++;

                datacauhoi.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        final GetData getdata = snapshot.getValue(GetData.class);
                        assert getdata != null;

                        ArrayList<String> String_cau = new ArrayList<>();
                        ArrayList<Integer> Store_random = new ArrayList<>();
                        ArrayList<Boolean> check_random = new ArrayList<>();

                        for(int b=0; b<=4; b++) { check_random.add(false); }

                        int counter = 0;
                        //Add option into array
                        String_cau.add(getdata.getOptiona());
                        String_cau.add(getdata.getOptionb());
                        String_cau.add(getdata.getOptionc());
                        String_cau.add(getdata.getOptiond());

                        //Get random option index
                        Random random1 = new Random();

                        while (counter<=4) {
                            int indexcau = random1.nextInt(4);
                            if (check_random.get(indexcau) == false)
                            {
                                check_random.set(indexcau, true);
                                Store_random.add(indexcau);
                                counter++;
                            }
                        }



                        txtquestion.setText(getdata.getCauhoi());
                        btna.setText(String_cau.get(Store_random.get(0)));
                        btnb.setText(String_cau.get(Store_random.get(1)));
                        btnc.setText(String_cau.get(Store_random.get(2)));
                        btnd.setText(String_cau.get(Store_random.get(3)));

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
                Intent chuyenthongke = new Intent(BLThiThu2.this, ThongKe.class);
                chuyenthongke.putExtra("tongcau", String.valueOf(tongsocau));
                chuyenthongke.putExtra("caudung", String.valueOf(socaudung));
                chuyenthongke.putExtra("causai", String.valueOf(socausai));
                chuyenthongke.putExtra("check", kt);
                startActivity(chuyenthongke);
            }
        }.start();
    }
}