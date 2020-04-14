package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzazg implements SensorEventListener {
    private final SensorManager zzdzb;
    private final Object zzdzc = new Object();
    private final Display zzdzd;
    private final float[] zzdze = new float[9];
    private final float[] zzdzf = new float[9];
    @GuardedBy("sensorThreadLock")
    private float[] zzdzg;
    private Handler zzdzh;
    private zzazi zzdzi;

    zzazg(Context context) {
        this.zzdzb = (SensorManager) context.getSystemService("sensor");
        this.zzdzd = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* access modifiers changed from: 0000 */
    public final void start() {
        if (this.zzdzh == null) {
            Sensor defaultSensor = this.zzdzb.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzaug.zzes("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.zzdzh = new zzdac(handlerThread.getLooper());
            if (!this.zzdzb.registerListener(this, defaultSensor, 0, this.zzdzh)) {
                zzaug.zzes("SensorManager.registerListener failed.");
                stop();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void stop() {
        if (this.zzdzh != null) {
            this.zzdzb.unregisterListener(this);
            this.zzdzh.post(new zzazf(this));
            this.zzdzh = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzazi zzazi) {
        this.zzdzi = zzazi;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzdzc) {
                if (this.zzdzg == null) {
                    this.zzdzg = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzdze, fArr);
            int rotation = this.zzdzd.getRotation();
            if (rotation == 1) {
                SensorManager.remapCoordinateSystem(this.zzdze, 2, 129, this.zzdzf);
            } else if (rotation == 2) {
                SensorManager.remapCoordinateSystem(this.zzdze, 129, 130, this.zzdzf);
            } else if (rotation != 3) {
                System.arraycopy(this.zzdze, 0, this.zzdzf, 0, 9);
            } else {
                SensorManager.remapCoordinateSystem(this.zzdze, 130, 1, this.zzdzf);
            }
            zzk(1, 3);
            zzk(2, 6);
            zzk(5, 7);
            synchronized (this.zzdzc) {
                System.arraycopy(this.zzdzf, 0, this.zzdzg, 0, 9);
            }
            zzazi zzazi = this.zzdzi;
            if (zzazi != null) {
                zzazi.zzst();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(float[] fArr) {
        synchronized (this.zzdzc) {
            if (this.zzdzg == null) {
                return false;
            }
            System.arraycopy(this.zzdzg, 0, fArr, 0, this.zzdzg.length);
            return true;
        }
    }

    private final void zzk(int i, int i2) {
        float[] fArr = this.zzdzf;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }
}
