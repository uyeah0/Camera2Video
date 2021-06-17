package com.m0_0m.ui_0613

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.worldtech.camera2video.*

class MainActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById<View>(R.id.bottomnavigationbar) as BottomNavigationView
        bottomNavigationView!!.background = null
        bottomNavigationView!!.menu.getItem(2).isEnabled = false
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment_home())
            .commit()
        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            var temp: Fragment? = null
            when (item.itemId) {
                R.id.navigation_1 -> temp = fragment_home()
                R.id.navigation_2 -> temp = fragment_calendar()
                R.id.navigation_3 -> temp = fragment_timetable()
                R.id.navigation_4 -> temp = fragment_user()
            }
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, temp!!).commit()
            true
        }
    }

    fun PopupClick(v: View?) {
        val intent = Intent(this, timerPopup::class.java)
        intent.putExtra("data", "Test Popup")
        startActivityForResult(intent, 1)
    } /*
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