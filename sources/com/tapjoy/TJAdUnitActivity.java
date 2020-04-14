package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.C1831gz;
import com.tapjoy.internal.C3071fm;
import com.tapjoy.internal.C3078fq;
import com.tapjoy.internal.C3110gn;

public class TJAdUnitActivity extends Activity implements OnClickListener {

    /* renamed from: c */
    private static TJAdUnitActivity f6224c;
    /* access modifiers changed from: 0000 */

    /* renamed from: a */
    public TJAdUnit f6225a;

    /* renamed from: b */
    private final Handler f6226b = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private TJPlacementData f6227d;

    /* renamed from: e */
    private TJAdUnitSaveStateData f6228e = new TJAdUnitSaveStateData();

    /* renamed from: f */
    private RelativeLayout f6229f = null;

    /* renamed from: g */
    private TJCloseButton f6230g;

    /* renamed from: h */
    private ProgressBar f6231h;

    /* renamed from: i */
    private boolean f6232i = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        StringBuilder sb = new StringBuilder("TJAdUnitActivity onCreate: ");
        sb.append(bundle);
        String str = "TJAdUnitActivity";
        TapjoyLog.m6550d(str, sb.toString());
        super.onCreate(bundle);
        f6224c = this;
        if (bundle != null) {
            this.f6228e = (TJAdUnitSaveStateData) bundle.getSerializable("ad_unit_bundle");
            TJAdUnitSaveStateData tJAdUnitSaveStateData = this.f6228e;
            if (tJAdUnitSaveStateData != null && tJAdUnitSaveStateData.isVideoComplete) {
                TapjoyLog.m6550d(str, "finishing TJAdUnitActivity");
                finish();
                return;
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String str2 = TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA;
            if (extras.getSerializable(str2) != null) {
                this.f6227d = (TJPlacementData) extras.getSerializable(str2);
                if (this.f6227d.getContentViewId() != null) {
                    TapjoyConnectCore.viewWillOpen(this.f6227d.getContentViewId(), 1);
                }
                if (TJPlacementManager.m6493a(this.f6227d.getKey()) != null) {
                    this.f6225a = TJPlacementManager.m6493a(this.f6227d.getKey()).getAdUnit();
                } else {
                    this.f6225a = new TJAdUnit();
                    this.f6225a.setAdContentTracker(new C3071fm(this.f6227d.getPlacementName(), this.f6227d.getPlacementType()));
                }
                if (!this.f6225a.hasCalledLoad()) {
                    TapjoyLog.m6550d(str, "No content loaded for ad unit -- loading now");
                    this.f6225a.load(this.f6227d, false, this);
                }
                this.f6225a.setAdUnitActivity(this);
                if (VERSION.SDK_INT < 11) {
                    setTheme(16973829);
                } else {
                    requestWindowFeature(1);
                    getWindow().setFlags(1024, 1024);
                    getWindow().setFlags(16777216, 16777216);
                }
                getWindow().setBackgroundDrawable(new ColorDrawable(0));
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                this.f6229f = new RelativeLayout(this);
                this.f6229f.setLayoutParams(layoutParams);
                this.f6229f.setBackgroundColor(0);
                TJWebView backgroundWebView = this.f6225a.getBackgroundWebView();
                backgroundWebView.setLayoutParams(layoutParams);
                if (backgroundWebView.getParent() != null) {
                    ((ViewGroup) backgroundWebView.getParent()).removeView(backgroundWebView);
                }
                TJWebView webView = this.f6225a.getWebView();
                webView.setLayoutParams(layoutParams);
                if (webView.getParent() != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                }
                this.f6229f.addView(backgroundWebView);
                VideoView videoView = this.f6225a.getVideoView();
                LayoutParams layoutParams2 = new LayoutParams(-1, -1);
                if (videoView.getParent() != null) {
                    ((ViewGroup) videoView.getParent()).removeView(videoView);
                }
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setGravity(17);
                linearLayout.addView(videoView, new LinearLayout.LayoutParams(-1, -1));
                this.f6229f.addView(linearLayout, layoutParams2);
                this.f6229f.addView(webView);
                this.f6231h = new ProgressBar(this, null, 16842874);
                if (this.f6227d.hasProgressSpinner()) {
                    setProgressSpinnerVisibility(true);
                } else {
                    setProgressSpinnerVisibility(false);
                }
                LayoutParams layoutParams3 = new LayoutParams(-2, -2);
                layoutParams3.addRule(13);
                this.f6231h.setLayoutParams(layoutParams3);
                this.f6229f.addView(this.f6231h);
                this.f6230g = new TJCloseButton(this);
                this.f6230g.setOnClickListener(this);
                this.f6229f.addView(this.f6230g);
                setContentView(this.f6229f);
                this.f6225a.setVisible(true);
                TJCorePlacement a = TJPlacementManager.m6493a(this.f6227d.getKey());
                if (a != null) {
                    String str3 = TJCorePlacement.f6303a;
                    StringBuilder sb2 = new StringBuilder("Content shown for placement ");
                    sb2.append(a.f6310c.getPlacementName());
                    TapjoyLog.m6553i(str3, sb2.toString());
                    a.f6313f.mo30148a();
                    TJPlacement a2 = a.mo29544a("SHOW");
                    if (!(a2 == null || a2.getListener() == null)) {
                        a2.getListener().onContentShow(a2);
                    }
                }
                return;
            }
        }
        TapjoyLog.m6551e(str, new TapjoyErrorMessage(ErrorType.SDK_ERROR, "Failed to launch AdUnit Activity"));
        finish();
    }

