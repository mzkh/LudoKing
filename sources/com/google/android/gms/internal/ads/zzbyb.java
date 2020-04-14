package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyb extends zzach {
    private final zzbur zzfjl;
    /* access modifiers changed from: private */
    public final zzbuj zzfml;
    private final zzbvj zzfpm;
    private final Context zzzc;

    public zzbyb(Context context, zzbur zzbur, zzbvj zzbvj, zzbuj zzbuj) {
        this.zzzc = context;
        this.zzfjl = zzbur;
        this.zzfpm = zzbvj;
        this.zzfml = zzbuj;
    }

    public final IObjectWrapper zzqm() {
        return null;
    }

    public final String zzco(String str) {
        return (String) this.zzfjl.zzahz().get(str);
    }

    public final zzabi zzcp(String str) {
        return (zzabi) this.zzfjl.zzahx().get(str);
    }

    public final List<String> getAvailableAssetNames() {
        SimpleArrayMap zzahx = this.zzfjl.zzahx();
        SimpleArrayMap zzahz = this.zzfjl.zzahz();
        String[] strArr = new String[(zzahx.size() + zzahz.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzahx.size()) {
            strArr[i3] = (String) zzahx.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzahz.size()) {
            strArr[i3] = (String) zzahz.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.zzfjl.getCustomTemplateId();
    }

    public final void performClick(String str) {
        this.zzfml.zzfp(str);
    }

    public final void recordImpression() {
        this.zzfml.zzahd();
    }

    public final zzwr getVideoController() {
        return this.zzfjl.getVideoController();
    }

    public final void destroy() {
        this.zzfml.destroy();
    }

    public final IObjectWrapper zzqr() {
        return ObjectWrapper.wrap(this.zzzc);
    }

    public final boolean zzu(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || !this.zzfpm.zza((ViewGroup) unwrap)) {
            return false;
        }
        this.zzfjl.zzahu().zza((zzaaw) new zzbya(this));
        return true;
    }

    public final boolean zzqs() {
        if (this.zzfml.zzahl() && this.zzfjl.zzahv() != null && this.zzfjl.zzahu() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzqt() {
        IObjectWrapper zzahw = this.zzfjl.zzahw();
        if (zzahw != null) {
            zzq.zzky().zzae(zzahw);
            return true;
        }
        zzaug.zzeu("Trying to start OMID session before creation.");
        return false;
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzfjl.zzahw() != null) {
            this.zzfml.zzy((View) unwrap);
        }
    }

    public final void zzqu() {
        String zzahy = this.zzfjl.zzahy();
        if ("Google".equals(zzahy)) {
            zzaug.zzeu("Illegal argument specified for omid partner name.");
        } else {
            this.zzfml.zzg(zzahy, false);
        }
    }
}
