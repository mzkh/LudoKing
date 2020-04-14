package com.adcolony.sdk;

import android.opengl.GLES20;
import android.util.Log;

/* renamed from: com.adcolony.sdk.am */
class C0500am {

    /* renamed from: a */
    C0496ak f300a;

    /* renamed from: b */
    int f301b = GLES20.glCreateShader(35633);

    /* renamed from: c */
    int f302c = GLES20.glCreateShader(35632);

    /* renamed from: d */
    int f303d;

    /* renamed from: e */
    int f304e;

    /* renamed from: f */
    int f305f;

    /* renamed from: g */
    int f306g;

    /* renamed from: h */
    int f307h;

    /* renamed from: i */
    int f308i;

    /* renamed from: com.adcolony.sdk.am$a */
    static class C0501a extends C0500am {
        C0501a(C0496ak akVar) {
            super(akVar, "precision mediump float;              \nuniform mat4   transform;             \nattribute vec4 position;              \nattribute lowp vec4 color;            \nvarying   lowp vec4 vertex_color;     \nvoid main()                           \n{                                     \n  gl_Position = transform * position; \n  vertex_color = color / 255.0;       \n}                                     \n", "precision mediump float;        \nvarying lowp vec4 vertex_color; \nvoid main()                     \n{                               \n  gl_FragColor = vertex_color;  \n}                               \n");
        }
    }

    /* renamed from: com.adcolony.sdk.am$b */
    static class C0502b extends C0500am {
        C0502b(C0496ak akVar) {
            super(akVar, "precision mediump float;              \nuniform mat4   transform;             \nattribute vec4 position;              \nattribute      vec2 uv;               \nvarying        vec2 vertex_uv;        \nvoid main()                           \n{                                     \n  gl_Position = transform * position; \n  vertex_uv = uv;                     \n}                                     \n", "precision mediump float;                       \nuniform              sampler2D texture;        \nvarying              vec2      vertex_uv;      \nvoid main()                                    \n{                                              \n  gl_FragColor = texture2D(texture,vertex_uv); \n}                                              \n");
        }
    }

    /* renamed from: com.adcolony.sdk.am$c */
    static class C0503c extends C0500am {
        C0503c(C0496ak akVar) {
            super(akVar, "precision mediump float;                  \nuniform mat4   transform;                 \nattribute vec4 position;                  \nattribute      vec2 uv;                   \nvarying        vec2 vertex_uv;            \nattribute lowp vec4 color;                \nvarying   lowp vec4 vertex_color;         \nvoid main()                               \n{                                         \n  gl_Position = transform * position;     \n  vertex_uv = uv;                         \n  vertex_color = color / 255.0;           \n}                                         \n", "precision mediump float;                                      \nuniform      sampler2D texture;                               \nvarying      vec2      vertex_uv;                             \nvarying lowp vec4 vertex_color;                               \nvoid main()                                                   \n{                                                             \n  vec4 texture_color = texture2D(texture,vertex_uv);          \n  gl_FragColor = vec4( texture_color.xyz + (vertex_color.xyz * texture_color.a), texture_color.a ); \n}                                                             \n");
        }
    }

    /* renamed from: com.adcolony.sdk.am$d */
    static class C0504d extends C0500am {
        C0504d(C0496ak akVar) {
            super(akVar, "precision mediump float;              \nuniform        mat4 transform;        \nattribute      vec4 position;         \nattribute      vec2 uv;               \nvarying        vec2 vertex_uv;        \nattribute lowp vec4 color;            \nvarying   lowp vec4 vertex_color;     \nvoid main()                           \n{                                     \n  gl_Position = transform * position; \n  vertex_uv = uv;                     \n  vertex_color = color / 255.0;       \n}                                     \n", "precision mediump float;                                      \nuniform           sampler2D texture;                          \nvarying           vec2      vertex_uv;                        \nvarying   lowp    vec4      vertex_color;                     \nvoid main()                                                   \n{                                                             \n  gl_FragColor = texture2D(texture,vertex_uv) * vertex_color; \n}                                                             \n");
        }
    }

