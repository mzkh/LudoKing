package com.unity3d.services.p040ar.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.view.Display;
import android.view.WindowManager;
import com.google.ar.core.Session;

@TargetApi(23)
/* renamed from: com.unity3d.services.ar.view.DisplayRotationHelper */
public class DisplayRotationHelper implements DisplayListener {
    private final Context context;
    private final Display display;
    private boolean viewportChanged;
    private int viewportHeight;
    private int viewportWidth;

    public void onDisplayAdded(int i) {
    }

    public void onDisplayRemoved(int i) {
    }

    DisplayRotationHelper(Context context2) {
        this.context = context2;
        this.display = ((WindowManager) context2.getSystemService(WindowManager.class)).getDefaultDisplay();
    }

    /* access modifiers changed from: 0000 */
    public void onResume() {
        ((DisplayManager) this.context.getSystemService(DisplayManager.class)).registerDisplayListener(this, null);
    }

    /* access modifiers changed from: 0000 */
    public void onPause() {
        ((DisplayManager) this.context.getSystemService(DisplayManager.class)).unregisterDisplayListener(this);
    }

    /* access modifiers changed from: 0000 */
    public void onSurfaceChanged(int i, int i2) {
        this.viewportWidth = i;
        this.viewportHeight = i2;
        this.viewportChanged = true;
    }

    /* access modifiers changed from: 0000 */
    public void updateSessionIfNeeded(Session session) {
        if (this.viewportChanged) {
            session.setDisplayGeometry(this.display.getRotation(), this.viewportWidth, this.viewportHeight);
            this.viewportChanged = false;
        }
    }

    public int getRotation() {
        return this.display.getRotation();
    }

    public void onDisplayChanged(int i) {
        this.viewportChanged = true;
    }
}
