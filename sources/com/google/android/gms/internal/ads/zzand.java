package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzand implements OnClickListener {
    private final /* synthetic */ zzana zzdge;
    private final /* synthetic */ String zzdgf;
    private final /* synthetic */ String zzdgg;

    zzand(zzana zzana, String str, String str2) {
        this.zzdge = zzana;
        this.zzdgf = str;
        this.zzdgg = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzdge.zzlk.getSystemService("download");
        try {
            String str = this.zzdgf;
            String str2 = this.zzdgg;
            Request request = new Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzq.zzkl();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdge.zzdn("Could not store picture.");
        }
    }
}
