package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzlv implements zzlu {
    private final zzhd zzacv = new zzhd();
    private final zzlu[] zzbbf;
    private final ArrayList<zzlu> zzbbg;
    private zzlt zzbbh;
    private zzgy zzbbi;
    private Object zzbbj;
    private int zzbbk = -1;
    private zzlx zzbbl;

    public zzlv(zzlu... zzluArr) {
        this.zzbbf = zzluArr;
        this.zzbbg = new ArrayList<>(Arrays.asList(zzluArr));
    }

    public final void zza(zzgc zzgc, boolean z, zzlt zzlt) {
        this.zzbbh = zzlt;
        int i = 0;
        while (true) {
            zzlu[] zzluArr = this.zzbbf;
            if (i < zzluArr.length) {
                zzluArr[i].zza(zzgc, false, new zzly(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzhl() throws IOException {
        zzlx zzlx = this.zzbbl;
        if (zzlx == null) {
            for (zzlu zzhl : this.zzbbf) {
                zzhl.zzhl();
            }
            return;
        }
        throw zzlx;
    }

    public final zzls zza(int i, zznc zznc) {
        zzls[] zzlsArr = new zzls[this.zzbbf.length];
        for (int i2 = 0; i2 < zzlsArr.length; i2++) {
            zzlsArr[i2] = this.zzbbf[i2].zza(i, zznc);
        }
        return new zzlw(zzlsArr);
    }

    public final void zzb(zzls zzls) {
        zzlw zzlw = (zzlw) zzls;
        int i = 0;
        while (true) {
            zzlu[] zzluArr = this.zzbbf;
            if (i < zzluArr.length) {
                zzluArr[i].zzb(zzlw.zzbbm[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzhm() {
        for (zzlu zzhm : this.zzbbf) {
            zzhm.zzhm();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(int i, zzgy zzgy, Object obj) {
        zzlx zzlx;
        if (this.zzbbl == null) {
            int zzep = zzgy.zzep();
            int i2 = 0;
            while (true) {
                if (i2 >= zzep) {
                    if (this.zzbbk == -1) {
                        this.zzbbk = zzgy.zzeq();
                    } else if (zzgy.zzeq() != this.zzbbk) {
                        zzlx = new zzlx(1);
                    }
                    zzlx = null;
                } else if (zzgy.zza(i2, this.zzacv, false).zzagt) {
                    zzlx = new zzlx(0);
                    break;
                } else {
                    i2++;
                }
            }
            this.zzbbl = zzlx;
        }
        if (this.zzbbl == null) {
            this.zzbbg.remove(this.zzbbf[i]);
            if (i == 0) {
                this.zzbbi = zzgy;
                this.zzbbj = obj;
            }
            if (this.zzbbg.isEmpty()) {
                this.zzbbh.zzb(this.zzbbi, this.zzbbj);
            }
        }
    }
}
