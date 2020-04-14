package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzq;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcno implements zzcrr<Bundle> {
    private final zzua zzbll;
    private final List<Parcelable> zzgdw;
    private final Context zzlk;

    public zzcno(Context context, zzua zzua, List<Parcelable> list) {
        this.zzlk = context;
        this.zzbll = zzua;
        this.zzgdw = list;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzq.zzkj();
        bundle.putString("activity", zzaul.zzat(this.zzlk));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("width", this.zzbll.width);
        bundle2.putInt("height", this.zzbll.height);
        bundle.putBundle("size", bundle2);
        if (this.zzgdw.size() > 0) {
            List<Parcelable> list = this.zzgdw;
            bundle.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
        }
    }
}
