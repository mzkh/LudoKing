package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzb;
import com.google.android.gms.internal.ads.zzdqw.zze;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdsm<T> implements zzdsv<T> {
    private final zzdsg zzhne;
    private final boolean zzhnf;
    private final zzdtn<?, ?> zzhno;
    private final zzdql<?> zzhnp;

    private zzdsm(zzdtn<?, ?> zzdtn, zzdql<?> zzdql, zzdsg zzdsg) {
        this.zzhno = zzdtn;
        this.zzhnf = zzdql.zzm(zzdsg);
        this.zzhnp = zzdql;
        this.zzhne = zzdsg;
    }

    static <T> zzdsm<T> zza(zzdtn<?, ?> zzdtn, zzdql<?> zzdql, zzdsg zzdsg) {
        return new zzdsm<>(zzdtn, zzdql, zzdsg);
    }

    public final T newInstance() {
        return this.zzhne.zzazy().zzazq();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzhno.zzay(t).equals(this.zzhno.zzay(t2))) {
            return false;
        }
        if (this.zzhnf) {
            return this.zzhnp.zzai(t).equals(this.zzhnp.zzai(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzhno.zzay(t).hashCode();
        return this.zzhnf ? (hashCode * 53) + this.zzhnp.zzai(t).hashCode() : hashCode;
    }

    public final void zzf(T t, T t2) {
        zzdsx.zza(this.zzhno, t, t2);
        if (this.zzhnf) {
            zzdsx.zza(this.zzhnp, t, t2);
        }
    }

    public final void zza(T t, zzduk zzduk) throws IOException {
        Iterator it = this.zzhnp.zzai(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzdqo zzdqo = (zzdqo) entry.getKey();
            if (zzdqo.zzazi() != zzduh.MESSAGE || zzdqo.zzazj() || zzdqo.zzazk()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzdrj) {
                zzduk.zzb(zzdqo.zzab(), (Object) ((zzdrj) entry).zzbam().zzaxg());
            } else {
                zzduk.zzb(zzdqo.zzab(), entry.getValue());
            }
        }
        zzdtn<?, ?> zzdtn = this.zzhno;
        zzdtn.zzc(zzdtn.zzay(t), zzduk);
    }

    public final void zza(T t, byte[] bArr, int i, int i2, zzdpl zzdpl) throws IOException {
        zzdqw zzdqw = (zzdqw) t;
        zzdtq zzdtq = zzdqw.zzhkr;
        if (zzdtq == zzdtq.zzbbx()) {
            zzdtq = zzdtq.zzbby();
            zzdqw.zzhkr = zzdtq;
        }
        ((zzb) t).zzazz();
        zze zze = null;
        while (i < i2) {
            int zza = zzdpi.zza(bArr, i, zzdpl);
            int i3 = zzdpl.zzhfx;
            if (i3 == 11) {
                int i4 = 0;
                Object obj = null;
                while (zza < i2) {
                    zza = zzdpi.zza(bArr, zza, zzdpl);
                    int i5 = zzdpl.zzhfx;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zze != null) {
                                zzdsr.zzbbf();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza = zzdpi.zze(bArr, zza, zzdpl);
                                obj = (zzdpm) zzdpl.zzhfz;
                            }
                        }
                    } else if (i7 == 0) {
                        zza = zzdpi.zza(bArr, zza, zzdpl);
                        i4 = zzdpl.zzhfx;
                        zze = (zze) this.zzhnp.zza(zzdpl.zzhga, this.zzhne, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzdpi.zza(i5, bArr, zza, i2, zzdpl);
                }
                if (obj != null) {
                    zzdtq.zzc((i4 << 3) | 2, obj);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zze = (zze) this.zzhnp.zza(zzdpl.zzhga, this.zzhne, i3 >>> 3);
                if (zze == null) {
                    i = zzdpi.zza(i3, bArr, zza, i2, zzdtq, zzdpl);
                } else {
                    zzdsr.zzbbf();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzdpi.zza(i3, bArr, zza, i2, zzdpl);
            }
        }
        if (i != i2) {
            throw zzdrg.zzbai();
        }
    }

    public final void zza(T t, zzdsw zzdsw, zzdqj zzdqj) throws IOException {
        boolean z;
        zzdtn<?, ?> zzdtn = this.zzhno;
        zzdql<?> zzdql = this.zzhnp;
        Object zzaz = zzdtn.zzaz(t);
        zzdqm zzaj = zzdql.zzaj(t);
        do {
            try {
                if (zzdsw.zzays() == Integer.MAX_VALUE) {
                    zzdtn.zzi(t, zzaz);
                    return;
                }
                int tag = zzdsw.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdpm zzdpm = null;
                    while (zzdsw.zzays() != Integer.MAX_VALUE) {
                        int tag2 = zzdsw.getTag();
                        if (tag2 == 16) {
                            i = zzdsw.zzayd();
                            obj = zzdql.zza(zzdqj, this.zzhne, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzdql.zza(zzdsw, obj, zzdqj, zzaj);
                            } else {
                                zzdpm = zzdsw.zzayc();
                            }
                        } else if (!zzdsw.zzayt()) {
                            break;
                        }
                    }
                    if (zzdsw.getTag() != 12) {
                        throw zzdrg.zzbag();
                    } else if (zzdpm != null) {
                        if (obj != null) {
                            zzdql.zza(zzdpm, obj, zzdqj, zzaj);
                        } else {
                            zzdtn.zza(zzaz, i, zzdpm);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzdql.zza(zzdqj, this.zzhne, tag >>> 3);
                    if (zza != null) {
                        zzdql.zza(zzdsw, zza, zzdqj, zzaj);
                    } else {
                        z = zzdtn.zza(zzaz, zzdsw);
                        continue;
                    }
                } else {
                    z = zzdsw.zzayt();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzdtn.zzi(t, zzaz);
            }
        } while (z);
    }

    public final void zzak(T t) {
        this.zzhno.zzak(t);
        this.zzhnp.zzak(t);
    }

    public final boolean zzaw(T t) {
        return this.zzhnp.zzai(t).isInitialized();
    }

    public final int zzau(T t) {
        zzdtn<?, ?> zzdtn = this.zzhno;
        int zzba = zzdtn.zzba(zzdtn.zzay(t)) + 0;
        return this.zzhnf ? zzba + this.zzhnp.zzai(t).zzazd() : zzba;
    }
}
