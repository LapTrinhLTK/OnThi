package com.example.onthituyensinh;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class BL_On_Luyen extends AppCompatActivity {

    TextView txtquestion,timer;
    Button btna, btnb, btnc, btnd;

    //Bộ các mảng xử lý HTCS
    ArrayList<Integer> Store_index = new ArrayList<>();

    ArrayList<Integer> Index_cau = new ArrayList();
    ArrayList<String> selection = new ArrayList<>();
    int[][] mixed_position = new int[10000][4];


    ArrayList<Boolean> dd = new ArrayList<>();
    int numrandom, numcau;
    int socaudung = 0;
    int socausai = 0;
    int tongsocau = 0;
    int socau;
    int dem = 0;
    String chon;

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

        for(int a = 0; a<=9999; a++) { dd.add(false); }
        for(int j = 0; j<=9999; j++) { selection.add("X");}
        //Add value into Store_index
        for (int k=0; k<=3; k++) { Store_index.add(k);}


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
            //Truyen thong ke
            chuyenthongke.putExtra("socau", String.valueOf(socau));
            chuyenthongke.putExtra("tongcau", String.valueOf(tongsocau));
            chuyenthongke.putExtra("caudung", String.valueOf(socaudung));
            chuyenthongke.putExtra("causai", String.valueOf(socausai));
            chuyenthongke.putExtra("keynodemon", keynodemon);

            //Truyền bộ mảng HTCS
            chuyenthongke.putExtra("index_cau_array", Index_cau);
            chuyenthongke.putExtra("selection_array", selection);
            chuyenthongke.putExtra("mixed_position_array", mixed_position);

            startActivity(chuyenthongke);
        }
        else
        {
            Random random = new Random();
            numcau = random.nextInt(numrandom);
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

                        //Tron cau chon
                        ArrayList<String> String_cau = new ArrayList<>();

                        int tg = 0;
                        int counter = 1;

                        //Add option into array
                        String_cau.add(getdata.getOptiona());
                        String_cau.add(getdata.getOptionb());
                        String_cau.add(getdata.getOptionc());
                        String_cau.add(getdata.getOptiond());

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
                                chon = "A";
                                if (btna.getText().toString().equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi();
                                }
                                else { Incorrect(); }

                            }
                        });

                        btnb.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                chon = "B";
                                if (btnb.getText().toString().equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi();
                                }
                                else { Incorrect(); }

                            }
                        });

                        btnc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                chon = "C";
                                if (btnc.getText().toString().equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi();
                                }
                                else { Incorrect(); }

                            }
                        });

                        btnd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                chon = "D";
                                if (btnd.getText().toString().equals(getdata.getDapan())){
                                    socaudung++;
                                    TaoCauHoi();
                                }
                                else { Incorrect(); }

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

    public void Incorrect()
    {
        socausai++;

        Index_cau.add(numcau);
        selection.set(numcau, chon);

        for (int m = 0; m<=3; m++)
        {
            mixed_position[numcau][m] = Store_index.get(m);
        }
        TaoCauHoi();
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
                chuyenthongke.putExtra("keynodemon", keynodemon);

                //Truyền bộ mảng HTCS
                chuyenthongke.putExtra("index_cau_array", Index_cau);
                chuyenthongke.putExtra("selection_array", selection);
                chuyenthongke.putExtra("mixed_position_array", mixed_position);

                startActivity(chuyenthongke);
            }
        }.start();
    }



    }
