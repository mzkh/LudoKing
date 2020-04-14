package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzd;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzl;
import com.google.android.gms.drive.events.zzo;
import com.google.android.gms.drive.events.zzq;
import com.google.android.gms.drive.events.zzr;

final class zzeg extends Handler {
    private final Context zzgu;

    private zzeg(Looper looper, Context context) {
        super(looper);
        this.zzgu = context;
    }

    public final void handleMessage(Message message) {
        String str = "EventCallback";
        if (message.what != 1) {
            zzee.zzbx.efmt(str, "Don't know how to handle this event in context %s", this.zzgu);
            return;
        }
        Pair pair = (Pair) message.obj;
        zzi zzi = (zzi) pair.first;
        DriveEvent driveEvent = (DriveEvent) pair.second;
        int type = driveEvent.getType();
        if (type == 1) {
            ((ChangeListener) zzi).onChange((ChangeEvent) driveEvent);
        } else if (type == 2) {
            ((CompletionListener) zzi).onCompletion((CompletionEvent) driveEvent);
        } else if (type == 3) {
            zzq zzq = (zzq) zzi;
            zzo zzo = (zzo) driveEvent;
            DataHolder zzy = zzo.zzy();
            if (zzy != null) {
                zzq.zza(new zzeh(new MetadataBuffer(zzy)));
            }
            if (zzo.zzz()) {
                zzq.zzc(zzo.zzaa());
            }
        } else if (type == 4) {
            ((zzd) zzi).zza((zzb) driveEvent);
        } else if (type != 8) {
            zzee.zzbx.wfmt(str, "Unexpected event: %s", driveEvent);
        } else {
            ((zzl) zzi).zza(new zze(((zzr) driveEvent).zzab()));
        }
    }
}
