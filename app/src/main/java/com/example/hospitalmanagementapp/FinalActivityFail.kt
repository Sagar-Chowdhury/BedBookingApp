package com.example.hospitalmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospitalmanagementapp.databinding.ActivityFinalFailBinding

class FinalActivityFail : AppCompatActivity() {

    private lateinit var binding: ActivityFinalFailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinalFailBinding.inflate(layoutInflater)

        binding.tryagain.setOnClickListener {

            val intent = Intent(this,StarterActivity::class.java)
            startActivity(intent)

            finish()

        }


        setContentView(binding.root)
    }
}