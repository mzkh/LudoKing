package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw;
import com.google.android.gms.internal.ads.zzdqw.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public abstract class zzdqw<MessageType extends zzdqw<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdpf<MessageType, BuilderType> {
    private static Map<Object, zzdqw<?, ?>> zzhkt = new ConcurrentHashMap();
    protected zzdtq zzhkr = zzdtq.zzbbx();
    private int zzhks = -1;

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    public static abstract class zza<MessageType extends zzdqw<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdpe<MessageType, BuilderType> {
        private final MessageType zzhko;
        protected MessageType zzhkp;
        private boolean zzhkq = false;

        protected zza(MessageType messagetype) {
            this.zzhko = messagetype;
            this.zzhkp = (zzdqw) messagetype.zza(zzd.zzhky, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzazn() {
            if (this.zzhkq) {
                MessageType messagetype = (zzdqw) this.zzhkp.zza(zzd.zzhky, (Object) null, (Object) null);
                zza(messagetype, this.zzhkp);
                this.zzhkp = messagetype;
                this.zzhkq = false;
            }
        }

        public final boolean isInitialized() {
            return zzdqw.zza(this.zzhkp, false);
        }

        /* renamed from: zzazo */
        public MessageType zzazq() {
            if (this.zzhkq) {
                return this.zzhkp;
            }
            MessageType messagetype = this.zzhkp;
            zzdsr.zzbbf().zzax(messagetype).zzak(messagetype);
            this.zzhkq = true;
            return this.zzhkp;
        }

        /* renamed from: zzazp */
        public final MessageType zzazr() {
            MessageType messagetype = (zzdqw) zzazq();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzdto(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzazn();
            zza(this.zzhkp, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzdsr.zzbbf().zzax(messagetype).zzf(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzdqj zzdqj) throws zzdrg {
            zzazn();
            try {
                zzdsr.zzbbf().zzax(this.zzhkp).zza(this.zzhkp, bArr, 0, i2 + 0, new zzdpl(zzdqj));
                return this;
            } catch (zzdrg e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzdrg.zzbac();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzdpy zzdpy, zzdqj zzdqj) throws IOException {
            zzazn();
            try {
                zzdsr.zzbbf().zzax(this.zzhkp).zza(this.zzhkp, zzdqd.zza(zzdpy), zzdqj);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzdpe zza(byte[] bArr, int i, int i2, zzdqj zzdqj) throws zzdrg {
            return zzb(bArr, 0, i2, zzdqj);
        }

        public final /* synthetic */ zzdpe zzaxf() {
            return (zza) clone();
        }

        public final /* synthetic */ zzdsg zzazs() {
            return this.zzhko;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzdqw) this.zzhko).zza(zzd.zzhkz, (Object) null, (Object) null);
            zza.zza((MessageType) (zzdqw) zzazq());
            return zza;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzdqw<MessageType, BuilderType> implements zzdsi {
        protected zzdqm<Object> zzhku = zzdqm.zzazc();

        /* access modifiers changed from: 0000 */
        public final zzdqm<Object> zzazz() {
            if (this.zzhku.isImmutable()) {
                this.zzhku = (zzdqm) this.zzhku.clone();
            }
            return this.zzhku;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    public static class zzc<T extends zzdqw<T, ?>> extends zzdph<T> {
        private final T zzhko;

        public zzc(T t) {
            this.zzhko = t;
        }
    }

    /* 'enum' access flag removed */
    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    public static final class zzd {
        public static final int zzhkv = 1;
        public static final int zzhkw = 2;
        public static final int zzhkx = 3;
        public static final int zzhky = 4;
        public static final int zzhkz = 5;
        public static final int zzhla = 6;
        public static final int zzhlb = 7;
        private static final /* synthetic */ int[] zzhlc = {zzhkv, zzhkw, zzhkx, zzhky, zzhkz, zzhla, zzhlb};
        public static final int zzhld = 1;
        public static final int zzhle = 2;
        private static final /* synthetic */ int[] zzhlf = {zzhld, zzhle};
        public static final int zzhlg = 1;
        public static final int zzhlh = 2;
        private static final /* synthetic */ int[] zzhli = {zzhlg, zzhlh};

        public static int[] zzbaa() {
            return (int[]) zzhlc.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    public static class zze<ContainingType extends zzdsg, Type> extends zzdqh<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzdsh.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzhfq != 0) {
            return this.zzhfq;
        }
        this.zzhfq = zzdsr.zzbbf().zzax(this).hashCode(this);
        return this.zzhfq;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzdqw) zza(zzd.zzhla, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzdsr.zzbbf().zzax(this).equals(this, (zzdqw) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzdqw<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzazt() {
        return (zza) zza(zzd.zzhkz, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza((T) this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: 0000 */
    public final int zzaxh() {
        return this.zzhks;
    }

    /* access modifiers changed from: 0000 */
    public final void zzfi(int i) {
        this.zzhks = i;
    }

    public final void zzb(zzdqf zzdqf) throws IOException {
        zzdsr.zzbbf().zzax(this).zza(this, zzdqg.zza(zzdqf));
    }

    public final int zzazu() {
        if (this.zzhks == -1) {
            this.zzhks = zzdsr.zzbbf().zzax(this).zzau(this);
        }
        return this.zzhks;
    }

    static <T extends zzdqw<?, ?>> T zzf(Class<T> cls) {
        T t = (zzdqw) zzhkt.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzdqw) zzhkt.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzdqw) ((zzdqw) zzdtt.zzj(cls)).zza(zzd.zzhla, (Object) null, (Object) null);
            if (t != null) {
                zzhkt.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzdqw<?, ?>> void zza(Class<T> cls, T t) {
        zzhkt.put(cls, t);
    }

    protected static Object zza(zzdsg zzdsg, String str, Object[] objArr) {
        return new zzdst(zzdsg, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzdqw<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzd.zzhkv, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzaw = zzdsr.zzbbf().zzax(t).zzaw(t);
        if (z) {
            t.zza(zzd.zzhkw, (Object) zzaw ? t : null, (Object) null);
        }
        return zzaw;
    }

    protected static zzdrb zzazv() {
        return zzdqy.zzbab();
    }

    protected static zzdrb zza(zzdrb zzdrb) {
        int size = zzdrb.size();
        return zzdrb.zzgo(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzdrd<E> zzazw() {
        return zzdsu.zzbbi();
    }

    protected static <E> zzdrd<E> zza(zzdrd<E> zzdrd) {
        int size = zzdrd.size();
        return zzdrd.zzfl(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzdqw<T, ?>> T zza(T t, zzdpy zzdpy, zzdqj zzdqj) throws zzdrg {
        T t2 = (zzdqw) t.zza(zzd.zzhky, (Object) null, (Object) null);
        try {
            zzdsv zzax = zzdsr.zzbbf().zzax(t2);
            zzax.zza(t2, zzdqd.zza(zzdpy), zzdqj);
            zzax.zzak(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzdrg) {
                throw ((zzdrg) e.getCause());
            }
            throw new zzdrg(e.getMessage()).zzo(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzdrg) {
                throw ((zzdrg) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzdqw<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzdqj zzdqj) throws zzdrg {
        T t2 = (zzdqw) t.zza(zzd.zzhky, (Object) null, (Object) null);
        try {
            zzdsv zzax = zzdsr.zzbbf().zzax(t2);
            zzax.zza(t2, bArr, 0, i2, new zzdpl(zzdqj));
            zzax.zzak(t2);
            if (t2.zzhfq == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzdrg) {
                throw ((zzdrg) e.getCause());
            }
            throw new zzdrg(e.getMessage()).zzo(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzdrg.zzbac().zzo(t2);
        }
    }

    private static <T extends zzdqw<T, ?>> T zzb(T t) throws zzdrg {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzdrg(new zzdto(t).getMessage()).zzo(t);
    }

    protected static <T extends zzdqw<T, ?>> T zza(T t, zzdpm zzdpm) throws zzdrg {
        return zzb((T) zzb((T) zza(t, zzdpm, zzdqj.zzaza())));
    }

    private static <T extends zzdqw<T, ?>> T zza(T t, zzdpm zzdpm, zzdqj zzdqj) throws zzdrg {
        T zza2;
        try {
            zzdpy zzaxp = zzdpm.zzaxp();
            zza2 = zza(t, zzaxp, zzdqj);
            zzaxp.zzfp(0);
            return zza2;
        } catch (zzdrg e) {
            throw e.zzo(zza2);
        } catch (zzdrg e2) {
            throw e2;
        }
    }

    protected static <T extends zzdqw<T, ?>> T zza(T t, byte[] bArr) throws zzdrg {
        return zzb((T) zza(t, bArr, 0, bArr.length, zzdqj.zzaza()));
    }

    protected static <T extends zzdqw<T, ?>> T zza(T t, byte[] bArr, zzdqj zzdqj) throws zzdrg {
        return zzb((T) zza(t, bArr, 0, bArr.length, zzdqj));
    }

    public final /* synthetic */ zzdsf zzazx() {
        zza zza2 = (zza) zza(zzd.zzhkz, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzdsf zzazy() {
        return (zza) zza(zzd.zzhkz, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzdsg zzazs() {
        return (zzdqw) zza(zzd.zzhla, (Object) null, (Object) null);
    }
}
