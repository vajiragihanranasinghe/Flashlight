package com.flashlight.app;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CameraManager cameraManager;
    private String cameraId;
    private boolean flashOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnFlash);

        cameraManager = getSystemService(CameraManager.class);

        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

        button.setOnClickListener(v -> {
            try {
                flashOn = !flashOn;
                cameraManager.setTorchMode(cameraId, flashOn);
                button.setText(flashOn ? "TURN OFF" : "TURN ON");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
