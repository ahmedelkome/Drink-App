package com.ahmed.task_one

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var drink_list :AutoCompleteTextView
    lateinit var price :TextView
    lateinit var submit : Button
    val orange = "Orange juice"
    val apple = "Apple juice"
    val mango = "Mango juice"
    val kewi = "Kewi juice"

    val values = mapOf(
        orange to 25,
        apple to 35,
        mango to 40,
        kewi to 50
    )
    private fun id(){
        drink_list = findViewById(R.id.drinkorder)
        price = findViewById(R.id.price)
        submit = findViewById(R.id.b1)
    }
    private fun adapter() {
        val list = listOf(orange,apple,mango,kewi)
        val adapter = ArrayAdapter(this,R.layout.names,list)
        drink_list.setAdapter(adapter)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        id()
        adapter()
            drink_list.setOnItemClickListener { adapterView, view, i, l ->
                val select = drink_list.text.toString()
                val priceselect = values[select]
                price.setText(priceselect.toString())
            }
        submit.setOnClickListener {
            val message = "I want to order ${drink_list.text.toString()}"
            var move = Intent(Intent.ACTION_SENDTO)
            move.data = Uri.parse("mailto:")
            move.putExtra(Intent.EXTRA_EMAIL, arrayOf("CityDrink@gmail.com"))
            move.putExtra(Intent.EXTRA_SUBJECT,"Order")
            move.putExtra(Intent.EXTRA_TEXT,message)
            startActivity(move)
        }



    }

}