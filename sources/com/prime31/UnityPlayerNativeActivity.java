package com.prime31;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class UnityPlayerNativeActivity extends com.unity3d.player.UnityPlayerNativeActivity {
    private ActivityProxyObjectHelper _proxyHelper;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.prime31.UnityPlayerNativeActivity, android.app.Activity, com.unity3d.player.UnityPlayerNativeActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        UnityPlayerNativeActivity.super.onCreate(bundle);
        try {
            this._proxyHelper = new ActivityProxyObjectHelper(this);
            this._proxyHelper.onCreate(bundle);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Failed to create proxyHelper: ");
            sb.append(e.getMessage());
            Log.i("Prime31", sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        UnityPlayerNativeActivity.super.onActivityResult(i, i2, intent);
        this._proxyHelper.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        UnityPlayerNativeActivity.super.onNewIntent(intent);
        setIntent(intent);
        this._proxyHelper.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        UnityPlayerNativeActivity.super.onStart();
        this._proxyHelper.invokeZeroParameterMethod("onStart");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        UnityPlayerNativeActivity.super.onStop();
        this._proxyHelper.invokeZeroParameterMethod("onStop");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        UnityPlayerNativeActivity.super.onDestroy();
        this._proxyHelper.invokeZeroParameterMethod("onDestroy");
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        UnityPlayerNativeActivity.super.onRestart();
        this._proxyHelper.invokeZeroParameterMethod("onRestart");
    }

    public void onPause() {
        UnityPlayerNativeActivity.super.onPause();
        this._proxyHelper.invokeZeroParameterMethod("onPause");
    }

    public void onResume() {
        UnityPlayerNativeActivity.super.onResume();
        this._proxyHelper.invokeZeroParameterMethod("onResume");
    }

    public void onBackPressed() {
        UnityPlayerNativeActivity.super.onBackPressed();
        this._proxyHelper.invokeZeroParameterMethod("onBackPressed");
    }

    public void onSaveInstanceState(Bundle bundle) {
        this._proxyHelper.onSaveInstanceState(bundle);
        UnityPlayerNativeActivity.super.onSaveInstanceState(bundle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        UnityPlayerNativeActivity.super.onRestoreInstanceState(bundle);
        this._proxyHelper.onRestoreInstanceState(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        UnityPlayerNativeActivity.super.onConfigurationChanged(configuration);
        this._proxyHelper.onConfigurationChanged(configuration);
    }

    public void onWindowFocusChanged(boolean z) {
        UnityPlayerNativeActivity.super.onWindowFocusChanged(z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return UnityPlayerNativeActivity.super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return UnityPlayerNativeActivity.super.onKeyUp(i, keyEvent);
    }
}
