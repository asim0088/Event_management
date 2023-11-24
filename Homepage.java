package com.example.eventmanagementprojectformygroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        CardView uploadEventUpload = findViewById(R.id.cardLabTest2);
        uploadEventUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, uploadEvent.class));
            }
        });
        CardView Logout = findViewById(R.id.cardLabTest6);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,MainActivity.class));
            }
        });
        CardView ViewMedicine = findViewById(R.id.cardLabTest3);
        ViewMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,viewEvent.class));
            }
        });
    }
}