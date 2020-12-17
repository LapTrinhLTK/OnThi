package com.example.onthituyensinh;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class OnThiTuyenSinh extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
