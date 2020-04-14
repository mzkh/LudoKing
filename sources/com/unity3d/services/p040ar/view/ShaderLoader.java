package com.unity3d.services.p040ar.view;

import android.opengl.GLES20;
import com.unity3d.services.core.log.DeviceLog;

/* renamed from: com.unity3d.services.ar.view.ShaderLoader */
public class ShaderLoader {
    public static int load(String str, int i) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Error compiling shader: ");
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        DeviceLog.error(sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static boolean checkGLError(String str) {
        int i = 0;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            DeviceLog.error(sb.toString());
            i = glGetError;
        }
        if (i != 0) {
            return true;
        }
        return false;
    }
}
