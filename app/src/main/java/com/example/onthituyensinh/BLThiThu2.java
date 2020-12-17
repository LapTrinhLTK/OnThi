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

public class BLThiThu2 extends AppCompatActivity {
    Button btna,btnb,btnc,btnd;
    TextView txtquestion, timer;

    ArrayList<Integer> Store_index = new ArrayList<>();

    //Bộ mảng môn Anh
//    ArrayList<Integer> Index_cau_Anh;
//    ArrayList<String> selection_Anh;
//    int [][] mixed_position_Anh;

    //Bộ mảng môn tự nhiên
//    ArrayList<Integer> Index_cau_tn = new ArrayList();
//    ArrayList<String> selection_tn = new ArrayList<>();
//    int[][] mixed_position_tn = new int[10000][4];

    ArrayList<Boolean> dd = new ArrayList<>();

    int socaudung = 0;
    int socausai = 0;
    int tongsocau = 0;
    int socau, numcau;
    int dem = 0;
    int minutes;
    int seconds;
//    int kt = 1;
    String keytn, keyxh, chon;
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

        //Nhận bộ mảng môn Anh
//        Index_cau_Anh= chuyenbltunhien.getIntegerArrayListExtra("index_cau_array_anh");
//        selection_Anh = chuyenbltunhien.getStringArrayListExtra("selection_array_anh");
//        mixed_position_Anh = (int[][]) getIntent().getSerializableExtra("mixed_position_array_anh");

        for(int a = 0; a<=120; a++) { dd.add(false); }
        for(int j = 0; j<=9999; j++) { Arrays.selection_tn.add("X");}
        //Add value into Store_index
        for (int k=0; k<=3; k++) { Store_index.add(k);}

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
            chuyenblxahoi.putExtra("keytunhien", keytn);

            //Truyền bộ mảng Anh Văn
//            chuyenblxahoi.putExtra("index_cau_array_anh", Index_cau_Anh);
//            chuyenblxahoi.putExtra("selection_array_anh", selection_Anh);
//            chuyenblxahoi.putExtra("mixed_position_array_anh", mixed_position_Anh);

            //Truyền bộ mảng tự nhiên
//            chuyenblxahoi.putExtra("index_cau_array_tn", Index_cau_tn);
//            chuyenblxahoi.putExtra("selection_array_tn", selection_tn);
//            chuyenblxahoi.putExtra("mixed_position_array_tn", mixed_position_tn);

            startActivity(chuyenblxahoi);
        }
        else
        {
            Random random = new Random();
            numcau = random.nextInt(30);
            numcau++;

            if (dd.get(numcau) == false)
            {
                dd.set(numcau, true);

//                if (mon.equals("Hóa Học")) {
//                    datacauhoi = FirebaseDatabase.getInstance().getReference().child("Hóa Học").child("Cau" + String.valueOf(numcau));
//                }
//                else { datacauhoi = FirebaseDatabase.getInstance().getReference().child(mon).child("Cau" + String.valueOf(numcau));}

                switch (mon){
                    case "Vật Lý": datacauhoi = FirebaseDatabase.getInstance().getReference().child("Vật Lý").child("Cau" + String.valueOf(numcau));
                    break;
                    case "Sinh Học": datacauhoi = FirebaseDatabase.getInstance().getReference().child("Sinh Học").child("Cau" + String.valueOf(numcau));
                        break;
                    default: datacauhoi = FirebaseDatabase.getInstance().getReference().child("Hóa Học").child("Cau" + String.valueOf(numcau));


                }
                tongsocau++;

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
                                } else {Incorrect();}

                            }
                        });

                        btnb.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "B";
                                if (btnb.getText().toString().equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi(mon);
                                } else {Incorrect(); }

                            }
                        });

                        btnc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "C";
                                if (btnc.getText().toString().equals(getdata.getDapan())) {
                                    socaudung++;
                                    TaoCauHoi(mon);
                                } else {Incorrect(); }

                            }
                        });

                        btnd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String chon = "D";
                                if (btnd.getText().toString().equals(getdata.getDapan())){
                                    socaudung++;
                                    TaoCauHoi(mon);
                                } else {Incorrect(); }

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

    public void Incorrect()
    {
        socausai++;

        Arrays.Index_cau_tn.add(numcau);
        Arrays.selection_tn.set(numcau, chon);

        for (int m = 0; m<=3; m++)
        {
            Arrays.mixed_position_tn[numcau][m] = Store_index.get(m);
        }
        TaoCauHoi(keytn);
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
                chuyenthongke.putExtra("keyxahoi", keyxh);
                chuyenthongke.putExtra("keytunhien", keytn);
//                chuyenthongke.putExtra("check", kt);

//                //Truyền bộ mảng Anh Văn
//                chuyenthongke.putExtra("index_cau_array_anh", Index_cau_Anh);
//                chuyenthongke.putExtra("selection_array_anh", selection_Anh);
//                chuyenthongke.putExtra("mixed_position_array_anh", mixed_position_Anh);
//
//                //Truyền bộ mảng môn tự nhiên
//                chuyenthongke.putExtra("index_cau_array_tn", Index_cau_tn);
//                chuyenthongke.putExtra("selection_array_tn", selection_tn);
//                chuyenthongke.putExtra("mixed_position_array_tn", mixed_position_tn);

                startActivity(chuyenthongke);
            }
        }.start();
    }
}