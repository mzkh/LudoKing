package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.internal.C1363d.C1364b.C1365e;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.appsflyer.internal.r */
public final class C1376r {

    /* renamed from: com.appsflyer.internal.r$3 */
    public static class C13773 implements InvocationHandler {

        /* renamed from: ॱ */
        private /* synthetic */ C1378c f3584;

        public C13773(C1378c cVar) {
            this.f3584 = cVar;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equals("onLvlResult")) {
                String str = objArr[0] != null ? objArr[0] : null;
                String str2 = objArr[1] != null ? objArr[1] : null;
                C1378c cVar = this.f3584;
                if (cVar == null) {
                    AFLogger.afDebugLog("onLvlResult invocation succeeded, but listener is null");
                } else if (str == null || str2 == null) {
                    String str3 = "onLvlResult with error";
                    if (str2 == null) {
                        this.f3584.mo10736(str3, new Exception("AFLVL Invalid signature"));
                    } else {
                        this.f3584.mo10736(str3, new Exception("AFLVL Invalid signedData"));
                    }
                } else {
                    cVar.mo10737(str, str2);
                }
            } else {
                String name = method.getName();
                String str4 = "onLvlFailure";
                if (name.equals(str4)) {
                    C1378c cVar2 = this.f3584;
                    if (cVar2 == null) {
                        AFLogger.afDebugLog("onLvlFailure: listener is null");
                    } else if (objArr[0] != null) {
                        cVar2.mo10736("onLvlFailure with exception", objArr[0]);
                    } else {
                        cVar2.mo10736(str4, new Exception("unknown"));
                    }
                } else {
                    C1378c cVar3 = this.f3584;
                    if (cVar3 != null) {
                        cVar3.mo10736("lvlInvocation failed", new Exception("com.appsflyer.lvl.AppsFlyerLVL$resultListener invocation failed"));
                    }
                }
            }
            return null;
        }

        C13773() {
        }

        /* renamed from: ˏ */
        public static boolean m3343(Context context) {
            if (AppsFlyerLib.getInstance().isTrackingStopped()) {
                return false;
            }
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
                if (context.getPackageManager().queryIntentServices(new Intent("com.google.firebase.MESSAGING_EVENT", null, context, FirebaseMessagingServiceListener.class), 0).size() > 0) {
                    return true;
                }
                AFLogger.afWarnLog("Cannot verify existence of our InstanceID Listener Service in the manifest. Please refer to documentation.");
                return false;
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
            }
        }

        /* renamed from: ˊ */
        public static void m3342(Context context, String str) {
            if (str != null) {
                AFLogger.afInfoLog("updateServerUninstallToken called with: ".concat(String.valueOf(str)));
                String str2 = "afUninstallToken";
                C1365e r0 = C1365e.m3328(AppsFlyerProperties.getInstance().getString(str2));
                SharedPreferences r2 = AppsFlyerLibCore.m3225(context);
                if (!r2.getBoolean("sentRegisterRequestToAF", false) || r0.f3542 == null || !r0.f3542.equals(str)) {
                    AppsFlyerProperties.getInstance().set(str2, str);
                    if (AppsFlyerLibCore.m3236(r2)) {
                        AppsFlyerLibCore.getInstance().mo10734(context, str);
                    }
                }
            }
        }
    }

    /* renamed from: com.appsflyer.internal.r$c */
    public interface C1378c {
        /* renamed from: ॱ */
        void mo10736(String str, Exception exc);

        /* renamed from: ॱ */
        void mo10737(@NonNull String str, @NonNull String str2);
    }

    C1376r() {
    }
}
