package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

public class NetworkConnectivity extends Activity {

    /* renamed from: a */
    private final int f7831a = 0;

    /* renamed from: b */
    private final int f7832b;

    /* renamed from: c */
    private final int f7833c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f7834d;

    /* renamed from: e */
    private ConnectivityManager f7835e;

    /* renamed from: f */
    private final NetworkCallback f7836f;

    public NetworkConnectivity(Context context) {
        int i = 1;
        this.f7832b = 1;
        this.f7833c = 2;
        this.f7834d = 0;
        this.f7836f = new NetworkCallback() {
            public final void onAvailable(Network network) {
                super.onAvailable(network);
            }

            public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                NetworkConnectivity networkConnectivity;
                int i;
                super.onCapabilitiesChanged(network, networkCapabilities);
                if (networkCapabilities.hasTransport(0)) {
                    networkConnectivity = NetworkConnectivity.this;
                    i = 1;
                } else {
                    networkConnectivity = NetworkConnectivity.this;
                    i = 2;
                }
                networkConnectivity.f7834d = i;
            }

            public final void onLost(Network network) {
                super.onLost(network);
                NetworkConnectivity.this.f7834d = 0;
            }

            public final void onUnavailable() {
                super.onUnavailable();
                NetworkConnectivity.this.f7834d = 0;
            }
        };
        this.f7835e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f7835e.registerDefaultNetworkCallback(this.f7836f);
        NetworkInfo activeNetworkInfo = this.f7835e.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() != 0) {
                i = 2;
            }
            this.f7834d = i;
        }
    }

    /* renamed from: a */
    public final int mo30587a() {
        return this.f7834d;
    }

    /* renamed from: b */
    public final void mo30588b() {
        this.f7835e.unregisterNetworkCallback(this.f7836f);
    }
}
