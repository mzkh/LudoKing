package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdbj<E> extends zzdbb<E> {
    private int zzafv;
    @NullableDecl
    private Object[] zzgpl;

    public zzdbj() {
        super(4);
    }

    zzdbj(int i) {
        super(i);
        this.zzgpl = new Object[zzdbg.zzdr(i)];
    }

    public final zzdbg<E> zzaov() {
        zzdbt zzdbt;
        int i = this.size;
        if (i == 0) {
            return zzdbt.zzgpu;
        }
        if (i == 1) {
            return zzdbg.zzae(this.zzgoz[0]);
        }
        if (this.zzgpl == null || zzdbg.zzdr(this.size) != this.zzgpl.length) {
            zzdbg zzb = zzdbg.zza(this.size, this.zzgoz);
            this.size = zzb.size();
            zzdbt = zzb;
        } else {
            Object[] copyOf = zzdbg.zzu(this.size, this.zzgoz.length) ? Arrays.copyOf(this.zzgoz, this.size) : this.zzgoz;
            int i2 = this.zzafv;
            Object[] objArr = this.zzgpl;
            zzdbt zzdbt2 = new zzdbt(copyOf, i2, objArr, objArr.length - 1, this.size);
            zzdbt = zzdbt2;
        }
        this.zzgpa = true;
        this.zzgpl = null;
        return zzdbt;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Iterable, code=java.lang.Iterable<java.lang.Object>, for r2v0, types: [java.lang.Iterable<java.lang.Object>, java.lang.Object, java.lang.Iterable] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzdba zze(java.lang.Iterable<java.lang.Object> r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzdaq.checkNotNull(r2)
            java.lang.Object[] r0 = r1.zzgpl
            if (r0 == 0) goto L_0x0019
            java.util.Iterator r2 = r2.iterator()
        L_0x000b:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x001c
            java.lang.Object r0 = r2.next()
            r1.zzab(r0)
            goto L_0x000b
        L_0x0019:
            super.zze(r2)
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdbj.zze(java.lang.Iterable):com.google.android.gms.internal.ads.zzdba");
    }

    public final /* synthetic */ zzdbb zzac(Object obj) {
        return (zzdbj) zzab(obj);
    }

    public final /* synthetic */ zzdba zza(Iterator it) {
        zzdaq.checkNotNull(it);
        while (it.hasNext()) {
            zzab(it.next());
        }
        return this;
    }

    public final /* synthetic */ zzdba zzab(Object obj) {
        zzdaq.checkNotNull(obj);
        if (this.zzgpl != null) {
            int zzdr = zzdbg.zzdr(this.size);
            Object[] objArr = this.zzgpl;
            if (zzdr <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int zzdp = zzdaz.zzdp(hashCode);
                while (true) {
                    int i = zzdp & length;
                    Object[] objArr2 = this.zzgpl;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zzdp = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zzafv += hashCode;
                        super.zzab(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzgpl = null;
        super.zzab(obj);
        return this;
    }
}
