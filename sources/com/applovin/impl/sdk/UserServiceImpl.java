package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinUserService.OnConsentDialogDismissListener;

public class UserServiceImpl implements AppLovinUserService {

    /* renamed from: a */
    private final C1192i f2089a;

    UserServiceImpl(C1192i iVar) {
        this.f2089a = iVar;
    }

    public void showConsentDialog(Activity activity, OnConsentDialogDismissListener onConsentDialogDismissListener) {
        this.f2089a.mo10191Q().mo10170a(activity, onConsentDialogDismissListener);
    }

    public String toString() {
        return "UserService{}";
    }
}
