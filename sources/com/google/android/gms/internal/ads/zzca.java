package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public enum zzca implements zzdra {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);
    
    private static final zzdqz<zzca> zzeg = null;
    private final int value;

    public final int zzab() {
        return this.value;
    }

    public static zzca zzk(int i) {
        if (i == 0) {
            return UNKNOWN_PROTO;
        }
        if (i == 1) {
            return AFMA_SIGNALS;
        }
        if (i == 2) {
            return UNITY_SIGNALS;
        }
        if (i != 3) {
            return null;
        }
        return PARTNER_SIGNALS;
    }

    public static zzdrc zzac() {
        return zzcc.zzep;
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

    private zzca(int i) {
        this.value = i;
    }

    static {
        zzeg = new zzcd();
    }
}
