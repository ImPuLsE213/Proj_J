package com.example.j

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textToSendTextBox = findViewById<EditText>(R.id.textToSendTextBox)
        val outputText = findViewById<TextView>(R.id.outputText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener{
            outputText.text = textToSendTextBox.text
        }
    }
}