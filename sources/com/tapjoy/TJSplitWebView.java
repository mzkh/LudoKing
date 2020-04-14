package com.tapjoy;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.internal.C1852jq;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJSplitWebView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TJWebView f6400a = new TJWebView(this.f6410k);
    @Nullable

    /* renamed from: b */
    private C2833a f6401b;
    @Nullable

    /* renamed from: c */
    private C2833a f6402c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f6403d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f6404e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f */
    public String f6405f;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: g */
    public Uri f6406g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public HashSet f6407h;

    /* renamed from: i */
    private JSONObject f6408i;

    /* renamed from: j */
    private TJAdUnitJSBridge f6409j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Context f6410k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Boolean f6411l;

    /* renamed from: m */
    private RelativeLayout f6412m;

    /* renamed from: n */
    private FrameLayout f6413n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ProgressBar f6414o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TextView f6415p;

    /* renamed from: q */
    private TJImageButton f6416q;

    /* renamed from: r */
    private TJImageButton f6417r;

    /* renamed from: s */
    private String f6418s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f6419t;

    /* renamed from: u */
    private String f6420u;

    /* renamed from: v */
    private String f6421v;

    /* renamed from: w */
    private String f6422w;

    /* renamed from: com.tapjoy.TJSplitWebView$a */
    static class C2833a {

        /* renamed from: a */
        final double f6432a;

        /* renamed from: b */
        final double f6433b;

        /* renamed from: c */
        final double f6434c;

        /* renamed from: d */
        final double f6435d;

        /* renamed from: e */
        final float f6436e;

        C2833a(JSONObject jSONObject) {
            this.f6432a = jSONObject.optDouble("width", 0.0d);
            this.f6433b = jSONObject.optDouble("height", 0.0d);
            this.f6434c = jSONObject.optDouble("left", 0.0d);
            this.f6435d = jSONObject.optDouble("top", 0.0d);
            this.f6436e = (float) jSONObject.optDouble("cornerRadius", 0.0d);
        }
    }

    /* renamed from: com.tapjoy.TJSplitWebView$b */
    class C2834b extends WebViewClient {
        private C2834b() {
        }

        /* synthetic */ C2834b(TJSplitWebView tJSplitWebView, byte b) {
            this();
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (TJSplitWebView.this.f6411l.booleanValue()) {
                TJSplitWebView.this.f6415p.setText(TapjoyUrlFormatter.getDomain(str));
                TJSplitWebView.this.f6414o.setVisibility(0);
            }
            StringBuilder sb = new StringBuilder("onPageStarted: ");
            sb.append(str);
            TapjoyLog.m6550d("TJSplitWebView", sb.toString());
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            StringBuilder sb = new StringBuilder("shouldOverrideUrlLoading: ");
            sb.append(str);
            String str2 = "TJSplitWebView";
            TapjoyLog.m6550d(str2, sb.toString());
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                String scheme = parse.getScheme();
                if (!(scheme == null || host == null || ((!scheme.equals("http") && !scheme.equals("https")) || (TJSplitWebView.this.f6407h != null && TJSplitWebView.this.f6407h.contains(host))))) {
                    TJSplitWebView.this.f6404e = str;
                    return false;
                }
            }
            try {
                TJSplitWebView.this.f6410k.startActivity(new Intent("android.intent.action.VIEW", parse));
                if (!TJSplitWebView.this.f6411l.booleanValue()) {
                    TJSplitWebView.this.mo29644a();
                }
            } catch (Exception e) {
                TapjoyLog.m6552e(str2, e.getMessage());
            }
            return true;
        }

        @Nullable
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            String h = TJSplitWebView.this.f6405f;
            Uri i = TJSplitWebView.this.f6406g;
            if (!(h == null || i == null || str == null || !str.startsWith(h))) {
                TJSplitWebView.this.f6410k.startActivity(new Intent("android.intent.action.VIEW", i));
                TJSplitWebView.this.mo29644a();
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            StringBuilder sb = new StringBuilder("onReceivedError: ");
            sb.append(str2);
            sb.append(" firstUrl:");
            sb.append(TJSplitWebView.this.f6403d);
            TapjoyLog.m6550d("TJSplitWebView", sb.toString());
            if (TJSplitWebView.this.f6419t) {
                TJSplitWebView.this.showErrorDialog();
                return;
            }
            if (str2.equals(TJSplitWebView.this.f6403d)) {
                TJSplitWebView.this.mo29644a();
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TJSplitWebView.this.f6411l.booleanValue()) {
                if (TJSplitWebView.this.f6414o != null) {
                    TJSplitWebView.this.f6414o.setProgress(0);
                    TJSplitWebView.this.f6414o.setVisibility(8);
                }
                TJSplitWebView.this.isFirstOrLastPage();
            }
        }
    }

    @TargetApi(21)
    public TJSplitWebView(Context context, JSONObject jSONObject, TJAdUnitJSBridge tJAdUnitJSBridge) {
        super(context);
        this.f6409j = tJAdUnitJSBridge;
        this.f6410k = context;
        JSONObject optJSONObject = jSONObject.optJSONObject(String.SPLIT_VIEW_LAYOUT);
        JSONArray optJSONArray = jSONObject.optJSONArray(String.SPLIT_VIEW_EXIT_HOSTS);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(String.SPLIT_VIEW_ERROR_DIALOG_STRINGS);
        this.f6418s = jSONObject.optString(String.SPLIT_VIEW_URL_FOR_EXTERNAL_OPEN);
        this.f6408i = jSONObject.optJSONObject(String.SPLIT_VIEW_ANIMATION);
        setLayoutOption(optJSONObject);
        setExitHosts(optJSONArray);
        setErrorDialog(optJSONObject2);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.f6400a.setId(TapjoyUtil.generateViewId());
        this.f6400a.setBackgroundColor(-1);
        WebSettings settings = this.f6400a.getSettings();
        if (settings != null) {
            settings.setUseWideViewPort(true);
        }
        this.f6400a.setWebViewClient(new C2834b(this, 0));
        this.f6411l = Boolean.valueOf(jSONObject.optBoolean(String.SPLIT_VIEW_SHOW_TOOLBAR));
        if (this.f6411l.booleanValue()) {
            addToolbar();
            addLineBreak();
            addProgressBar();
            this.f6400a.setWebChromeClient(new WebChromeClient() {
                public final void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    TJSplitWebView.this.f6414o.setProgress(i);
                    TJSplitWebView.this.isFirstOrLastPage();
                }
            });
        }
        addView(this.f6400a, layoutParams);
    }

    @TargetApi(21)
    public void addToolbar() {
        this.f6412m = new RelativeLayout(this.f6410k);
        this.f6412m.setId(TapjoyUtil.generateViewId());
        LayoutParams layoutParams = new LayoutParams(-1, (int) (new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale() * 40.0f));
        layoutParams.addRule(6);
        this.f6412m.setBackgroundColor(-1);
        this.f6412m.setVisibility(0);
        setupToolbarUI();
        addView(this.f6412m, layoutParams);
    }

    @TargetApi(21)
    public void addProgressBar() {
        this.f6414o = new ProgressBar(this.f6410k, null, 16842872);
        this.f6414o.setMax(100);
        this.f6414o.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#5d95ff")));
        this.f6414o.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dddddd")));
        addView(this.f6414o);
    }

    @TargetApi(21)
    public void addLineBreak() {
        this.f6413n = new FrameLayout(getContext());
        this.f6413n.setBackgroundColor(Color.parseColor("#dddddd"));
        addView(this.f6413n);
    }

    @TargetApi(21)
    public void setupToolbarUI() {
        float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f6416q = new TJImageButton(this.f6410k);
        this.f6416q.setId(TapjoyUtil.generateViewId());
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        int i = (int) (10.0f * screenDensityScale);
        layoutParams.setMargins(i, i, i, i);
        int i2 = (int) (5.0f * screenDensityScale);
        this.f6416q.setPadding(i2, i, i, i);
        this.f6416q.setEnabledImageBitmap(TapjoyIcons.getBackEnabledImage(screenDensityScale));
        this.f6416q.setDisableImageBitmap(TapjoyIcons.getBackDisabledImage(screenDensityScale));
        this.f6416q.setBackgroundColor(0);
        this.f6416q.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (TJSplitWebView.this.f6400a.canGoBack()) {
                    TJSplitWebView.this.f6400a.goBack();
                }
            }
        });
        relativeLayout.addView(this.f6416q, layoutParams);
        this.f6417r = new TJImageButton(this.f6410k);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, this.f6416q.getId());
        layoutParams2.setMargins(i, i, i, i);
        this.f6417r.setPadding(i, i, i2, i);
        this.f6417r.setEnabledImageBitmap(TapjoyIcons.getForwardEnabledImage(screenDensityScale));
        this.f6417r.setDisableImageBitmap(TapjoyIcons.getForwardDisabledImage(screenDensityScale));
        this.f6417r.setBackgroundColor(0);
        this.f6417r.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                TJSplitWebView.this.f6400a.goForward();
            }
        });
        relativeLayout.addView(this.f6417r, layoutParams2);
        ImageButton imageButton = new ImageButton(this.f6410k);
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(i, i, i, i);
        imageButton.setPadding(i2, i2, i2, i2);
        imageButton.setImageBitmap(TapjoyIcons.getCloseImage(screenDensityScale));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                TJSplitWebView.this.mo29644a();
            }
        });
        relativeLayout.addView(imageButton, layoutParams3);
        this.f6415p = new TextView(this.f6410k);
        this.f6415p.setId(TapjoyUtil.generateViewId());
        LayoutParams layoutParams4 = new LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.f6415p.setMaxLines(1);
        this.f6415p.setMaxEms(Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        this.f6415p.setTextAlignment(4);
        this.f6415p.setTextColor(Color.parseColor("#5d95ff"));
        this.f6415p.setBackgroundColor(0);
        this.f6415p.setEnabled(false);
        this.f6415p.setTypeface(Typeface.create("sans-serif-medium", 0));
        relativeLayout.addView(this.f6415p, layoutParams4);
        ImageButton imageButton2 = new ImageButton(this.f6410k);
        imageButton2.setId(TapjoyUtil.generateViewId());
        LayoutParams layoutParams5 = new LayoutParams(-2, -2);
        layoutParams5.addRule(1, this.f6415p.getId());
        layoutParams5.addRule(15);
        imageButton2.setPadding(i2, i2, i2, i2);
        imageButton2.setImageBitmap(TapjoyIcons.getOpenBrowserImage(screenDensityScale));
        imageButton2.setBackgroundColor(0);
        imageButton2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                TJSplitWebView.this.openInExternalBrowser();
            }
        });
        relativeLayout.addView(imageButton2, layoutParams5);
        this.f6412m.addView(relativeLayout, new LayoutParams(-1, -2));
    }

    public void openInExternalBrowser() {
        Uri uri;
        if (C1852jq.m3669c(this.f6418s)) {
            uri = Uri.parse(this.f6400a.getUrl());
            if (uri == null) {
                uri = Uri.parse(getLastUrl());
            }
        } else {
            uri = Uri.parse(this.f6418s);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        if (this.f6400a.getContext() != null) {
            try {
                this.f6400a.getContext().startActivity(intent);
            } catch (Exception e) {
                TapjoyLog.m6550d("TJSplitWebView", e.getMessage());
            }
        }
    }

    public boolean goBack() {
        if (!this.f6400a.canGoBack()) {
            return false;
        }
        this.f6400a.goBack();
        return true;
    }

    public void isFirstOrLastPage() {
        this.f6416q.setEnabled(this.f6400a.canGoBack());
        this.f6417r.setEnabled(this.f6400a.canGoForward());
    }

    @TargetApi(21)
    public void showErrorDialog() {
        new Builder(this.f6410k, 16974394).setMessage(this.f6420u).setPositiveButton(this.f6421v, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setNegativeButton(this.f6422w, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (C1852jq.m3669c(TJSplitWebView.this.getLastUrl())) {
                    TJSplitWebView tJSplitWebView = TJSplitWebView.this;
                    tJSplitWebView.loadUrl(tJSplitWebView.f6403d);
                } else {
                    TJSplitWebView tJSplitWebView2 = TJSplitWebView.this;
                    tJSplitWebView2.loadUrl(tJSplitWebView2.getLastUrl());
                }
                dialogInterface.cancel();
            }
        }).create().show();
    }

    public void applyLayoutOption(JSONObject jSONObject) {
        setLayoutOption(jSONObject);
        m6499a(getWidth(), getHeight());
    }

    public void setExitHosts(JSONArray jSONArray) {
        if (jSONArray == null) {
            this.f6407h = null;
            return;
        }
        this.f6407h = new HashSet();
        for (int i = 0; i <= jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (optString != null) {
                this.f6407h.add(optString);
            }
        }
    }

    public void setErrorDialog(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f6419t = true;
            this.f6420u = jSONObject.optString("description");
            this.f6421v = jSONObject.optString(String.CLOSE);
            this.f6422w = jSONObject.optString("reload");
        }
    }

    public void setUserAgent(String str) {
        this.f6400a.getSettings().setUserAgentString(str);
    }

    public void setTrigger(@Nullable String str, @Nullable String str2) {
        this.f6405f = C1852jq.m3668b(str);
        this.f6406g = str2 != null ? Uri.parse(str2) : null;
    }

    public void loadUrl(String str) {
        TJWebView tJWebView = this.f6400a;
        if (tJWebView != null) {
            this.f6403d = str;
            this.f6404e = str;
            tJWebView.loadUrl(str);
        }
    }

    public String getLastUrl() {
        return this.f6404e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo29644a() {
        this.f6409j.dismissSplitView(null, null);
    }

    /* access modifiers changed from: protected */
    public void setLayoutOption(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(String.LANDSCAPE);
            C2833a aVar = null;
            this.f6402c = optJSONObject != null ? new C2833a(optJSONObject) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(String.PORTRAIT);
            if (optJSONObject2 != null) {
                aVar = new C2833a(optJSONObject2);
            }
            this.f6401b = aVar;
        }
    }

    /* renamed from: a */
    private void m6499a(int i, int i2) {
        C2833a aVar = i <= i2 ? this.f6401b : this.f6402c;
        if (aVar == null) {
            this.f6400a.setVisibility(4);
            return;
        }
        double d = (double) i;
        double d2 = aVar.f6432a;
        Double.isNaN(d);
        int i3 = (int) (d2 * d);
        double d3 = (double) i2;
        double d4 = aVar.f6433b;
        Double.isNaN(d3);
        int i4 = (int) (d4 * d3);
        if (i3 == 0 || i4 == 0) {
            this.f6400a.setVisibility(4);
            return;
        }
        double d5 = aVar.f6434c;
        Double.isNaN(d);
        int i5 = (int) (d * d5);
        double d6 = aVar.f6435d;
        Double.isNaN(d3);
        int i6 = (int) (d3 * d6);
        int i7 = (i - i3) - i5;
        int i8 = (i2 - i4) - i6;
        LayoutParams layoutParams = (LayoutParams) this.f6400a.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i4;
        Boolean bool = this.f6411l;
        if (bool == null || !bool.booleanValue()) {
            layoutParams.setMargins(i5, i6, i7, i8);
        } else {
            float screenDensityScale = new TapjoyDisplayMetricsUtil(getContext()).getScreenDensityScale();
            int height = ((int) (40.0f * screenDensityScale)) + this.f6413n.getHeight();
            LayoutParams layoutParams2 = (LayoutParams) this.f6412m.getLayoutParams();
            layoutParams2.setMargins(i5, i6, i7, i8);
            this.f6412m.setLayoutParams(layoutParams2);
            layoutParams.setMargins(i5, i6 + height, i7, i8);
            LayoutParams layoutParams3 = new LayoutParams(i3, (int) screenDensityScale);
            layoutParams3.setMargins(i5, layoutParams.topMargin - this.f6414o.getHeight(), i7, i8);
            this.f6414o.setLayoutParams(layoutParams3);
            this.f6413n.setLayoutParams(layoutParams3);
        }
        this.f6400a.setLayoutParams(layoutParams);
        this.f6400a.setVisibility(0);
        if (VERSION.SDK_INT >= 21) {
            if (aVar.f6436e > 0.0f) {
                float[] fArr = new float[8];
                final float f = aVar.f6436e * getResources().getDisplayMetrics().density;
                Boolean bool2 = this.f6411l;
                if (bool2 == null || !bool2.booleanValue()) {
                    Arrays.fill(fArr, f);
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
                    shapeDrawable.getPaint().setColor(-1);
                    this.f6400a.setBackground(shapeDrawable);
                    this.f6400a.setClipToOutline(true);
                    return;
                }
                this.f6412m.setOutlineProvider(new ViewOutlineProvider() {
                    public final void getOutline(View view, Outline outline) {
                        int width = view.getWidth();
                        float height = (float) view.getHeight();
                        float f = f;
                        outline.setRoundRect(0, 0, width, (int) (height + f), f);
                    }
                });
                this.f6412m.setClipToOutline(true);
                return;
            }
            this.f6400a.setBackground(null);
            this.f6400a.setClipToOutline(false);
            Boolean bool3 = this.f6411l;
            if (bool3 != null && bool3.booleanValue()) {
                this.f6412m.setClipToOutline(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m6499a(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    public void animateOpen(ViewGroup viewGroup) {
        JSONObject jSONObject = this.f6408i;
        if (jSONObject != null) {
            String str = String.ANIMATION_EVENT_ON_OPEN;
            if (jSONObject.has(str) && this.f6408i.optString(str).equalsIgnoreCase(String.ANIMATION_TYPE_SLIDE_UP)) {
                setY((float) viewGroup.getHeight());
                animate().translationY(0.0f);
            }
        }
    }
}
