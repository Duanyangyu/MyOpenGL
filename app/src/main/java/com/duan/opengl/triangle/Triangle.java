package com.duan.opengl.triangle;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Log;

import com.duan.opengl.utils.BufferUtils;
import com.duan.opengl.utils.GlUtil;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL;

/**
 * Created by duanyy on 2017/7/14.
 */

public class Triangle {

    private static final String TAG = "Triangle";

//    private static final String VERTIC_SHADER = "attribute vec3 position;" +
//            "void main()" +
//            "{" +
//            "    gl_Position = vec4(position.x, position.y, position.z, 1.0);" +
//            "}";
//
//    private static final String FRAGMENT_SHADER = "precision mediump float;" +
//            "void main() {" +
//            "  gl_FragColor = vec4(0.5,0.5,0.5,0.5);" +
//            "}";

    private static final String VERTIC_SHADER = "attribute vec3 position;" +
            "attribute vec2 a_textCoord;"+
            "varying vec2 v_textCoord;"+
            "void main()" +
            "{" +
            "    gl_Position = vec4(position.x, position.y, position.z, 1.0);" +
            "    v_textCoord = a_textCoord;"+
            "}";

    private static final String FRAGMENT_SHADER = "precision mediump float;" +
            "varying vec2 v_textCoord;"+
            "uniform sampler2D u_sampleTexture;"+
            "void main() {" +
            "  gl_FragColor = texture2D(u_sampleTexture,v_textCoord);" +
//            "  gl_FragColor = vec4(0.5,0.5,0.5,0.5);" +
            "}";


    private float[] vertices;
    private float[] textures;

    private FloatBuffer mVerticsBuffer;
    private FloatBuffer mTextureBuffer;

    private int mPositionHandler;
    private int mProgramId;

    private Bitmap mContentBitmap;
    private int mTextureHandler;

    public Triangle() {
        this.vertices = new float[]{
                -0.8f,0.8f,0f,
                -0.8f,-0.8f,0.f,
                0.8f,-0.8f,0.f,
        };
        this.textures = new float[]{
                0.f,0.8f,
                0.f,0.f,
                0.8f,0.f
        };
        init();
    }

    public Triangle(float[] vertices,float[] textures){
        this.vertices = vertices;
        this.textures = textures;
        init();
    }

    private void init(){
        mProgramId = GlUtil.createProgram(VERTIC_SHADER, FRAGMENT_SHADER);
        mVerticsBuffer = BufferUtils.float2Buffer(vertices);
        mTextureBuffer = BufferUtils.float2Buffer(textures);
    }

    public void drawFrame(){
        GLES20.glUseProgram(mProgramId);
        mPositionHandler = GLES20.glGetAttribLocation(mProgramId,"position");
        mTextureHandler = GLES20.glGetAttribLocation(mProgramId, "a_textCoord");
        Log.e(TAG,"mProgramId="+mProgramId+", mPositionHandler="+mPositionHandler+", mTextureHandler="+mTextureHandler);

        if (mContentBitmap != null) {
            int textureId = GlUtil.loadTexture(mContentBitmap, -1, GlUtil.Direction.HORIZONTAL, false);
            Log.e(TAG,"textureId="+textureId);
            GLES20.glActiveTexture(GLES20.GL_TEXTURE0);//默认激活的纹理单元
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D,textureId);
        }

        GLES20.glEnableVertexAttribArray(mPositionHandler);
        GLES20.glEnableVertexAttribArray(mTextureHandler);

        GLES20.glVertexAttribPointer(mPositionHandler,3,GLES20.GL_FLOAT,false,0,mVerticsBuffer);
        GLES20.glVertexAttribPointer(mTextureHandler,2,GLES20.GL_FLOAT,false,0,mTextureBuffer);

        GLES20.glDrawArrays(GLES20.GL_TRIANGLES,0,3);

        GLES20.glDisableVertexAttribArray(mPositionHandler);
        GLES20.glDisableVertexAttribArray(mTextureHandler);

        GLES20.glUseProgram(0);
    }

    public void setContentBitmap(Bitmap mContentBitmap) {
        this.mContentBitmap = mContentBitmap;
    }
}
