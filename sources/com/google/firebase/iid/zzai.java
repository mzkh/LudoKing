package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final /* synthetic */ class zzai implements ComponentFactory {
    static final ComponentFactory zza = new zzai();

    private zzai() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new zza((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }
}
