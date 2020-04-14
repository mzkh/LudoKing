package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public enum zzbz implements zzdra {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    
    private static final zzdqz<zzbz> zzeg = null;
    private final int value;

    public final int zzab() {
        return this.value;
    }

    public static zzbz zzj(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i == 2) {
            return ENUM_FAILURE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzdrc zzac() {
        return zzcb.zzep;
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

    private zzbz(int i) {
        this.value = i;
    }

    static {
        zzeg = new zzby();
    }
}
