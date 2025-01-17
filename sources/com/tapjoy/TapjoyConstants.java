package com.tapjoy;

public class TapjoyConstants {
    public static final String EXTRA_AD_DATA = "AD_DATA";
    public static final String EXTRA_AD_UNIT_CALLBACK_ID = "AD_UNIT_CALLBACK_ID";
    public static final String EXTRA_CACHED_VIDEO_LOCATION = "CACHED_VIDEO_LOCATION";
    public static final String EXTRA_DISPLAY_AD_URL = "DISPLAY_AD_URL";
    public static final String EXTRA_FEATURED_APP_FULLSCREEN_AD_URL = "FULLSCREEN_AD_URL";
    public static final String EXTRA_FULLSCREEN_HTML_DATA = "FULLSCREEN_HTML_DATA";
    public static final String EXTRA_URL_BASE = "URL_BASE";
    public static final String EXTRA_URL_PARAMS = "URL_PARAMS";
    public static final String EXTRA_USER_ID = "USER_ID";
    public static final String EXTRA_VIDEO_ALLOW_BACK_BUTTON = "VIDEO_ALLOW_BACK_BUTTON";
    public static final String EXTRA_VIDEO_CANCEL_MESSAGE = "VIDEO_CANCEL_MESSAGE";
    public static final String EXTRA_VIDEO_DATA = "VIDEO_DATA";
    public static final String EXTRA_VIDEO_MESSAGE = "VIDEO_MESSAGE";
    public static final String EXTRA_VIDEO_SHOULD_DISMISS = "VIDEO_SHOULD_DISMISS";
    public static final String EXTRA_VIDEO_TRACKING_URLS = "VIDEO_TRACKING_URLS";
    public static final String EXTRA_VIDEO_URL = "VIDEO_URL";
    public static final String LOG_LEVEL_DEBUG_OFF = "debug_off";
    public static final String LOG_LEVEL_DEBUG_ON = "debug_on";
    public static final String LOG_LEVEL_INTERNAL = "internal";
    public static final long PAID_APP_TIME = 900000;
    public static final int PLACEMENT_PRELOAD_STATUS_COMPLETE = 1;
    public static final int PLACEMENT_PRELOAD_STATUS_PARTIAL = 2;
    public static final String PREF_ANALYTICS_ID = "tapjoyAnalyticsId";
    public static final String PREF_BELOW_CONSENT_AGE = "below_consent_age";
    public static final String PREF_CONTAINS_EXTERNAL_DATA = "containsExternalData";
    public static final String PREF_ELAPSED_TIME = "tapjoy_elapsed_time";
    public static final String PREF_INSTALL_ID = "tapjoyInstallId";
    public static final String PREF_LAST_CONNECT_PARAMS_HASH = "connectParamsHash";
    public static final String PREF_LAST_CONNECT_RESULT = "connectResult";
    public static final String PREF_LAST_CONNECT_RESULT_EXPIRES = "connectResultExpires";
    public static final String PREF_LAST_CURRENCY_BALANCE = "last_currency_balance";
    public static final String PREF_LOG_LEVEL = "tapjoyLogLevel";
    public static final String PREF_SERVER_PROVIDED_CONFIGURATIONS = "configurations";
    public static final String PREF_SUBJECT_TO_GDPR = "gdpr";
    public static final String PREF_TAPJOY_CACHE = "tapjoyCacheData";
    public static final String PREF_USER_CONSENT = "cgdpr";
    public static final long SESSION_ID_INACTIVITY_TIME = 1800000;
    public static final String TAPJOY_CACHE_HEADER = "x-tapjoy-cacheable-assets";
    public static final String TAPJOY_DEBUG_HEADER = "X-Tapjoy-Debug";
    public static final String TAPJOY_DISABLE_PRELOAD_HEADER = "X-Tapjoy-Disable-Preload";
    public static final String TAPJOY_PRERENDER_HEADER = "x-tapjoy-prerender";
    public static final String TAPJOY_RENDERED_TRACKING_HEADER = "X-Tapjoy-Rendered-Tracking";
    public static final long TIMER_INCREMENT = 10000;
    public static final String TJC_ADAPTER_VERSION = "adapter_version";
    public static final String TJC_ADVERTISING_ID = "advertising_id";
    public static final String TJC_ADVERTISING_ID_CHECK_DISABLED = "ad_id_check_disabled";
    public static final String TJC_AD_TRACKING_ENABLED = "ad_tracking_enabled";
    public static final int TJC_AD_VIEW = 1;
    public static final String TJC_AMOUNT = "amount";
    public static final String TJC_ANALYTICS_API_KEY = "analytics_api_key";
    public static final String TJC_ANALYTICS_ID = "analytics_id";
    public static final String TJC_ANDROID_ID = "android_id";
    public static final String TJC_API_KEY = "api_key";
    public static final String TJC_APP_GROUP_ID = "app_group_id";
    public static final String TJC_APP_ID = "app_id";
    public static final String TJC_APP_PLACEMENT = "app";
    public static final String TJC_APP_VERSION_NAME = "app_version";
    public static final String TJC_AWARD_CURRENCY_URL_PATH = "points/award?";
    public static final String TJC_BRIDGE_VERSION = "bridge_version";
    public static final String TJC_BRIDGE_VERSION_NUMBER = "1.0.16";
    public static final String TJC_CACHED_OFFERS = "cached_ids";
    public static final String TJC_CARRIER_COUNTRY_CODE = "carrier_country_code";
    public static final String TJC_CARRIER_NAME = "carrier_name";
    public static final String TJC_CLICK_URL = "click_url";
    public static final String TJC_CONNECTION_SUBTYPE = "connection_subtype";
    public static final String TJC_CONNECTION_TYPE = "connection_type";
    public static final String TJC_CONNECTION_TYPE_MOBILE = "mobile";
    public static final String TJC_CONNECTION_TYPE_WIFI = "wifi";
    public static final String TJC_CONNECT_URL_PATH = "api/connect/v3.json?";
    public static final String TJC_CURRENCY = "tap_points";
    public static final String TJC_CURRENCY_ID = "currency_id";
    public static final String TJC_CURRENCY_MULTIPLIER = "display_multiplier";
    public static final String TJC_CURRENCY_NAME = "currency_name";
    public static final String TJC_CUSTOM_PARAMETER = "cp";
    public static final String TJC_DEBUG = "debug";
    public static final String TJC_DEVICE_COUNTRY_CODE = "country_code";
    public static final String TJC_DEVICE_COUNTRY_SIM = "country_sim";
    public static final String TJC_DEVICE_DISPLAY_DENSITY = "display_d";
    public static final String TJC_DEVICE_DISPLAY_HEIGHT = "display_h";
    public static final String TJC_DEVICE_DISPLAY_WIDTH = "display_w";
    public static final String TJC_DEVICE_GOOGLE_PLAY_SERVICES_VERSION = "device_gps_version";
    public static final String TJC_DEVICE_ID_NAME = "udid";
    public static final String TJC_DEVICE_LANGUAGE = "language_code";
    public static final String TJC_DEVICE_MAC_ADDRESS = "mac_address";
    public static final String TJC_DEVICE_MANUFACTURER = "device_manufacturer";
    public static final String TJC_DEVICE_NAME = "device_name";
    public static final String TJC_DEVICE_OS_VERSION_NAME = "os_version";
    public static final String TJC_DEVICE_PLATFORM_TYPE = "android";
    public static final String TJC_DEVICE_SCREEN_DENSITY = "screen_density";
    public static final String TJC_DEVICE_SCREEN_LAYOUT_SIZE = "screen_layout_size";
    public static final String TJC_DEVICE_TIMEZONE = "timezone";
    public static final String TJC_DEVICE_TYPE_NAME = "device_type";
    public static final String TJC_EVENT_DEBUGGING = "tjdebug";
    public static final String TJC_EVENT_URL_PATH = "user_events?";
    public static final String TJC_FALSE = "false";
    public static final String TJC_FULLSCREEN_AD_DISMISS_URL = "dismiss";
    public static final String TJC_GET_CURRENCY_BALANCE_URL_PATH = "get_vg_store_items/user_account?";
    public static final String TJC_GUID = "guid";
    public static final String TJC_INSTALLED = "installed";
    public static final String TJC_INSTALLER = "installer";
    public static final String TJC_INSTALL_ID = "install_id";
    public static final String TJC_LEGACY_ID_FALLBACK_ALLOWED = "legacy_id_fallback_allowed";
    public static final String TJC_LIBRARY_REVISION = "library_revision";
    public static final String TJC_LIBRARY_VERSION = "library_version";
    public static final int TJC_LIBRARY_VERSION_INT = 1241;
    public static final String TJC_LIBRARY_VERSION_NUMBER = "12.4.1";
    public static final String TJC_LIMITED = "lmtd";
    public static final String TJC_MANAGED_DEVICE_ID = "managed_device_id";
    public static final String TJC_MEDIATION_SOURCE = "mediation_source";
    public static final int TJC_MM_CONTEXTUAL = 3;
    public static final int TJC_MM_INTERSTITIAL = 2;
    public static final String TJC_MOBILE_COUNTRY_CODE = "mobile_country_code";
    public static final String TJC_MOBILE_NETWORK_CODE = "mobile_network_code";
    public static final String TJC_MULTIPLE_CURRENCY_SELECTOR_FLAG = "currency_selector";
    public static final String TJC_NOTIFICATION_ALIASES = "[aliases]";
    public static final String TJC_NOTIFICATION_DEVICE_ALIASES_PREFIX = "device_aliases";
    public static final String TJC_NOTIFICATION_DEVICE_ANDROID_ID = "[android_id]";
    public static final String TJC_NOTIFICATION_DEVICE_DEFAULT = "[default]";
    public static final String TJC_NOTIFICATION_DEVICE_MAC_ADDRESS = "[mac_address]";
    public static final String TJC_NOTIFICATION_DEVICE_PREFIX = "device";
    public static final String TJC_NOTIFICATION_DEVICE_SHA1_MAC = "[mac_sha1]";
    public static final String TJC_NOTIFICATION_DEVICE_TAG_NAMES = "[tag_names]";
    public static final String TJC_NOTIFICATION_DEVICE_TIMEZONE = "[timezone]";
    public static final String TJC_NOTIFICATION_DEVICE_TOKEN = "[token]";
    public static final String TJC_NOTIFICATION_ID = "notification_id";
    public static final String TJC_NOTIFICATION_OAUTH_SIGNATURE = "oauth_signature";
    public static final String TJC_NOTIFICATION_OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    public static final int TJC_NO_VIEW = 0;
    public static final String TJC_PACKAGED_GOOGLE_PLAY_SERVICES_VERSION = "packaged_gps_version";
    public static final String TJC_PACKAGE_DATA_VERSION = "pkg_data_ver";
    public static final String TJC_PACKAGE_ID = "pkg_id";
    public static final String TJC_PACKAGE_REVISION = "pkg_rev";
    public static final String TJC_PACKAGE_SIGN = "pkg_sign";
    public static final String TJC_PACKAGE_VERSION = "pkg_ver";
    public static final String TJC_PLACEMENT_AUCTION_MEDIATION_CONTENT_PATH = "bid_content?";
    public static final String TJC_PLACEMENT_CONTENT_PATH = "content?";
    public static final String TJC_PLACEMENT_MEDIATION_CONTENT_PATH = "mediation_content?";
    public static final String TJC_PLACEMENT_OFFER_ID = "offerId";
    public static final int TJC_PLACEMENT_RESPONSE_TIMEOUT = 30000;
    public static final String TJC_PLACEMENT_SERVICE_PATH = "v1/apps";
    public static final String TJC_PLATFORM = "platform";
    public static final String TJC_PLUGIN = "plugin";
    public static final String TJC_PLUGIN_ADOBE_AIR = "adobeair";
    public static final String TJC_PLUGIN_NATIVE = "native";
    public static final String TJC_PLUGIN_PHONEGAP = "phonegap";
    public static final String TJC_PLUGIN_UNITY = "unity";
    public static final String TJC_PREFERENCE = "tjcPrefrences";
    public static final String TJC_PURCHASE_CURRENCY = "purchase_currency";
    public static final String TJC_PURCHASE_LAST_AT = "purchase_last_at";
    public static final String TJC_PURCHASE_LAST_PRICE = "purchase_last_price";
    public static final String TJC_PURCHASE_TOTAL_COUNT = "purchase_total_count";
    public static final String TJC_PURCHASE_TOTAL_PRICE = "purchase_total_price";
    public static final String TJC_REDIRECT_URL = "redirect_url";
    public static final String TJC_REFERRER = "referrer";
    public static final String TJC_RETRY = "retry";
    public static final String TJC_SDK_PLACEMENT = "sdk";
    public static final String TJC_SDK_TYPE = "sdk_type";
    public static final String TJC_SDK_TYPE_CONNECT = "connect";
    public static final String TJC_SDK_TYPE_DEFAULT = "event";
    public static final String TJC_SESSION_ID = "session_id";
    public static final String TJC_SESSION_LAST_AT = "session_last_at";
    public static final String TJC_SESSION_LAST_LENGTH = "session_last_length";
    public static final String TJC_SESSION_TOTAL_COUNT = "session_total_count";
    public static final String TJC_SESSION_TOTAL_LENGTH = "session_total_length";
    public static final String TJC_SPEND_CURRENCY_URL_PATH = "points/spend?";
    public static final String TJC_STORE = "store";
    public static final String TJC_STORE_NAME = "store_name";
    public static final String TJC_STORE_VIEW = "store_view";
    public static final String TJC_SUBJECT_TO_GDPR = "gdpr";
    public static final String TJC_TIMESTAMP = "timestamp";
    public static final String TJC_TIME_TO_LIVE = "timeToLive";
    public static final String TJC_TRUE = "true";
    public static final String TJC_USER_CONSENT = "cgdpr";
    public static final String TJC_USER_FRIEND_COUNT = "friend_count";
    public static final String TJC_USER_ID = "publisher_user_id";
    public static final String TJC_USER_ID_URL_PATH = "set_publisher_user_id?";
    public static final String TJC_USER_LEVEL = "user_level";
    public static final String TJC_USER_MONTHLY_FREQUENCY = "fq30";
    public static final String TJC_USER_TAGS = "user_tags";
    public static final String TJC_USER_VARIABLE_1 = "uv1";
    public static final String TJC_USER_VARIABLE_2 = "uv2";
    public static final String TJC_USER_VARIABLE_3 = "uv3";
    public static final String TJC_USER_VARIABLE_4 = "uv4";
    public static final String TJC_USER_VARIABLE_5 = "uv5";
    public static final String TJC_USER_WEEKLY_FREQUENCY = "fq7";
    public static final String TJC_VERIFIER = "verifier";
    public static final String TJC_VIDEO_AD_URL = "tjvideo://";
    public static final String TJC_VIDEO_COMPLETE_URL = "video_complete_url";
    public static final String TJC_VIDEO_ID = "video_id";
    public static final String TJC_VIDEO_OFFER_WALL_URL = "offer_wall";
    public static final String TJC_VIDEO_TJVIDEO_URL = "tjvideo";
    public static final String TJC_VIDEO_URL = "video_url";
    public static final String TJC_YOUTUBE_AD_PARAM = "tjyoutubevideo=true";
    public static final String[] dependencyClassNames = {"com.tapjoy.TJAdUnitActivity", "com.tapjoy.TJContentActivity"};
    public static final String[] dependencyPermissions = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};
    public static final String[] optionalPermissions = {"android.permission.ACCESS_WIFI_STATE"};
}
