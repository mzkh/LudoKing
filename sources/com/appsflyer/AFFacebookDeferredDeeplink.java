package com.appsflyer;

import android.os.Bundle;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AFFacebookDeferredDeeplink {

    /* renamed from: ˊ */
    public String f3311;

    /* renamed from: ˋ */
    String f3312;

    /* renamed from: ˎ */
    byte[] f3313;

    /* renamed from: ˏ */
    String f3314;

    /* renamed from: com.appsflyer.AFFacebookDeferredDeeplink$4 */
    public static class C13194 implements InvocationHandler {

        /* renamed from: ˊ */
        private static String f3315;

        /* renamed from: ˋ */
        private static String f3316;

        /* renamed from: ˎ */
        private /* synthetic */ AppLinkFetchEvents f3317;

        /* renamed from: ॱ */
        private /* synthetic */ Class f3318;

        C13194(Class cls, AppLinkFetchEvents appLinkFetchEvents) {
            this.f3318 = cls;
            this.f3317 = appLinkFetchEvents;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String str;
            String str2;
            String str3;
            if (method.getName().equals("onDeferredAppLinkDataFetched")) {
                if (objArr[0] != null) {
                    Object cast = this.f3318.cast(objArr[0]);
                    Bundle bundle = (Bundle) Bundle.class.cast(this.f3318.getMethod("getArgumentBundle", new Class[0]).invoke(cast, new Object[0]));
                    if (bundle != null) {
                        str = bundle.getString(AppLinkData.ARGUMENTS_NATIVE_URL);
                        str3 = bundle.getString("target_url");
                        Bundle bundle2 = bundle.getBundle("extras");
                        if (bundle2 != null) {
                            Bundle bundle3 = bundle2.getBundle(ShareConstants.DEEPLINK_CONTEXT);
                            if (bundle3 != null) {
                                str2 = bundle3.getString(ShareConstants.PROMO_CODE);
                            }
                        }
                        str2 = null;
                    } else {
                        str2 = null;
                        str = null;
                        str3 = null;
                    }
                    AppLinkFetchEvents appLinkFetchEvents = this.f3317;
                    if (appLinkFetchEvents != null) {
                        appLinkFetchEvents.onAppLinkFetchFinished(str, str3, str2);
                    }
                } else {
                    AppLinkFetchEvents appLinkFetchEvents2 = this.f3317;
                    if (appLinkFetchEvents2 != null) {
                        appLinkFetchEvents2.onAppLinkFetchFinished(null, null, null);
                    }
                }
                return null;
            }
            AppLinkFetchEvents appLinkFetchEvents3 = this.f3317;
            if (appLinkFetchEvents3 != null) {
                appLinkFetchEvents3.onAppLinkFetchFailed("onDeferredAppLinkDataFetched invocation failed");
            }
            return null;
        }

        C13194() {
        }

        /* renamed from: ॱ */
        static void m3167(String str) {
            f3315 = str;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i == 0 || i == str.length() - 1) {
                    sb.append(str.charAt(i));
                } else {
                    sb.append("*");
                }
            }
            f3316 = sb.toString();
        }

        /* renamed from: ˏ */
        public static void m3166(String str) {
            if (f3315 == null) {
                m3167(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
            }
            String str2 = f3315;
            if (str2 != null && str.contains(str2)) {
                AFLogger.afInfoLog(str.replace(f3315, f3316));
            }
        }
    }

    public interface AppLinkFetchEvents {
        void onAppLinkFetchFailed(String str);

        void onAppLinkFetchFinished(@Nullable String str, @Nullable String str2, @Nullable String str3);
    }

    AFFacebookDeferredDeeplink() {
    }

    AFFacebookDeferredDeeplink(String str, byte[] bArr, String str2) {
        this.f3312 = str;
        this.f3313 = bArr;
        this.f3314 = str2;
    }

    public AFFacebookDeferredDeeplink(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i = 0;
        int i2 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.f3312 = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.f3314 = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.f3314);
                if (matcher.matches()) {
                    i = Integer.parseInt(matcher.group(1));
                    i2 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.f3313 = (i > 4 || i2 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            }
        }
        scanner.close();
    }
}
