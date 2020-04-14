package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.adcolony.sdk.af */
class C0486af {
    C0486af() {
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public boolean mo8241a() {
        NetworkInfo networkInfo;
        Context c = C0476a.m85c();
        boolean z = false;
        if (c == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                networkInfo = null;
            } else {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null) {
                return false;
            }
            if (networkInfo.getType() == 1) {
                z = true;
            }
            return z;
        } catch (SecurityException e) {
            new C0749a().mo8726a("SecurityException - please ensure you added the ").mo8726a("ACCESS_NETWORK_STATE permission: ").mo8726a(e.toString()).mo8728a(C0748w.f1171g);
            return false;
        } catch (Exception e2) {
            new C0749a().mo8726a("Exception occurred when retrieving activeNetworkInfo in ").mo8726a("ADCNetwork.using_wifi(): ").mo8726a(e2.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public boolean mo8242b() {
        NetworkInfo networkInfo;
        Context c = C0476a.m85c();
        boolean z = false;
        if (c == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                networkInfo = null;
            } else {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null) {
                return false;
            }
            int type = networkInfo.getType();
            if (type == 0 || type >= 2) {
                z = true;
            }
            return z;
        } catch (SecurityException e) {
            new C0749a().mo8726a("SecurityException - please ensure you added the ").mo8726a("ACCESS_NETWORK_STATE permission: ").mo8726a(e.toString()).mo8728a(C0748w.f1171g);
            return false;
        } catch (Exception e2) {
            new C0749a().mo8726a("Exception occurred when retrieving activeNetworkInfo in ").mo8726a("ADCNetwork.using_mobile(): ").mo8726a(e2.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo8243c() {
        if (mo8241a()) {
            return TapjoyConstants.TJC_CONNECTION_TYPE_WIFI;
        }
        return mo8242b() ? "cell" : "none";
    }
}
