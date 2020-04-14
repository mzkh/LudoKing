package com.unity3d.services.p040ar.view;

import android.os.Bundle;
import android.view.View;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.ads.adunit.IAdUnitViewHandler;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.p040ar.ARCheck;

/* renamed from: com.unity3d.services.ar.view.ARViewHandler */
public class ARViewHandler implements IAdUnitViewHandler {
    private ARView _arView;

    public void onStart(AdUnitActivity adUnitActivity) {
    }

    public void onStop(AdUnitActivity adUnitActivity) {
    }

    public boolean create(AdUnitActivity adUnitActivity) {
        if (ARCheck.isFrameworkPresent() && this._arView == null) {
            this._arView = new ARView(adUnitActivity);
        }
        return true;
    }

    public boolean destroy() {
        ARView aRView = this._arView;
        if (aRView != null) {
            ViewUtilities.removeViewFromParent(aRView);
        }
        this._arView = null;
        return true;
    }

    public View getView() {
        return this._arView;
    }

    public void onCreate(AdUnitActivity adUnitActivity, Bundle bundle) {
        create(adUnitActivity);
    }

    public void onResume(AdUnitActivity adUnitActivity) {
        ARView aRView = this._arView;
        if (aRView != null) {
            aRView.onResume();
        }
    }

    public void onPause(AdUnitActivity adUnitActivity) {
        ARView aRView = this._arView;
        if (aRView != null) {
            aRView.onPause();
        }
    }

    public void onDestroy(AdUnitActivity adUnitActivity) {
        if (adUnitActivity.isFinishing()) {
            destroy();
        }
    }
}
