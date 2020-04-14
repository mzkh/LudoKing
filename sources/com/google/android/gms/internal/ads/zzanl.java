package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzanl {
    private static final Object lock = new Object();
    @GuardedBy("lock")
    @VisibleForTesting
    private static boolean zzdgs = false;
    @GuardedBy("lock")
    @VisibleForTesting
    private static boolean zzye = false;
    @VisibleForTesting
    private zzcyu zzdgt;

    public final boolean zzp(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue()) {
                return false;
            }
            if (zzye) {
                return true;
            }
            try {
                zzq(context);
                boolean zzau = this.zzdgt.zzau(ObjectWrapper.wrap(context));
                zzye = zzau;
                return zzau;
            } catch (RemoteException e) {
                e = e;
                zzaxi.zze("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e2) {
                e = e2;
                zzaxi.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @VisibleForTesting
    private final void zzq(Context context) {
        synchronized (lock) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue() && !zzdgs) {
                try {
                    zzdgs = true;
                    this.zzdgt = (zzcyu) zzaxh.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzank.zzbty);
                } catch (zzaxj e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Nullable
    public final String getVersion(Context context) {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue()) {
            return null;
        }
        try {
            zzq(context);
            String str = "a.";
            String valueOf = String.valueOf(this.zzdgt.getVersion());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (RemoteException | NullPointerException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                if (((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue()) {
                    if (zzye) {
                        try {
                            return this.zzdgt.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzaxi.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public final void zzae(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue()) {
                if (zzye) {
                    try {
                        this.zzdgt.zzae(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzaxi.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzaf(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue()) {
                if (zzye) {
                    try {
                        this.zzdgt.zzaf(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzaxi.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue()) {
                if (zzye) {
                    try {
                        this.zzdgt.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzaxi.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcqu)).booleanValue()) {
                if (zzye) {
                    try {
                        this.zzdgt.zze(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzaxi.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }
}
