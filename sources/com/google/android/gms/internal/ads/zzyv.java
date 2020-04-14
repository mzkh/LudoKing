package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzyv {
    private final Collection<zzyp<?>> zzcft = new ArrayList();
    private final Collection<zzyp<String>> zzcfu = new ArrayList();
    private final Collection<zzyp<String>> zzcfv = new ArrayList();

    public final void zza(zzyp zzyp) {
        this.zzcft.add(zzyp);
    }

    public final void zzb(zzyp<String> zzyp) {
        this.zzcfu.add(zzyp);
    }

    public final void zzc(zzyp<String> zzyp) {
        this.zzcfv.add(zzyp);
    }

    public final void zza(Editor editor, int i, JSONObject jSONObject) {
        for (zzyp zzyp : this.zzcft) {
            if (zzyp.getSource() == 1) {
                zzyp.zza(editor, zzyp.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
            return;
        }
        zzaxi.zzes("Flag Json is null.");
    }

    public final List<String> zzpr() {
        ArrayList arrayList = new ArrayList();
        for (zzyp zzd : this.zzcfu) {
            String str = (String) zzuv.zzon().zzd(zzd);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> zzps() {
        List<String> zzpr = zzpr();
        for (zzyp zzd : this.zzcfv) {
            String str = (String) zzuv.zzon().zzd(zzd);
            if (str != null) {
                zzpr.add(str);
            }
        }
        return zzpr;
    }
}
