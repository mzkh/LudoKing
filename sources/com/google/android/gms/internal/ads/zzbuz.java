package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public interface zzbuz {
    void cancelUnconfirmedClick();

    void destroy();

    boolean isCustomClickGestureEnabled();

    void setClickConfirmingView(View view);

    void zza(@Nullable View view, MotionEvent motionEvent, View view2);

    void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zza(View view, Map<String, WeakReference<View>> map);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zza(zzadf zzadf);

    void zza(zzwe zzwe);

    void zza(@Nullable zzwi zzwi);

    void zzahd();

    void zzahe();

    void zzahf();

    void zzf(Bundle bundle);

    void zzfp(String str);

    void zzg(Bundle bundle);

    boolean zzh(Bundle bundle);

    void zzqw();
}
