package com.duan.opengl.cube;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;

import com.duan.opengl.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class CubeActivity extends Activity {

    @InjectView(R.id.mGLSurfaceView)
    public GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);
        ButterKnife.inject(this);
        initView();
    }

    private void initView(){
        CubeRender cubeRender = new CubeRender();
        mGLSurfaceView.setEGLContextClientVersion(2);
        mGLSurfaceView.setRenderer(cubeRender);
//        mGLSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @OnClick(R.id.mBtnRequestRender)
    public void mBtnRequestRender(View view){
        if (mGLSurfaceView != null) {
            mGLSurfaceView.requestRender();
        }
    }

}
