package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public enum zzbv implements zzdra {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3);
    
    private static final zzdqz<zzbv> zzeg = null;
    private final int value;

    public final int zzab() {
        return this.value;
    }

    public static zzbv zzi(int i) {
        if (i == 0) {
            return UNKNOWN_ENCRYPTION_METHOD;
        }
        if (i == 1) {
            return BITSLICER;
        }
        if (i == 2) {
            return TINK_HYBRID;
        }
        if (i != 3) {
            return null;
        }
        return UNENCRYPTED;
    }

    public static zzdrc zzac() {
        return zzbw.zzep;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=");
        sb.append(this.value);
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    private zzbv(int i) {
        this.value = i;
    }

    static {
        zzeg = new zzbx();
    }
}
