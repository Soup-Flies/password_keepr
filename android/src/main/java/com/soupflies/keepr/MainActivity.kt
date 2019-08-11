package com.soupflies.keepr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.FragmentActivity
import com.soupflies.keepr.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        setContentView(R.layout.main_activity)
    }
}
