package com.example.osmlsandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    companion object {
        var basePath = "http://";
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        val intentModel = Intent(this, ModelActivity::class.java)

        val saveData = findViewById<View>(R.id.button) as Button
        saveData.setOnClickListener {
            val ipserver = findViewById<View>(R.id.editTextTextPersonName) as EditText
            basePath += ipserver.text.toString()
            startActivity(intentModel)
        }
    }
}