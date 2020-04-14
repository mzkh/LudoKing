package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import com.google.android.gms.drive.DriveFile;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbdk extends MutableContextWrapper {
    private Activity zzdvj;
    private Context zzehy;
    private Context zzzc;

    public zzbdk(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final void setBaseContext(Context context) {
        this.zzzc = context.getApplicationContext();
        this.zzdvj = context instanceof Activity ? (Activity) context : null;
        this.zzehy = context;
        super.setBaseContext(this.zzzc);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zzdvj;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        this.zzzc.startActivity(intent);
    }

    public final Activity zzxn() {
        return this.zzdvj;
    }

    public final Object getSystemService(String str) {
        return this.zzehy.getSystemService(str);
    }

    public final Context zzzk() {
        return this.zzehy;
    }
}
