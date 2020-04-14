package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzdf;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzza;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzp extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzl zzblj;

    private zzp(zzl zzl) {
        this.zzblj = zzl;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            this.zzblj.zzblq = (zzdf) this.zzblj.zzblm.get(((Long) zzuv.zzon().zzd(zzza.zzcpf)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaxi.zzd("", e);
        }
        return this.zzblj.zzjx();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.zzblj.zzblo != null && str != null) {
            this.zzblj.zzblo.loadUrl(str);
        }
    }

    /* synthetic */ zzp(zzl zzl, zzk zzk) {
        this(zzl);
    }
}
