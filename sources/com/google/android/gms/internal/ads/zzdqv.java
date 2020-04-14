package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqj;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
abstract class zzdqv<T extends zzdqj> {
    private static final Logger logger = Logger.getLogger(zzdqf.class.getName());
    private static String zzhkn = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzdqv() {
    }

    /* access modifiers changed from: protected */
    public abstract T zzazm();

    static <T extends zzdqj> T zze(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzdqv.class.getClassLoader();
        if (cls.equals(zzdqj.class)) {
            str = zzhkn;
        } else if (cls.getPackage().equals(zzdqv.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzdqj) cls.cast(((zzdqv) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzazm());
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalStateException(e4);
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzdqv.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzdqv) it.next()).zzazm()));
                } catch (ServiceConfigurationError e5) {
                    ServiceConfigurationError serviceConfigurationError = e5;
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String str2 = "Unable to load ";
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger2.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), serviceConfigurationError);
                }
            }
            if (arrayList.size() == 1) {
                return (zzdqj) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzdqj) cls.getMethod("combine", new Class[]{Collection.class}).invoke(null, new Object[]{arrayList});
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }
}
