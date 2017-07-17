package com.duan.opengl;

/**
 * Created by duanyy on 2017/7/17.
 */

public abstract class Renderable {

    public abstract void onSurfaceCreated();
    public abstract void onSurfaceChanged(int width,int height);
    public abstract void drawFrame();

}
