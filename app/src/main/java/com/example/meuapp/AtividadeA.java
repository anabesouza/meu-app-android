package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AtividadeA extends AppCompatActivity {

    private EditText editTextData;
    private Button buttonSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_a);

        editTextData = findViewById(R.id.editTextData);
        buttonSendData = findViewById(R.id.buttonSendData);

        buttonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editTextData.getText().toString();

                Intent intent = new Intent(AtividadeA.this, AtividadeB.class);
                intent.putExtra("data", data);

                startActivity(intent);
            }
        });
    }
}
