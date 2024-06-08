package com.example.opengl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BarycentricResultActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        textViewResult = findViewById(R.id.textViewResult);

        // Nhận dữ liệu từ Intent
        float xa = getIntent().getFloatExtra("xa", 0);
        float ya = getIntent().getFloatExtra("ya", 0);
        float za = getIntent().getFloatExtra("za", 0);
        float xb = getIntent().getFloatExtra("xb", 0);
        float yb = getIntent().getFloatExtra("yb", 0);
        float zb = getIntent().getFloatExtra("zb", 0);
        float xc = getIntent().getFloatExtra("xc", 0);
        float yc = getIntent().getFloatExtra("yc", 0);
        float zc = getIntent().getFloatExtra("zc", 0);
        float nxa = getIntent().getFloatExtra("nxa", 0);
        float nya = getIntent().getFloatExtra("nya", 0);
        float nza = getIntent().getFloatExtra("nza", 0);
        float nxb = getIntent().getFloatExtra("nxb", 0);
        float nyb = getIntent().getFloatExtra("nyb", 0);
        float nzb = getIntent().getFloatExtra("nzb", 0);
        float nxc = getIntent().getFloatExtra("nxc", 0);
        float nyc = getIntent().getFloatExtra("nyc", 0);
        float nzc = getIntent().getFloatExtra("nzc", 0);

        // Hiển thị nội dung nhận được từ Intent
        String result = "Xa: " + xa + "\n" +
                "Ya: " + ya + "\n" +
                "Za: " + za + "\n" +
                "Xb: " + xb + "\n" +
                "Yb: " + yb + "\n" +
                "Zb: " + zb + "\n" +
                "Xc: " + xc + "\n" +
                "Yc: " + yc + "\n" +
                "Zc: " + zc + "\n" +
                "Nxa: " + nxa + "\n" +
                "Nya: " + nya + "\n" +
                "Nza: " + nza + "\n" +
                "Nxb: " + nxb + "\n" +
                "Nyb: " + nyb + "\n" +
                "Nzb: " + nzb + "\n" +
                "Nxc: " + nxc + "\n" +
                "Nyc: " + nyc + "\n" +
                "Nzc: " + nzc;
        textViewResult.setText(result);
    }
}