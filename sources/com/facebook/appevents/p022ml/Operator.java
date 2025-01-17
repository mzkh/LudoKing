package com.facebook.appevents.p022ml;

/* renamed from: com.facebook.appevents.ml.Operator */
final class Operator {
    Operator() {
    }

    static float[] add(float[] fArr, float[] fArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i * i2; i4++) {
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = (i4 * i3) + i5;
                fArr[i6] = fArr[i6] + fArr2[i5];
            }
        }
        return fArr;
    }

    static float[] mul(float[] fArr, float[] fArr2, int i, int i2, int i3) {
        float[] fArr3 = new float[(i * i3)];
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = (i4 * i3) + i5;
                fArr3[i6] = 0.0f;
                for (int i7 = 0; i7 < i2; i7++) {
                    fArr3[i6] = fArr3[i6] + (fArr[(i4 * i2) + i7] * fArr2[(i7 * i3) + i5]);
                }
            }
        }
        return fArr3;
    }

    static void relu(float[] fArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (fArr[i2] < 0.0f) {
                fArr[i2] = 0.0f;
            }
        }
    }

    static float[] concatenate(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[(fArr.length + fArr2.length)];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    static void softmax(float[] fArr, int i) {
        float f = Float.MIN_VALUE;
        for (int i2 = 0; i2 < i; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
            }
        }
        for (int i3 = 0; i3 < i; i3++) {
            fArr[i3] = (float) Math.exp((double) (fArr[i3] - f));
        }
        float f2 = 0.0f;
        for (int i4 = 0; i4 < i; i4++) {
            f2 += fArr[i4];
        }
        for (int i5 = 0; i5 < i; i5++) {
            fArr[i5] = fArr[i5] / f2;
        }
    }

    static float[] dense(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3) {
        float[] mul = mul(fArr, fArr2, i, i2, i3);
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = (i4 * i3) + i5;
                mul[i6] = mul[i6] + fArr3[i5];
            }
        }
        return mul;
    }

    static float[] embedding(int[] iArr, float[] fArr, int i, int i2, int i3) {
        float[] fArr2 = new float[(i * i2 * i3)];
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = iArr[(i4 * i2) + i5];
                for (int i7 = 0; i7 < i3; i7++) {
                    fArr2[(i3 * i2 * i4) + (i3 * i5) + i7] = fArr[(i6 * i3) + i7];
                }
            }
        }
        return fArr2;
    }

    static float[] transpose2D(float[] fArr, int i, int i2) {
        float[] fArr2 = new float[(i * i2)];
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                fArr2[(i4 * i) + i3] = fArr[(i3 * i2) + i4];
            }
        }
        return fArr2;
    }

    static float[] transpose3D(float[] fArr, int i, int i2, int i3) {
        float[] fArr2 = new float[(i * i2 * i3)];
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                for (int i6 = 0; i6 < i3; i6++) {
                    fArr2[(i6 * i * i2) + (i5 * i) + i4] = fArr[(i4 * i2 * i3) + (i5 * i3) + i6];
                }
            }
        }
        return fArr2;
    }

    static float[] conv1D(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        int i10 = (i2 - i8) + 1;
        float[] fArr3 = new float[(i6 * i10 * i9)];
        for (int i11 = 0; i11 < i6; i11++) {
            for (int i12 = 0; i12 < i9; i12++) {
                for (int i13 = 0; i13 < i10; i13++) {
                    int i14 = 0;
                    float f = 0.0f;
                    while (i14 < i8) {
                        float f2 = f;
                        for (int i15 = 0; i15 < i7; i15++) {
                            f2 += fArr[(i2 * i7 * i11) + ((i14 + i13) * i7) + i15] * fArr2[(((i14 * i7) + i15) * i9) + i12];
                        }
                        i14++;
                        f = f2;
                    }
                    fArr3[(i9 * i10 * i11) + (i13 * i9) + i12] = f;
                }
            }
        }
        return fArr3;
    }

    static float[] maxPool1D(float[] fArr, int i, int i2, int i3) {
        int i4 = (i - i3) + 1;
        float[] fArr2 = new float[(i4 * i2)];
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                for (int i7 = i6; i7 < i6 + i3; i7++) {
                    int i8 = (i6 * i2) + i5;
                    fArr2[i8] = Math.max(fArr2[i8], fArr[(i7 * i2) + i5]);
                }
            }
        }
        return fArr2;
    }
}
