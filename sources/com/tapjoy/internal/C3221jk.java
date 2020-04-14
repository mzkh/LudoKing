package com.tapjoy.internal;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompatExtras;
import com.tapjoy.internal.C3215ji.C3216a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiresApi(16)
/* renamed from: com.tapjoy.internal.jk */
final class C3221jk {

    /* renamed from: a */
    private static final Object f7722a = new Object();

    /* renamed from: b */
    private static Field f7723b;

    /* renamed from: c */
    private static boolean f7724c;

    /* renamed from: d */
    private static final Object f7725d = new Object();

    /* renamed from: a */
    public static SparseArray m7497a(List list) {
        int size = list.size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m7496a(Notification notification) {
        synchronized (f7722a) {
            if (f7724c) {
                return null;
            }
            try {
                if (f7723b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(NotificationCompatJellybean.TAG, "Notification.extras field is not of type Bundle");
                        f7724c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f7723b = declaredField;
                }
                Bundle bundle = (Bundle) f7723b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f7723b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e(NotificationCompatJellybean.TAG, "Unable to access notification extras", e);
                f7724c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e(NotificationCompatJellybean.TAG, "Unable to access notification extras", e2);
                f7724c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    private static Bundle[] m7498a(C3222jl[] jlVarArr) {
        if (jlVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[jlVarArr.length];
        for (int i = 0; i < jlVarArr.length; i++) {
            C3222jl jlVar = jlVarArr[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", jlVar.f7726a);
            bundle.putCharSequence("label", jlVar.f7727b);
            bundle.putCharSequenceArray("choices", jlVar.f7728c);
            bundle.putBoolean("allowFreeFormInput", jlVar.f7729d);
            bundle.putBundle("extras", jlVar.f7730e);
            Set<String> set = jlVar.f7731f;
            if (set != null && !set.isEmpty()) {
                ArrayList arrayList = new ArrayList(set.size());
                for (String add : set) {
                    arrayList.add(add);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }

    /* renamed from: a */
    public static Bundle m7495a(Builder builder, C3216a aVar) {
        builder.addAction(aVar.f7666e, aVar.f7667f, aVar.f7668g);
        Bundle bundle = new Bundle(aVar.f7662a);
        if (aVar.f7663b != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, m7498a(aVar.f7663b));
        }
        if (aVar.f7664c != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m7498a(aVar.f7664c));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f7665d);
        return bundle;
    }
}
