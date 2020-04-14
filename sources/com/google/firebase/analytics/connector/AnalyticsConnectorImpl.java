package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzacb;
    @VisibleForTesting
    private final AppMeasurement zzacc;
    @VisibleForTesting
    final Map<String, zza> zzacd = new ConcurrentHashMap();

    private AnalyticsConnectorImpl(AppMeasurement appMeasurement) {
        Preconditions.checkNotNull(appMeasurement);
        this.zzacc = appMeasurement;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzacb == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzacb == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zzb.zzacf, zza.zzace);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzacb = new AnalyticsConnectorImpl(AppMeasurement.zza(context, bundle));
                }
            }
        }
        return zzacb;
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzd.zzdj(str) && zzd.zza(str2, bundle) && zzd.zzb(str, str2, bundle)) {
            this.zzacc.logEventInternal(str, str2, bundle);
        }
    }

    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, Object obj) {
        if (zzd.zzdj(str) && zzd.zzu(str, str2)) {
            this.zzacc.setUserPropertyInternal(str, str2, obj);
        }
    }

    @WorkerThread
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzacc.getUserProperties(z);
    }

    @WorkerThread
    @KeepForSdk
    public AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull final String str, AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzd.zzdj(str) || zzdi(str)) {
            return null;
        }
        AppMeasurement appMeasurement = this.zzacc;
        Object obj = "fiam".equals(str) ? new zzc(appMeasurement, analyticsConnectorListener) : "crash".equals(str) ? new zze(appMeasurement, analyticsConnectorListener) : null;
        if (obj == null) {
            return null;
        }
        this.zzacd.put(str, obj);
        return new AnalyticsConnectorHandle() {
            public void unregister() {
                if (AnalyticsConnectorImpl.this.zzdi(str)) {
                    AnalyticsConnectorListener zzrr = ((zza) AnalyticsConnectorImpl.this.zzacd.get(str)).zzrr();
                    if (zzrr != null) {
                        zzrr.onMessageTriggered(0, null);
                    }
                    AnalyticsConnectorImpl.this.zzacd.remove(str);
                }
            }

            @KeepForSdk
            public void registerEventNames(Set<String> set) {
                if (AnalyticsConnectorImpl.this.zzdi(str) && str.equals("fiam") && set != null && !set.isEmpty()) {
                    ((zza) AnalyticsConnectorImpl.this.zzacd.get(str)).registerEventNames(set);
                }
            }

            @KeepForSdk
            public void unregisterEventNames() {
                if (AnalyticsConnectorImpl.this.zzdi(str) && str.equals("fiam")) {
                    ((zza) AnalyticsConnectorImpl.this.zzacd.get(str)).unregisterEventNames();
                }
            }
        };
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        if (zzd.zza(conditionalUserProperty)) {
            this.zzacc.setConditionalUserProperty(zzd.zzb(conditionalUserProperty));
        }
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (str2 == null || zzd.zza(str2, bundle)) {
            this.zzacc.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @WorkerThread
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @Nullable String str2) {
        ArrayList arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty zzb : this.zzacc.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzd.zzb(zzb));
        }
        return arrayList;
    }

    @WorkerThread
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zzacc.getMaxUserProperties(str);
    }

    /* access modifiers changed from: private */
    public final boolean zzdi(@NonNull String str) {
        return !str.isEmpty() && this.zzacd.containsKey(str) && this.zzacd.get(str) != null;
    }

    static final /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) zzacb).zzacc.zza(z);
        }
    }
}
