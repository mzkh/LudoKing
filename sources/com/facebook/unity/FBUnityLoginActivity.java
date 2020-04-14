package com.facebook.unity;

import android.os.Bundle;
import com.facebook.CallbackManager;

public class FBUnityLoginActivity extends BaseActivity {
    public static final String LOGIN_PARAMS = "login_params";
    public static final String LOGIN_TYPE = "login_type";

    /* renamed from: com.facebook.unity.FBUnityLoginActivity$1 */
    static /* synthetic */ class C17231 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$unity$FBUnityLoginActivity$LoginType = new int[LoginType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.facebook.unity.FBUnityLoginActivity$LoginType[] r0 = com.facebook.unity.FBUnityLoginActivity.LoginType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$unity$FBUnityLoginActivity$LoginType = r0
                int[] r0 = $SwitchMap$com$facebook$unity$FBUnityLoginActivity$LoginType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.unity.FBUnityLoginActivity$LoginType r1 = com.facebook.unity.FBUnityLoginActivity.LoginType.READ     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$unity$FBUnityLoginActivity$LoginType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.unity.FBUnityLoginActivity$LoginType r1 = com.facebook.unity.FBUnityLoginActivity.LoginType.PUBLISH     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$unity$FBUnityLoginActivity$LoginType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.unity.FBUnityLoginActivity$LoginType r1 = com.facebook.unity.FBUnityLoginActivity.LoginType.TV_READ     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$facebook$unity$FBUnityLoginActivity$LoginType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.facebook.unity.FBUnityLoginActivity$LoginType r1 = com.facebook.unity.FBUnityLoginActivity.LoginType.TV_PUBLISH     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.unity.FBUnityLoginActivity.C17231.<clinit>():void");
        }
    }

    public enum LoginType {
        READ,
        PUBLISH,
        TV_READ,
        TV_PUBLISH
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LoginType loginType = (LoginType) getIntent().getSerializableExtra(LOGIN_TYPE);
        String stringExtra = getIntent().getStringExtra(LOGIN_PARAMS);
        int i = C17231.$SwitchMap$com$facebook$unity$FBUnityLoginActivity$LoginType[loginType.ordinal()];
        if (i == 1) {
            FBLogin.loginWithReadPermissions(stringExtra, this);
        } else if (i == 2) {
            FBLogin.loginWithPublishPermissions(stringExtra, this);
        } else if (i == 3) {
            FBLogin.loginForTVWithReadPermissions(stringExtra, this);
        } else if (i == 4) {
            FBLogin.loginForTVWithPublishPermissions(stringExtra, this);
        }
    }

    public CallbackManager getCallbackManager() {
        return this.mCallbackManager;
    }
}
