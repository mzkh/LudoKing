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
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.games.video.Videos.CaptureStateResult;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class VideosClient extends zzt {
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STARTED = 2;
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STOPPED = 3;
    public static final int CAPTURE_OVERLAY_STATE_DISMISSED = 4;
    public static final int CAPTURE_OVERLAY_STATE_SHOWN = 1;
    private static final ResultConverter<CaptureAvailableResult, Boolean> zzez = new zzda();
    private static final ResultConverter<CaptureStateResult, CaptureState> zzfa = new zzdb();
    private static final ResultConverter<CaptureCapabilitiesResult, VideoCapabilities> zzfb = new zzdc();

    public interface OnCaptureOverlayStateListener extends CaptureOverlayStateListener {
        void onCaptureOverlayStateChanged(int i);
    }

    VideosClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    VideosClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<VideoCapabilities> getCaptureCapabilities() {
        return zzbe.toTask(Games.Videos.getCaptureCapabilities(asGoogleApiClient()), zzfb);
    }

    public Task<Intent> getCaptureOverlayIntent() {
        return doRead((TaskApiCall<A, TResult>) new zzcw<A,TResult>(this));
    }

    public Task<CaptureState> getCaptureState() {
        return zzbe.toTask(Games.Videos.getCaptureState(asGoogleApiClient()), zzfa);
    }

    public Task<Boolean> isCaptureAvailable(int i) {
        return zzbe.toTask(Games.Videos.isCaptureAvailable(asGoogleApiClient(), i), zzez);
    }

    public Task<Boolean> isCaptureSupported() {
        return doRead((TaskApiCall<A, TResult>) new zzcx<A,TResult>(this));
    }

    public Task<Void> registerOnCaptureOverlayStateChangedListener(@NonNull OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        ListenerHolder registerListener = registerListener(onCaptureOverlayStateListener, OnCaptureOverlayStateListener.class.getSimpleName());
        return doRegisterEventListener(new zzcy(this, registerListener, registerListener), new zzcz(this, registerListener.getListenerKey()));
    }

    public Task<Boolean> unregisterOnCaptureOverlayStateChangedListener(@NonNull OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(onCaptureOverlayStateListener, OnCaptureOverlayStateListener.class.getSimpleName()));
    }
}
