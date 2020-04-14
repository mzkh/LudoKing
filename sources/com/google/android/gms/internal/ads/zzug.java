package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class zzug {
    /* access modifiers changed from: private */
    public final zztv zzccu;
    /* access modifiers changed from: private */
    public final zzts zzccv;
    /* access modifiers changed from: private */
    public final zzxn zzccw;
    /* access modifiers changed from: private */
    public final zzadn zzccx;
    /* access modifiers changed from: private */
    public final zzaqm zzccy;
    private final zzarq zzccz;
    /* access modifiers changed from: private */
    public final zzanm zzcda;
    /* access modifiers changed from: private */
    public final zzadm zzcdb;

    public zzug(zztv zztv, zzts zzts, zzxn zzxn, zzadn zzadn, zzaqm zzaqm, zzarq zzarq, zzanm zzanm, zzadm zzadm) {
        this.zzccu = zztv;
        this.zzccv = zzts;
        this.zzccw = zzxn;
        this.zzccx = zzadn;
        this.zzccy = zzaqm;
        this.zzccz = zzarq;
        this.zzcda = zzanm;
        this.zzcdb = zzadm;
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "no_ads_fallback");
        bundle.putString("flow", str);
        zzuv.zzoj().zza(context, zzuv.zzop().zzblz, "gmob-apps", bundle, true);
    }

    public final zzvl zza(Context context, zzua zzua, String str, zzajx zzajx) {
        zzuk zzuk = new zzuk(this, context, zzua, str, zzajx);
        return (zzvl) zzuk.zzd(context, false);
    }

    public final zzve zzb(Context context, String str, zzajx zzajx) {
        return (zzve) new zzup(this, context, str, zzajx).zzd(context, false);
    }

    public final zzabm zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzabm) new zzur(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzabt zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzabt) new zzuq(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzara zzc(Context context, String str, zzajx zzajx) {
        return (zzara) new zzui(this, context, str, zzajx).zzd(context, false);
    }

    @Nullable
    public final zzano zzb(Activity activity) {
        zzul zzul = new zzul(this, activity);
        Intent intent = activity.getIntent();
        String str = "com.google.android.gms.ads.internal.overlay.useClientJar";
        boolean z = false;
        if (!intent.hasExtra(str)) {
            zzaxi.zzes("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra(str, false);
        }
        return (zzano) zzul.zzd(activity, z);
    }
}
