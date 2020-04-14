package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.appsflyer.share.Constants;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzbcw;
import com.google.android.gms.internal.ads.zzbda;
import com.google.android.gms.internal.ads.zzbdb;
import com.google.android.gms.internal.ads.zzbdd;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import java.net.URISyntaxException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaev<T extends zzbct & zzbcw & zzbda & zzbdb & zzbdd> implements zzaer<T> {
    private final zzc zzcyb;
    private final zzamz zzcyc;

    public zzaev(zzc zzc, zzamz zzamz) {
        this.zzcyb = zzc;
        this.zzcyc = zzamz;
    }

    private static boolean zzd(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zze(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                zzq.zzkl();
                return 7;
            } else if ("l".equalsIgnoreCase(str)) {
                zzq.zzkl();
                return 6;
            } else if (Constants.URL_CAMPAIGN.equalsIgnoreCase(str)) {
                return zzq.zzkl().zzvq();
            }
        }
        return -1;
    }

    private final void zzu(boolean z) {
        zzamz zzamz = this.zzcyc;
        if (zzamz != null) {
            zzamz.zzv(z);
        }
    }

    @VisibleForTesting
    static String zza(Context context, zzdf zzdf, String str, View view, @Nullable Activity activity) {
        if (zzdf == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzdf.zzd(parse)) {
                parse = zzdf.zza(parse, context, view, activity);
            }
            return parse.toString();
        } catch (zzdi unused) {
            return str;
        } catch (Exception e) {
            zzq.zzkn().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
            return str;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        String str = "OpenGmsgHandler.onGmsg";
        zzbct zzbct = (zzbct) obj;
        String zzd = zzate.zzd((String) map.get("u"), zzbct.getContext(), true);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            zzaug.zzeu("Action missing from an open GMSG.");
            return;
        }
        zzc zzc = this.zzcyb;
        if (zzc != null && !zzc.zzjk()) {
            this.zzcyb.zzbl(zzd);
        } else if ("expand".equalsIgnoreCase(str2)) {
            if (((zzbcw) zzbct).zzzu()) {
                zzaug.zzeu("Cannot expand WebView that is already expanded.");
                return;
            }
            zzu(false);
            ((zzbda) zzbct).zzb(zzd(map), zze(map));
        } else if ("webapp".equalsIgnoreCase(str2)) {
            zzu(false);
            if (zzd != null) {
                ((zzbda) zzbct).zza(zzd(map), zze(map), zzd);
            } else {
                ((zzbda) zzbct).zza(zzd(map), zze(map), (String) map.get(String.HTML), (String) map.get("baseurl"));
            }
        } else {
            if (TapjoyConstants.TJC_APP_PLACEMENT.equalsIgnoreCase(str2)) {
                if ("true".equalsIgnoreCase((String) map.get("system_browser"))) {
                    zzu(true);
                    if (TextUtils.isEmpty(zzd)) {
                        zzaug.zzeu("Destination url cannot be empty.");
                        return;
                    }
                    try {
                        ((zzbda) zzbct).zza(new zzd(new zzaeu(zzbct.getContext(), ((zzbdb) zzbct).zzzs(), ((zzbdd) zzbct).getView()).zzc(map)));
                        return;
                    } catch (ActivityNotFoundException e) {
                        zzaug.zzeu(e.getMessage());
                        return;
                    }
                }
            }
            zzu(true);
            String str3 = (String) map.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str3)) {
                try {
                    intent = Intent.parseUri(str3, 0);
                } catch (URISyntaxException e2) {
                    String str4 = "Error parsing the url: ";
                    String valueOf = String.valueOf(str3);
                    zzaug.zzc(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), e2);
                }
            }
            if (!(intent == null || intent.getData() == null)) {
                Uri data = intent.getData();
                String uri = data.toString();
                if (!TextUtils.isEmpty(uri)) {
                    try {
                        uri = zza(zzbct.getContext(), ((zzbdb) zzbct).zzzs(), uri, ((zzbdd) zzbct).getView(), zzbct.zzxn());
                    } catch (Exception e3) {
                        zzaug.zzc("Error occurred while adding signals.", e3);
                        zzq.zzkn().zza(e3, str);
                    }
                    try {
                        data = Uri.parse(uri);
                    } catch (Exception e4) {
                        String str5 = "Error parsing the uri: ";
                        String valueOf2 = String.valueOf(uri);
                        zzaug.zzc(valueOf2.length() != 0 ? str5.concat(valueOf2) : new String(str5), e4);
                        zzq.zzkn().zza(e4, str);
                    }
                }
                intent.setData(data);
            }
            if (intent != null) {
                ((zzbda) zzbct).zza(new zzd(intent));
                return;
            }
            if (!TextUtils.isEmpty(zzd)) {
                zzd = zza(zzbct.getContext(), ((zzbdb) zzbct).zzzs(), zzd, ((zzbdd) zzbct).getView(), zzbct.zzxn());
            }
            zzbda zzbda = (zzbda) zzbct;
            zzd zzd2 = new zzd((String) map.get("i"), zzd, (String) map.get("m"), (String) map.get("p"), (String) map.get(Constants.URL_CAMPAIGN), (String) map.get("f"), (String) map.get("e"));
            zzbda.zza(zzd2);
        }
    }
}
