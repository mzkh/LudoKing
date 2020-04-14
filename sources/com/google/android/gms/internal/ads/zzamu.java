package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.C1774R;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzamu extends zzanj {
    private final Map<String, String> zzcuv;
    private String zzdfh = zzdl("description");
    private long zzdfi = zzdm("start_ticks");
    private long zzdfj = zzdm("end_ticks");
    private String zzdfk = zzdl("summary");
    private String zzdfl = zzdl(Param.LOCATION);
    /* access modifiers changed from: private */
    public final Context zzlk;

    public zzamu(zzbbw zzbbw, Map<String, String> map) {
        super(zzbbw, "createCalendarEvent");
        this.zzcuv = map;
        this.zzlk = zzbbw.zzxn();
    }

    private final String zzdl(String str) {
        return TextUtils.isEmpty((CharSequence) this.zzcuv.get(str)) ? "" : (String) this.zzcuv.get(str);
    }

    private final long zzdm(String str) {
        String str2 = (String) this.zzcuv.get(str);
        long j = -1;
        if (str2 == null) {
            return -1;
        }
        try {
            j = Long.parseLong(str2);
        } catch (NumberFormatException unused) {
        }
        return j;
    }

    public final void execute() {
        if (this.zzlk == null) {
            zzdn("Activity context is not available.");
            return;
        }
        zzq.zzkj();
        if (!zzaul.zzas(this.zzlk).zzpp()) {
            zzdn("This feature is not available on the device.");
            return;
        }
        zzq.zzkj();
        Builder zzar = zzaul.zzar(this.zzlk);
        Resources resources = zzq.zzkn().getResources();
        zzar.setTitle(resources != null ? resources.getString(C1774R.string.f3703s5) : "Create calendar event");
        zzar.setMessage(resources != null ? resources.getString(C1774R.string.f3704s6) : "Allow Ad to create a calendar event?");
        zzar.setPositiveButton(resources != null ? resources.getString(C1774R.string.f3701s3) : "Accept", new zzamx(this));
        zzar.setNegativeButton(resources != null ? resources.getString(C1774R.string.f3702s4) : "Decline", new zzamw(this));
        zzar.create().show();
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.zzdfh);
        data.putExtra("eventLocation", this.zzdfl);
        data.putExtra("description", this.zzdfk);
        long j = this.zzdfi;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdfj;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }
}
