package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdtt {
    private static final Logger logger = Logger.getLogger(zzdtt.class.getName());
    private static final Unsafe zzgqj = zzbcc();
    private static final Class<?> zzhft = zzdpj.zzaxm();
    private static final boolean zzhgx = zzbcd();
    private static final boolean zzhou = zzm(Long.TYPE);
    private static final boolean zzhov = zzm(Integer.TYPE);
    private static final zzd zzhow;
    private static final boolean zzhox = zzbce();
    static final long zzhoy = ((long) zzk(byte[].class));
    private static final long zzhoz = ((long) zzk(boolean[].class));
    private static final long zzhpa = ((long) zzl(boolean[].class));
    private static final long zzhpb = ((long) zzk(int[].class));
    private static final long zzhpc = ((long) zzl(int[].class));
    private static final long zzhpd = ((long) zzk(long[].class));
    private static final long zzhpe = ((long) zzl(long[].class));
    private static final long zzhpf = ((long) zzk(float[].class));
    private static final long zzhpg = ((long) zzl(float[].class));
    private static final long zzhph = ((long) zzk(double[].class));
    private static final long zzhpi = ((long) zzl(double[].class));
    private static final long zzhpj = ((long) zzk(Object[].class));
    private static final long zzhpk = ((long) zzl(Object[].class));
    private static final long zzhpl;
    private static final int zzhpm = ((int) (zzhoy & 7));
    static final boolean zzhpn = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzdtt.zzhpn) {
                return zzdtt.zzq(obj, j);
            }
            return zzdtt.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzdtt.zzhpn) {
                zzdtt.zza(obj, j, b);
            } else {
                zzdtt.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzdtt.zzhpn) {
                return zzdtt.zzs(obj, j);
            }
            return zzdtt.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzdtt.zzhpn) {
                zzdtt.zzb(obj, j, z);
            } else {
                zzdtt.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            this.zzhpq.putByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzhpq.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzhpq.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzhpq.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzhpq.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzhpq.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzhpq.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzhpq.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzhpq.putDouble(obj, j, d);
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzhpq.copyMemory(bArr, zzdtt.zzhoy + j, null, j2, j3);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzdtt.zzhpn) {
                return zzdtt.zzq(obj, j);
            }
            return zzdtt.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzdtt.zzhpn) {
                zzdtt.zza(obj, j, b);
            } else {
                zzdtt.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzdtt.zzhpn) {
                return zzdtt.zzs(obj, j);
            }
            return zzdtt.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzdtt.zzhpn) {
                zzdtt.zzb(obj, j, z);
            } else {
                zzdtt.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static abstract class zzd {
        Unsafe zzhpq;

        zzd(Unsafe unsafe) {
            this.zzhpq = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzhpq.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzhpq.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzhpq.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzhpq.putLong(obj, j, j2);
        }
    }

    private zzdtt() {
    }

    static boolean zzbca() {
        return zzhgx;
    }

    static boolean zzbcb() {
        return zzhox;
    }

    static <T> T zzj(Class<T> cls) {
        try {
            return zzgqj.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzk(Class<?> cls) {
        if (zzhgx) {
            return zzhow.zzhpq.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzl(Class<?> cls) {
        if (zzhgx) {
            return zzhow.zzhpq.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzhow.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzhow.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzhow.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzhow.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzhow.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzhow.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzhow.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzhow.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzhow.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzhow.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzhow.zzhpq.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzhow.zzhpq.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzhow.zzy(bArr, zzhoy + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzhow.zze(bArr, zzhoy + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzhow.zza(bArr, j, j2, j3);
    }

    static void zza(long j, byte b) {
        zzhow.zza(j, b);
    }

    static long zzn(ByteBuffer byteBuffer) {
        return zzhow.zzl(byteBuffer, zzhpl);
    }

    static Unsafe zzbcc() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzdtv());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbcd() {
        Unsafe unsafe = zzgqj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzdpj.zzaxl()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzbce() {
        String str = "copyMemory";
        String str2 = "getLong";
        Unsafe unsafe = zzgqj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod(str2, new Class[]{Object.class, Long.TYPE});
            if (zzbcf() == null) {
                return false;
            }
            if (zzdpj.zzaxl()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod(str2, new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzm(Class<?> cls) {
        if (!zzdpj.zzaxl()) {
            return false;
        }
        try {
            Class<?> cls2 = zzhft;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzbcf() {
        if (zzdpj.zzaxl()) {
            Field zzb2 = zzb(Buffer.class, "effectiveDirectAddress");
            if (zzb2 != null) {
                return zzb2;
            }
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fe  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzdtt> r0 = com.google.android.gms.internal.ads.zzdtt.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzbcc()
            zzgqj = r0
            java.lang.Class r0 = com.google.android.gms.internal.ads.zzdpj.zzaxm()
            zzhft = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzm(r0)
            zzhou = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzm(r0)
            zzhov = r0
            sun.misc.Unsafe r0 = zzgqj
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0053
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.ads.zzdpj.zzaxl()
            if (r0 == 0) goto L_0x004c
            boolean r0 = zzhou
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.ads.zzdtt$zzc r1 = new com.google.android.gms.internal.ads.zzdtt$zzc
            sun.misc.Unsafe r0 = zzgqj
            r1.<init>(r0)
            goto L_0x0053
        L_0x0040:
            boolean r0 = zzhov
            if (r0 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzdtt$zza r1 = new com.google.android.gms.internal.ads.zzdtt$zza
            sun.misc.Unsafe r0 = zzgqj
            r1.<init>(r0)
            goto L_0x0053
        L_0x004c:
            com.google.android.gms.internal.ads.zzdtt$zzb r1 = new com.google.android.gms.internal.ads.zzdtt$zzb
            sun.misc.Unsafe r0 = zzgqj
            r1.<init>(r0)
        L_0x0053:
            zzhow = r1
            boolean r0 = zzbce()
            zzhox = r0
            boolean r0 = zzbcd()
            zzhgx = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzhoy = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzhoz = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzhpa = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzhpb = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzhpc = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzhpd = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzhpe = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzhpf = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzhpg = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzhph = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzhpi = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzhpj = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzhpk = r0
            java.lang.reflect.Field r0 = zzbcf()
            if (r0 == 0) goto L_0x00e8
            com.google.android.gms.internal.ads.zzdtt$zzd r1 = zzhow
            if (r1 != 0) goto L_0x00e1
            goto L_0x00e8
        L_0x00e1:
            sun.misc.Unsafe r1 = r1.zzhpq
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00ea
        L_0x00e8:
            r0 = -1
        L_0x00ea:
            zzhpl = r0
            long r0 = zzhoy
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzhpm = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00fe
            r0 = 1
            goto L_0x00ff
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            zzhpn = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtt.<clinit>():void");
    }
}
