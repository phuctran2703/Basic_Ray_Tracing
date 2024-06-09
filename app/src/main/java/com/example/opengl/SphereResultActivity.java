package com.example.opengl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;

public class SphereResultActivity extends AppCompatActivity {
    private Bundle data;
    private GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLSurfaceView = new GLSurfaceView(this);

        data = getIntent().getExtras();
        float x0 = data.getFloat("x0");
        float y0 = data.getFloat("y0");
        float z0 = data.getFloat("z0");
        float xd = data.getFloat("xd");
        float yd = data.getFloat("yd");
        float zd = data.getFloat("zd");
        float xc = data.getFloat("xc");
        float yc = data.getFloat("yc");
        float zc = data.getFloat("zc");
        float r = data.getFloat("r");

        float[] rayPosition = new float[]{x0,y0,z0};
        float[] rayDirection = new float[]{xd,yd,zd};
        float[] center = new float[]{xc,yc,zc};
        float radius = r;


        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if (supportsEs2)
        {
            mGLSurfaceView.setEGLContextClientVersion(2);

            mGLSurfaceView.setRenderer(new SphereRender(rayPosition, rayDirection, center, radius));
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
