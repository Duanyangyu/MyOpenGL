package com.duan.opengl.rectangle;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.duan.opengl.utils.BufferUtils;
import com.duan.opengl.utils.GlUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by duanyy on 2017/7/16.
 */

public class RectangleRender implements GLSurfaceView.Renderer {

    private static final String VERTIC_SHADER = "attribute vec3 a_Position;" +
            "void main(){" +
            "   gl_Position = vec4(a_Position.x,a_Position.y,a_Position.z,1.0);" +
            "}";

    private static final String FRAGMENT_SHADER = "precision mediump float;" +
            "void main(){" +
            "   gl_FragColor = vec4(0.5f,0.8f,0.9f,1.0f);"+
            "}";

    private FloatBuffer mVerticsBuffer;
    private float[] vertics = {
            -1.0f,1.0f,0.f,
            -1.0f,-1.0f,0.f,
            1.0f,-1.0f,0.f,
            1.0f,1.0f,0.0f
    };

    private ShortBuffer mVerticsIndexBuffer;
    private short[] verticsIndex = {
            0,1,2,0,2,3
    };

    private int programId;


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        mVerticsBuffer = BufferUtils.float2Buffer(vertics);
        mVerticsIndexBuffer = BufferUtils.short2Buffer(verticsIndex);
        programId = GlUtil.createProgram(VERTIC_SHADER, FRAGMENT_SHADER);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {

        GLES20.glClear( GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
        GLES20.glClearColor(1.0f,0.f,0.f,1.0f);

        GLES20.glUseProgram(programId);

        int a_position = GLES20.glGetAttribLocation(programId, "a_Position");
        GLES20.glEnableVertexAttribArray(a_position);
        GLES20.glVertexAttribPointer(a_position,3,GLES20.GL_FLOAT,false,0,mVerticsBuffer);
        GLES20.glDrawElements(GLES20.GL_TRIANGLES,6,GLES20.GL_UNSIGNED_SHORT,mVerticsIndexBuffer);
//        GLES20.glDrawArrays(GLES20.GL_TRIANGLES,0,3);
        GlUtil.checkGlError("drawFrame");
        GLES20.glDisableVertexAttribArray(a_position);
        GLES20.glUseProgram(0);
    }
}
