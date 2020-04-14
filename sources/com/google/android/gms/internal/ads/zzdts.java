package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public final class zzdts extends AbstractList<String> implements zzdrn, RandomAccess {
    /* access modifiers changed from: private */
    public final zzdrn zzhot;

    public zzdts(zzdrn zzdrn) {
        this.zzhot = zzdrn;
    }

    public final zzdrn zzbao() {
        return this;
    }

    public final Object zzgq(int i) {
        return this.zzhot.zzgq(i);
    }

    public final int size() {
        return this.zzhot.size();
    }

    public final void zzdb(zzdpm zzdpm) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzdtr(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzdtu(this);
    }

    public final List<?> zzban() {
        return this.zzhot.zzban();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzhot.get(i);
    }
}
