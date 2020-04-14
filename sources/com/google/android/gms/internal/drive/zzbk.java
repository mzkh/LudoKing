package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzn;

final class zzbk extends zzav {
    private final /* synthetic */ zzbi zzet;
    private final /* synthetic */ MetadataChangeSet zzeu;
    private final /* synthetic */ zzn zzev;

    zzbk(zzbi zzbi, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, zzn zzn) {
        this.zzet = zzbi;
        this.zzeu = metadataChangeSet;
        this.zzev = zzn;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzeu.zzp().zza(zzaw.getContext());
        zzeo zzeo = (zzeo) zzaw.getService();
        zzm zzm = new zzm(this.zzet.zzeq.getDriveId(), this.zzeu.zzp(), this.zzet.zzeq.getRequestId(), this.zzet.zzeq.zza(), this.zzev);
        zzeo.zza(zzm, (zzeq) new zzgs(this));
    }
}
