package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.tapjoy.internal.aa */
public enum C2859aa {
    UNSPECIFIED,
    PORTRAIT,
    LANDSCAPE,
    SQUARE,
    NATURAL_PORTRAIT(PORTRAIT),
    RIGHT_LANDSCAPE(LANDSCAPE, NATURAL_PORTRAIT),
    REVERSE_PORTRAIT(PORTRAIT, NATURAL_PORTRAIT),
    LEFT_LANDSCAPE(LANDSCAPE, NATURAL_PORTRAIT),
    NATURAL_LANDSCAPE(LANDSCAPE),
    RIGHT_PORTRAIT(PORTRAIT, NATURAL_LANDSCAPE),
    REVERSE_LANDSCAPE(LANDSCAPE, NATURAL_LANDSCAPE),
    LEFT_PORTRAIT(PORTRAIT, NATURAL_LANDSCAPE),
    NATURAL_SQUARE(SQUARE),
    RIGHT_SQUARE(SQUARE, NATURAL_SQUARE),
    REVERSE_SQUARE(SQUARE, NATURAL_SQUARE),
    LEFT_SQUARE(SQUARE, NATURAL_SQUARE);
    

    /* renamed from: q */
    private final C2859aa f6627q;

    /* renamed from: r */
    private final C2859aa f6628r;

    private C2859aa(C2859aa aaVar) {
        this.f6627q = aaVar;
        this.f6628r = this;
    }

    private C2859aa(C2859aa aaVar, C2859aa aaVar2) {
        this.f6627q = aaVar;
        this.f6628r = aaVar2;
    }

    /* renamed from: a */
    public final boolean mo29787a() {
        C2859aa aaVar = PORTRAIT;
        return this == aaVar || this.f6627q == aaVar;
    }

    /* renamed from: b */
    public final boolean mo29788b() {
        C2859aa aaVar = LANDSCAPE;
        return this == aaVar || this.f6627q == aaVar;
    }

    /* renamed from: c */
    public final int mo29789c() {
        if (this.f6628r != null) {
            return ordinal() - this.f6628r.ordinal();
        }
        return 0;
    }

    /* renamed from: a */
    public static C2859aa m6557a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        Point point = new Point();
        if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.x = defaultDisplay.getWidth();
            point.y = defaultDisplay.getHeight();
        }
        if (point.x < point.y) {
            int i = rotation & 3;
            if (i == 1) {
                return RIGHT_PORTRAIT;
            }
            if (i == 2) {
                return REVERSE_PORTRAIT;
            }
            if (i != 3) {
                return NATURAL_PORTRAIT;
            }
            return LEFT_PORTRAIT;
        } else if (point.x > point.y) {
            int i2 = rotation & 3;
            if (i2 == 1) {
                return RIGHT_LANDSCAPE;
            }
            if (i2 == 2) {
                return REVERSE_LANDSCAPE;
            }
            if (i2 != 3) {
                return NATURAL_LANDSCAPE;
            }
            return LEFT_LANDSCAPE;
        } else {
            int i3 = rotation & 3;
            if (i3 == 1) {
                return RIGHT_SQUARE;
            }
            if (i3 == 2) {
                return REVERSE_SQUARE;
            }
            if (i3 != 3) {
                return NATURAL_SQUARE;
            }
            return LEFT_SQUARE;
        }
    }

    /* renamed from: b */
    public static C2859aa m6558b(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return PORTRAIT;
        }
        if (i != 2) {
            return UNSPECIFIED;
        }
        return LANDSCAPE;
    }
}
