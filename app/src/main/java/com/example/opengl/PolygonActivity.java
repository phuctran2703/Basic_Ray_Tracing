package com.example.opengl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PolygonActivity extends AppCompatActivity {

    private EditText editTextX0, editTextY0, editTextZ0;
    private EditText editTextXd, editTextYd, editTextZd;
    private EditText editTextXp, editTextYp, editTextZp;
    private EditText editTextNx, editTextNy, editTextNz;
    private EditText editTextXa, editTextYa, editTextZa;
    private EditText editTextXb, editTextYb, editTextZb;
    private EditText editTextXc, editTextYc, editTextZc;
    private Button buttonSubmit;
    private Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ray_to_polygon);

        // Ánh xạ các view từ XML
        editTextX0 = findViewById(R.id.editTextX0);
        editTextY0 = findViewById(R.id.editTextY0);
        editTextZ0 = findViewById(R.id.editTextZ0);
        editTextXd = findViewById(R.id.editTextXd);
        editTextYd = findViewById(R.id.editTextYd);
        editTextZd = findViewById(R.id.editTextZd);
        editTextXa = findViewById(R.id.editTextXa);
        editTextYa = findViewById(R.id.editTextYa);
        editTextZa = findViewById(R.id.editTextZa);
        editTextXb = findViewById(R.id.editTextXb);
        editTextYb = findViewById(R.id.editTextYb);
        editTextZb = findViewById(R.id.editTextZb);
        editTextXc = findViewById(R.id.editTextXc);
        editTextYc = findViewById(R.id.editTextYc);
        editTextZc = findViewById(R.id.editTextZc);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonReturn = findViewById(R.id.buttonReturn);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x0 = Float.parseFloat(editTextX0.getText().toString());
                float y0 = Float.parseFloat(editTextY0.getText().toString());
                float z0 = Float.parseFloat(editTextZ0.getText().toString());
                float xd = Float.parseFloat(editTextXd.getText().toString());
                float yd = Float.parseFloat(editTextYd.getText().toString());
                float zd = Float.parseFloat(editTextZd.getText().toString());
                float xa = Float.parseFloat(editTextXa.getText().toString());
                float ya = Float.parseFloat(editTextYa.getText().toString());
                float za = Float.parseFloat(editTextZa.getText().toString());
                float xb = Float.parseFloat(editTextXb.getText().toString());
                float yb = Float.parseFloat(editTextYb.getText().toString());
                float zb = Float.parseFloat(editTextZb.getText().toString());
                float xc = Float.parseFloat(editTextXc.getText().toString());
                float yc = Float.parseFloat(editTextYc.getText().toString());
                float zc = Float.parseFloat(editTextZc.getText().toString());

                Intent intent = new Intent(PolygonActivity.this, PolygonResultActivity.class);
                // Gửi dữ liệu đến `ResultActivity` thông qua `Intent`
                intent.putExtra("x0", x0);
                intent.putExtra("y0", y0);
                intent.putExtra("z0", z0);
                intent.putExtra("xd", xd);
                intent.putExtra("yd", yd);
                intent.putExtra("zd", zd);
                intent.putExtra("xa", xa);
                intent.putExtra("ya", ya);
                intent.putExtra("za", za);
                intent.putExtra("xb", xb);
                intent.putExtra("yb", yb);
                intent.putExtra("zb", zb);
                intent.putExtra("xc", xc);
                intent.putExtra("yc", yc);
                intent.putExtra("zc", zc);
                startActivity(intent);
            }
        });

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
