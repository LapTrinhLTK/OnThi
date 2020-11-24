package com.example.onthituyensinh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class BL_On_Luyen extends AppCompatActivity {

    TextView txtquestion,timer;
    Button btna, btnb, btnc, btnd;


    ArrayList<String> selection = new ArrayList<>();
    ArrayList<Integer> indexcausai = new ArrayList<>();

    ArrayList<Boolean> dd = new ArrayList<>();

    int numrandom;
    int socaudung = 0;
    int socausai = 0;
    int tongsocau = 0;
    int socau;
    int dem = 0;

    String keynodemon;

    DatabaseReference datacauhoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_l__on__luyen);
        //Anh xa cac view
        txtquestion = (TextView) findViewById(R.id.cauhoi);
        timer = (TextView) findViewById(R.id.timer);
        btna = (Button) findViewById(R.id.btnA);
        btnb = (Button) findViewById(R.id.btnB);
        btnc = (Button) findViewById(R.id.btnC);
        btnd = (Button) findViewById(R.id.btnD);

        Intent chuyenbl1 = getIntent();
        keynodemon = chuyenbl1.getStringExtra("monchon");


        int time  = chuyenbl1.getIntExtra("thoigian", 150);
        time = time*60;

        for(int a = 0; a<=120; a++) { dd.add(false); }


        TaoCauHoi();
        CountDownTimer(time, timer);

        }
        



    public void TaoCauHoi()
    {
        dem++;
        if (keynodemon.equals("Anh Văn")) { socau = 20; numrandom = 40;}
        else { socau = 15; numrandom = 30;}

        if (dem>socau)
        {
            Intent chuyenthongke = new Intent(BL_On_Luyen.this, ThongKe.class);
            chuyenthongke.putExtra("socau", String.valueOf(socau));
            chuyenthongke.putExtra("tongcau", String.valueOf(tongsocau));
            chuyenthongke.putExtra("caudung", String.valueOf(socaudung));
            chuyenthongke.putExtra("causai", String.valueOf(socausai));
            startActivity(chuyenthongke);
        }
        else
        {
            Random random = new Random();
            int numcau = random.nextInt(numrandom);
            numcau++;

            if (dd.get(numcau) == false)
            {
                dd.set(numcau, true);


                switch (keynodemon)
                {
                    case "Vật Lý":
                        datacauhoi = FirebaseDatabase.getInstance().getReference().child("Vật Lý").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Hóa Học":
                        datacauhoi = FirebaseDatabase.getInstance().getReference().child("Hóa Học").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Sinh Học":
                        datacauhoi = FirebaseDatabase.getInstance().getReference().child("Sinh Học").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Lịch Sử":
                        datacauhoi = FirebaseDatabase.getInstance().getReference().child("Lịch Sử").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Địa Lý":
                        datacauhoi = FirebaseDatabase.getInstance().getReference().child("Địa Lý").child("Cau" + String.valueOf(numcau));
                        break;
                    case "GDCD":
                        datacauhoi = FirebaseDatabase.getInstance().getReference().child("GDCD").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Anh Văn":
                        datacauhoi = FirebaseDatabase.getInstance().getReference().child("Anh Văn").child("Cau" + String.valueOf(numcau));
                        break;
                    default:   datacauhoi = FirebaseDatabase.getInstance().getReference().child("Hóa Học").child("Cau" + String.valueOf(numcau));

                }


                tongsocau++;
                final int finalNumcau = numcau;
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

                        for(int k = 0; k<=3; k++){ Log.d("hello", ""+Store_random.get(k));}

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
                                    TaoCauHoi();
                                } else {
                                    
                                    socausai++;
                                    TaoCauHoi();
                                }

                            }
                        });

                        btnb.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "B";
                                if (btnb.getText().toString().equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi();
                                } else {
                                    socausai++;
                                    TaoCauHoi();
                                }

                            }
                        });

                        btnc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "C";
                                if (btnc.getText().toString().equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi();
                                } else {
                                    socausai++;
                                    TaoCauHoi();
                                }

                            }
                        });

                        btnd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "D";
                                if (btnd.getText().toString().equals(getdata.getDapan())){
                                    socaudung++;
                                    TaoCauHoi();
                                } else {
                                    socausai++;
                                    TaoCauHoi();
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
                TaoCauHoi();
            }



        }

    }

    public void CountDownTimer(int seconds, final TextView tv)
    {
        new CountDownTimer(seconds * 1000 + 1000, 1000)
        {
            public void onTick(long millisUntilFinished)
            {
                int seconds = (int) (millisUntilFinished/1000);
                int minutes = seconds/60;
                int hours = minutes/60;

                seconds = seconds % 60;
                hours = hours % 60;
                tv.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
            }

            public void onFinish()
            {
                tv.setText("Hết thời gian làm bài");
                Intent chuyenthongke = new Intent(BL_On_Luyen.this, ThongKe.class);
                chuyenthongke.putExtra("socau", String.valueOf(socau));
                chuyenthongke.putExtra("tongcau", String.valueOf(tongsocau-1));
                chuyenthongke.putExtra("caudung", String.valueOf(socaudung));
                chuyenthongke.putExtra("causai", String.valueOf(socausai));
                startActivity(chuyenthongke);
            }
        }.start();
    }



    }
