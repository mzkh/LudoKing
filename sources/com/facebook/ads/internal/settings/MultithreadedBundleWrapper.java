package com.facebook.ads.internal.settings;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;

@Keep
public class MultithreadedBundleWrapper {
    private final Bundle mBundle = new Bundle();

    public synchronized void putBoolean(String str, boolean z) {
        this.mBundle.putBoolean(str, z);
    }

    public synchronized boolean getBoolean(String str) {
        return this.mBundle.getBoolean(str);
    }

    public synchronized boolean getBoolean(String str, boolean z) {
        return this.mBundle.getBoolean(str, z);
    }

    @Nullable
    public synchronized ArrayList<String> getStringArrayList(String str) {
        return this.mBundle.getStringArrayList(str);
    }

    public synchronized void putStringArrayList(String str, ArrayList<String> arrayList) {
        this.mBundle.putStringArrayList(str, arrayList);
    }

    @Nullable
    public synchronized String getString(String str, @Nullable String str2) {
        return this.mBundle.getString(str, str2);
    }

    public synchronized void putString(String str, @Nullable String str2) {
        this.mBundle.putString(str, str2);
    }

    public synchronized void putSerializable(String str, Serializable serializable) {
        this.mBundle.putSerializable(str, serializable);
    }

    @Nullable
    public synchronized Serializable getSerializable(String str) {
        return this.mBundle.getSerializable(str);
    }

    public Bundle toBundle() {
        return new Bundle(this.mBundle);
    }

    public synchronized void reset(Bundle bundle) {
        this.mBundle.clear();
        this.mBundle.putAll(bundle);
    }
}
