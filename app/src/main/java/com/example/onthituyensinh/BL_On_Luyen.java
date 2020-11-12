package com.example.onthituyensinh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import java.util.ArrayList;
import java.util.Random;

public class BL_On_Luyen extends AppCompatActivity {

    TextView txtquestion,timer;
    Button btna, btnb, btnc, btnd;


    ArrayList<Boolean> dd = new ArrayList<>();



    int socaudung = 0;
    int socausai = 0;
    int tongsocau = 0;
    int socau, k;
    int dem = 0;


    String keynodemon = "";
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


        Intent chuyencb = getIntent();
        String keynodemon = chuyencb.getStringExtra("monol");


        //Kiem tra so cau
        if (keynodemon == "Anh Văn") { socau = 20; }
        else { socau = 15; }

        for(int a = 0; a<=120; a++)
        {
            dd.add(false);
        }



        TaoCauHoi();


        }
        



    public void TaoCauHoi()
    {
        dem++;

        if (dem>socau)
        {
            Intent chuyenthongke = new Intent(BL_On_Luyen.this, ThongKe.class);
            chuyenthongke.putExtra("tongcau", String.valueOf(tongsocau));
            chuyenthongke.putExtra("caudung", String.valueOf(socaudung));
            chuyenthongke.putExtra("causai", String.valueOf(socausai));
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

                String mon = keynodemon;
                switch (mon)
                {
                    case "Vật Lý": datacauhoi = FirebaseDatabase.getInstance().getReference().child("Vật Lý").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Hóa Học": datacauhoi = FirebaseDatabase.getInstance().getReference().child("Hóa Học").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Sinh Học": datacauhoi = FirebaseDatabase.getInstance().getReference().child("Sinh Học").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Lịch Sử": datacauhoi = FirebaseDatabase.getInstance().getReference().child("Lịch Sử").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Địa Lý": datacauhoi = FirebaseDatabase.getInstance().getReference().child("Địa Lý").child("Cau" + String.valueOf(numcau));
                        break;
                    case "GDCD": datacauhoi = FirebaseDatabase.getInstance().getReference().child("GDCD").child("Cau" + String.valueOf(numcau));
                        break;
                    case "Anh Văn": datacauhoi = FirebaseDatabase.getInstance().getReference().child("Anh Văn").child("Cau" + String.valueOf(numcau));
                        break;
                    default: datacauhoi = FirebaseDatabase.getInstance().getReference().child("Anh Văn").child("Cau" + String.valueOf(numcau));

                }

                tongsocau++;
                datacauhoi.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        final GetData getdata = snapshot.getValue(GetData.class);
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
                                if (chon.equals(getdata.getDapan())) {
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
                                if (chon.equals(getdata.getDapan())) {
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
                                if (chon.equals(getdata.getDapan())){
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



        

    }
