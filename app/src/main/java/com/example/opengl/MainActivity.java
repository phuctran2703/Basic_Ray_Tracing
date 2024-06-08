package com.example.opengl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button sphereButton, polygonButton, barycentricButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sphereButton = findViewById(R.id.sphere);
        polygonButton = findViewById(R.id.polygon);
        barycentricButton = findViewById(R.id.barycentric);

        sphereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SphereActivity.class);
                startActivity(intent);
            }
        });

        polygonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PolygonActivity.class);
                startActivity(intent);
            }
        });

        barycentricButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarycentricActivity.class);
                startActivity(intent);
            }
        });
    }
}