package com.example.movie.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie.R
import com.example.movie.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
