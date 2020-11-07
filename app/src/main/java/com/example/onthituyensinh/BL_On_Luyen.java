package com.example.onthituyensinh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    //Khai bao cac bien
    int socaudung = 0;
    int socausai = 0;
    int tongsocau = 0;
    int socau;
    int dem = 0;

    //Lay node mon on luyen da chon (string)
    Intent chuyencb = getIntent();
    String keynodemon = chuyencb.getStringExtra("monol");

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



        //Kiem tra so cau
        if (keynodemon == "Anh Văn") { socau = 20; }
        else { socau = 15; }

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
            datacauhoi = FirebaseDatabase.getInstance().getReference().child(keynodemon).child("Câu "+ String.valueOf(numcau));
            tongsocau++;
            datacauhoi.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot)
                {
                    final GetData getdata = snapshot.getValue(GetData.class);
                    txtquestion.setText(getdata.getCauhoi());
                    btna.setText(getdata.getChona());
                    btnb.setText(getdata.getChonb());
                    btnc.setText(getdata.getChonc());
                    btnd.setText(getdata.getChond());

                    btna.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String chon = btna.getText().toString();
                            if (chon.equals(getdata.dapan))
                            { socaudung++; }
                            else {socausai++;}
                            TaoCauHoi();
                        }
                    });

                    btnb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String chon = btnb.getText().toString();
                            if (chon.equals(getdata.dapan))
                            { socaudung++; }
                            else {socausai++;}
                            TaoCauHoi();
                        }
                    });

                    btnc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String chon = btnc.getText().toString();
                            if (chon.equals(getdata.dapan))
                            { socaudung++; }
                            else {socausai++;}
                            TaoCauHoi();
                        }
                    });

                    btnd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String chon = btnd.getText().toString();
                            if (chon.equals(getdata.dapan))
                            { socaudung++; }
                            else {socausai++;}
                            TaoCauHoi();
                        }
                    });



                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });




        }

    }




        

    }
