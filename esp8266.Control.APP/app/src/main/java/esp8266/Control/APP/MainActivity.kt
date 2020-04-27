package esp8266.Control.APP


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


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




        // Write a message to the database

        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue(true)


        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value
                outputText.text = value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })


    }
}
