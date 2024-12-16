package com.speechify.android.ui.test.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.speechify.android.ui.test.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ActivityHomeBinding.inflate(layoutInflater).root
        )

    }
}