package com.example.osmlsandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import org.openapitools.client.apis.StateApi
import org.openapitools.client.models.State

class ModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model)

        val apiInstance = StateApi(MainActivity.basePath)


        val statusBar = findViewById<View>(R.id.textView2) as TextView
        val statusTheSimulation = findViewById<View>(R.id.tableLayout) as TableLayout
        statusTheSimulation.addView(TableRow(this).also {
            it.addView(Button(this).apply {
                text = "Active"
                textSize = 14.0f
                setOnClickListener {
                    apiInstance.statePut(State.active)
                    statusBar.text ="now ${apiInstance.stateGet()}"
                }
            })
            it.addView(Button(this).apply {
                text = "Pause"
                textSize = 14.0f
                setOnClickListener {
                    apiInstance.statePut(State.paused)
                    statusBar.text ="now ${apiInstance.stateGet()}"
                }
            })
            it.addView(Button(this).apply {
                text = "Stop"
                textSize = 14.0f
                setOnClickListener {
                    apiInstance.statePut(State.stopped)
                    statusBar.text ="now ${apiInstance.stateGet()}"
                }
            })
        })
        statusBar.text = "now ${apiInstance.stateGet()}"
    }
}