    /* renamed from: com.adcolony.sdk.am$e */
    static class C0505e extends C0500am {
        C0505e(C0496ak akVar) {
            super(akVar, "precision mediump float;                        \nuniform        mat4   transform;                \nattribute      vec4 position;                   \nattribute      vec2 uv;                         \nvarying        vec2 vertex_uv;                  \nattribute lowp vec4  color;                     \nvarying   lowp vec4  vertex_color;              \nvoid main()                                     \n{                                               \n  gl_Position = transform * position;           \n  vertex_uv = uv;                               \n  vertex_color = color / 255.0;                 \n}                                               \n", "precision mediump float;                                        \nuniform      sampler2D texture;                                 \nvarying      vec2      vertex_uv;                               \nvarying lowp vec4      vertex_color;                            \nvoid main()                                                     \n{                                                               \n  lowp float texture_a = texture2D(texture,vertex_uv).a;        \n  gl_FragColor = vec4( vertex_color.xyz*texture_a, texture_a ); \n}                                                               \n");
        }
    }

    /* renamed from: com.adcolony.sdk.am$f */
    static class C0506f extends C0500am {
        C0506f(C0496ak akVar) {
            super(akVar, "precision mediump float;                   \nuniform mat4   transform;                  \nattribute vec4 position;                   \nattribute      vec2 uv;                    \nvarying        vec2 vertex_uv;             \nattribute lowp vec4  color;                \nvarying   lowp vec4  vertex_color;         \nvarying   lowp float vertex_inverse_a;     \nvoid main()                                \n{                                          \n  gl_Position = transform * position;      \n  vertex_uv = uv;                          \n  vertex_color = color / 255.0;            \n  vertex_inverse_a = 1.0 - vertex_color.a; \n}                                          \n", "precision mediump float;                   \nuniform      sampler2D texture;            \nvarying      vec2      vertex_uv;          \nvarying lowp vec4      vertex_color;       \nvarying lowp float vertex_inverse_a;       \nvoid main()                                \n{                                          \n  vec4 texture_color = texture2D(texture,vertex_uv);        \n  gl_FragColor = vec4( (texture_color.xyz*vertex_inverse_a)+(vertex_color.xyz*texture_color.a), texture_color.a );  \n}                                                   \n");
        }
    }

    C0500am(C0496ak akVar, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Compiling ");
        sb.append(getClass().getSimpleName());
        sb.append("...");
        m199a(sb.toString());
        this.f300a = akVar;
        m199a("Vertex shader");
        GLES20.glShaderSource(this.f301b, str);
        GLES20.glCompileShader(this.f301b);
        m199a(GLES20.glGetShaderInfoLog(this.f301b));
        m199a("Pixel shader");
        GLES20.glShaderSource(this.f302c, str2);
        GLES20.glCompileShader(this.f302c);
        m199a(GLES20.glGetShaderInfoLog(this.f302c));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("vertex_shader:");
        sb2.append(this.f301b);
        sb2.append(" pixel_shader:");
        sb2.append(this.f302c);
        m199a(sb2.toString());
        this.f303d = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.f303d, this.f301b);
        GLES20.glAttachShader(this.f303d, this.f302c);
        GLES20.glLinkProgram(this.f303d);
        this.f304e = GLES20.glGetUniformLocation(this.f303d, "transform");
        this.f305f = GLES20.glGetAttribLocation(this.f303d, "position");
        this.f306g = GLES20.glGetAttribLocation(this.f303d, "color");
        this.f307h = GLES20.glGetUniformLocation(this.f303d, "texture");
        this.f308i = GLES20.glGetAttribLocation(this.f303d, "uv");
    }

    /* renamed from: a */
    static void m199a(String str) {
        Log.d("ADC3", str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8303a() {
        GLES20.glUseProgram(this.f303d);
        GLES20.glUniformMatrix4fv(this.f304e, 1, false, this.f300a.f269z.f392c, 0);
        this.f300a.f266w.rewind();
        GLES20.glVertexAttribPointer(this.f305f, 2, 5126, false, 0, this.f300a.f266w);
        GLES20.glEnableVertexAttribArray(this.f305f);
        if (this.f308i >= 0) {
            this.f300a.f267x.rewind();
            GLES20.glVertexAttribPointer(this.f308i, 2, 5126, false, 0, this.f300a.f267x);
            GLES20.glEnableVertexAttribArray(this.f308i);
        }
        if (this.f306g >= 0) {
            this.f300a.f268y.rewind();
            GLES20.glVertexAttribPointer(this.f306g, 4, 5121, false, 0, this.f300a.f268y);
            GLES20.glEnableVertexAttribArray(this.f306g);
        }
        int i = this.f307h;
        if (i >= 0) {
            GLES20.glUniform1i(i, 0);
        }
    }
}
