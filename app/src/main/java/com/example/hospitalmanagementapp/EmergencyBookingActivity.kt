package com.example.hospitalmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hospitalmanagementapp.databinding.ActivityEmergencyBookingBinding
import com.google.firebase.firestore.FirebaseFirestore

class EmergencyBookingActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private val count=1
    private lateinit var binding: ActivityEmergencyBookingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEmergencyBookingBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.done.setOnClickListener {

            val intent = Intent(this,StarterActivity::class.java)
            startActivity(intent)
            finish()


        }

        retriveData()

    }


    private fun retriveData() {

        val db  = FirebaseFirestore.getInstance()

        db.collection("HospitalData").get()
            .addOnCompleteListener{


                val str=StringBuffer()

                if(it.isSuccessful)
                {
                    for(document in it.result!!)
                    {
                        str.append(document.data.getValue("Filled")).append(" ")
                            .append(document.data.getValue("Total"))

                    }


                }




                furthurWork(str)

            }





    }

    private fun furthurWork(x:StringBuffer)
    {
        val a = x.substring(0,x.indexOf(' '))
        val b =x.substring(x.indexOf(' ')+1)
        val filled = Integer.parseInt(a)
        val total  =Integer.parseInt(b)

        firestore = FirebaseFirestore.getInstance()
        val collref = firestore.collection("HospitalData")



        if(count>0) {

            if ((filled + count) <= total) {
                val tobeadded = hashMapOf(
                    "Filled" to (filled + count).toString(),
                    "Total" to total.toString()

                )

                collref.document(
                    "2pITVDNTreAneUR8p13Y"
                )
                    .update(tobeadded as Map<String, Any>)



              val xyz =  (Math.random() * 3658974).toInt()

              binding.uid.text = "Emergency${xyz}"





            } else {

                Toast.makeText(this, "  Not Enough Beds ", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@EmergencyBookingActivity,FinalActivityFail::class.java)

                startActivity(intent)

                finish()

            }

        }
        else
        {
            Toast.makeText(this, " No Bed Selected ", Toast.LENGTH_SHORT).show()

        }




    }



}