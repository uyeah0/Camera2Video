package com.worldtech.camera2video;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//
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
    }

    public void PopupClick(View v){
        Intent intent = new Intent(this, timerPopup.class);
        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //데이터 받기
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }
        }
    }
*/
}
    /*
    BottomNavigationView bottomNavigationView;
//바텀 네비게이션 뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavi);
        //처음화면
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new fragment_home()).commit();
        // FrameLayout에 fragment.xml 띄우기
        // 바텀 네비게이션뷰 안의 아이템 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
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

