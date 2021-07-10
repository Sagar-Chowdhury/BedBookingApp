package com.example.hospitalmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hospitalmanagementapp.databinding.ActivityFinalBinding

class FinalActivity : AppCompatActivity() {


    private lateinit var binding: ActivityFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityFinalBinding.inflate(layoutInflater)

        setUid()

        binding.done.setOnClickListener {

            navigatetoMain()

        }

        setContentView(binding.root)
    }

    private fun setUid() {
        val intent = intent.getStringExtra("xyz")

        binding.uid.text = intent

    }

    private fun navigatetoMain() {

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

        finish()


    }
}