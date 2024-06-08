package com.example.opengl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SphereActivity extends AppCompatActivity {
    private EditText editTextX0, editTextY0, editTextZ0, editTextXd, editTextYd, editTextZd, editTextXc, editTextYc, editTextZc, editTextR;
    private Button buttonSubmit, buttonReturn;
    private TextView textViewResult;
    private Bundle data; // Bundle lưu trữ dữ liệu từ màn hình trước

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ray_to_sphere);

        // Ánh xạ các view từ XML
        editTextX0 = findViewById(R.id.editTextX0);
        editTextY0 = findViewById(R.id.editTextY0);
        editTextZ0 = findViewById(R.id.editTextZ0);
        editTextXd = findViewById(R.id.editTextXd);
        editTextYd = findViewById(R.id.editTextYd);
        editTextZd = findViewById(R.id.editTextZd);
        editTextXc = findViewById(R.id.editTextXc);
        editTextYc = findViewById(R.id.editTextYc);
        editTextZc = findViewById(R.id.editTextZc);
        editTextR = findViewById(R.id.editTextR);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonReturn = findViewById(R.id.buttonReturn);

        // Xử lý sự kiện khi nhấn nút "Submit"
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x0 = Float.parseFloat(editTextX0.getText().toString());
                float y0 = Float.parseFloat(editTextY0.getText().toString());
                float z0 = Float.parseFloat(editTextZ0.getText().toString());
                float xd = Float.parseFloat(editTextXd.getText().toString());
                float yd = Float.parseFloat(editTextYd.getText().toString());
                float zd = Float.parseFloat(editTextZd.getText().toString());
                float xc = Float.parseFloat(editTextXc.getText().toString());
                float yc = Float.parseFloat(editTextYc.getText().toString());
                float zc = Float.parseFloat(editTextZc.getText().toString());
                float r = Float.parseFloat(editTextR.getText().toString());

                // Chuyển dữ liệu sang màn hình SphereResultActivity
                Intent intent = new Intent(SphereActivity.this, SphereResultActivity.class);
                Bundle data = new Bundle();
                data.putFloat("x0", x0);
                data.putFloat("y0", y0);
                data.putFloat("z0", z0);
                data.putFloat("xd", xd);
                data.putFloat("yd", yd);
                data.putFloat("zd", zd);
                data.putFloat("xc", xc);
                data.putFloat("yc", yc);
                data.putFloat("zc", zc);
                data.putFloat("r", r);
                intent.putExtras(data);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn nút "Return"
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
