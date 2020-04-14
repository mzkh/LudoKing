package com.google.android.gms.drive;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface TransferPreferences {
    public static final int BATTERY_USAGE_CHARGING_ONLY = 257;
    public static final int BATTERY_USAGE_UNKNOWN = 0;
    public static final int BATTERY_USAGE_UNRESTRICTED = 256;
    public static final int NETWORK_TYPE_ANY = 1;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI_ONLY = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BatteryUsage {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    int getBatteryUsagePreference();

    int getNetworkPreference();

    boolean isRoamingAllowed();
}
