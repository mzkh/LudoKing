package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Calendar;

class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState = new TwilightState();

    private static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;

        TwilightState() {
        }
    }

    static TwilightManager getInstance(@NonNull Context context) {
        if (sInstance == null) {
            Context applicationContext = context.getApplicationContext();
            sInstance = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService(Param.LOCATION));
        }
        return sInstance;
    }

    @VisibleForTesting
    static void setInstance(TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    /* access modifiers changed from: 0000 */
    public boolean isNight() {
        TwilightState twilightState = this.mTwilightState;
        if (isStateValid()) {
            return twilightState.isNight;
        }
        Location lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation != null) {
            updateState(lastKnownLocation);
            return twilightState.isNight;
        }
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocation() {
        Location location = null;
        Location lastKnownLocationForProvider = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? getLastKnownLocationForProvider("network") : null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = getLastKnownLocationForProvider("gps");
        }
        if (location == null || lastKnownLocationForProvider == null) {
            if (location != null) {
                lastKnownLocationForProvider = location;
            }
            return lastKnownLocationForProvider;
        }
        if (location.getTime() > lastKnownLocationForProvider.getTime()) {
            lastKnownLocationForProvider = location;
        }
        return lastKnownLocationForProvider;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location getLastKnownLocationForProvider(String str) {
        try {
            if (this.mLocationManager.isProviderEnabled(str)) {
                return this.mLocationManager.getLastKnownLocation(str);
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to get last known location", e);
        }
        return null;
    }

    private boolean isStateValid() {
        return this.mTwilightState.nextUpdate > System.currentTimeMillis();
    }

    private void updateState(@NonNull Location location) {
        long j;
        TwilightState twilightState = this.mTwilightState;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator instance = TwilightCalculator.getInstance();
        TwilightCalculator twilightCalculator = instance;
        twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = instance.sunset;
        twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = instance.state == 1;
        long j3 = instance.sunrise;
        long j4 = j2;
        long j5 = instance.sunset;
        long j6 = j3;
        boolean z2 = z;
        instance.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = instance.sunrise;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            long j8 = currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6;
            j = j8 + 60000;
        }
        twilightState.isNight = z2;
        twilightState.yesterdaySunset = j4;
        twilightState.todaySunrise = j6;
        twilightState.todaySunset = j5;
        twilightState.tomorrowSunrise = j7;
        twilightState.nextUpdate = j;
    }
}
