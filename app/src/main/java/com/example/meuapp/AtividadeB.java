package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AtividadeB extends AppCompatActivity {

    private TextView textViewReceivedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_b);

        textViewReceivedData = findViewById(R.id.textViewReceivedData);

        Intent intent = getIntent();
        String receivedData = intent.getStringExtra("data");

        textViewReceivedData.setText(receivedData);
    }
}
