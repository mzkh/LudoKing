package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class EventsClient extends zzt {
    private static final ResultConverter<LoadEventsResult, EventBuffer> zzj = new zzg();

    EventsClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    EventsClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<AnnotatedData<EventBuffer>> load(boolean z) {
        return zzbe.zzb(Games.Events.load(asGoogleApiClient(), z), zzj);
    }

    public Task<AnnotatedData<EventBuffer>> loadByIds(boolean z, @NonNull String... strArr) {
        return zzbe.zzb(Games.Events.loadByIds(asGoogleApiClient(), z, strArr), zzj);
    }

    public void increment(@NonNull String str, @IntRange(from = 0) int i) {
        doWrite((TaskApiCall<A, TResult>) new zzf<A,TResult>(this, str, i));
    }
}
