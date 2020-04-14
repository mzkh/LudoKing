package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public interface zzbvz extends OnClickListener, OnTouchListener {
    void zza(String str, View view, boolean z);

    View zzaeu();

    FrameLayout zzain();

    zzpf zzaio();

    Map<String, WeakReference<View>> zzaip();

    Map<String, WeakReference<View>> zzaiq();

    Map<String, WeakReference<View>> zzair();

    String zzais();

    IObjectWrapper zzait();

    View zzfw(String str);
}
