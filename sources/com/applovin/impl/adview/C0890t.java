package com.applovin.impl.adview;

import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.applovin.impl.adview.t */
interface C0890t {
    int getCurrentPosition();

    int getDuration();

    int getHeight();

    int getWidth();

    boolean isPlaying();

    void pause();

    void seekTo(int i);

    void setLayoutParams(LayoutParams layoutParams);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setVideoSize(int i, int i2);

    void setVideoURI(Uri uri);

    void start();

    void stopPlayback();
}
