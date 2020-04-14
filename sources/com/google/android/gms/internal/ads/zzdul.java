package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdul;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzdul<M extends zzdul<M>> extends zzdus {
    protected zzdun zzhqy;

    /* access modifiers changed from: protected */
    public int zznx() {
        if (this.zzhqy != null) {
            for (int i = 0; i < this.zzhqy.size(); i++) {
                this.zzhqy.zzhf(i).zznx();
            }
        }
        return 0;
    }

    public void zza(zzduj zzduj) throws IOException {
        if (this.zzhqy != null) {
            for (int i = 0; i < this.zzhqy.size(); i++) {
                this.zzhqy.zzhf(i).zza(zzduj);
            }
        }
    }

    public final /* synthetic */ zzdus zzbci() throws CloneNotSupportedException {
        return (zzdul) clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdul zzdul = (zzdul) super.clone();
        zzdup.zza(this, zzdul);
        return zzdul;
    }
}
