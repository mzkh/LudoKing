package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzd;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdst implements zzdse {
    private final int flags;
    private final String info;
    private final Object[] zzhnb;
    private final zzdsg zzhne;

    zzdst(zzdsg zzdsg, String str, Object[] objArr) {
        this.zzhne = zzdsg;
        this.info = str;
        this.zzhnb = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzbbg() {
        return this.info;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzbbh() {
        return this.zzhnb;
    }

    public final zzdsg zzbba() {
        return this.zzhne;
    }

    public final int zzbay() {
        return (this.flags & 1) == 1 ? zzd.zzhld : zzd.zzhle;
    }

    public final boolean zzbaz() {
        return (this.flags & 2) == 2;
    }
}
