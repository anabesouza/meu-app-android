package com.example.meuapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class SorteioActivity extends AppCompatActivity {

    private EditText editTextMin, editTextMax;
    private Button buttonSortear;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);

        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
        buttonSortear = findViewById(R.id.buttonSortear);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonSortear.setOnClickListener(v -> sortearNumero());
    }

    private void sortearNumero() {
        String minStr = editTextMin.getText().toString();
        String maxStr = editTextMax.getText().toString();

        if (!minStr.isEmpty() && !maxStr.isEmpty()) {
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);
            if (min <= max) {
                int resultado = new Random().nextInt((max - min) + 1) + min;
                textViewResultado.setText("Resultado: " + resultado);
            } else {
                textViewResultado.setText("Erro: Min deve ser <= Max");
            }
        } else {
            textViewResultado.setText("Erro: Preencha os campos");
        }
    }
}
