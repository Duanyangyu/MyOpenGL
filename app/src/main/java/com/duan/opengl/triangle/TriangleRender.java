package com.duan.opengl.triangle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;


import com.duan.opengl.R;
import com.duan.opengl.rectangle.Rectangle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by duanyy on 2017/7/14.
 */

public class TriangleRender implements GLSurfaceView.Renderer {

    private static final String TAG = "TriangleRender";

    private Context mContext;

    private Bitmap mContentBitmap;
    private Triangle mTriangle;
    private Rectangle mRecangle;


    public TriangleRender(Context context) {
        this.mContext = context;
        mContentBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bitmap);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.e(TAG,"onSurfaceCreated");
        mTriangle = new Triangle();
        mRecangle = new Rectangle();
        GLES20.glClearColor(1f,0.5f,0.9f,1.f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Log.e(TAG,"onSurfaceChanged");
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        Log.e(TAG,"onDrawFrame");
        GLES20.glClear( GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);

//        mTriangle.drawFrame();
        mRecangle.drawFrame();
    }

    public void setContentBitmap(Bitmap mContentBitmap) {
        this.mContentBitmap = mContentBitmap;
        if (mTriangle != null) {
            mTriangle.setContentBitmap(mContentBitmap);
        }
        if (mRecangle != null) {
            mRecangle.setContentBitmap(mContentBitmap);
        }
    }
}
