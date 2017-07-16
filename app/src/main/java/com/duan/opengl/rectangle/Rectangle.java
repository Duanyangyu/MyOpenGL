package com.duan.opengl.rectangle;


import android.content.Context;
import android.graphics.Bitmap;

import com.duan.opengl.triangle.Triangle;

/**
 * Created by duanyy on 2017/7/16.
 */

public class Rectangle {

    private static final String TAG = "Rectangle";

    private float[] vertics1 = {
            -0.5f,0.5f,0.f,
            -0.5f,-0.5f,0.f,
            0.5f,-0.5f,0.f
    };

    private float[] verticx2 = {
            -0.5f,0.5f,0.0f,
            0.5f,-0.5f,0.0f,
            0.5f,0.5f,0.0f
    };

    private float[] textures1 = {
                0.f,1f,
                0.f,0.f,
                1f,0.f
    };

    private float[] textures2 = {
            0.f,1f,
            1.f,0.f,
            1f,1.f
    };


    private Triangle triangle1;
    private Triangle triangle2;

    private Bitmap mContentBitmap;

    public Rectangle() {
        triangle1 = new Triangle(vertics1,textures1);
        triangle2 = new Triangle(verticx2,textures2);
    }

    public void drawFrame(){
        triangle1.drawFrame();
        triangle2.drawFrame();
    }

    public void setContentBitmap(Bitmap mContentBitmap) {
        this.mContentBitmap = mContentBitmap;
        triangle1.setContentBitmap(mContentBitmap);
        triangle2.setContentBitmap(mContentBitmap);

        //test for upload to Git.

    }

}
