package com.example.opengl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SphereActivity extends AppCompatActivity {
    private EditText editTextX0, editTextY0, editTextZ0, editTextXd, editTextYd, editTextZd, editTextXc, editTextYc, editTextZc, editTextR;
    private Button buttonSubmit, buttonReturn;
    private TextView textViewResult;
    private Bundle data;

    private Spanned getSubscriptText(String text) {
        // Replace all letters with subscript
        return Html.fromHtml(text.replaceAll("([xyzp])([0dc])", "$1<sub><small><small>$2</small></small></sub>"), Html.FROM_HTML_MODE_LEGACY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ray_to_sphere);

        TextView textViewRayOrigin = findViewById(R.id.textViewRayOrigin);
        TextView textViewRayDirection = findViewById(R.id.textViewRayDirection);
        TextView textViewSphereCenter = findViewById(R.id.textViewSphereCenter);
        TextView textViewSphereRadius = findViewById(R.id.textViewSphereRadius);

        textViewRayOrigin.setText(getSubscriptText("Ray Origin (p0) [x0, y0, z0]"));
        textViewRayDirection.setText(getSubscriptText("Ray Direction (d) [xd, yd, zd]"));
        textViewSphereCenter.setText(getSubscriptText("Sphere Center (c) [xc, yc, zc]"));
        textViewSphereRadius.setText(getSubscriptText("Sphere Radius (r)"));

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

        editTextX0.setHint(getSubscriptText("x0"));
        editTextY0.setHint(getSubscriptText("y0"));
        editTextZ0.setHint(getSubscriptText("z0"));
        editTextXd.setHint(getSubscriptText("xd"));
        editTextYd.setHint(getSubscriptText("yd"));
        editTextZd.setHint(getSubscriptText("zd"));
        editTextXc.setHint(getSubscriptText("xc"));
        editTextYc.setHint(getSubscriptText("yc"));
        editTextZc.setHint(getSubscriptText("zc"));
        editTextR.setHint(getSubscriptText("r"));

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

                // Send data to SphereResultActivity
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

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
