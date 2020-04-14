package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdau<E> extends zzdbx<E> {
    private int position;
    private final int size;

    protected zzdau(int i, int i2) {
        zzdaq.zzs(i2, i);
        this.size = i;
        this.position = i2;
    }

    /* access modifiers changed from: protected */
    public abstract E get(int i);

    public final boolean hasNext() {
        return this.position < this.size;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.position;
            this.position = i + 1;
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.position;
    }

    public final boolean hasPrevious() {
        return this.position > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.position - 1;
            this.position = i;
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.position - 1;
    }
}
