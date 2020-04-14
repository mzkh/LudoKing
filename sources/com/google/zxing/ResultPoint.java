package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

public class ResultPoint {

    /* renamed from: x */
    private final float f3936x;

    /* renamed from: y */
    private final float f3937y;

    public ResultPoint(float f, float f2) {
        this.f3936x = f;
        this.f3937y = f2;
    }

    public final float getX() {
        return this.f3936x;
    }

    public final float getY() {
        return this.f3937y;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f3936x == resultPoint.f3936x && this.f3937y == resultPoint.f3937y) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f3936x) * 31) + Float.floatToIntBits(this.f3937y);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.f3936x);
        sb.append(',');
        sb.append(this.f3937y);
        sb.append(')');
        return sb.toString();
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint3 = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint = resultPointArr[2];
        } else if (distance3 < distance2 || distance3 < distance) {
            resultPoint3 = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[1];
        } else {
            resultPoint3 = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[2];
        }
        if (crossProductZ(resultPoint2, resultPoint3, resultPoint) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint;
            resultPoint = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint3;
        resultPointArr[2] = resultPoint;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f3936x, resultPoint.f3937y, resultPoint2.f3936x, resultPoint2.f3937y);
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f = resultPoint2.f3936x;
        float f2 = resultPoint2.f3937y;
        return ((resultPoint3.f3936x - f) * (resultPoint.f3937y - f2)) - ((resultPoint3.f3937y - f2) * (resultPoint.f3936x - f));
    }
}
