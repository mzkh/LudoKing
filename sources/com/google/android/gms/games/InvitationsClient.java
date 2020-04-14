package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.InvitationCallback;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class InvitationsClient extends zzt {
    private static final ResultConverter<LoadInvitationsResult, InvitationBuffer> zzbi = new zzaa();

    InvitationsClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    InvitationsClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Intent> getInvitationInboxIntent() {
        return doRead((TaskApiCall<A, TResult>) new zzx<A,TResult>(this));
    }

    public Task<Void> registerInvitationCallback(@NonNull InvitationCallback invitationCallback) {
        ListenerHolder registerListener = registerListener(invitationCallback, InvitationCallback.class.getSimpleName());
        return doRegisterEventListener(new zzy(this, registerListener, registerListener), new zzz(this, registerListener.getListenerKey()));
    }

    public Task<Boolean> unregisterInvitationCallback(@NonNull InvitationCallback invitationCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(invitationCallback, InvitationCallback.class.getSimpleName()));
    }

    public Task<AnnotatedData<InvitationBuffer>> loadInvitations() {
        return loadInvitations(0);
    }

    public Task<AnnotatedData<InvitationBuffer>> loadInvitations(int i) {
        return zzbe.zzb(Games.Invitations.loadInvitations(asGoogleApiClient(), i), zzbi);
    }
}