    public void setCloseButtonVisibility(boolean z) {
        if (z) {
            this.f6230g.setVisibility(0);
        } else {
            this.f6230g.setVisibility(4);
        }
    }

    public void setCloseButtonClickable(boolean z) {
        this.f6230g.setClickableRequested(z);
    }

    public void setProgressSpinnerVisibility(boolean z) {
        if (z) {
            this.f6231h.setVisibility(0);
        } else {
            this.f6231h.setVisibility(4);
        }
    }

    public void onBackPressed() {
        handleClose();
    }

    public void handleClose() {
        handleClose(false);
    }

    public void handleClose(boolean z) {
        if (!this.f6225a.getCloseRequested()) {
            TapjoyLog.m6550d("TJAdUnitActivity", String.CLOSE_REQUESTED);
            this.f6225a.closeRequested(z);
            this.f6226b.postDelayed(new Runnable() {
                public final void run() {
                    if (TJAdUnitActivity.this.f6225a.getCloseRequested()) {
                        TapjoyLog.m6550d("TJAdUnitActivity", "Did not receive callback from content. Closing ad.");
                        TJAdUnitActivity.this.finish();
                    }
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        f6224c = null;
        TapjoyLog.m6550d("TJAdUnitActivity", "onDestroy");
        TJAdUnit tJAdUnit = this.f6225a;
        if (tJAdUnit != null) {
            tJAdUnit.destroy();
        }
        TJPlacementData tJPlacementData = this.f6227d;
        if (tJPlacementData != null && tJPlacementData.isBaseActivity()) {
            if (this.f6227d.getContentViewId() != null) {
                TapjoyConnectCore.viewDidClose(this.f6227d.getContentViewId());
            }
            TJCorePlacement a = TJPlacementManager.m6493a(this.f6227d.getKey());
            if (a != null) {
                TJPlacement a2 = a.mo29544a("SHOW");
                if (a2 != null && a2.getListener() != null) {
                    String str = TJCorePlacement.f6303a;
                    StringBuilder sb = new StringBuilder("Content dismissed for placement ");
                    sb.append(a.f6310c.getPlacementName());
                    TapjoyLog.m6553i(str, sb.toString());
                    C3078fq fqVar = a.f6313f.f7271a;
                    if (fqVar != null) {
                        fqVar.f7262b.clear();
                    }
                    if (a2 != null && a2.f6372a != null) {
                        a2.f6372a.onContentDismiss(a2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        TapjoyLog.m6550d("TJAdUnitActivity", "onResume");
        super.onResume();
        if (this.f6225a.isLockedOrientation()) {
            setRequestedOrientation(this.f6225a.getLockedOrientation());
        }
        this.f6225a.resume(this.f6228e);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        TapjoyLog.m6550d("TJAdUnitActivity", "onStart");
        if (C1831gz.m3554a().f3830n) {
            this.f6232i = true;
            C3110gn.m7177a(this);
        }
        if (!this.f6227d.isBaseActivity()) {
            setResult(-1, getIntent());
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        TapjoyLog.m6550d("TJAdUnitActivity", "onPause");
        this.f6225a.pause();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TapjoyLog.m6550d("TJAdUnitActivity", "onSaveInstanceState");
        this.f6228e.seekTime = this.f6225a.getVideoSeekTime();
        this.f6228e.isVideoComplete = this.f6225a.isVideoComplete();
        this.f6228e.isVideoMuted = this.f6225a.isMuted();
        bundle.putSerializable("ad_unit_bundle", this.f6228e);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (this.f6232i) {
            this.f6232i = false;
            C3110gn.m7182b(this);
        }
        super.onStop();
        TapjoyLog.m6550d("TJAdUnitActivity", "onStop");
    }

    public void showErrorDialog() {
        if (!isFinishing()) {
            String str = "OK";
            String str2 = "An error occured. Please try again later.";
            if (VERSION.SDK_INT >= 21) {
                new Builder(this, 16974394).setMessage(str2).setPositiveButton(str, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        TJAdUnitActivity.this.handleClose();
                        dialogInterface.cancel();
                    }
                }).create().show();
                return;
            }
            new Builder(this).setMessage(str2).setPositiveButton(str, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TJAdUnitActivity.this.handleClose();
                    dialogInterface.cancel();
                }
            }).create().show();
        }
    }

    public void onClick(View view) {
        handleClose();
    }

    /* renamed from: a */
    static void m6429a() {
        TJAdUnitActivity tJAdUnitActivity = f6224c;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.handleClose(true);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f6225a.notifyOrientationChanged();
    }
}
