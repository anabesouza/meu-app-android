package com.example.meuapp;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Button buttonLogin, buttonSorteio, buttonPaint, buttonAtividadeA, buttonAtividadeB;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView sensorDataText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSorteio = findViewById(R.id.buttonSorteio);
        buttonPaint = findViewById(R.id.buttonPaint);
        buttonAtividadeA = findViewById(R.id.buttonAtividadeA);
        buttonAtividadeB = findViewById(R.id.buttonAtividadeB);
        sensorDataText = findViewById(R.id.sensorData);

        buttonLogin.setOnClickListener(v -> abrirTela(LoginActivity.class));
        buttonSorteio.setOnClickListener(v -> abrirTela(SorteioActivity.class));
        buttonPaint.setOnClickListener(v -> abrirTela(PaintActivity.class));
        buttonAtividadeA.setOnClickListener(v -> abrirTela(AtividadeA.class));
        buttonAtividadeB.setOnClickListener(v -> abrirTela(AtividadeB.class));

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            sensorDataText.setText("Acelerômetro não disponível.");
        }
    }

    private void abrirTela(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            sensorDataText.setText(String.format("X: %.2f | Y: %.2f | Z: %.2f", x, y, z));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
}
