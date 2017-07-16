package com.duan.opengl.utils;

import android.opengl.GLES20;
import android.text.TextUtils;

/**
 * Created by duanyy on 2017/7/14.
 */

public class OpenGLUtils {

    public static int loadShader(int type,String shader){
        int shaderId = GLES20.glCreateShader(type);
        if (shaderId != 0) {
            GLES20.glShaderSource(shaderId,shader);
            GLES20.glCompileShader(shaderId);
            int[] compiled = new int[1];
            GLES20.glGetShaderiv(shaderId,GLES20.GL_COMPILE_STATUS,compiled,0);
            if (compiled[0] == 0){
                GLES20.glDeleteShader(shaderId);
                shaderId = 0;
            }
        }
        return shaderId;
    }

    public static int loadProgram(String verticShader,String fragmentShader){
        if (TextUtils.isEmpty(verticShader))
            return 0;
        if (TextUtils.isEmpty(fragmentShader))
            return 0;

        int verticShaderId = loadShader(GLES20.GL_VERTEX_SHADER, verticShader);
        if (verticShaderId == 0)
            return 0;

        int fragmentShaderId = loadShader(GLES20.GL_FRAGMENT_SHADER,fragmentShader);
        if (fragmentShaderId == 0)
            return 0;

        int programId = GLES20.glCreateProgram();
        if (programId != 0){
            GLES20.glAttachShader(programId,verticShaderId);
            GLES20.glAttachShader(programId,fragmentShaderId);

            GLES20.glLinkProgram(programId);
            int[] linkState = new int[1];
            GLES20.glGetProgramiv(programId,GLES20.GL_LINK_STATUS,linkState,0);
            if (linkState[0] == 0){
                GLES20.glDeleteProgram(programId);
                programId = 0;
            }
        }
        return programId;
    }

}
