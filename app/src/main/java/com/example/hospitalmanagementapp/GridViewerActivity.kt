package com.example.hospitalmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hospitalmanagementapp.databinding.ActivityGridViewerBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.okhttp.Dispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import kotlin.properties.Delegates

class GridViewerActivity : AppCompatActivity() {



    private lateinit var binding: ActivityGridViewerBinding
    private  var count=0
    private lateinit var firestore: FirebaseFirestore




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGridViewerBinding.inflate(layoutInflater)


        setText()
        imageClickHandler()

        binding.Submit.setOnClickListener {



            retriveData()

        }


        setContentView(binding.root)



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













    private fun naviagateToFinal() {

        val string = intent.getStringExtra("get")

        val uid = string?.subSequence(string.indexOf('^')+1,string.length)





       val intent = Intent(this,FinalActivity::class.java)
        if (string != null) {
            intent.putExtra("xyz","$uid"+string[0])
        }
        startActivity(intent)

        finish()





    }


    private fun setText() {

        val string = intent.getStringExtra("get")

        val name = string?.subSequence(0,string.indexOf('*'))

        if(!name.isNullOrBlank())
            binding.welcometext.text = "Welcome , $name"
        else
        {
            Toast.makeText(this,"Empty Name",Toast.LENGTH_SHORT).show()

        }







    }


   private fun imageClickHandler()
    {
        binding.imageView1.setOnClickListener {

            binding.imageView1.setImageResource(R.drawable.reddd)
            count++


        }
        binding.imageView2.setOnClickListener {

            binding.imageView2.setImageResource(R.drawable.reddd)
            count++


        }
        binding.imageView3.setOnClickListener {

            binding.imageView3.setImageResource(R.drawable.reddd)
            count++


        }
        binding.imageView4.setOnClickListener {

            binding.imageView4.setImageResource(R.drawable.reddd)
            count++


        }
        binding.imageView5.setOnClickListener {

            binding.imageView5.setImageResource(R.drawable.reddd)
            count++


        }
        binding.imageView6.setOnClickListener {

            binding.imageView6.setImageResource(R.drawable.reddd)
            count++


        }
        binding.imageView7.setOnClickListener {

            binding.imageView7.setImageResource(R.drawable.reddd)
            count++


        }
        binding.imageView8.setOnClickListener {

            binding.imageView8.setImageResource(R.drawable.reddd)
            count++


        }
        binding.imageView9.setOnClickListener {

            binding.imageView9.setImageResource(R.drawable.reddd)
            count++


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




                naviagateToFinal()


            } else {

                Toast.makeText(this, "  Not Enough Beds ", Toast.LENGTH_SHORT).show()
                navigateToFinalNegetive()


            }

        }
        else
        {
            Toast.makeText(this, " No Bed Selected ", Toast.LENGTH_SHORT).show()

        }




    }







    private fun navigateToFinalNegetive()
    {
        val intent = Intent(this,FinalActivityFail::class.java)
        startActivity(intent)

        finish()

    }




}