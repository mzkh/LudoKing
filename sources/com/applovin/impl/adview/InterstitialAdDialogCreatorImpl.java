package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class InterstitialAdDialogCreatorImpl implements InterstitialAdDialogCreator {

    /* renamed from: a */
    private static final Object f1367a = new Object();

    /* renamed from: b */
    private static WeakReference<C0876n> f1368b = new WeakReference<>(null);

    /* renamed from: c */
    private static WeakReference<Context> f1369c = new WeakReference<>(null);

    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Context context) {
        C0876n nVar;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        synchronized (f1367a) {
            nVar = (C0876n) f1368b.get();
            if (nVar != null && nVar.isShowing()) {
                if (f1369c.get() == context) {
                    appLovinSdk.getLogger().mo10381d("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
                }
            }
            nVar = new C0876n(appLovinSdk, context);
            f1368b = new WeakReference<>(nVar);
            f1369c = new WeakReference<>(context);
        }
        return nVar;
    }
}
