package com.applovin.mediation.adapters;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinSdk;

public abstract class MediationAdapterBase implements MaxAdapter {
    protected static final String KEY_MUTED = "muted";
    private boolean alwaysRewardUser;
    private final C1227o mLogger = this.mSdk.mo10249v();
    private final C1192i mSdk;
    private final String mTag = getClass().getSimpleName();
    private final AppLovinSdk mWrappingSdk;
    private MaxReward reward;

    public MediationAdapterBase(AppLovinSdk appLovinSdk) {
        this.mWrappingSdk = appLovinSdk;
        this.mSdk = C1281o.m3071a(appLovinSdk);
    }

    protected static String mediationTag() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinSdk_");
        sb.append(AppLovinSdk.VERSION);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void checkActivities(Context context, Class<?>... clsArr) {
    }

    /* access modifiers changed from: protected */
    public void checkExistence(Class<?>... clsArr) {
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls : clsArr) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found: ");
                sb.append(cls.getName());
                log(sb.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void configureReward(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        this.alwaysRewardUser = BundleUtils.getBoolean("always_reward_user", maxAdapterResponseParameters.isTesting(), serverParameters);
        int i = BundleUtils.getInt("amount", 0, serverParameters);
        String string = BundleUtils.getString("currency", "", serverParameters);
        StringBuilder sb = new StringBuilder();
        sb.append("Creating reward: ");
        sb.append(i);
        sb.append(" ");
        sb.append(string);
        log(sb.toString());
        this.reward = MaxReward.create(i, string);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo10519d(String str) {
        this.mLogger.mo10378b(this.mTag, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo10520e(String str) {
        this.mLogger.mo10382e(this.mTag, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo10521e(String str, Throwable th) {
        this.mLogger.mo10379b(this.mTag, str, th);
    }

    /* access modifiers changed from: protected */
    public MaxReward getReward() {
        MaxReward maxReward = this.reward;
        return maxReward != null ? maxReward : MaxReward.createDefault();
    }

    /* access modifiers changed from: 0000 */
    public String getVersionString(Class cls, String str) {
        String b = C1281o.m3097b(cls, str);
        if (b == null) {
            log("Failed to retrieve version string.");
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public AppLovinSdk getWrappingSdk() {
        return this.mWrappingSdk;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo10525i(String str) {
        this.mLogger.mo10380c(this.mTag, str);
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        this.mLogger.mo10380c(this.mTag, str);
    }

    /* access modifiers changed from: protected */
    public void log(String str, Throwable th) {
        this.mLogger.mo10379b(this.mTag, str, th);
    }

    /* access modifiers changed from: protected */
    public boolean shouldAlwaysRewardUser() {
        return this.alwaysRewardUser;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public void mo10529w(String str) {
        this.mLogger.mo10381d(this.mTag, str);
    }
}
