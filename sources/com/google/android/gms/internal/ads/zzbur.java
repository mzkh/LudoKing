package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbur {
    private Bundle extras;
    private zzaba zzcwc;
    private List<zzxk> zzcwr = Collections.emptyList();
    private List<?> zzeiq;
    private double zzeit;
    private float zzejf;
    @Nullable
    private IObjectWrapper zzfeu;
    private int zzfli;
    private zzwr zzflj;
    private View zzflk;
    private zzxk zzfll;
    private zzbbw zzflm;
    @Nullable
    private zzbbw zzfln;
    private View zzflo;
    private IObjectWrapper zzflp;
    private zzabi zzflq;
    private zzabi zzflr;
    private String zzfls;
    private SimpleArrayMap<String, zzaau> zzflt = new SimpleArrayMap<>();
    private SimpleArrayMap<String, String> zzflu = new SimpleArrayMap<>();
    @Nullable
    private String zzlr;

    public final synchronized void zzdg(int i) {
        this.zzfli = i;
    }

    public final synchronized void zzb(zzwr zzwr) {
        this.zzflj = zzwr;
    }

    public final synchronized void zza(zzaba zzaba) {
        this.zzcwc = zzaba;
    }

    public final synchronized void setImages(List<zzaau> list) {
        this.zzeiq = list;
    }

    public final synchronized void zzf(List<zzxk> list) {
        this.zzcwr = list;
    }

    public final synchronized void zza(@Nullable zzxk zzxk) {
        this.zzfll = zzxk;
    }

    public final synchronized void zzaa(View view) {
        this.zzflo = view;
    }

    public final synchronized void setStarRating(double d) {
        this.zzeit = d;
    }

    public final synchronized void zza(zzabi zzabi) {
        this.zzflq = zzabi;
    }

    public final synchronized void zzb(zzabi zzabi) {
        this.zzflr = zzabi;
    }

    public final synchronized void zzfr(String str) {
        this.zzfls = str;
    }

    public final synchronized void zzi(zzbbw zzbbw) {
        this.zzflm = zzbbw;
    }

    public final synchronized void zzj(zzbbw zzbbw) {
        this.zzfln = zzbbw;
    }

    public final synchronized void zzas(IObjectWrapper iObjectWrapper) {
        this.zzfeu = iObjectWrapper;
    }

    public final synchronized void zzo(String str, String str2) {
        if (str2 == null) {
            this.zzflu.remove(str);
        } else {
            this.zzflu.put(str, str2);
        }
    }

    public final synchronized void zza(String str, zzaau zzaau) {
        if (zzaau == null) {
            this.zzflt.remove(str);
        } else {
            this.zzflt.put(str, zzaau);
        }
    }

    private final synchronized void setMediaContentAspectRatio(float f) {
        this.zzejf = f;
    }

    public final synchronized void zzfs(@Nullable String str) {
        this.zzlr = str;
    }

    private final synchronized String zzft(String str) {
        return (String) this.zzflu.get(str);
    }

    public final synchronized int zzahp() {
        return this.zzfli;
    }

    public final synchronized zzwr getVideoController() {
        return this.zzflj;
    }

    public final synchronized zzaba zzqo() {
        return this.zzcwc;
    }

    public final synchronized View zzahq() {
        return this.zzflk;
    }

    public final synchronized String getHeadline() {
        return zzft("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzeiq;
    }

    @Nullable
    public final zzabi zzahr() {
        List<?> list = this.zzeiq;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zzeiq.get(0);
            if (obj instanceof IBinder) {
                return zzabl.zzm((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized List<zzxk> getMuteThisAdReasons() {
        return this.zzcwr;
    }

    @Nullable
    public final synchronized zzxk zzahs() {
        return this.zzfll;
    }

    public final synchronized String getBody() {
        return zzft("body");
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getCallToAction() {
        return zzft("call_to_action");
    }

    public final synchronized View zzaht() {
        return this.zzflo;
    }

    public final synchronized IObjectWrapper zzqp() {
        return this.zzflp;
    }

    public final synchronized String getStore() {
        return zzft("store");
    }

    public final synchronized String getPrice() {
        return zzft("price");
    }

    public final synchronized double getStarRating() {
        return this.zzeit;
    }

    public final synchronized zzabi zzqn() {
        return this.zzflq;
    }

    public final synchronized String getAdvertiser() {
        return zzft("advertiser");
    }

    public final synchronized zzabi zzqq() {
        return this.zzflr;
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzfls;
    }

    public final synchronized zzbbw zzahu() {
        return this.zzflm;
    }

    @Nullable
    public final synchronized zzbbw zzahv() {
        return this.zzfln;
    }

    @Nullable
    public final synchronized IObjectWrapper zzahw() {
        return this.zzfeu;
    }

    public final synchronized SimpleArrayMap<String, zzaau> zzahx() {
        return this.zzflt;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzejf;
    }

    @Nullable
    public final synchronized String zzahy() {
        return this.zzlr;
    }

    public final synchronized SimpleArrayMap<String, String> zzahz() {
        return this.zzflu;
    }

    public final synchronized void destroy() {
        if (this.zzflm != null) {
            this.zzflm.destroy();
            this.zzflm = null;
        }
        if (this.zzfln != null) {
            this.zzfln.destroy();
            this.zzfln = null;
        }
        this.zzfeu = null;
        this.zzflt.clear();
        this.zzflu.clear();
        this.zzflj = null;
        this.zzcwc = null;
        this.zzflk = null;
        this.zzeiq = null;
        this.extras = null;
        this.zzflo = null;
        this.zzflp = null;
        this.zzflq = null;
        this.zzflr = null;
        this.zzfls = null;
    }

    public static zzbur zza(zzakl zzakl) {
        try {
            zzwr videoController = zzakl.getVideoController();
            zzaba zzqo = zzakl.zzqo();
            View view = (View) zzat(zzakl.zzry());
            String headline = zzakl.getHeadline();
            List<?> images = zzakl.getImages();
            String body = zzakl.getBody();
            Bundle extras2 = zzakl.getExtras();
            String callToAction = zzakl.getCallToAction();
            View view2 = (View) zzat(zzakl.zzrz());
            IObjectWrapper zzqp = zzakl.zzqp();
            String advertiser = zzakl.getAdvertiser();
            zzabi zzqq = zzakl.zzqq();
            zzbur zzbur = new zzbur();
            zzbur.zzfli = 1;
            zzbur.zzflj = videoController;
            zzbur.zzcwc = zzqo;
            zzbur.zzflk = view;
            zzbur.zzo("headline", headline);
            zzbur.zzeiq = images;
            zzbur.zzo("body", body);
            zzbur.extras = extras2;
            zzbur.zzo("call_to_action", callToAction);
            zzbur.zzflo = view2;
            zzbur.zzflp = zzqp;
            zzbur.zzo("advertiser", advertiser);
            zzbur.zzflr = zzqq;
            return zzbur;
        } catch (RemoteException e) {
            zzaug.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzbur zza(zzakg zzakg) {
        try {
            zzwr videoController = zzakg.getVideoController();
            zzaba zzqo = zzakg.zzqo();
            View view = (View) zzat(zzakg.zzry());
            String headline = zzakg.getHeadline();
            List<?> images = zzakg.getImages();
            String body = zzakg.getBody();
            Bundle extras2 = zzakg.getExtras();
            String callToAction = zzakg.getCallToAction();
            View view2 = (View) zzat(zzakg.zzrz());
            IObjectWrapper zzqp = zzakg.zzqp();
            String store = zzakg.getStore();
            String price = zzakg.getPrice();
            double starRating = zzakg.getStarRating();
            zzabi zzqn = zzakg.zzqn();
            zzbur zzbur = new zzbur();
            zzabi zzabi = zzqn;
            zzbur.zzfli = 2;
            zzbur.zzflj = videoController;
            zzbur.zzcwc = zzqo;
            zzbur.zzflk = view;
            zzbur.zzo("headline", headline);
            zzbur.zzeiq = images;
            zzbur.zzo("body", body);
            zzbur.extras = extras2;
            zzbur.zzo("call_to_action", callToAction);
            zzbur.zzflo = view2;
            zzbur.zzflp = zzqp;
            zzbur.zzo("store", store);
            zzbur.zzo("price", price);
            zzbur.zzeit = starRating;
            zzbur.zzflq = zzabi;
            return zzbur;
        } catch (RemoteException e) {
            zzaug.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzbur zzb(zzakm zzakm) {
        try {
            return zza(zzakm.getVideoController(), zzakm.zzqo(), (View) zzat(zzakm.zzry()), zzakm.getHeadline(), zzakm.getImages(), zzakm.getBody(), zzakm.getExtras(), zzakm.getCallToAction(), (View) zzat(zzakm.zzrz()), zzakm.zzqp(), zzakm.getStore(), zzakm.getPrice(), zzakm.getStarRating(), zzakm.zzqn(), zzakm.getAdvertiser(), zzakm.getMediaContentAspectRatio());
        } catch (RemoteException e) {
            zzaug.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzbur zzb(zzakg zzakg) {
        try {
            return zza(zzakg.getVideoController(), zzakg.zzqo(), (View) zzat(zzakg.zzry()), zzakg.getHeadline(), zzakg.getImages(), zzakg.getBody(), zzakg.getExtras(), zzakg.getCallToAction(), (View) zzat(zzakg.zzrz()), zzakg.zzqp(), zzakg.getStore(), zzakg.getPrice(), zzakg.getStarRating(), zzakg.zzqn(), null, 0.0f);
        } catch (RemoteException e) {
            zzaug.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzbur zzb(zzakl zzakl) {
        try {
            return zza(zzakl.getVideoController(), zzakl.zzqo(), (View) zzat(zzakl.zzry()), zzakl.getHeadline(), zzakl.getImages(), zzakl.getBody(), zzakl.getExtras(), zzakl.getCallToAction(), (View) zzat(zzakl.zzrz()), zzakl.zzqp(), null, null, -1.0d, zzakl.zzqq(), zzakl.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzaug.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzbur zza(zzwr zzwr, zzaba zzaba, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzabi zzabi, String str6, float f) {
        zzbur zzbur = new zzbur();
        zzbur.zzfli = 6;
        zzbur.zzflj = zzwr;
        zzbur.zzcwc = zzaba;
        zzbur.zzflk = view;
        String str7 = str;
        zzbur.zzo("headline", str);
        zzbur.zzeiq = list;
        String str8 = str2;
        zzbur.zzo("body", str2);
        zzbur.extras = bundle;
        String str9 = str3;
        zzbur.zzo("call_to_action", str3);
        zzbur.zzflo = view2;
        zzbur.zzflp = iObjectWrapper;
        String str10 = str4;
        zzbur.zzo("store", str4);
        String str11 = str5;
        zzbur.zzo("price", str5);
        zzbur.zzeit = d;
        zzbur.zzflq = zzabi;
        zzbur.zzo("advertiser", str6);
        zzbur.setMediaContentAspectRatio(f);
        return zzbur;
    }

    private static <T> T zzat(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }
}
