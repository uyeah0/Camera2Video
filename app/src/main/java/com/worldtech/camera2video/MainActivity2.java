package com.worldtech.camera2video;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.worldtech.camera2video.activity.RecordVideoActivity;

public class MainActivity2 extends AppCompatActivity {
    Activity activity;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//
        activity = this;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationbar);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new fragment_home()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;
                switch (item.getItemId())
                {
                    case R.id.navigation_1 : temp = new fragment_home();
                        break;
                    case R.id.navigation_2 : temp = new fragment_calendar();
                        break;
                    case R.id.navigation_3 : temp = new fragment_timetable();
                        break;
                    case R.id.navigation_4 : temp = new fragment_user();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,temp).commit();
                return true;
            }
        });

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity, RecordVideoActivity.class));

            }
        });
    }

    public void PopupClick(View v) {
        Intent intent = new Intent(this, timerPopup.class);
        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //????????? ??????
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }
        }
    }
*/
}
    /*
    BottomNavigationView bottomNavigationView;
//?????? ??????????????? ???

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavi);
        //????????????
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new fragment_home()).commit();
        // FrameLayout??? fragment.xml ?????????
        // ?????? ?????????????????? ?????? ????????? ??????
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item??? ????????? id?????? ????????? FrameLayout??? fragment.xml?????????
                    case R.id.navigation_1: getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new fragment_home()).commit();
                    break;
                    case R.id.navigation_2: getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new fragment_timetable()).commit();
                    break;
                    case R.id.navigation_3: getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new fragment_calendar()).commit();
                    break;
                    case R.id.navigation_4: getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new fragment_user()).commit();
                    break;
                    case R.id.navigation_5: getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Fragment5()).commit();
                    break;

                }
                return true;
            }
        });
    }
    */

