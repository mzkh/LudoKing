package com.google.android.gms.internal.ads;

import java.util.Random;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzuv {
    private static zzuv zzcdo = new zzuv();
    private final zzawy zzcdp;
    private final zzug zzcdq;
    private final String zzcdr;
    private final zzyv zzcds;
    private final zzyx zzcdt;
    private final zzyw zzcdu;
    private final zzaxl zzcdv;
    private final Random zzcdw;
    private final WeakHashMap<Object, String> zzcdx;

    protected zzuv() {
        zzawy zzawy = new zzawy();
        zzug zzug = new zzug(new zztv(), new zzts(), new zzxn(), new zzadn(), new zzaqm(), new zzarq(), new zzanm(), new zzadm());
        this(zzawy, zzug, new zzyv(), new zzyx(), new zzyw(), zzawy.zzwl(), new zzaxl(0, 15601000, true), new Random(), new WeakHashMap());
    }

    private zzuv(zzawy zzawy, zzug zzug, zzyv zzyv, zzyx zzyx, zzyw zzyw, String str, zzaxl zzaxl, Random random, WeakHashMap<Object, String> weakHashMap) {
        this.zzcdp = zzawy;
        this.zzcdq = zzug;
        this.zzcds = zzyv;
        this.zzcdt = zzyx;
        this.zzcdu = zzyw;
        this.zzcdr = str;
        this.zzcdv = zzaxl;
        this.zzcdw = random;
        this.zzcdx = weakHashMap;
    }

    public static zzawy zzoj() {
        return zzcdo.zzcdp;
    }

    public static zzug zzok() {
        return zzcdo.zzcdq;
    }

    public static zzyx zzol() {
        return zzcdo.zzcdt;
    }

    public static zzyv zzom() {
        return zzcdo.zzcds;
    }

    public static zzyw zzon() {
        return zzcdo.zzcdu;
    }

    public static String zzoo() {
        return zzcdo.zzcdr;
    }

    public static zzaxl zzop() {
        return zzcdo.zzcdv;
    }

    public static Random zzoq() {
        return zzcdo.zzcdw;
    }
}
