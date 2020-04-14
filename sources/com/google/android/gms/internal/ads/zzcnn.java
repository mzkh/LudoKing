package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnn implements zzcru<zzcno> {
    private final zzcwe zzfga;
    private final zzddl zzgdu;
    private final View zzgdv;
    private final Context zzlk;

    public zzcnn(zzddl zzddl, Context context, zzcwe zzcwe, @Nullable ViewGroup viewGroup) {
        this.zzgdu = zzddl;
        this.zzlk = context;
        this.zzfga = zzcwe;
        this.zzgdv = viewGroup;
    }

    public final zzddi<zzcno> zzalv() {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcje)).booleanValue()) {
            return zzdcy.zzi(new Exception("Ad Key signal disabled."));
        }
        return this.zzgdu.zzd(new zzcnq(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcno zzalw() throws Exception {
        Context context = this.zzlk;
        zzua zzua = this.zzfga.zzbll;
        ArrayList arrayList = new ArrayList();
        View view = this.zzgdv;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzcno(context, zzua, arrayList);
    }
}
