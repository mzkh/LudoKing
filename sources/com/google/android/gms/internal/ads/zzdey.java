package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdey {
    private static final Logger logger = Logger.getLogger(zzdey.class.getName());
    private static final ConcurrentMap<String, zza> zzgsx = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzgsy = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdef<?>> zzgsz = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzdex<?>> zzgta = new ConcurrentHashMap();

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    interface zza {
        zzden<?> zzapw();

        Class<?> zzapx();

        Set<Class<?>> zzapy();

        <P> zzden<P> zzb(Class<P> cls) throws GeneralSecurityException;
    }

    private static synchronized zza zzgs(String str) throws GeneralSecurityException {
        zza zza2;
        synchronized (zzdey.class) {
            if (!zzgsx.containsKey(str)) {
                String str2 = "No key manager found for key type ";
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            zza2 = (zza) zzgsx.get(str);
        }
        return zza2;
    }

    public static synchronized void zza(String str, zzdef<?> zzdef) throws GeneralSecurityException {
        synchronized (zzdey.class) {
            if (zzgsz.containsKey(str.toLowerCase())) {
                if (!zzdef.getClass().equals(((zzdef) zzgsz.get(str.toLowerCase())).getClass())) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    String str2 = "com.google.crypto.tink.Registry";
                    String str3 = "addCatalogue";
                    String str4 = "Attempted overwrite of a catalogueName catalogue for name ";
                    String valueOf = String.valueOf(str);
                    logger2.logp(level, str2, str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
                    sb.append("catalogue for name ");
                    sb.append(str);
                    sb.append(" has been already registered");
                    throw new GeneralSecurityException(sb.toString());
                }
            }
            zzgsz.put(str.toLowerCase(), zzdef);
        }
    }

    public static zzdef<?> zzgt(String str) throws GeneralSecurityException {
        if (str != null) {
            zzdef<?> zzdef = (zzdef) zzgsz.get(str.toLowerCase());
            if (zzdef != null) {
                return zzdef;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase().startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static synchronized <P> void zza(zzden<P> zzden) throws GeneralSecurityException {
        synchronized (zzdey.class) {
            zza(zzden, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized <P> void zza(java.lang.String r8, java.lang.Class<?> r9, boolean r10) throws java.security.GeneralSecurityException {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzdey> r0 = com.google.android.gms.internal.ads.zzdey.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzdey$zza> r1 = zzgsx     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.containsKey(r8)     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzdey$zza> r1 = zzgsx     // Catch:{ all -> 0x0093 }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.ads.zzdey$zza r1 = (com.google.android.gms.internal.ads.zzdey.zza) r1     // Catch:{ all -> 0x0093 }
            java.lang.Class r2 = r1.zzapx()     // Catch:{ all -> 0x0093 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x0093 }
            if (r2 != 0) goto L_0x0065
            java.util.logging.Logger r10 = logger     // Catch:{ all -> 0x0093 }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "com.google.crypto.tink.Registry"
            java.lang.String r4 = "ensureKeyManagerInsertable"
            java.lang.String r5 = "Attempted overwrite of a registered key manager for key type "
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0093 }
            int r7 = r6.length()     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0038
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x0093 }
            goto L_0x003e
        L_0x0038:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r6.<init>(r5)     // Catch:{ all -> 0x0093 }
            r5 = r6
        L_0x003e:
            r10.logp(r2, r3, r4, r5)     // Catch:{ all -> 0x0093 }
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0093 }
            r4 = 0
            r3[r4] = r8     // Catch:{ all -> 0x0093 }
            r8 = 1
            java.lang.Class r1 = r1.zzapx()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0093 }
            r3[r8] = r1     // Catch:{ all -> 0x0093 }
            r8 = 2
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x0093 }
            r3[r8] = r9     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0093 }
            r10.<init>(r8)     // Catch:{ all -> 0x0093 }
            throw r10     // Catch:{ all -> 0x0093 }
        L_0x0065:
            if (r10 == 0) goto L_0x0091
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r9 = zzgsy     // Catch:{ all -> 0x0093 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x0093 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0093 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0093 }
            if (r9 != 0) goto L_0x0091
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0093 }
            java.lang.String r10 = "New keys are already disallowed for key type "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0093 }
            int r1 = r8.length()     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0088
            java.lang.String r8 = r10.concat(r8)     // Catch:{ all -> 0x0093 }
            goto L_0x008d
        L_0x0088:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r8.<init>(r10)     // Catch:{ all -> 0x0093 }
        L_0x008d:
            r9.<init>(r8)     // Catch:{ all -> 0x0093 }
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x0091:
            monitor-exit(r0)
            return
        L_0x0093:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdey.zza(java.lang.String, java.lang.Class, boolean):void");
    }

    public static synchronized <P> void zza(zzden<P> zzden, boolean z) throws GeneralSecurityException {
        synchronized (zzdey.class) {
            if (zzden != null) {
                String keyType = zzden.getKeyType();
                zza(keyType, zzden.getClass(), z);
                if (!zzgsx.containsKey(keyType)) {
                    zzgsx.put(keyType, new zzdfa(zzden));
                }
                zzgsy.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <P> void zza(zzdex<P> zzdex) throws GeneralSecurityException {
        synchronized (zzdey.class) {
            if (zzdex != null) {
                Class zzapo = zzdex.zzapo();
                if (zzgta.containsKey(zzapo)) {
                    zzdex zzdex2 = (zzdex) zzgta.get(zzapo);
                    if (!zzdex.getClass().equals(zzdex2.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String str = "com.google.crypto.tink.Registry";
                        String str2 = "registerPrimitiveWrapper";
                        String str3 = "Attempted overwrite of a registered SetWrapper for type ";
                        String valueOf = String.valueOf(zzapo.toString());
                        logger2.logp(level, str, str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzapo.getName(), zzdex2.getClass().getName(), zzdex.getClass().getName()}));
                    }
                }
                zzgta.put(zzapo, zzdex);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static zzden<?> zzgu(String str) throws GeneralSecurityException {
        return zzgs(str).zzapw();
    }

    private static <P> zzden<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zza zzgs = zzgs(str);
        if (cls == null) {
            return zzgs.zzapw();
        }
        if (zzgs.zzapy().contains(cls)) {
            return zzgs.zzb(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzgs.zzapx());
        Set<Class> zzapy = zzgs.zzapy();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : zzapy) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    public static synchronized zzdjn zza(zzdjt zzdjt) throws GeneralSecurityException {
        zzdjn zzr;
        synchronized (zzdey.class) {
            zzden zzgu = zzgu(zzdjt.zzatu());
            if (((Boolean) zzgsy.get(zzdjt.zzatu())).booleanValue()) {
                zzr = zzgu.zzr(zzdjt.zzatv());
            } else {
                String str = "newKey-operation not permitted for key type ";
                String valueOf = String.valueOf(zzdjt.zzatu());
                throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        return zzr;
    }

    public static synchronized zzdsg zzb(zzdjt zzdjt) throws GeneralSecurityException {
        zzdsg zzq;
        synchronized (zzdey.class) {
            zzden zzgu = zzgu(zzdjt.zzatu());
            if (((Boolean) zzgsy.get(zzdjt.zzatu())).booleanValue()) {
                zzq = zzgu.zzq(zzdjt.zzatv());
            } else {
                String str = "newKey-operation not permitted for key type ";
                String valueOf = String.valueOf(zzdjt.zzatu());
                throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        return zzq;
    }

    public static synchronized zzdsg zza(String str, zzdsg zzdsg) throws GeneralSecurityException {
        zzdsg zzb;
        synchronized (zzdey.class) {
            zzden zza2 = zza(str, null);
            if (((Boolean) zzgsy.get(str)).booleanValue()) {
                zzb = zza2.zzb(zzdsg);
            } else {
                String str2 = "newKey-operation not permitted for key type ";
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
        }
        return zzb;
    }

    public static <P> P zza(String str, zzdsg zzdsg, Class<P> cls) throws GeneralSecurityException {
        return zza(str, (Class) checkNotNull(cls)).zza(zzdsg);
    }

    private static <P> P zza(String str, zzdpm zzdpm, Class<P> cls) throws GeneralSecurityException {
        return zza(str, cls).zzp(zzdpm);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zza(str, zzdpm.zzy(bArr), (Class) checkNotNull(cls));
    }

    public static <P> zzdev<P> zza(zzdep zzdep, zzden<P> zzden, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) checkNotNull(cls);
        zzdfb.zzd(zzdep.zzapq());
        zzdev<P> zza2 = zzdev.zza(cls2);
        for (com.google.android.gms.internal.ads.zzdjx.zza zza3 : zzdep.zzapq().zzauj()) {
            if (zza3.zzaps() == zzdjr.ENABLED) {
                zzdeu zza4 = zza2.zza(zza(zza3.zzauo().zzatu(), zza3.zzauo().zzatv(), cls2), zza3);
                if (zza3.zzaup() == zzdep.zzapq().zzaui()) {
                    zza2.zza(zza4);
                }
            }
        }
        return zza2;
    }

    public static <P> P zza(zzdev<P> zzdev) throws GeneralSecurityException {
        zzdex zzdex = (zzdex) zzgta.get(zzdev.zzapo());
        if (zzdex != null) {
            return zzdex.zza(zzdev);
        }
        String str = "No wrapper found for ";
        String valueOf = String.valueOf(zzdev.zzapo().getName());
        throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
