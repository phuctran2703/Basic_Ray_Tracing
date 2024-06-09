package com.example.opengl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BarycentricResultActivity extends AppCompatActivity {
    private GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLSurfaceView = new GLSurfaceView(this);

        // Get data from Intent
        float xa = getIntent().getFloatExtra("xa", 0);
        float ya = getIntent().getFloatExtra("ya", 0);
        float za = getIntent().getFloatExtra("za", 0);
        float xb = getIntent().getFloatExtra("xb", 0);
        float yb = getIntent().getFloatExtra("yb", 0);
        float zb = getIntent().getFloatExtra("zb", 0);
        float xc = getIntent().getFloatExtra("xc", 0);
        float yc = getIntent().getFloatExtra("yc", 0);
        float zc = getIntent().getFloatExtra("zc", 0);
        float xp = getIntent().getFloatExtra("xp", 0);
        float yp = getIntent().getFloatExtra("yp", 0);
        float zp = getIntent().getFloatExtra("zp", 0);
        float nxa = getIntent().getFloatExtra("nxa", 0);
        float nya = getIntent().getFloatExtra("nya", 0);
        float nza = getIntent().getFloatExtra("nza", 0);
        float nxb = getIntent().getFloatExtra("nxb", 0);
        float nyb = getIntent().getFloatExtra("nyb", 0);
        float nzb = getIntent().getFloatExtra("nzb", 0);
        float nxc = getIntent().getFloatExtra("nxc", 0);
        float nyc = getIntent().getFloatExtra("nyc", 0);
        float nzc = getIntent().getFloatExtra("nzc", 0);

        float[] pointA = new float[]{xa,ya,za};
        float[] pointB = new float[]{xb,yb,zb};
        float[] pointC = new float[]{xc,yc,zc};
        float[] pointP = new float[]{xp,yp,zp};
        float[] normalA = new float[]{nxa,nya,nza};
        float[] normalB = new float[]{nxb,nyb,nzb};
        float[] normalC = new float[]{nxc,nyc,nzc};

        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if (supportsEs2)
        {
            mGLSurfaceView.setEGLContextClientVersion(2);
            mGLSurfaceView.setRenderer(new BarycentricRender(pointA, pointB, pointC, pointP, normalA, normalB, normalC));
        }
        else
        {
            return;
        }

        setContentView(mGLSurfaceView);
    }
    protected void onResume()
    {
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mGLSurfaceView.onPause();
    }
}