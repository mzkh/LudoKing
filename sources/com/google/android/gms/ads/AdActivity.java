package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzano;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzuv;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class AdActivity extends Activity {
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    @KeepForSdk
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzano zzaaw;

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzaaw = zzuv.zzok().zzb((Activity) this);
        zzano zzano = this.zzaaw;
        String str = "#007 Could not call remote method.";
        if (zzano == null) {
            zzaxi.zze(str, null);
            finish();
            return;
        }
        try {
            zzano.onCreate(bundle);
        } catch (RemoteException e) {
            zzaxi.zze(str, e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onRestart();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onStart();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onResume();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onPause();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onStop();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onDestroy();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    private final void zzda() {
        zzano zzano = this.zzaaw;
        if (zzano != null) {
            try {
                zzano.zzda();
            } catch (RemoteException e) {
                zzaxi.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zzda();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zzda();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzda();
    }

    public final void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzaaw != null) {
                z = this.zzaaw.zzsp();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzaaw.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzaaw.zzag(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
