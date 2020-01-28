package com.chronvas.realmtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;

public class Main2Activity extends AppCompatActivity {
Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        realm=Realm.getDefaultInstance();
    }
}
