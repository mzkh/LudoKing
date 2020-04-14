package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

public class HFPStatus {

    /* renamed from: a */
    private Context f7820a;

    /* renamed from: b */
    private BroadcastReceiver f7821b = null;

    /* renamed from: c */
    private Intent f7822c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f7823d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AudioManager f7824e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f7825f = C3293a.f7827a;

    /* renamed from: com.unity3d.player.HFPStatus$a */
    enum C3293a {
        ;

        static {
            f7830d = new int[]{f7827a, f7828b, f7829c};
        }
    }

    public HFPStatus(Context context) {
        this.f7820a = context;
        this.f7824e = (AudioManager) this.f7820a.getSystemService("audio");
        initHFPStatusJni();
    }

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    /* renamed from: a */
    public final void mo30583a() {
        deinitHFPStatusJni();
    }

    /* access modifiers changed from: protected */
    public boolean getHFPStat() {
        return this.f7825f == C3293a.f7828b;
    }

    /* access modifiers changed from: protected */
    public void requestHFPStat() {
        this.f7821b = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                if (intExtra != -1) {
                    if (intExtra == 0) {
                        if (HFPStatus.this.f7823d) {
                            HFPStatus.this.f7824e.setMode(0);
                        }
                        HFPStatus.this.f7823d = false;
                    } else if (intExtra != 1) {
                        if (intExtra == 2) {
                            if (HFPStatus.this.f7825f == C3293a.f7828b) {
                                HFPStatus.this.f7823d = true;
                                return;
                            }
                            HFPStatus.this.f7825f = C3293a.f7829c;
                        }
                    } else {
                        HFPStatus.this.f7825f = C3293a.f7828b;
                        if (!HFPStatus.this.f7823d) {
                            HFPStatus.this.f7824e.stopBluetoothSco();
                        } else {
                            HFPStatus.this.f7824e.setMode(3);
                        }
                    }
                }
            }
        };
        this.f7822c = this.f7820a.registerReceiver(this.f7821b, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.f7824e.startBluetoothSco();
        } catch (NullPointerException unused) {
            C3342f.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }
}
