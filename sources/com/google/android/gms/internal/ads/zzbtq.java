package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tapjoy.TJAdUnitConstants.String;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbtq implements zzbuz {
    private final zzaxl zzblk;
    private final Clock zzbmp;
    private final zzdf zzegb;
    private final zzcyp zzfbe;
    private final zzbuy zzfdo;
    private final zzcvr zzfet;
    private final zzcwe zzfga;
    private final JSONObject zzfjj;
    private final zzbyh zzfjk;
    private final zzbur zzfjl;
    /* access modifiers changed from: private */
    public final zzbni zzfjm;
    /* access modifiers changed from: private */
    public final zzbmv zzfjn;
    private final zzbhk zzfjo;
    private final zzbvm zzfjp;
    private final zzbqv zzfjq;
    private boolean zzfjr = false;
    private boolean zzfjs;
    private boolean zzfjt = false;
    private boolean zzfju = false;
    private Point zzfjv = new Point();
    private Point zzfjw = new Point();
    private long zzfjx = 0;
    private long zzfjy = 0;
    private zzwe zzfjz;
    private final Context zzlk;

    public zzbtq(Context context, zzbuy zzbuy, JSONObject jSONObject, zzbyh zzbyh, zzbur zzbur, zzdf zzdf, zzbni zzbni, zzbmv zzbmv, zzcvr zzcvr, zzaxl zzaxl, zzcwe zzcwe, zzbhk zzbhk, zzbvm zzbvm, Clock clock, zzbqv zzbqv, zzcyp zzcyp) {
        this.zzlk = context;
        this.zzfdo = zzbuy;
        this.zzfjj = jSONObject;
        this.zzfjk = zzbyh;
        this.zzfjl = zzbur;
        this.zzegb = zzdf;
        this.zzfjm = zzbni;
        this.zzfjn = zzbmv;
        this.zzfet = zzcvr;
        this.zzblk = zzaxl;
        this.zzfga = zzcwe;
        this.zzfjo = zzbhk;
        this.zzfjp = zzbvm;
        this.zzbmp = clock;
        this.zzfjq = zzbqv;
        this.zzfbe = zzcyp;
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        this.zzfjv = new Point();
        this.zzfjw = new Point();
        if (!this.zzfjs) {
            this.zzfjq.zzq(view);
            this.zzfjs = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzfjo.zzo(this);
        boolean zzcp = zzawm.zzcp(this.zzblk.zzdwf);
        if (map != null) {
            for (Entry value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zzcp) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Entry value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zzcp) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        this.zzfjv = new Point();
        this.zzfjw = new Point();
        this.zzfjq.zzr(view);
        this.zzfjs = false;
    }

    private final boolean zzfo(String str) {
        JSONObject optJSONObject = this.zzfjj.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        View view3 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject zza = zza(map, map2, view2);
        JSONObject zzs = zzs(view2);
        JSONObject zzt = zzt(view2);
        JSONObject zzu = zzu(view2);
        View view4 = view;
        String zzb = zzb(view, map);
        zza(view, zzs, zza, zzt, zzu, zzb, zzfq(zzb), null, z, false);
    }

    @Nullable
    private final String zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    return (String) entry.getKey();
                }
            }
        }
        int zzahp = this.zzfjl.zzahp();
        if (zzahp == 1) {
            return "1099";
        }
        if (zzahp == 2) {
            return "2099";
        }
        if (zzahp == 3 || zzahp != 6) {
            return null;
        }
        return "3099";
    }

    public final void zzfp(String str) {
        zza(null, null, null, null, null, str, null, null, false, false);
    }

    public final void zzf(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzaug.zzdv("Click data is null. No click is reported.");
        } else if (!zzfo("click_reporting")) {
            zzaug.zzes("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, zzq.zzkj().zza(bundle, (JSONObject) null), false, false);
        }
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfju) {
            zzaug.zzdv("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzahc()) {
            zzaug.zzdv("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            JSONObject zza = zza(map, map2, view);
            JSONObject zzs = zzs(view);
            JSONObject zzt = zzt(view);
            JSONObject zzu = zzu(view);
            String zzb = zzb(null, map);
            zza(view, zzs, zza, zzt, zzu, zzb, zzfq(zzb), null, z, true);
        }
    }

    private final boolean zzahc() {
        return this.zzfjj.optBoolean("allow_custom_click_gesture", false);
    }

    public final void zzqw() {
        this.zzfju = true;
    }

    public final boolean isCustomClickGestureEnabled() {
        return zzahc();
    }

    private final void zza(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z, boolean z2) {
        String str2 = "has_custom_click_handler";
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzfjj);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put(str2, this.zzfdo.zzfv(this.zzfjl.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, this.zzfjl.zzahp());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.zzfga.zzdeh != null && this.zzfga.zzdeh.zzbka);
            jSONObject8.put("custom_mute_enabled", !this.zzfjl.getMuteThisAdReasons().isEmpty() && this.zzfjl.zzahs() != null);
            if (this.zzfjp.zzaiw() != null && this.zzfjj.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbmp.currentTimeMillis());
            if (this.zzfju && zzahc()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzfdo.zzfv(this.zzfjl.getCustomTemplateId()) != null) {
                z3 = true;
            }
            jSONObject8.put(str2, z3);
            jSONObject8.put("click_signals", zzv(view));
            jSONObject7.put(String.CLICK, jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzbmp.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzfjx);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzfjy);
            jSONObject7.put("touch_signal", jSONObject9);
            zzaxr.zza(this.zzfjk.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzaug.zzc("Unable to create click JSON.", e);
        }
    }

    public final void zza(@Nullable View view, MotionEvent motionEvent, @Nullable View view2) {
        int[] zzw = zzw(view2);
        this.zzfjv = new Point(((int) motionEvent.getRawX()) - zzw[0], ((int) motionEvent.getRawY()) - zzw[1]);
        long currentTimeMillis = this.zzbmp.currentTimeMillis();
        this.zzfjy = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzfjx = currentTimeMillis;
            this.zzfjw = this.zzfjv;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation((float) this.zzfjv.x, (float) this.zzfjv.y);
        this.zzegb.zzb(obtain);
        obtain.recycle();
    }

    public final void zzg(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzaug.zzdv("Touch event data is null. No touch event is reported.");
        } else if (!zzfo("touch_reporting")) {
            zzaug.zzes("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            this.zzegb.zzcd().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
        }
    }

    public final void zzahd() {
        zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null);
    }

    public final void setClickConfirmingView(View view) {
        if (!this.zzfjj.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzaug.zzeu("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzbvm zzbvm = this.zzfjp;
        if (view != null) {
            view.setOnClickListener(zzbvm);
            view.setClickable(true);
            zzbvm.zzfni = new WeakReference<>(view);
        }
    }

    public final void zza(zzadf zzadf) {
        if (!this.zzfjj.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzaug.zzeu("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzfjp.zza(zzadf);
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzfjj.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzfjp.cancelUnconfirmedClick();
        }
    }

    public final void zza(@Nullable zzwi zzwi) {
        try {
            if (!this.zzfjt) {
                if (zzwi != null || this.zzfjl.zzahs() == null) {
                    this.zzfjt = true;
                    this.zzfbe.zzei(zzwi.zzov());
                    zzahe();
                    return;
                }
                this.zzfjt = true;
                this.zzfbe.zzei(this.zzfjl.zzahs().zzov());
                zzahe();
            }
        } catch (RemoteException e) {
            zzaug.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzwe zzwe) {
        this.zzfjz = zzwe;
    }

    public final void zzahe() {
        try {
            if (this.zzfjz != null) {
                this.zzfjz.onAdMuted();
            }
        } catch (RemoteException e) {
            zzaug.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        zza(zzs(view), zza(map, map2, view), zzt(view), zzu(view), (JSONObject) null);
    }

    public final void zzahf() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzfjj);
            zzaxr.zza(this.zzfjk.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzaxi.zzc("", e);
        }
    }

    public final boolean zzh(Bundle bundle) {
        if (!zzfo("impression_reporting")) {
            zzaug.zzes("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, zzq.zzkj().zza(bundle, (JSONObject) null));
    }

    private final boolean zza(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable JSONObject jSONObject5) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzfjj);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            this.zzfjk.zza("/logScionEvent", (zzaer<Object>) new zzbts<Object>(this));
            this.zzfjk.zza("/nativeImpression", (zzaer<Object>) new zzbtv<Object>(this));
            zzaxr.zza(this.zzfjk.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (!this.zzfjr && this.zzfet.zzgjj != null) {
                this.zzfjr |= zzq.zzkt().zzb(this.zzlk, this.zzblk.zzblz, this.zzfet.zzgjj.toString(), this.zzfga.zzgkh);
            }
            return true;
        } catch (JSONException e) {
            zzaug.zzc("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final JSONObject zzb(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzdf(rect.right - rect.left));
        jSONObject.put("height", zzdf(rect.bottom - rect.top));
        jSONObject.put("x", zzdf(rect.left));
        jSONObject.put("y", zzdf(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d4 A[Catch:{ JSONException -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e4 A[Catch:{ JSONException -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fc A[Catch:{ JSONException -> 0x0100 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject zzs(@androidx.annotation.Nullable android.view.View r14) {
        /*
            r13 = this;
            java.lang.String r0 = "window"
            java.lang.String r1 = "relative_to"
            java.lang.String r2 = "y"
            java.lang.String r3 = "x"
            java.lang.String r4 = "height"
            java.lang.String r5 = "width"
            java.lang.String r6 = "Cannot access method getTemplateTypeName: "
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            if (r14 != 0) goto L_0x0016
            return r7
        L_0x0016:
            r8 = 1
            r9 = 0
            int[] r10 = zzw(r14)     // Catch:{ Exception -> 0x0088 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0088 }
            r11.<init>()     // Catch:{ Exception -> 0x0088 }
            int r12 = r14.getMeasuredWidth()     // Catch:{ Exception -> 0x0088 }
            int r12 = r13.zzdf(r12)     // Catch:{ Exception -> 0x0088 }
            r11.put(r5, r12)     // Catch:{ Exception -> 0x0088 }
            int r12 = r14.getMeasuredHeight()     // Catch:{ Exception -> 0x0088 }
            int r12 = r13.zzdf(r12)     // Catch:{ Exception -> 0x0088 }
            r11.put(r4, r12)     // Catch:{ Exception -> 0x0088 }
            r12 = r10[r9]     // Catch:{ Exception -> 0x0088 }
            int r12 = r13.zzdf(r12)     // Catch:{ Exception -> 0x0088 }
            r11.put(r3, r12)     // Catch:{ Exception -> 0x0088 }
            r12 = r10[r8]     // Catch:{ Exception -> 0x0088 }
            int r12 = r13.zzdf(r12)     // Catch:{ Exception -> 0x0088 }
            r11.put(r2, r12)     // Catch:{ Exception -> 0x0088 }
            r11.put(r1, r0)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r12 = "frame"
            r7.put(r12, r11)     // Catch:{ Exception -> 0x0088 }
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch:{ Exception -> 0x0088 }
            r11.<init>()     // Catch:{ Exception -> 0x0088 }
            boolean r12 = r14.getGlobalVisibleRect(r11)     // Catch:{ Exception -> 0x0088 }
            if (r12 == 0) goto L_0x0061
            org.json.JSONObject r0 = r13.zzb(r11)     // Catch:{ Exception -> 0x0088 }
            goto L_0x0082
        L_0x0061:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0088 }
            r11.<init>()     // Catch:{ Exception -> 0x0088 }
            r11.put(r5, r9)     // Catch:{ Exception -> 0x0088 }
            r11.put(r4, r9)     // Catch:{ Exception -> 0x0088 }
            r4 = r10[r9]     // Catch:{ Exception -> 0x0088 }
            int r4 = r13.zzdf(r4)     // Catch:{ Exception -> 0x0088 }
            r11.put(r3, r4)     // Catch:{ Exception -> 0x0088 }
            r3 = r10[r8]     // Catch:{ Exception -> 0x0088 }
            int r3 = r13.zzdf(r3)     // Catch:{ Exception -> 0x0088 }
            r11.put(r2, r3)     // Catch:{ Exception -> 0x0088 }
            r11.put(r1, r0)     // Catch:{ Exception -> 0x0088 }
            r0 = r11
        L_0x0082:
            java.lang.String r1 = "visible_bounds"
            r7.put(r1, r0)     // Catch:{ Exception -> 0x0088 }
            goto L_0x008d
        L_0x0088:
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)
        L_0x008d:
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzctf
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0106
            android.view.ViewParent r14 = r14.getParent()
            if (r14 == 0) goto L_0x00c8
            java.lang.Class r0 = r14.getClass()     // Catch:{ NoSuchMethodException -> 0x00c8, SecurityException -> 0x00c4, IllegalAccessException -> 0x00bf, InvocationTargetException -> 0x00ba }
            java.lang.String r1 = "getTemplateTypeName"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ NoSuchMethodException -> 0x00c8, SecurityException -> 0x00c4, IllegalAccessException -> 0x00bf, InvocationTargetException -> 0x00ba }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x00c8, SecurityException -> 0x00c4, IllegalAccessException -> 0x00bf, InvocationTargetException -> 0x00ba }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ NoSuchMethodException -> 0x00c8, SecurityException -> 0x00c4, IllegalAccessException -> 0x00bf, InvocationTargetException -> 0x00ba }
            java.lang.Object r14 = r0.invoke(r14, r1)     // Catch:{ NoSuchMethodException -> 0x00c8, SecurityException -> 0x00c4, IllegalAccessException -> 0x00bf, InvocationTargetException -> 0x00ba }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NoSuchMethodException -> 0x00c8, SecurityException -> 0x00c4, IllegalAccessException -> 0x00bf, InvocationTargetException -> 0x00ba }
            goto L_0x00ca
        L_0x00ba:
            r14 = move-exception
            com.google.android.gms.internal.ads.zzaug.zzc(r6, r14)
            goto L_0x00c8
        L_0x00bf:
            r14 = move-exception
            com.google.android.gms.internal.ads.zzaug.zzc(r6, r14)
            goto L_0x00c8
        L_0x00c4:
            r14 = move-exception
            com.google.android.gms.internal.ads.zzaug.zzc(r6, r14)
        L_0x00c8:
            java.lang.String r14 = ""
        L_0x00ca:
            r0 = -1
            int r1 = r14.hashCode()     // Catch:{ JSONException -> 0x0100 }
            r2 = -2066603854(0xffffffff84d220b2, float:-4.940079E-36)
            if (r1 == r2) goto L_0x00e4
            r2 = 2019754500(0x78630204, float:1.8417067E34)
            if (r1 == r2) goto L_0x00da
            goto L_0x00ed
        L_0x00da:
            java.lang.String r1 = "medium_template"
            boolean r14 = r14.equals(r1)     // Catch:{ JSONException -> 0x0100 }
            if (r14 == 0) goto L_0x00ed
            r0 = 1
            goto L_0x00ed
        L_0x00e4:
            java.lang.String r1 = "small_template"
            boolean r14 = r14.equals(r1)     // Catch:{ JSONException -> 0x0100 }
            if (r14 == 0) goto L_0x00ed
            r0 = 0
        L_0x00ed:
            java.lang.String r14 = "native_template_type"
            if (r0 == 0) goto L_0x00fc
            if (r0 == r8) goto L_0x00f7
            r7.put(r14, r9)     // Catch:{ JSONException -> 0x0100 }
            goto L_0x0106
        L_0x00f7:
            r0 = 2
            r7.put(r14, r0)     // Catch:{ JSONException -> 0x0100 }
            goto L_0x0106
        L_0x00fc:
            r7.put(r14, r8)     // Catch:{ JSONException -> 0x0100 }
            goto L_0x0106
        L_0x0100:
            r14 = move-exception
            java.lang.String r0 = "Could not log native template signal to JSON"
            com.google.android.gms.internal.ads.zzaug.zzc(r0, r14)
        L_0x0106:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtq.zzs(android.view.View):org.json.JSONObject");
    }

    private static JSONObject zzt(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzq.zzkj();
            jSONObject.put("contained_in_scroll_view", zzaul.zzp(view) != -1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private final JSONObject zzu(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        String str = "can_show_on_lock_screen";
        try {
            zzq.zzkj();
            jSONObject.put(str, zzaul.zzo(view));
            zzq.zzkj();
            jSONObject.put("is_keyguard_locked", zzaul.zzax(this.zzlk));
        } catch (JSONException unused) {
            zzaug.zzeu("Unable to get lock screen information");
        }
        return jSONObject;
    }

    private final JSONObject zza(@Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, @Nullable View view) {
        String str;
        String str2;
        JSONObject jSONObject;
        Map<String, WeakReference<View>> map3 = map2;
        String str3 = "ad_view";
        String str4 = "relative_to";
        String str5 = "y";
        String str6 = "x";
        String str7 = "height";
        String str8 = "width";
        JSONObject jSONObject2 = new JSONObject();
        if (!(map == null || view == null)) {
            int[] zzw = zzw(view);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] zzw2 = zzw(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator it2 = it;
                    try {
                        jSONObject4.put(str8, zzdf(view2.getMeasuredWidth()));
                        jSONObject4.put(str7, zzdf(view2.getMeasuredHeight()));
                        jSONObject4.put(str6, zzdf(zzw2[0] - zzw[0]));
                        jSONObject4.put(str5, zzdf(zzw2[1] - zzw[1]));
                        jSONObject4.put(str4, str3);
                        jSONObject3.put("frame", jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = zzb(rect);
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put(str8, 0);
                            jSONObject.put(str7, 0);
                            jSONObject.put(str6, zzdf(zzw2[0] - zzw[0]));
                            jSONObject.put(str5, zzdf(zzw2[1] - zzw[1]));
                            jSONObject.put(str4, str3);
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            str2 = str3;
                            str = str4;
                            try {
                                jSONObject3.put(ViewHierarchyConstants.TEXT_SIZE, (double) textView.getTextSize());
                                jSONObject3.put(ViewHierarchyConstants.TEXT_KEY, textView.getText());
                            } catch (JSONException unused) {
                                zzaug.zzeu("Unable to get asset views information");
                                it = it2;
                                str3 = str2;
                                str4 = str;
                            }
                        } else {
                            str2 = str3;
                            str = str4;
                        }
                        jSONObject3.put("is_clickable", map3 != null && map3.containsKey(entry.getKey()) && view2.isClickable());
                        jSONObject2.put((String) entry.getKey(), jSONObject3);
                    } catch (JSONException unused2) {
                        str2 = str3;
                        str = str4;
                        zzaug.zzeu("Unable to get asset views information");
                        it = it2;
                        str3 = str2;
                        str4 = str;
                    }
                    it = it2;
                    str3 = str2;
                    str4 = str;
                }
            }
        }
        return jSONObject2;
    }

    private final String zzv(View view) {
        try {
            JSONObject optJSONObject = this.zzfjj.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.zzegb.zzcd().zza(this.zzlk, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzaug.zzc("Exception obtaining click signals", e);
            return null;
        }
    }

    private final JSONObject zzfq(@Nullable String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("click_point", zzahg());
                jSONObject.put("asset_id", str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
            zzaug.zzc("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
        return jSONObject;
    }

    @Nullable
    private final JSONObject zzahg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", zzdf(this.zzfjv.x));
            jSONObject.put("y", zzdf(this.zzfjv.y));
            jSONObject.put("start_x", zzdf(this.zzfjw.x));
            jSONObject.put("start_y", zzdf(this.zzfjw.y));
            return jSONObject;
        } catch (JSONException e) {
            zzaug.zzc("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    private static int[] zzw(@Nullable View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private final int zzdf(int i) {
        return zzuv.zzoj().zzb(this.zzlk, i);
    }

    public final void destroy() {
        this.zzfjk.destroy();
    }
}
