package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzsf {

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends zzdqw<zza, zzb> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zza zzbsd;
        private static volatile zzdsp<zza> zzdv;

        /* renamed from: com.google.android.gms.internal.ads.zzsf$zza$zza reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum C3512zza implements zzdra {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_FAILED_TO_LOAD_INVALID_REQUEST(100),
            AD_FAILED_TO_LOAD_NETWORK_ERROR(101),
            AD_FAILED_TO_LOAD_TIMEOUT(102),
            AD_FAILED_TO_LOAD_CANCELLED(103),
            AD_FAILED_TO_LOAD_NO_ERROR(104),
            AD_FAILED_TO_LOAD_NOT_FOUND(105),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(PointerIconCompat.TYPE_HELP),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(PointerIconCompat.TYPE_WAIT),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(PointerIconCompat.TYPE_CELL),
            REQUEST_FAILED_TO_RENDER(PointerIconCompat.TYPE_CROSSHAIR),
            REQUEST_IS_PREFETCH(1100),
            REQUEST_SAVED_TO_CACHE(1101),
            REQUEST_LOADED_FROM_CACHE(1102),
            REQUEST_PREFETCH_INTERCEPTED(1103),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED),
            ANDROID_WEBVIEW_CRASH(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED),
            OFFLINE_UPLOAD(GamesActivityResultCodes.RESULT_LICENSE_FAILED),
            DELAY_PAGE_LOAD_CANCELLED_AD(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED);
            
            private static final zzdqz<C3512zza> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName());
                sb.append('@');
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=");
                sb.append(this.value);
                sb.append(" name=");
                sb.append(name());
                sb.append('>');
                return sb.toString();
            }

            private C3512zza(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzsj();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zza, zzb> implements zzdsi {
            private zzb() {
                super(zza.zzbsd);
            }

            /* synthetic */ zzb(zzsh zzsh) {
                this();
            }
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzsh.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza((zzdsg) zzbsd, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbsd;
                case 5:
                    zzdsp<zza> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zza.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new zzc<>(zzbsd);
                                zzdv = zzdsp;
                            }
                        }
                    }
                    return zzdsp;
                case 6:
                    return Byte.valueOf(1);
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzbsd = zza;
            zzdqw.zza(zza.class, zza);
        }
    }
}
