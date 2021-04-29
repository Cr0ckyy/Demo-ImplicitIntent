package com.myapplicationdev.android.c347_l2_ex2demoimplicitintent;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnEmail, btnRP;
    EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextMessage = findViewById(R.id.editTextMessage);
        Button btnEmail = findViewById(R.id.buttonEmail);

        btnEmail.setOnClickListener(arg0 -> {
            // The action you want this intent to do;
            // ACTION_SEND is used to indicate sending text
            Intent email = new Intent(Intent.ACTION_SEND);

            // Put essentials like email address, subject & body text
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});

            email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from C347");

            email.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText());

            // This MIME type indicates email
            email.setType("message/rfc822");

            // createChooser shows user a list of app that can handle
            // this MIME type, which is, email
            startActivity(Intent.createChooser(email, "Choose an Email client :"));


        });

        btnRP = findViewById(R.id.buttonRP);

        btnRP.setOnClickListener(arg0 -> {
            // Intent to display data
            Intent rpIntent = new Intent(Intent.ACTION_VIEW);
            // Set the URL to be used.
            rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
            startActivity(rpIntent);
        });
    }
}



