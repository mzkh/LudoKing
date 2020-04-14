package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.zzh;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class RealTimeMultiplayerClient extends zzt {

    public interface ReliableMessageSentCallback extends com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback {
        void onRealTimeMessageSent(int i, int i2, String str);
    }

    RealTimeMultiplayerClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    RealTimeMultiplayerClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Intent> getWaitingRoomIntent(@NonNull Room room, @IntRange(from = 0) int i) {
        return doRead((TaskApiCall<A, TResult>) new zzba<A,TResult>(this, room, i));
    }

    public Task<Intent> getSelectOpponentsIntent(@IntRange(from = 1) int i, @IntRange(from = 1) int i2) {
        return getSelectOpponentsIntent(i, i2, true);
    }

    public Task<Intent> getSelectOpponentsIntent(@IntRange(from = 1) int i, @IntRange(from = 1) int i2, boolean z) {
        return doRead((TaskApiCall<A, TResult>) new zzbi<A,TResult>(this, i, i2, z));
    }

    public Task<Void> create(@NonNull RoomConfig roomConfig) {
        ListenerHolder registerListener = registerListener(roomConfig.zzdo(), zzh.class.getSimpleName());
        return doRegisterEventListener(new zzbj(this, registerListener, registerListener, roomConfig), new zzbk(this, registerListener.getListenerKey()));
    }

    public Task<Void> join(@NonNull RoomConfig roomConfig) {
        ListenerHolder registerListener = registerListener(roomConfig.zzdo(), zzh.class.getSimpleName());
        return doRegisterEventListener(new zzbl(this, registerListener, registerListener, roomConfig), new zzbm(this, registerListener.getListenerKey()));
    }

    public Task<Void> leave(@NonNull RoomConfig roomConfig, @NonNull String str) {
        ListenerHolder registerListener = registerListener(roomConfig.zzdo(), zzh.class.getSimpleName());
        return doRead((TaskApiCall<A, TResult>) new zzbg<A,TResult>(this, str)).continueWithTask(new zzbq(this, registerListener)).continueWithTask(new zzbn(this, registerListener, str, roomConfig));
    }

    public Task<Integer> sendReliableMessage(@NonNull byte[] bArr, @NonNull String str, @NonNull String str2, @Nullable ReliableMessageSentCallback reliableMessageSentCallback) {
        zzbr zzbr = new zzbr(this, reliableMessageSentCallback != null ? ListenerHolders.createListenerHolder(reliableMessageSentCallback, Looper.getMainLooper(), ReliableMessageSentCallback.class.getSimpleName()) : null, bArr, str, str2);
        return doWrite((TaskApiCall<A, TResult>) zzbr);
    }

    public Task<Void> sendUnreliableMessage(@NonNull byte[] bArr, @NonNull String str, @NonNull String str2) {
        return doWrite((TaskApiCall<A, TResult>) new zzbb<A,TResult>(this, bArr, str, str2));
    }

    public Task<Void> sendUnreliableMessage(@NonNull byte[] bArr, @NonNull String str, @NonNull List<String> list) {
        return doWrite((TaskApiCall<A, TResult>) new zzbc<A,TResult>(this, list, bArr, str));
    }

    public Task<Void> sendUnreliableMessageToOthers(@NonNull byte[] bArr, @NonNull String str) {
        return doWrite((TaskApiCall<A, TResult>) new zzbd<A,TResult>(this, bArr, str));
    }

    public Task<Void> declineInvitation(@NonNull String str) {
        return doWrite((TaskApiCall<A, TResult>) new zzbe<A,TResult>(this, str));
    }

    public Task<Void> dismissInvitation(@NonNull String str) {
        return doWrite((TaskApiCall<A, TResult>) new zzbf<A,TResult>(this, str));
    }
}
