package com.example.laboratorio_04

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultsActivity : AppCompatActivity() {

    //Keys
    private val keyName = "NAME";
    private val keyEmail = "EMAIL";
    private val keyPhone = "PHONE";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        supportActionBar!!.hide()

        var editTextName = findViewById <TextView>(R.id.text_view_name);
        var editTextEmail = findViewById <TextView>(R.id.text_view_email);
        var editTextPhone = findViewById <TextView>(R.id.text_view_phone);
        var btnShare = findViewById<Button>(R.id.btn_share)

        val name = intent.getStringExtra(keyName).toString() ?: ""
        val email = intent.getStringExtra(keyEmail).toString() ?: ""
        val phone = intent.getStringExtra(keyPhone).toString() ?: ""

        editTextName.text = name;
        editTextEmail.text = email;
        editTextPhone.text = phone;

        listeners(btnShare, name, email, phone);

    }

    /*
   // Create the text message with a string
    val sendIntent = Intent().apply {
    action = Intent.ACTION_SEND
    putExtra(Intent.EXTRA_TEXT, textMessage)
    type = "text/plain"
}

    // Verify that the intent will resolve to an activity
    if (sendIntent.resolveActivity(packageManager) != null) {
    startActivity(sendIntent)
}
     */

    //Btn share
    private fun listeners(btnShare:Button, name: String, email: String, phone : String){
        btnShare.setOnClickListener(){
            val publicIntent : Intent = Intent().apply {
                action = Intent.ACTION_SEND;
                putExtra(Intent.EXTRA_TEXT, getString(R.string.share_data, name, email, phone));
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(publicIntent, "This is my personal information");
            startActivity(shareIntent);
        }
    }
}
