package com.example.hospitalmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.hospitalmanagementapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnLogin.setOnClickListener {

            movetoGrid()

        }

        setContentView(binding.root)


    }

    private fun movetoGrid() {

        val patientName = binding.patientName.text.toString()
        val age = binding.patientAge.text.toString()

        val number = binding.phoneNumber.text.toString()



        if(patientName.isEmpty())
        {
            Toast.makeText(this," Enter Correct Patient Name ",Toast.LENGTH_SHORT).show()


        }
        else if(!(age.isDigitsOnly()) || age.isEmpty())
        {


            Toast.makeText(this," Enter Correct Patient Age ",Toast.LENGTH_SHORT).show()




        }
        else if(number.length !=10)
        {

            Toast.makeText(this," Enter Correct Phone Number ",Toast.LENGTH_SHORT).show()


        }
        else
        {
            val sendString = "$patientName*$age^$number"

            val intent = Intent(this,GridViewerActivity::class.java)
            intent.putExtra("get",sendString)
            startActivity(intent)

            finish()



        }




    }
}