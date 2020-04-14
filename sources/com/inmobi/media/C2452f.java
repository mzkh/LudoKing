package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* renamed from: com.inmobi.media.f */
/* compiled from: AdContainer */
public interface C2452f {

    /* renamed from: com.inmobi.media.f$a */
    /* compiled from: AdContainer */
    public interface C2453a {
        /* renamed from: a */
        void mo28374a();

        /* renamed from: a */
        void mo28375a(Object obj);

        /* renamed from: b */
        void mo28376b(Object obj);
    }

    /* renamed from: a */
    void mo28357a();

    /* renamed from: a */
    void mo28358a(int i, Map<String, String> map);

    /* renamed from: a */
    void mo28359a(String str);

    /* renamed from: b */
    void mo28360b();

    /* renamed from: c */
    boolean mo28361c();

    /* renamed from: d */
    void mo28362d();

    void destroy();

    /* renamed from: e */
    void mo28364e();

    /* renamed from: f */
    void mo28365f();

    @NonNull
    C2426eq getAdConfig();

    Object getDataModel();

    C2453a getFullScreenEventsListener();

    String getMarkupType();

    int getPlacementType();

    @Nullable
    View getVideoContainerView();

    C2300cu getViewableAd();

    void setFullScreenActivityContext(Activity activity);
}
