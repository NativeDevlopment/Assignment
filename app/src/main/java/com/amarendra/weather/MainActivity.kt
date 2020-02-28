package com.amarendra.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amarendra.weather.ui.ZipcodeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, ZipcodeFragment.newInstance())
                .commitNow()
        }
    }

}
