package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String zzabl;
    private final int zzddp;
    private final String zzdeu;
    private final String zzeij;
    private final Bundle zzeik;
    private final Bundle zzeil;
    private final int zzeim;
    private final Context zzlk;
    private final boolean zznf;
    private final Location zzng;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, @Nullable String str2, String str3) {
        this.zzeij = str;
        this.zzeik = bundle;
        this.zzeil = bundle2;
        this.zzlk = context;
        this.zznf = z;
        this.zzng = location;
        this.zzddp = i;
        this.zzeim = i2;
        this.zzabl = str2;
        this.zzdeu = str3;
    }

    public String getBidResponse() {
        return this.zzeij;
    }

    public Bundle getServerParameters() {
        return this.zzeik;
    }

    public Bundle getMediationExtras() {
        return this.zzeil;
    }

    public Context getContext() {
        return this.zzlk;
    }

    public Location getLocation() {
        return this.zzng;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzddp;
    }

    public boolean isTestRequest() {
        return this.zznf;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzeim;
    }

    @Nullable
    public String getMaxAdContentRating() {
        return this.zzabl;
    }

    public String getWatermark() {
        return this.zzdeu;
    }
}
