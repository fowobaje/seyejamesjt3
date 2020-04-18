package com.example.groceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TotalCost extends AppCompatActivity {

    EditText cReceiver, cCompose, cSubject;
    Button cSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_cost);

        cReceiver = findViewById(R.id.receiver);
        cCompose = findViewById(R.id.compose);
        cSubject = findViewById(R.id.subject);
        cSend = findViewById(R.id.send);

        cSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String receiver = cReceiver.getText().toString().trim();
                String compose = cCompose.getText().toString().trim();
                String subject = cSubject.getText().toString().trim();

                sendEmail (receiver, subject, compose);

            }
        });
    }

    private void sendEmail(String receiver, String subject, String compose) {
        Intent cEmailIntent = new Intent(Intent.ACTION_SEND);
        cEmailIntent.setData(Uri.parse("mailto:"));
        cEmailIntent.setType("text/plain");
        cEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{receiver});
        cEmailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        cEmailIntent.putExtra(Intent.EXTRA_TEXT, compose);

        try {
            startActivity(Intent.createChooser(cEmailIntent, "Email Client"));
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);

        }
    }


}
