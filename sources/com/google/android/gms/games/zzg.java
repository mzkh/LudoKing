package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;

final class zzg implements ResultConverter<LoadEventsResult, EventBuffer> {
    zzg() {
    }

    public final /* synthetic */ Object convert(Result result) {
        LoadEventsResult loadEventsResult = (LoadEventsResult) result;
        if (loadEventsResult == null) {
            return null;
        }
        return loadEventsResult.getEvents();
    }
}
