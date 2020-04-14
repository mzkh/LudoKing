package com.google.android.gms.internal.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.C1774R;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzana extends zzanj {
    private final Map<String, String> zzcuv;
    /* access modifiers changed from: private */
    public final Context zzlk;

    public zzana(zzbbw zzbbw, Map<String, String> map) {
        super(zzbbw, "storePicture");
        this.zzcuv = map;
        this.zzlk = zzbbw.zzxn();
    }

    public final void execute() {
        if (this.zzlk == null) {
            zzdn("Activity context is not available");
            return;
        }
        zzq.zzkj();
        if (!zzaul.zzas(this.zzlk).zzpo()) {
            zzdn("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zzcuv.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdn("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String str2 = "Invalid image url: ";
            String valueOf = String.valueOf(str);
            zzdn(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzq.zzkj();
            if (!zzaul.zzee(lastPathSegment)) {
                String str3 = "Image type not recognized: ";
                String valueOf2 = String.valueOf(lastPathSegment);
                zzdn(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                return;
            }
            Resources resources = zzq.zzkn().getResources();
            zzq.zzkj();
            Builder zzar = zzaul.zzar(this.zzlk);
            zzar.setTitle(resources != null ? resources.getString(C1774R.string.f3699s1) : "Save image");
            zzar.setMessage(resources != null ? resources.getString(C1774R.string.f3700s2) : "Allow Ad to store image in Picture gallery?");
            zzar.setPositiveButton(resources != null ? resources.getString(C1774R.string.f3701s3) : "Accept", new zzand(this, str, lastPathSegment));
            zzar.setNegativeButton(resources != null ? resources.getString(C1774R.string.f3702s4) : "Decline", new zzanc(this));
            zzar.create().show();
        }
    }
}
