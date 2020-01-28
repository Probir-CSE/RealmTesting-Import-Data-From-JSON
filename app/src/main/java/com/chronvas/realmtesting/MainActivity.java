package com.chronvas.realmtesting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm realm;

    RecyclerView nameRV;
    ArrayList<String>people;
    DivisionAdapter RVadapter;
    private Object People;
    private ArrayList ArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        nameRV=findViewById(R.id.RV_Name);
        RealmImporter.importFromJson(getResources());

        getdatafrmrealm();

//        Button importbtn = findViewById(R.id.importbtn);
//        importbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                RealmImporter.importFromJson(getResources());
//            }
//        });
//
//        Button countbtn = findViewById(R.id.count);
//        countbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                realm = Realm.getDefaultInstance();
//
//                int people = realm.where(People.class).findAll().size();
//                if (people > 0) {
//                    Snackbar.make(view,
//                            "Found: " + people +
//                                    " people in the database", Snackbar.LENGTH_LONG).show();
//                } else {
//                    Snackbar.make(view, "Found no people in the database!", Snackbar.LENGTH_LONG).show();
//                }
//            }
//        });

//        Button viewNamebtn = findViewById(R.id.viewname);
//        viewNamebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                People first = realm.where(People.class).findAllAsync().first();
////                RealmResults<People> userSchedules=realm.where(People.class).findAll();
////                ArrayList<People> modelRecyclerArrayList = new ArrayList<>();
////                for (People userSchedule:userSchedules)
////                {
////                    Log.e("All Data: ", String.valueOf(userSchedule));
////                }
////                ;
//
//                Snackbar.make(view,
//                        "First person's name is: " + first.getName() +
//                                " and his age is: " + first.getAge(), Snackbar.LENGTH_LONG).show();
//            }
//        });
//
//        getdatafrmrealm();
//        Button changeNamebtn = findViewById(R.id.changename);
//        changeNamebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                realm.executeTransaction(new Realm.Transaction() {
//                    @Override
//                    public void execute(@NonNull Realm realm) {
//                        People michael = realm.where(People.class).findFirst();
//                        michael.setName("Probir");
//                    }
//                });
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        if (!realm.isClosed()) realm.close();
        super.onDestroy();
    }

    public void getdatafrmrealm(){
        ArrayList<String> name=new ArrayList<>();// name store in this Array List to populate on recycler view

        RealmResults<People> userSchedules=realm.where(People.class).findAll();
        for (People userSchedule:userSchedules)
        {

            String names = userSchedule.getName();
            name.add(names);
            Log.e("All Data: ", String.valueOf(userSchedule));
            Log.e("Name:",names);
        }
        DivisionAdapter customAdapter = new DivisionAdapter(this,name);
        nameRV.setAdapter(customAdapter);

    }
}
