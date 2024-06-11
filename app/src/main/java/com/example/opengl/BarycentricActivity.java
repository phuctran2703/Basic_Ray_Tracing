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

public class BarycentricActivity extends AppCompatActivity {
    private EditText editTextXa, editTextYa, editTextZa;
    private EditText editTextXb, editTextYb, editTextZb;
    private EditText editTextXc, editTextYc, editTextZc;
    private EditText editTextXp, editTextYp, editTextZp;
    private EditText editTextNxa, editTextNya, editTextNza;
    private EditText editTextNxb, editTextNyb, editTextNzb;
    private EditText editTextNxc, editTextNyc, editTextNzc;
    private Button buttonSubmit, buttonReturn;

    private Spanned getSubscriptText(String text) {
        return Html.fromHtml(text.replaceAll("([xyzpn])([abcp]|xa|xb|xc|ya|yb|yc|za|zb|zc)", "$1<sub><small><small><small>$2</small></small></small></sub>"), Html.FROM_HTML_MODE_LEGACY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barycentric);

        TextView textViewVertexA = findViewById(R.id.textViewVertexA);
        TextView textViewVertexB = findViewById(R.id.textViewVertexB);
        TextView textViewVertexC = findViewById(R.id.textViewVertexC);
        TextView textViewVertexP = findViewById(R.id.textViewPointP);
        TextView textViewNormalA = findViewById(R.id.textViewNormalA);
        TextView textViewNormalB = findViewById(R.id.textViewNormalB);
        TextView textViewNormalC = findViewById(R.id.textViewNormalC);

        textViewVertexA.setText(getSubscriptText("Vertex A [xa, ya, za]"));
        textViewVertexB.setText(getSubscriptText("Vertex B [xb, yb, zb]"));
        textViewVertexC.setText(getSubscriptText("Vertex C [xc, yc, zc]"));
        textViewVertexP.setText(getSubscriptText("Point P [xp, yp, zp]"));
        textViewNormalA.setText(getSubscriptText("Normal A [nxa, nya, nza]"));
        textViewNormalB.setText(getSubscriptText("Normal B [nxb, nyb, nzb]"));
        textViewNormalC.setText(getSubscriptText("Normal C [nxc, nyc, nzc]"));

        // Ánh xạ các view từ XML
        editTextXa = findViewById(R.id.editTextXa);
        editTextYa = findViewById(R.id.editTextYa);
        editTextZa = findViewById(R.id.editTextZa);
        editTextXb = findViewById(R.id.editTextXb);
        editTextYb = findViewById(R.id.editTextYb);
        editTextZb = findViewById(R.id.editTextZb);
        editTextXc = findViewById(R.id.editTextXc);
        editTextYc = findViewById(R.id.editTextYc);
        editTextZc = findViewById(R.id.editTextZc);
        editTextXp = findViewById(R.id.editTextXp);
        editTextYp = findViewById(R.id.editTextYp);
        editTextZp = findViewById(R.id.editTextZp);
        editTextNxa = findViewById(R.id.editTextNxa);
        editTextNya = findViewById(R.id.editTextNya);
        editTextNza = findViewById(R.id.editTextNza);
        editTextNxb = findViewById(R.id.editTextNxb);
        editTextNyb = findViewById(R.id.editTextNyb);
        editTextNzb = findViewById(R.id.editTextNzb);
        editTextNxc = findViewById(R.id.editTextNxc);
        editTextNyc = findViewById(R.id.editTextNyc);
        editTextNzc = findViewById(R.id.editTextNzc);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonReturn = findViewById(R.id.buttonReturn);

        editTextXa.setHint(getSubscriptText("xa"));
        editTextYa.setHint(getSubscriptText("ya"));
        editTextZa.setHint(getSubscriptText("za"));
        editTextXb.setHint(getSubscriptText("xb"));
        editTextYb.setHint(getSubscriptText("yb"));
        editTextZb.setHint(getSubscriptText("zb"));
        editTextXc.setHint(getSubscriptText("xc"));
        editTextYc.setHint(getSubscriptText("yc"));
        editTextZc.setHint(getSubscriptText("zc"));
        editTextXp.setHint(getSubscriptText("xp"));
        editTextYp.setHint(getSubscriptText("yp"));
        editTextZp.setHint(getSubscriptText("zp"));
        editTextNxa.setHint(getSubscriptText("nxa"));
        editTextNya.setHint(getSubscriptText("nya"));
        editTextNza.setHint(getSubscriptText("nza"));
        editTextNxb.setHint(getSubscriptText("nxb"));
        editTextNyb.setHint(getSubscriptText("nyb"));
        editTextNzb.setHint(getSubscriptText("nzb"));
        editTextNxc.setHint(getSubscriptText("nxc"));
        editTextNyc.setHint(getSubscriptText("nyc"));
        editTextNzc.setHint(getSubscriptText("nzc"));

        if (savedInstanceState != null) {
            editTextXa.setText(String.valueOf(savedInstanceState.getFloat("xa")));
            editTextYa.setText(String.valueOf(savedInstanceState.getFloat("ya")));
            editTextZa.setText(String.valueOf(savedInstanceState.getFloat("za")));
            editTextXb.setText(String.valueOf(savedInstanceState.getFloat("xb")));
            editTextYb.setText(String.valueOf(savedInstanceState.getFloat("yb")));
            editTextZb.setText(String.valueOf(savedInstanceState.getFloat("zb")));
            editTextXc.setText(String.valueOf(savedInstanceState.getFloat("xc")));
            editTextYc.setText(String.valueOf(savedInstanceState.getFloat("yc")));
            editTextZc.setText(String.valueOf(savedInstanceState.getFloat("zc")));
            editTextXp.setText(String.valueOf(savedInstanceState.getFloat("xp")));
            editTextYp.setText(String.valueOf(savedInstanceState.getFloat("yp")));
            editTextZp.setText(String.valueOf(savedInstanceState.getFloat("zp")));
            editTextNxa.setText(String.valueOf(savedInstanceState.getFloat("nxa")));
            editTextNya.setText(String.valueOf(savedInstanceState.getFloat("nya")));
            editTextNza.setText(String.valueOf(savedInstanceState.getFloat("nza")));
            editTextNxb.setText(String.valueOf(savedInstanceState.getFloat("nxb")));
            editTextNyb.setText(String.valueOf(savedInstanceState.getFloat("nyb")));
            editTextNzb.setText(String.valueOf(savedInstanceState.getFloat("nzb")));
            editTextNxc.setText(String.valueOf(savedInstanceState.getFloat("nxc")));
            editTextNyc.setText(String.valueOf(savedInstanceState.getFloat("nyc")));
            editTextNzc.setText(String.valueOf(savedInstanceState.getFloat("nzc")));
        }

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float xa = Float.parseFloat(editTextXa.getText().toString());
                float ya = Float.parseFloat(editTextYa.getText().toString());
                float za = Float.parseFloat(editTextZa.getText().toString());
                float xb = Float.parseFloat(editTextXb.getText().toString());
                float yb = Float.parseFloat(editTextYb.getText().toString());
                float zb = Float.parseFloat(editTextZb.getText().toString());
                float xc = Float.parseFloat(editTextXc.getText().toString());
                float yc = Float.parseFloat(editTextYc.getText().toString());
                float zc = Float.parseFloat(editTextZc.getText().toString());
                float xp = Float.parseFloat(editTextXp.getText().toString());
                float yp = Float.parseFloat(editTextYp.getText().toString());
                float zp = Float.parseFloat(editTextZp.getText().toString());
                float nxa = Float.parseFloat(editTextNxa.getText().toString());
                float nya = Float.parseFloat(editTextNya.getText().toString());
                float nza = Float.parseFloat(editTextNza.getText().toString());
                float nxb = Float.parseFloat(editTextNxb.getText().toString());
                float nyb = Float.parseFloat(editTextNyb.getText().toString());
                float nzb = Float.parseFloat(editTextNzb.getText().toString());
                float nxc = Float.parseFloat(editTextNxc.getText().toString());
                float nyc = Float.parseFloat(editTextNyc.getText().toString());
                float nzc = Float.parseFloat(editTextNzc.getText().toString());

                Intent intent = new Intent(BarycentricActivity.this, BarycentricResultActivity.class);
                intent.putExtra("xa", xa);
                intent.putExtra("ya", ya);
                intent.putExtra("za", za);
                intent.putExtra("xb", xb);
                intent.putExtra("yb", yb);
                intent.putExtra("zb", zb);
                intent.putExtra("xc", xc);
                intent.putExtra("yc", yc);
                intent.putExtra("zc", zc);
                intent.putExtra("xp", xp);
                intent.putExtra("yp", yp);
                intent.putExtra("zp", zp);
                intent.putExtra("nxa", nxa);
                intent.putExtra("nya", nya);
                intent.putExtra("nza", nza);
                intent.putExtra("nxb", nxb);
                intent.putExtra("nyb", nyb);
                intent.putExtra("nzb", nzb);
                intent.putExtra("nxc", nxc);
                intent.putExtra("nyc", nyc);
                intent.putExtra("nzc", nzc);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save state in Bundle
        outState.putFloat("xa", Float.parseFloat(editTextXa.getText().toString()));
        outState.putFloat("ya", Float.parseFloat(editTextYa.getText().toString()));
        outState.putFloat("za", Float.parseFloat(editTextZa.getText().toString()));
        outState.putFloat("xb", Float.parseFloat(editTextXb.getText().toString()));
        outState.putFloat("yb", Float.parseFloat(editTextYb.getText().toString()));
        outState.putFloat("zb", Float.parseFloat(editTextZb.getText().toString()));
        outState.putFloat("xc", Float.parseFloat(editTextXc.getText().toString()));
        outState.putFloat("yc", Float.parseFloat(editTextYc.getText().toString()));
        outState.putFloat("zc", Float.parseFloat(editTextZc.getText().toString()));
        outState.putFloat("xp", Float.parseFloat(editTextXp.getText().toString()));
        outState.putFloat("yp", Float.parseFloat(editTextYp.getText().toString()));
        outState.putFloat("zp", Float.parseFloat(editTextZp.getText().toString()));
        outState.putFloat("nxa", Float.parseFloat(editTextNxa.getText().toString()));
        outState.putFloat("nya", Float.parseFloat(editTextNya.getText().toString()));
        outState.putFloat("nza", Float.parseFloat(editTextNza.getText().toString()));
        outState.putFloat("nxb", Float.parseFloat(editTextNxb.getText().toString()));
        outState.putFloat("nyb", Float.parseFloat(editTextNyb.getText().toString()));
        outState.putFloat("nzb", Float.parseFloat(editTextNzb.getText().toString()));
        outState.putFloat("nxc", Float.parseFloat(editTextNxb.getText().toString()));
        outState.putFloat("nyc", Float.parseFloat(editTextNyb.getText().toString()));
        outState.putFloat("nzc", Float.parseFloat(editTextNzb.getText().toString()));
    }
}
