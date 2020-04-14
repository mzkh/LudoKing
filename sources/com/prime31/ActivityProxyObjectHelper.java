package com.prime31;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ActivityProxyObjectHelper {
    protected static final String TAG = "Prime31";
    public static final String metaDataValue = "UnityPlayerActivityProxy";
    private Activity _context;
    private List<Class<?>> _proxyClasses = new ArrayList();

    public ActivityProxyObjectHelper(Activity activity) {
        this._context = activity;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|15|16|34) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Prime31"
            android.app.Activity r1 = r7._context     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            android.app.Activity r2 = r7._context     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            android.os.Bundle r1 = r1.metaData     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            java.util.Set r2 = r1.keySet()     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
        L_0x001e:
            boolean r3 = r2.hasNext()     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            if (r3 != 0) goto L_0x0025
            goto L_0x0097
        L_0x0025:
            java.lang.Object r3 = r2.next()     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NameNotFoundException -> 0x0081, NullPointerException -> 0x006a }
            java.lang.Object r4 = r1.get(r3)     // Catch:{ Exception -> 0x001e }
            boolean r5 = r4 instanceof java.lang.String     // Catch:{ Exception -> 0x001e }
            if (r5 == 0) goto L_0x001e
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x001e }
            java.lang.String r5 = "UnityPlayerActivityProxy"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x001e }
            if (r4 == 0) goto L_0x001e
            java.lang.Class r4 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0058 }
            java.util.List<java.lang.Class<?>> r5 = r7._proxyClasses     // Catch:{ ClassNotFoundException -> 0x0058 }
            r5.add(r4)     // Catch:{ ClassNotFoundException -> 0x0058 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0058 }
            java.lang.String r6 = "found Activity proxy class: "
            r5.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x0058 }
            r5.append(r4)     // Catch:{ ClassNotFoundException -> 0x0058 }
            java.lang.String r4 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x0058 }
            android.util.Log.i(r0, r4)     // Catch:{ ClassNotFoundException -> 0x0058 }
            goto L_0x001e
        L_0x0058:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001e }
            java.lang.String r5 = "no proxy class found for "
            r4.<init>(r5)     // Catch:{ Exception -> 0x001e }
            r4.append(r3)     // Catch:{ Exception -> 0x001e }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x001e }
            android.util.Log.e(r0, r3)     // Catch:{ Exception -> 0x001e }
            goto L_0x001e
        L_0x006a:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to load meta-data, NullPointer: "
            r2.<init>(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.util.Log.e(r0, r1)
            goto L_0x0097
        L_0x0081:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to load meta-data, NameNotFound: "
            r2.<init>(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.util.Log.i(r0, r1)
        L_0x0097:
            java.util.List<java.lang.Class<?>> r0 = r7._proxyClasses
            java.util.Iterator r0 = r0.iterator()
        L_0x009d:
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x00a4
            return
        L_0x00a4:
            java.lang.Object r1 = r0.next()
            java.lang.Class r1 = (java.lang.Class) r1
            java.lang.String r2 = "onCreate"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00c1 }
            java.lang.Class<android.os.Bundle> r5 = android.os.Bundle.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x00c1 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x00c1 }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00c1 }
            r3[r6] = r8     // Catch:{ Exception -> 0x00c1 }
            r1.invoke(r2, r3)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x009d
        L_0x00c1:
            goto L_0x009d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.prime31.ActivityProxyObjectHelper.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod("onNewIntent", new Class[]{Intent.class}).invoke(null, new Object[]{intent});
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}).invoke(null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeZeroParameterMethod(String str) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod(str, new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod("onSaveInstanceState", new Class[]{Bundle.class}).invoke(null, new Object[]{bundle});
            } catch (Exception unused) {
            }
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod("onRestoreInstanceState", new Class[]{Bundle.class}).invoke(null, new Object[]{bundle});
            } catch (Exception unused) {
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod("onConfigurationChanged", new Class[]{Configuration.class}).invoke(null, new Object[]{configuration});
            } catch (Exception unused) {
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod("onWindowFocusChanged", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
            }
        }
    }

    public void onKeyDown(int i, KeyEvent keyEvent) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod("onKeyDown", new Class[]{Integer.TYPE, KeyEvent.class}).invoke(null, new Object[]{Integer.valueOf(i), keyEvent});
            } catch (Exception unused) {
            }
        }
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
        for (Class method : this._proxyClasses) {
            try {
                method.getMethod("onKeyDown", new Class[]{Integer.TYPE, KeyEvent.class}).invoke(null, new Object[]{Integer.valueOf(i), keyEvent});
            } catch (Exception unused) {
            }
        }
    }
}
