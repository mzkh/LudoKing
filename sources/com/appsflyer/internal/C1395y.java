package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.appsflyer.internal.y */
final class C1395y implements SensorEventListener {

    /* renamed from: ʽ */
    private final int f3632;

    /* renamed from: ˊ */
    private final float[][] f3633 = new float[2][];
    @NonNull

    /* renamed from: ˋ */
    private final String f3634;

    /* renamed from: ˎ */
    private final long[] f3635 = new long[2];
    @NonNull

    /* renamed from: ˏ */
    private final String f3636;

    /* renamed from: ॱ */
    private final int f3637;

    /* renamed from: ॱॱ */
    private double f3638;

    /* renamed from: ᐝ */
    private long f3639;

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    C1395y(int i, @Nullable String str, @Nullable String str2) {
        this.f3637 = i;
        String str3 = "";
        if (str == null) {
            str = str3;
        }
        this.f3636 = str;
        if (str2 == null) {
            str2 = str3;
        }
        this.f3634 = str2;
        this.f3632 = ((((i + 31) * 31) + this.f3636.hashCode()) * 31) + this.f3634.hashCode();
    }

    /* renamed from: ˋ */
    private static double m3363(@NonNull float[] fArr, @NonNull float[] fArr2) {
        double d = 0.0d;
        for (int i = 0; i < Math.min(fArr.length, fArr2.length); i++) {
            d += StrictMath.pow((double) (fArr[i] - fArr2[i]), 2.0d);
        }
        return Math.sqrt(d);
    }

    @NonNull
    /* renamed from: ˊ */
    private static List<Float> m3361(@NonNull float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (!(sensorEvent == null || sensorEvent.values == null)) {
            Sensor sensor = sensorEvent.sensor;
            if ((sensor == null || sensor.getName() == null || sensor.getVendor() == null) ? false : true) {
                int type = sensorEvent.sensor.getType();
                String name = sensorEvent.sensor.getName();
                String vendor = sensorEvent.sensor.getVendor();
                long j = sensorEvent.timestamp;
                float[] fArr = sensorEvent.values;
                if (m3362(type, name, vendor)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    float[][] fArr2 = this.f3633;
                    float[] fArr3 = fArr2[0];
                    if (fArr3 == null) {
                        fArr2[0] = Arrays.copyOf(fArr, fArr.length);
                        this.f3635[0] = currentTimeMillis;
                        return;
                    }
                    float[] fArr4 = fArr2[1];
                    if (fArr4 == null) {
                        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                        this.f3633[1] = copyOf;
                        this.f3635[1] = currentTimeMillis;
                        this.f3638 = m3363(fArr3, copyOf);
                    } else if (50000000 <= j - this.f3639) {
                        this.f3639 = j;
                        if (Arrays.equals(fArr4, fArr)) {
                            this.f3635[1] = currentTimeMillis;
                            return;
                        }
                        double r0 = m3363(fArr3, fArr);
                        if (r0 > this.f3638) {
                            this.f3633[1] = Arrays.copyOf(fArr, fArr.length);
                            this.f3635[1] = currentTimeMillis;
                            this.f3638 = r0;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: ˊ */
    private boolean m3362(int i, @NonNull String str, @NonNull String str2) {
        return this.f3637 == i && this.f3636.equals(str) && this.f3634.equals(str2);
    }

    @NonNull
    /* renamed from: ॱ */
    private Map<String, Object> m3364() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.f3637));
        concurrentHashMap.put("sN", this.f3636);
        concurrentHashMap.put("sV", this.f3634);
        float[] fArr = this.f3633[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", m3361(fArr));
        }
        float[] fArr2 = this.f3633[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", m3361(fArr2));
        }
        return concurrentHashMap;
    }

    public final int hashCode() {
        return this.f3632;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1395y)) {
            return false;
        }
        C1395y yVar = (C1395y) obj;
        return m3362(yVar.f3637, yVar.f3636, yVar.f3634);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final void mo10858(@NonNull Map<C1395y, Map<String, Object>> map, boolean z) {
        if (this.f3633[0] != null) {
            map.put(this, m3364());
            if (z) {
                for (int i = 0; i < 2; i++) {
                    this.f3633[i] = null;
                }
                for (int i2 = 0; i2 < 2; i2++) {
                    this.f3635[i2] = 0;
                }
                this.f3638 = 0.0d;
                this.f3639 = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, m3364());
        }
    }
}
