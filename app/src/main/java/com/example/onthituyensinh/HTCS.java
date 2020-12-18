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

//    ArrayList<Integer> Index_cau;
//    ArrayList<String> selection;
//    int [][] mixed_position;

//    ArrayList<Integer> Index_cau_Anh;
//    ArrayList<String> selection_Anh;
//    int [][] mixed_position_Anh;
//
//    ArrayList<Integer> Index_cau_tn;
//    ArrayList<String> selection_tn;
//    int [][] mixed_position_tn;
//
//    ArrayList<Integer> Index_cau_xh;
//    ArrayList<String> selection_xh;
//    int [][] mixed_position_xh;

    DatabaseReference datacauhoi;

//    String keynodemon;
    int index = 0;
    int index_anh = 0;
    int index_tn = 0;
    int index_xh = 0;
//    int kt = 0;
//    String keytn, keyxh;

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

        Intent chuyenhtcs = getIntent();
        //Nhận lưu trữ các giá trị thống kê
//        kt = chuyenhtcs.getIntExtra("check", 0);
        final String socau = chuyenhtcs.getStringExtra("socau");
        final String tongsocau = chuyenhtcs.getStringExtra("tongcau");
        final String socaudung = chuyenhtcs.getStringExtra("caudung");
        final String socausai = chuyenhtcs.getStringExtra("causai");
//        keynodemon = chuyenhtcs.getStringExtra("keynodemon");
//        keytn = chuyenhtcs.getStringExtra("keytunhien");
//        keyxh = chuyenhtcs.getStringExtra("keyxahoi");



        //Nhận bộ mảng ôn luyện
//        Index_cau= chuyenhtcs.getIntegerArrayListExtra("index_cau_array");
//        selection = chuyenhtcs.getStringArrayListExtra("selection_array");
//        mixed_position = (int[][]) getIntent().getSerializableExtra("mixed_position_array");

//        //Nhận bộ mảng môn Anh
//        Index_cau_Anh = chuyenhtcs.getIntegerArrayListExtra("index_cau_array_anh");
//        selection_Anh = chuyenhtcs.getStringArrayListExtra("selection_array_anh");
//        mixed_position_Anh = (int[][]) getIntent().getSerializableExtra("mixed_position_array_anh");
//
//        //Nhận bộ mảng tự nhiên
//        Index_cau_tn = chuyenhtcs.getIntegerArrayListExtra("index_cau_array_tn");
//        selection_tn= chuyenhtcs.getStringArrayListExtra("selection_array_tn");
//        mixed_position_tn = (int[][]) getIntent().getSerializableExtra("mixed_position_array_tn");
//
//        //Nhận bộ mảng xã hội
//        Index_cau_xh = chuyenhtcs.getIntegerArrayListExtra("index_cau_array_xh");
//        selection_xh = chuyenhtcs.getStringArrayListExtra("selection_array_xh");
//        mixed_position_xh = (int[][]) getIntent().getSerializableExtra("mixed_position_array_xh");


        btnreturn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyenthongke2 = new Intent(HTCS.this, ThongKe.class);
                chuyenthongke2.putExtra("socau", String.valueOf(socau));
                chuyenthongke2.putExtra("tongcau", String.valueOf(tongsocau));
                chuyenthongke2.putExtra("caudung", String.valueOf(socaudung));
                chuyenthongke2.putExtra("causai", String.valueOf(socausai));
//                chuyenthongke2.putExtra("check", kt);

                //Truyền trở về bộ mảng ôn luyện
//                chuyenthongke2.putExtra("index_cau_array", Index_cau);
//                chuyenthongke2.putExtra("selection_array", selection);
//                chuyenthongke2.putExtra("mixed_position_array", mixed_position);

