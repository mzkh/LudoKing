package com.google.firebase.iid;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final class zzo implements Continuation<Bundle, String> {
    private final /* synthetic */ zzk zza;

    zzo(zzk zzk) {
        this.zza = zzk;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        return zzk.zza((Bundle) task.getResult(IOException.class));
    }
}
