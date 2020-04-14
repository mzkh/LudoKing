package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.Payload.File;
import com.google.android.gms.nearby.connection.Payload.Stream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class zzfl {
    static Pair<zzfh, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> zza(Payload payload) throws IOException {
        int type = payload.getType();
        if (type == 1) {
            return Pair.create(new zzfj().zzb(payload.getId()).zzd(payload.getType()).zzb(payload.asBytes()).zzr(), null);
        }
        if (type != 2) {
            String str = "NearbyConnections";
            if (type == 3) {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    ParcelFileDescriptor[] createPipe2 = ParcelFileDescriptor.createPipe();
                    return Pair.create(new zzfj().zzb(payload.getId()).zzd(payload.getType()).zzc(createPipe[0]).zzd(createPipe2[0]).zzr(), Pair.create(createPipe[1], createPipe2[1]));
                } catch (IOException e) {
                    Log.e(str, String.format("Unable to create PFD pipe for streaming payload %d from client to service.", new Object[]{Long.valueOf(payload.getId())}), e);
                    throw e;
                }
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", new Object[]{Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())}));
                Log.wtf(str, "Unknown payload type!", illegalArgumentException);
                throw illegalArgumentException;
            }
        } else {
            return Pair.create(new zzfj().zzb(payload.getId()).zzd(payload.getType()).zzc(payload.asFile().asParcelFileDescriptor()).zze(payload.asFile().asJavaFile() == null ? null : payload.asFile().asJavaFile().getAbsolutePath()).zzc(payload.asFile().getSize()).zzr(), null);
        }
    }

    static Payload zza(zzfh zzfh) {
        long id = zzfh.getId();
        int type = zzfh.getType();
        if (type == 1) {
            return Payload.zza(zzfh.getBytes(), id);
        }
        String str = "NearbyConnections";
        if (type == 2) {
            String zzp = zzfh.zzp();
            if (zzp != null) {
                try {
                    return Payload.zza(File.zza(new java.io.File(zzp), zzfh.zzq()), id);
                } catch (FileNotFoundException e) {
                    String str2 = "Failed to create Payload from ParcelablePayload: Java file not found at ";
                    String valueOf = String.valueOf(zzp);
                    Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
                }
            }
            return Payload.zza(File.zza(zzfh.zzo()), id);
        } else if (type == 3) {
            return Payload.zza(Stream.zzb(zzfh.zzo()), id);
        } else {
            Log.w(str, String.format("Incoming ParcelablePayload %d has unknown type %d", new Object[]{Long.valueOf(zzfh.getId()), Integer.valueOf(zzfh.getType())}));
            return null;
        }
    }
}