//                //Truyền trở vềbộ mảng Anh
//                chuyenthongke2.putExtra("index_cau_array_anh", Index_cau_Anh);
//                chuyenthongke2.putExtra("selection_array_anh", selection_Anh);
//                chuyenthongke2.putExtra("mixed_position_array_anh", mixed_position_Anh);
//
//                //Truyền trở về bộ mảng tự nhiên
//                chuyenthongke2.putExtra("index_cau_array_tn", Index_cau_tn);
//                chuyenthongke2.putExtra("selection_array_tn", selection_tn);
//                chuyenthongke2.putExtra("mixed_position_array_tn", mixed_position_tn);
//
//                //Truyền trở về bộ mảng xã hội
//                chuyenthongke2.putExtra("index_cau_array_xh", Index_cau_xh);
//                chuyenthongke2.putExtra("selection_array_xh", selection_xh);
//                chuyenthongke2.putExtra("mixed_position_array_xh", mixed_position_xh);

//                chuyenthongke2.putExtra("keyxahoi", keyxh);
//                chuyenthongke2.putExtra("keytunhien", keytn);

//                chuyenthongke2.putExtra("keynodemon", keynodemon);

                startActivity(chuyenthongke2);
            }
        });

//        Log.d("pikachu", "hdfwuifhiew");
//        Log.d("pikachu", ""+kt);
        if (Arrays.kt == 1)
        {
            HienThiCauSaiAnh(index_anh);
        }
        else
        {
            if (Arrays.kt ==0 )
            {HienThiCauSaiOnLuyen(index);}

        }
    }

    public void HienThiCauSaiOnLuyen(final int index)
    {
        Log.d("hello", ""+Arrays.keynodemon);

        datacauhoi = FirebaseDatabase.getInstance().getReference().child(Arrays.keynodemon).child("Cau" + String.valueOf(Arrays.Index_cau.get(index)));

        datacauhoi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final GetData getdata = snapshot.getValue(GetData.class);
                assert getdata != null;

                ArrayList<String> String_cau = new ArrayList<>();

                //Add option into array
                Log.d("byebye", ""+String_cau.size());
                String_cau.add(getdata.getOptiona());
                String_cau.add(getdata.getOptionb());
                String_cau.add(getdata.getOptionc());
                String_cau.add(getdata.getOptiond());

                //Hiện câu hỏi đã sai
                txtquestion.setText(getdata.getCauhoi());
                btna.setText(String_cau.get(Arrays.mixed_position[Arrays.Index_cau.get(index)][0]));
                btnb.setText(String_cau.get(Arrays.mixed_position[Arrays.Index_cau.get(index)][1]));
                btnc.setText(String_cau.get(Arrays.mixed_position[Arrays.Index_cau.get(index)][2]));
                btnd.setText(String_cau.get(Arrays.mixed_position[Arrays.Index_cau.get(index)][3]));

                //Tô đỏ câu chọn sai
                String incorrect_ans = Arrays.selection.get(Arrays.Index_cau.get(index));

                switch (incorrect_ans)
                {
                    case "A": btna.setBackgroundColor(Color.RED);
                    break;
                    case "B": btnb.setBackgroundColor(Color.RED);
                    break;
                    case "C": btnc.setBackgroundColor(Color.RED);
                    break;
                    case "D": btnd.setBackgroundColor(Color.RED);
                    break;
                    default: Log.d("message", "error");
                }

                //Tô xanh đáp án đúng
                if (btna.getText().toString().equals(getdata.getDapan())) {
                    btna.setBackgroundColor(Color.GREEN);
                }
                else {
                    if (btnb.getText().toString().equals(getdata.getDapan())) {
                        btnb.setBackgroundColor(Color.GREEN);
                    }
                    else{
                        if (btnc.getText().toString().equals(getdata.getDapan())) {
                            btnc.setBackgroundColor(Color.GREEN);
                        }
                        else {
                            if (btnd.getText().toString().equals(getdata.getDapan())) {
                                btnd.setBackgroundColor(Color.GREEN);
                            }
                        }
                    }
                }

                //Kiểm tra giới hạn
                //Giới hạn trên

                if (index < Arrays.Index_cau.size()-1)
                {
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            HienThiCauSaiOnLuyen(index + 1);
                            btna.setBackgroundColor(Color.WHITE);
                            btnb.setBackgroundColor(Color.WHITE);
                            btnc.setBackgroundColor(Color.WHITE);
                            btnd.setBackgroundColor(Color.WHITE);
                        }
                    });
                }

                //Giới hạn dưới
                if (index > 0)
                {
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            HienThiCauSaiOnLuyen(index-1);
                            btna.setBackgroundColor(Color.WHITE);
                            btnb.setBackgroundColor(Color.WHITE);
                            btnc.setBackgroundColor(Color.WHITE);
                            btnd.setBackgroundColor(Color.WHITE);
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void HienThiCauSaiAnh(final int index_eng)
    {
        datacauhoi = FirebaseDatabase.getInstance().getReference().child("Anh Văn").child("Cau" + String.valueOf(Arrays.Index_cau_Anh.get(index_eng)));


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
                btna.setText(String_cau.get(Arrays.mixed_position_Anh[Arrays.Index_cau_Anh.get(index_eng)][0]));
                btnb.setText(String_cau.get(Arrays.mixed_position_Anh[Arrays.Index_cau_Anh.get(index_eng)][1]));
                btnc.setText(String_cau.get(Arrays.mixed_position_Anh[Arrays.Index_cau_Anh.get(index_eng)][2]));
                btnd.setText(String_cau.get(Arrays.mixed_position_Anh[Arrays.Index_cau_Anh.get(index_eng)][3]));

                //Tô đỏ câu chọn sai
                String incorrect_ans = Arrays.selection_Anh.get(Arrays.Index_cau_Anh.get(index_eng));

                switch (incorrect_ans)
                {
                    case "A": btna.setBackgroundColor(Color.RED);
                        break;
                    case "B": btnb.setBackgroundColor(Color.RED);
                        break;
                    case "C": btnc.setBackgroundColor(Color.RED);
                        break;
                    case "D": btnd.setBackgroundColor(Color.RED);
                        break;
                    default: Log.d("message", "error");
                }

                //Tô xanh đáp án đúng
                if (btna.getText().toString().equals(getdata.getDapan())) {
                    btna.setBackgroundColor(Color.GREEN);
                }
                else {
                    if (btnb.getText().toString().equals(getdata.getDapan())) {
                        btnb.setBackgroundColor(Color.GREEN);
                    }
                    else{
                        if (btnc.getText().toString().equals(getdata.getDapan())) {
                            btnc.setBackgroundColor(Color.GREEN);
                        }
                        else {
                            if (btnd.getText().toString().equals(getdata.getDapan())) {
                                btnd.setBackgroundColor(Color.GREEN);
                            }
                        }
                    }
                }

                //Kiểm tra giới hạn
                //Giới hạn trên
                if (index_eng < Arrays.Index_cau_Anh.size()-1)
                {
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index_anh++;
                            HienThiCauSaiAnh(index_eng+1);
                            btna.setBackgroundColor(Color.WHITE);
                            btnb.setBackgroundColor(Color.WHITE);
                            btnc.setBackgroundColor(Color.WHITE);
                            btnd.setBackgroundColor(Color.WHITE);
                        }
                    });
                }
                else {
                    if (index_eng == Arrays.Index_cau_Anh.size()-1)
                    {
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                HienthiCauSaiTN(index_tn);
                                btna.setBackgroundColor(Color.WHITE);
                                btnb.setBackgroundColor(Color.WHITE);
                                btnc.setBackgroundColor(Color.WHITE);
                                btnd.setBackgroundColor(Color.WHITE);
                            }
                        });
                    }
                }

                //Giới hạn dưới
                if (index_eng > 0)
                {
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index_anh = index_anh-1;
//                            Log.d("hk",""+index_anh);
                            HienThiCauSaiAnh(index_eng-1);
                            btna.setBackgroundColor(Color.WHITE);
                            btnb.setBackgroundColor(Color.WHITE);
                            btnc.setBackgroundColor(Color.WHITE);
                            btnd.setBackgroundColor(Color.WHITE);
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void HienthiCauSaiTN(final int index_tunhien)
    {
//        Log.d("roko", ""+Arrays.keytn);
        switch (Arrays.keytn)
        {
            case "Vật Lý":  datacauhoi = FirebaseDatabase.getInstance().getReference().child("Vật Lý").child("Cau" + String.valueOf(Arrays.Index_cau_tn.get(index_tunhien)));
            break;
            case "Sinh Học":  datacauhoi = FirebaseDatabase.getInstance().getReference().child("Sinh Học").child("Cau" + String.valueOf(Arrays.Index_cau_tn.get(index_tunhien)));
            break;
            default:  datacauhoi = FirebaseDatabase.getInstance().getReference().child("Hóa Học").child("Cau" + String.valueOf(Arrays.Index_cau_tn.get(index_tunhien)));
        }

//        datacauhoi = FirebaseDatabase.getInstance().getReference().child(Arrays.keytn).child("Cau" + String.valueOf(Arrays.Index_cau_tn.get(index_tunhien)));
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
                btna.setText(String_cau.get(Arrays.mixed_position_tn[Arrays.Index_cau_tn.get(index_tunhien)][0]));
                btnb.setText(String_cau.get(Arrays.mixed_position_tn[Arrays.Index_cau_tn.get(index_tunhien)][1]));
                btnc.setText(String_cau.get(Arrays.mixed_position_tn[Arrays.Index_cau_tn.get(index_tunhien)][2]));
                btnd.setText(String_cau.get(Arrays.mixed_position_tn[Arrays.Index_cau_tn.get(index_tunhien)][3]));

//                for (int p=0; p<=Arrays.selection_tn.size()-1; p++){ Log.d("oppa", ""+Arrays.selection_tn.get(p));}
                //Tô đỏ câu chọn sai
                String incorrect_ans = Arrays.selection_tn.get(Arrays.Index_cau_tn.get(index_tunhien));


//                Log.d("fes", ""+incorrect_ans);

                switch (incorrect_ans)
                {
                    case "A": btna.setBackgroundColor(Color.RED);
                        break;
                    case "B": btnb.setBackgroundColor(Color.RED);
                        break;
                    case "C": btnc.setBackgroundColor(Color.RED);
                        break;
                    case "D": btnd.setBackgroundColor(Color.RED);
                        break;
                    default: Log.d("message", "error");
                }

                //Tô xanh đáp án đúng
                if (btna.getText().toString().equals(getdata.getDapan())) {
                    btna.setBackgroundColor(Color.GREEN);
                }
                else {
                    if (btnb.getText().toString().equals(getdata.getDapan())) {
                        btnb.setBackgroundColor(Color.GREEN);
                    }
                    else{
                        if (btnc.getText().toString().equals(getdata.getDapan())) {
                            btnc.setBackgroundColor(Color.GREEN);
                        }
                        else {
                            if (btnd.getText().toString().equals(getdata.getDapan())) {
                                btnd.setBackgroundColor(Color.GREEN);
                            }
                        }
                    }
                }

                //Kiểm tra giới hạn
                //Giới hạn trên
                if (index_tunhien < Arrays.Index_cau_tn.size()-1)
                {
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index_tn++;
                            HienthiCauSaiTN(index_tunhien+1);
                            btna.setBackgroundColor(Color.WHITE);
                            btnb.setBackgroundColor(Color.WHITE);
                            btnc.setBackgroundColor(Color.WHITE);
                            btnd.setBackgroundColor(Color.WHITE);
                        }
                    });
                }
                else {
                    if (index_tunhien == Arrays.Index_cau_tn.size()-1)
                    {
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                HienThiCauSaiXH(index_xh);
                                btna.setBackgroundColor(Color.WHITE);
                                btnb.setBackgroundColor(Color.WHITE);
                                btnc.setBackgroundColor(Color.WHITE);
                                btnd.setBackgroundColor(Color.WHITE);
                            }
                        });
                    }
                }

                //Giới hạn dưới
                if (index_tunhien > 0)
                {
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index_tn = index_tn-1;
                            HienthiCauSaiTN(index_tunhien-1);
                            btna.setBackgroundColor(Color.WHITE);
                            btnb.setBackgroundColor(Color.WHITE);
                            btnc.setBackgroundColor(Color.WHITE);
                            btnd.setBackgroundColor(Color.WHITE);
                        }
                    });
                }
                else {
                    if (index_tunhien == 0)
                    {
                        back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Log.d("ples", ""+index_anh);
                                HienThiCauSaiAnh(index_anh);
                                btna.setBackgroundColor(Color.WHITE);
                                btnb.setBackgroundColor(Color.WHITE);
                                btnc.setBackgroundColor(Color.WHITE);
                                btnd.setBackgroundColor(Color.WHITE);
                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void HienThiCauSaiXH(final int index_xahoi)
    {

        datacauhoi = FirebaseDatabase.getInstance().getReference().child(Arrays.keyxh).child("Cau" + String.valueOf(Arrays.Index_cau_xh.get(index_xahoi)));
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
                btna.setText(String_cau.get(Arrays.mixed_position_xh[Arrays.Index_cau_xh.get(index_xahoi)][0]));
                btnb.setText(String_cau.get(Arrays.mixed_position_xh[Arrays.Index_cau_xh.get(index_xahoi)][1]));
                btnc.setText(String_cau.get(Arrays.mixed_position_xh[Arrays.Index_cau_xh.get(index_xahoi)][2]));
                btnd.setText(String_cau.get(Arrays.mixed_position_xh[Arrays.Index_cau_xh.get(index_xahoi)][3]));

                //Tô đỏ câu chọn sai
                String incorrect_ans = Arrays.selection_xh.get(Arrays.Index_cau_xh.get(index_xahoi));

                switch (incorrect_ans)
                {
                    case "A": btna.setBackgroundColor(Color.RED);
                        break;
                    case "B": btnb.setBackgroundColor(Color.RED);
                        break;
                    case "C": btnc.setBackgroundColor(Color.RED);
                        break;
                    case "D": btnd.setBackgroundColor(Color.RED);
                        break;
                    default: Log.d("message", "error");
                }

                //Tô xanh đáp án đúng
                if (btna.getText().toString().equals(getdata.getDapan())) {
                    btna.setBackgroundColor(Color.GREEN);
                }
                else {
                    if (btnb.getText().toString().equals(getdata.getDapan())) {
                        btnb.setBackgroundColor(Color.GREEN);
                    }
                    else{
                        if (btnc.getText().toString().equals(getdata.getDapan())) {
                            btnc.setBackgroundColor(Color.GREEN);
                        }
                        else {
                            if (btnd.getText().toString().equals(getdata.getDapan())) {
                                btnd.setBackgroundColor(Color.GREEN);
                            }
                        }
                    }
                }

                //Kiểm tra giới hạn
                //Giới hạn trên
                if (index_xahoi < Arrays.Index_cau_xh.size()-1)
                {
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index_xh++;
                            HienThiCauSaiXH(index_xahoi+1);
                            btna.setBackgroundColor(Color.WHITE);
                            btnb.setBackgroundColor(Color.WHITE);
                            btnc.setBackgroundColor(Color.WHITE);
                            btnd.setBackgroundColor(Color.WHITE);
                        }
                    });
                }

                //Giới hạn dưới
                if (index_xahoi > 0)
                {
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            index_xh = index_xh-1;
                            HienThiCauSaiXH(index_xahoi-1);
                            btna.setBackgroundColor(Color.WHITE);
                            btnb.setBackgroundColor(Color.WHITE);
                            btnc.setBackgroundColor(Color.WHITE);
                            btnd.setBackgroundColor(Color.WHITE);
                        }
                    });
                }
                else {
                    if (index_xahoi == 0)
                    {
                        back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                HienthiCauSaiTN(index_tn);
                                btna.setBackgroundColor(Color.WHITE);
                                btnb.setBackgroundColor(Color.WHITE);
                                btnc.setBackgroundColor(Color.WHITE);
                                btnd.setBackgroundColor(Color.WHITE);
                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}