package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvj {
    private final Executor executor;
    private final zzaay zzdeh;
    private final zzaui zzdrp;
    private final Executor zzfbx;
    private final zzcwe zzfga;
    private final zzbur zzfjl;
    private final zzbuv zzfkr;
    private final zzbup zzfkz;
    @Nullable
    private final zzbvr zzfmy;
    private final Context zzlk;

    public zzbvj(Context context, zzaui zzaui, zzcwe zzcwe, zzbuv zzbuv, zzbur zzbur, @Nullable zzbvr zzbvr, Executor executor2, Executor executor3, zzbup zzbup) {
        this.zzlk = context;
        this.zzdrp = zzaui;
        this.zzfga = zzcwe;
        this.zzdeh = zzcwe.zzdeh;
        this.zzfkr = zzbuv;
        this.zzfjl = zzbur;
        this.zzfmy = zzbvr;
        this.zzfbx = executor2;
        this.executor = executor3;
        this.zzfkz = zzbup;
    }

    public final void zza(zzbvz zzbvz) {
        this.zzfbx.execute(new zzbvi(this, zzbvz));
    }

    private static void zza(LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    public final void zzc(@Nullable zzbvz zzbvz) {
        if (!(zzbvz == null || this.zzfmy == null || zzbvz.zzain() == null)) {
            if (!((Boolean) zzuv.zzon().zzd(zzza.zzcsy)).booleanValue() || this.zzfkr.zzaib()) {
                try {
                    zzbvz.zzain().addView(this.zzfmy.zzaiy());
                } catch (zzbcf e) {
                    zzaug.zza("web view can not be obtained", e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzbvz zzbvz, String[] strArr) {
        Map zzaiq = zzbvz.zzaiq();
        if (zzaiq == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzaiq.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(@NonNull ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzaht = this.zzfjl.zzaht();
        if (zzaht == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzaht.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzaht.getParent()).removeView(zzaht);
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcol)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzaht, layoutParams);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzfjl.zzaht() == null) {
            return;
        }
        if (2 == this.zzfjl.zzahp() || 1 == this.zzfjl.zzahp()) {
            this.zzdrp.zzc(this.zzfga.zzgkh, String.valueOf(this.zzfjl.zzahp()), z);
        } else if (6 == this.zzfjl.zzahp()) {
            this.zzdrp.zzc(this.zzfga.zzgkh, "2", z);
            this.zzdrp.zzc(this.zzfga.zzgkh, "1", z);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzd(zzbvz zzbvz) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        IObjectWrapper iObjectWrapper;
        int i = 0;
        IObjectWrapper iObjectWrapper2 = null;
        if (this.zzfkr.zzaid() || this.zzfkr.zzaic()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                View zzfw = zzbvz.zzfw(strArr[i2]);
                if (zzfw != null && (zzfw instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzfw;
                    break;
                }
                i2++;
            }
        }
        viewGroup = null;
        boolean z = viewGroup != null;
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (this.zzfjl.zzahq() != null) {
            view = this.zzfjl.zzahq();
            zzaay zzaay = this.zzdeh;
            if (zzaay != null && !z) {
                zza(layoutParams, zzaay.zzbjy);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(this.zzfjl.zzqo() instanceof zzaat)) {
            view = null;
        } else {
            zzaat zzaat = (zzaat) this.zzfjl.zzqo();
            if (!z) {
                zza(layoutParams, zzaat.zzqh());
            }
            View zzaas = new zzaas(this.zzlk, zzaat, layoutParams);
            zzaas.setContentDescription((CharSequence) zzuv.zzon().zzd(zzza.zzcoi));
            view = zzaas;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzbvz.zzaeu().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout zzain = zzbvz.zzain();
                if (zzain != null) {
                    zzain.addView(adChoicesView);
                }
            }
            zzbvz.zza(zzbvz.zzais(), view, true);
        }
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcsx)).booleanValue()) {
            zzc(zzbvz);
        }
        String[] strArr2 = zzbvh.zzfmp;
        int length = strArr2.length;
        while (true) {
            if (i >= length) {
                viewGroup2 = null;
                break;
            }
            View zzfw2 = zzbvz.zzfw(strArr2[i]);
            if (zzfw2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzfw2;
                break;
            }
            i++;
        }
        this.executor.execute(new zzbvl(this, viewGroup2));
        if (viewGroup2 != null) {
            if (!zza(viewGroup2)) {
                viewGroup2.removeAllViews();
                View zzaeu = zzbvz.zzaeu();
                Context context = zzaeu != null ? zzaeu.getContext() : null;
                if (context != null) {
                    if (((Boolean) zzuv.zzon().zzd(zzza.zzcoh)).booleanValue()) {
                        zzabh zzqx = this.zzfkz.zzqx();
                        if (zzqx != null) {
                            try {
                                iObjectWrapper = zzqx.zzql();
                            } catch (RemoteException unused) {
                                zzaug.zzeu("Could not get main image drawable");
                                return;
                            }
                        }
                    } else {
                        zzabi zzahr = this.zzfjl.zzahr();
                        if (zzahr != null) {
                            try {
                                iObjectWrapper = zzahr.zzqi();
                            } catch (RemoteException unused2) {
                                zzaug.zzeu("Could not get drawable from image");
                            }
                        }
                    }
                    if (iObjectWrapper != null) {
                        Drawable drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper);
                        if (drawable != null) {
                            ImageView imageView = new ImageView(context);
                            imageView.setImageDrawable(drawable);
                            if (zzbvz != null) {
                                iObjectWrapper2 = zzbvz.zzait();
                            }
                            if (iObjectWrapper2 != null) {
                                if (((Boolean) zzuv.zzon().zzd(zzza.zzcsz)).booleanValue()) {
                                    imageView.setScaleType((ScaleType) ObjectWrapper.unwrap(iObjectWrapper2));
                                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    viewGroup2.addView(imageView);
                                }
                            }
                            imageView.setScaleType(ScaleType.CENTER_INSIDE);
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    }
                }
            } else if (this.zzfjl.zzahu() != null) {
                this.zzfjl.zzahu().zza((zzaaw) new zzbvk(this, zzbvz, viewGroup2));
            }
        }
    }
}
