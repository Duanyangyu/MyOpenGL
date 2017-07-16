package com.duan.opengl.triangle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;

import com.duan.opengl.R;
import com.duan.opengl.rectangle.RectangleRender;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.opengl.GLSurfaceView.RENDERMODE_WHEN_DIRTY;

public class TriangleActivity extends Activity {

    @InjectView(R.id.mTriangleGLSurfaceView)
    TriangleGLSurfaceView mSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        ButterKnife.inject(this);
        initView();
    }

    private void initView(){
        RectangleRender rectangleRender = new RectangleRender();
        mSurfaceView.setRenderer(rectangleRender);
        mSurfaceView.setRenderMode(RENDERMODE_WHEN_DIRTY);
    }

    @OnClick(R.id.btnRequestRender)
    public void btnRequestRender(View view){
        TriangleRender triangleRender = new TriangleRender(this);
        mSurfaceView.setRenderer(triangleRender);
        mSurfaceView.setRenderMode(RENDERMODE_WHEN_DIRTY);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitmap);
        triangleRender.setContentBitmap(bitmap);
        mSurfaceView.requestRender();
    }

    @OnClick(R.id.btnOpenGLRectangle)
    public void btnOpenGLRectangle(View view){

        mSurfaceView.requestRender();
    }

}
