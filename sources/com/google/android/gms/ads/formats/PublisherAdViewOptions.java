package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.ads.zzada;
import com.google.android.gms.internal.ads.zzadd;
import com.google.android.gms.internal.ads.zzuc;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzyh;

@Class(creator = "PublisherAdViewOptionsCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Creator<PublisherAdViewOptions> CREATOR = new zzc();
    @Field(getter = "getManualImpressionsEnabled", mo15151id = 1)
    private final boolean zzbkg;
    @Field(getter = "getAppEventListenerBinder", mo15151id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzvt zzbkh;
    @Nullable
    private AppEventListener zzbki;
    @Field(getter = "getDelayedBannerAdListenerBinder", mo15151id = 3)
    @Nullable
    private final IBinder zzbkj;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbkg = false;
        /* access modifiers changed from: private */
        @Nullable
        public AppEventListener zzbki;
        /* access modifiers changed from: private */
        @Nullable
        public ShouldDelayBannerRenderingListener zzbkk;

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbkg = z;
            return this;
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzbki = appEventListener;
            return this;
        }

        @KeepForSdk
        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzbkk = shouldDelayBannerRenderingListener;
            return this;
        }

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzbkg = builder.zzbkg;
        this.zzbki = builder.zzbki;
        AppEventListener appEventListener = this.zzbki;
        zzyh zzyh = null;
        this.zzbkh = appEventListener != null ? new zzuc(appEventListener) : null;
        if (builder.zzbkk != null) {
            zzyh = new zzyh(builder.zzbkk);
        }
        this.zzbkj = zzyh;
    }

    @Constructor
    PublisherAdViewOptions(@Param(mo15154id = 1) boolean z, @Param(mo15154id = 2) @Nullable IBinder iBinder, @Param(mo15154id = 3) @Nullable IBinder iBinder2) {
        this.zzbkg = z;
        this.zzbkh = iBinder != null ? zzvs.zze(iBinder) : null;
        this.zzbkj = iBinder2;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzbki;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbkg;
    }

    @Nullable
    public final zzvt zzjg() {
        return this.zzbkh;
    }

    @Nullable
    public final zzada zzjh() {
        return zzadd.zzw(this.zzbkj);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzvt zzvt = this.zzbkh;
        SafeParcelWriter.writeIBinder(parcel, 2, zzvt == null ? null : zzvt.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzbkj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
