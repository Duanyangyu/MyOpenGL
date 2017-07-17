package com.duan.opengl.cube;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.duan.opengl.Renderable;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by duanyy on 2017/7/17.
 */

public class CubeRender implements GLSurfaceView.Renderer {

    private Renderable mCube;

    public CubeRender() {
        mCube = new Cube();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        if (mCube != null) {
            mCube.onSurfaceCreated();
        }
        GLES20.glClearColor(1f,0.5f,0.9f,1.f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (mCube != null) {
            mCube.onSurfaceChanged(width,height);
        }
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear( GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
        if (mCube != null) {
            mCube.drawFrame();
        }
    }
}
