package com.example.opengl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;

public class PolygonResultActivity extends AppCompatActivity {

    private GLSurfaceView mGLSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLSurfaceView = new GLSurfaceView(this);

        // Get data from Intent
        float x0 = getIntent().getFloatExtra("x0", 0);
        float y0 = getIntent().getFloatExtra("y0", 0);
        float z0 = getIntent().getFloatExtra("z0", 0);
        float xd = getIntent().getFloatExtra("xd", 0);
        float yd = getIntent().getFloatExtra("yd", 0);
        float zd = getIntent().getFloatExtra("zd", 0);
        float xa = getIntent().getFloatExtra("xa", 0);
        float ya = getIntent().getFloatExtra("ya", 0);
        float za = getIntent().getFloatExtra("za", 0);
        float xb = getIntent().getFloatExtra("xb", 0);
        float yb = getIntent().getFloatExtra("yb", 0);
        float zb = getIntent().getFloatExtra("zb", 0);
        float xc = getIntent().getFloatExtra("xc", 0);
        float yc = getIntent().getFloatExtra("yc", 0);
        float zc = getIntent().getFloatExtra("zc", 0);

        float[] rayPosition = new float[]{x0,y0,z0};
        float[] rayDirection = new float[]{xd,yd,zd};
        float[] vertex1 = new float[]{xa,ya,za};
        float[] vertex2 = new float[]{xb,yb,zb};
        float[] vertex3 = new float[]{xc,yc,zc};

        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if (supportsEs2)
        {
            mGLSurfaceView.setEGLContextClientVersion(2);
            mGLSurfaceView.setRenderer(new SurfaceRender(vertex1, vertex2, vertex3, rayPosition, rayDirection));
        }
        else
        {
            return;
        }

        setContentView(mGLSurfaceView);
    }
    @Override
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
