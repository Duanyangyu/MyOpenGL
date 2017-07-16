package com.duan.opengl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.duan.opengl.triangle.TriangleActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }


    @OnClick(R.id.btnOpenGLTriangle)
    public void btnOpenGLTriangle(View view){
        Intent intent = new Intent(this, TriangleActivity.class);
        startActivity(intent);
    }


}
