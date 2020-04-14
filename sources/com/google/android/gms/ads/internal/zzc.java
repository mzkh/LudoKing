package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzasi;
import com.google.android.gms.internal.ads.zzaul;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzc {
    private boolean zzbkr;
    private zzasi zzbks;
    private zzaop zzbkt = null;
    private final Context zzlk;

    public zzc(Context context, zzasi zzasi, zzaop zzaop) {
        this.zzlk = context;
        this.zzbks = zzasi;
        if (this.zzbkt == null) {
            this.zzbkt = new zzaop();
        }
    }

    private final boolean zzjj() {
        zzasi zzasi = this.zzbks;
        return (zzasi != null && zzasi.zztm().zzdpb) || this.zzbkt.zzdlt;
    }

    public final void recordClick() {
        this.zzbkr = true;
    }

    public final boolean zzjk() {
        return !zzjj() || this.zzbkr;
    }

    public final void zzbl(@Nullable String str) {
        if (zzjj()) {
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            zzasi zzasi = this.zzbks;
            if (zzasi != null) {
                zzasi.zza(str, null, 3);
                return;
            }
            if (this.zzbkt.zzdlt && this.zzbkt.zzdlu != null) {
                for (String str3 : this.zzbkt.zzdlu) {
                    if (!TextUtils.isEmpty(str3)) {
                        String replace = str3.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzq.zzkj();
                        zzaul.zzb(this.zzlk, str2, replace);
                    }
                }
            }
        }
    }
}
