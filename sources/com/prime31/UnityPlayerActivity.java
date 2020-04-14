package com.prime31;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class UnityPlayerActivity extends com.unity3d.player.UnityPlayerActivity {
    private ActivityProxyObjectHelper _proxyHelper;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        super.onActivityResult(i, i2, intent);
        this._proxyHelper.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this._proxyHelper.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this._proxyHelper.invokeZeroParameterMethod("onStart");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this._proxyHelper.invokeZeroParameterMethod("onStop");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this._proxyHelper.invokeZeroParameterMethod("onDestroy");
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        this._proxyHelper.invokeZeroParameterMethod("onRestart");
    }

    public void onPause() {
        super.onPause();
        this._proxyHelper.invokeZeroParameterMethod("onPause");
    }

    public void onResume() {
        super.onResume();
        this._proxyHelper.invokeZeroParameterMethod("onResume");
    }

    public void onBackPressed() {
        super.onBackPressed();
        this._proxyHelper.invokeZeroParameterMethod("onBackPressed");
    }

    public void onSaveInstanceState(Bundle bundle) {
        this._proxyHelper.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this._proxyHelper.onRestoreInstanceState(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this._proxyHelper.onConfigurationChanged(configuration);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }
}
