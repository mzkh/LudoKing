package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbye implements zzaer<Object> {
    private final zzdvv<zzbyb> zzfkw;
    private final zzbyh zzfnd;
    @Nullable
    private final zzaco zzfpn;

    public zzbye(zzbuy zzbuy, zzbur zzbur, zzbyh zzbyh, zzdvv<zzbyb> zzdvv) {
        this.zzfpn = zzbuy.zzfv(zzbur.getCustomTemplateId());
        this.zzfnd = zzbyh;
        this.zzfkw = zzdvv;
    }

    public final void zzajf() {
        if (this.zzfpn != null) {
            this.zzfnd.zza("/nativeAdCustomClick", (zzaer<Object>) this);
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("asset");
        try {
            this.zzfpn.zza((zzace) this.zzfkw.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzaug.zzd(sb.toString(), e);
        }
    }
}
