package com.duan.opengl.triangle;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * Created by duanyy on 2017/7/14.
 */

public class TriangleGLSurfaceView extends GLSurfaceView {

    private Context mContext;

    public TriangleGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        setEGLContextClientVersion(2);
    }

}
