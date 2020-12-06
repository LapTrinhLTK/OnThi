package com.example.onthituyensinh;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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

public class HTCS extends AppCompatActivity {
    TextView txtquestion, btnreturn5;
    Button btna, btnb, btnc, btnd, next, back;

    ArrayList<Integer> Index_cau;
    ArrayList<String> selection;
    int [][] mixed_position;

    DatabaseReference datacauhoi;

    String keynodemon;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_t_c_s);

        txtquestion = (TextView) findViewById(R.id.cauhoihtcs);
        btna = (Button) findViewById(R.id.btnA);
        btnb = (Button) findViewById(R.id.btnB);
        btnc = (Button) findViewById(R.id.btnC);
        btnd = (Button) findViewById(R.id.btnD);
        next = (Button) findViewById(R.id.next);
        back = (Button) findViewById(R.id.back);
        btnreturn5 = (Button) findViewById(R.id.return5);

        //Nhận các mảng xử lý
        Intent chuyenhtcs = getIntent();
        Index_cau= chuyenhtcs.getIntegerArrayListExtra("index_cau_array");
        selection = chuyenhtcs.getStringArrayListExtra("selection_array");
        mixed_position = (int[][]) getIntent().getSerializableExtra("mixed_position_array");
        keynodemon = chuyenhtcs.getStringExtra("keynodemon");

        btnreturn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenthongke2 = new Intent(HTCS.this, ThongKe.class);
                startActivity(chuyenthongke2);
            }
        });

        HienThiCauSai(index);
    }

    public void HienThiCauSai(final int index)
    {
        if (keynodemon.equals("Hóa Học")) {
            datacauhoi = FirebaseDatabase.getInstance().getReference().child("Hóa Học").child("Cau" + String.valueOf(Index_cau.get(index)));
        }
        else { datacauhoi = FirebaseDatabase.getInstance().getReference().child(keynodemon).child("Cau" + String.valueOf(Index_cau.get(index)));}

        datacauhoi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final GetData getdata = snapshot.getValue(GetData.class);
                assert getdata != null;

                ArrayList<String> String_cau = new ArrayList<>();

                //Add option into array
                String_cau.add(getdata.getOptiona());
                String_cau.add(getdata.getOptionb());
                String_cau.add(getdata.getOptionc());
                String_cau.add(getdata.getOptiond());

                //Hiện câu hỏi đã sai
                txtquestion.setText(getdata.getCauhoi());
                btna.setText(String_cau.get(mixed_position[Index_cau.get(index)][0]));
                btnb.setText(String_cau.get(mixed_position[Index_cau.get(index)][1]));
                btnc.setText(String_cau.get(mixed_position[Index_cau.get(index)][2]));
                btnd.setText(String_cau.get(mixed_position[Index_cau.get(index)][3]));

                //Tô đỏ câu chọn sai
                String incorrect_ans = selection.get(Index_cau.get(index));
                switch (incorrect_ans)
                {
                    case "A": btna.setBackgroundColor(Color.RED);
                    case "B": btnb.setBackgroundColor(Color.RED);
                    case "C": btnc.setBackgroundColor(Color.RED);
                    case "D": btnd.setBackgroundColor(Color.RED);
                    default: Log.d("message", "Error");
                }

                //Tô xanh đáp án đúng
                if (btna.getText().toString().equals(getdata.getDapan())) { btna.setBackgroundColor(Color.GREEN); }
                if (btnb.getText().toString().equals(getdata.getDapan())) { btnb.setBackgroundColor(Color.GREEN); }
                if (btnc.getText().toString().equals(getdata.getDapan())) { btnc.setBackgroundColor(Color.GREEN); }
                if (btnd.getText().toString().equals(getdata.getDapan())) { btnd.setBackgroundColor(Color.GREEN); }

                if (index < Index_cau.size()-1)
                {
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            HienThiCauSai(index + 1);
                        }
                    });
                }

                if (index > 0)
                {
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            HienThiCauSai(index-1);
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}