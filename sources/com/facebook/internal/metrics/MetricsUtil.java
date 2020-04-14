package com.facebook.internal.metrics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class MetricsUtil {
    private final String CLASS_TAG = "internal.MetricsUtil";
    private final String STARTUP_METRICS_PREFERENCES = "MetricsUtil";
    private final String TIME_DIFFERENCE_BASE_PREF = "time_difference";
    private WeakReference<Context> ctx;
    private MetricsUtil metricsUtil;
    private HashMap<Tag, Long> taggedStartTimer = new HashMap<>();

    private MetricsUtil(Context context) {
        this.ctx = new WeakReference<>(context);
    }

    public synchronized MetricsUtil getInstance(Context context) {
        if (this.metricsUtil == null) {
            this.metricsUtil = new MetricsUtil(context);
            return this.metricsUtil;
        }
        return this.metricsUtil;
    }

    public void startMeasureFor(Tag tag) {
        this.taggedStartTimer.put(tag, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public void stopMeasureFor(Tag tag) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.taggedStartTimer.containsKey(tag)) {
            long longValue = elapsedRealtime - ((Long) this.taggedStartTimer.get(tag)).longValue();
            this.taggedStartTimer.remove(tag);
            updateLastTimeDifferenceFor(tag, longValue);
        }
    }

    public long getLastTimeDifferenceFor(Tag tag) {
        if (this.ctx.get() == null) {
            Utility.logd("internal.MetricsUtil", "getLastTimeDifferenceFor: Context is null");
            return -1;
        }
        SharedPreferences sharedPreferences = ((Context) this.ctx.get()).getSharedPreferences("MetricsUtil", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("time_difference");
        sb.append(tag.getSuffix());
        return sharedPreferences.getLong(sb.toString(), -1);
    }

    private void updateLastTimeDifferenceFor(Tag tag, long j) {
        if (this.ctx.get() == null) {
            Utility.logd("internal.MetricsUtil", "updateLastTimeDifferenceFor: Context is null");
            return;
        }
        Editor edit = ((Context) this.ctx.get()).getSharedPreferences("MetricsUtil", 0).edit();
        StringBuilder sb = new StringBuilder();
        sb.append("time_difference");
        sb.append(tag.getSuffix());
        edit.putLong(sb.toString(), j).apply();
    }
}
