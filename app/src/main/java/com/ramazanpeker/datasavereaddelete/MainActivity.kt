package com.ramazanpeker.datasavereaddelete

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences : Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences=this.getSharedPreferences("com.ramazanpeker.datasavereaddelete",Context.MODE_PRIVATE)
        ageFromPreferences=sharedPreferences.getInt("age",-1)
        if(ageFromPreferences==-1)
        {
            textView.text="Your Age :"
        }
        else
        {
            textView.text="Your Age: $ageFromPreferences"
        }
    }

    fun btnSave(view:View)
    {
        val myAge=editText.text.toString().toIntOrNull()
        if(myAge!=null)
        {
            textView.text="Your Age:"+myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }

    }
    fun btnDelete(view:View)
    {
        ageFromPreferences=sharedPreferences.getInt("age",-1)
        if(ageFromPreferences!=-1)
        {
            sharedPreferences.edit().remove("age").apply()
            textView.text="Your Age :"
        }

    }
}
