package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbau implements zzaer<zzazj> {
    private boolean zzedc;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzuv.zzoj();
            return zzawy.zza(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzaug.zzeu(sb.toString());
            return i;
        }
    }

    private static void zza(zzayw zzayw, Map<String, String> map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzayw.zzcs(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzaug.zzeu(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzayw.zzct(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzayw.zzcu(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzayw.zzcv(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzayw.zzcw(Integer.parseInt(str5));
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int i;
        String[] split;
        zzazj zzazj = (zzazj) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (str == null) {
            zzaug.zzeu("Action missing from video GMSG.");
            return;
        }
        if (zzaug.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzaug.zzdv(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzaug.zzeu("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzazj.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException unused) {
                zzaug.zzeu("Invalid color parameter in video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str)) {
                String str3 = (String) map.get("mimeTypes");
                if (str3 == null) {
                    zzaug.zzeu("No MIME types specified for decoder properties inspection.");
                    zzayw.zza(zzazj, "missingMimeTypes");
                } else if (VERSION.SDK_INT < 16) {
                    zzaug.zzeu("Video decoder properties available on API versions >= 16.");
                    zzayw.zza(zzazj, "deficientApiVersion");
                } else {
                    HashMap hashMap = new HashMap();
                    for (String str4 : str3.split(",")) {
                        hashMap.put(str4, zzaww.zzem(str4.trim()));
                    }
                    zzayw.zza(zzazj, (Map<String, List<Map<String, Object>>>) hashMap);
                }
            } else {
                zzazc zzxk = zzazj.zzxk();
                if (zzxk == null) {
                    zzaug.zzeu("Could not get underlay container for a video GMSG.");
                    return;
                }
                boolean equals = "new".equals(str);
                boolean equals2 = "position".equals(str);
                String str5 = "y";
                String str6 = "x";
                if (equals || equals2) {
                    Context context = zzazj.getContext();
                    int zza = zza(context, map, str6, 0);
                    int zza2 = zza(context, map, str5, 0);
                    int zza3 = zza(context, map, "w", -1);
                    int zza4 = zza(context, map, "h", -1);
                    int min = Math.min(zza3, zzazj.zzxt() - zza);
                    int min2 = Math.min(zza4, zzazj.zzxs() - zza2);
                    try {
                        i = Integer.parseInt((String) map.get("player"));
                    } catch (NumberFormatException unused2) {
                        i = 0;
                    }
                    boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                    if (!equals || zzxk.zzxg() != null) {
                        zzxk.zze(zza, zza2, min, min2);
                        return;
                    }
                    zzxk.zza(zza, zza2, min, min2, i, parseBoolean, new zzazk((String) map.get("flags")));
                    zzayw zzxg = zzxk.zzxg();
                    if (zzxg != null) {
                        zza(zzxg, map);
                    }
                    return;
                }
                zzbco zzxl = zzazj.zzxl();
                String str7 = String.VIDEO_CURRENT_TIME;
                if (zzxl != null) {
                    if ("timeupdate".equals(str)) {
                        String str8 = (String) map.get(str7);
                        if (str8 == null) {
                            zzaug.zzeu("currentTime parameter missing from timeupdate video GMSG.");
                            return;
                        }
                        try {
                            zzxl.zze(Float.parseFloat(str8));
                            return;
                        } catch (NumberFormatException unused3) {
                            String str9 = "Could not parse currentTime parameter from timeupdate video GMSG: ";
                            String valueOf = String.valueOf(str8);
                            zzaug.zzeu(valueOf.length() != 0 ? str9.concat(valueOf) : new String(str9));
                            return;
                        }
                    } else if ("skip".equals(str)) {
                        zzxl.zzaap();
                        return;
                    }
                }
                zzayw zzxg2 = zzxk.zzxg();
                if (zzxg2 == null) {
                    zzayw.zzb(zzazj);
                } else if (String.CLICK.equals(str)) {
                    Context context2 = zzazj.getContext();
                    int zza5 = zza(context2, map, str6, 0);
                    int zza6 = zza(context2, map, str5, 0);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                    zzxg2.zze(obtain);
                    obtain.recycle();
                } else if (str7.equals(str)) {
                    String str10 = (String) map.get("time");
                    if (str10 == null) {
                        zzaug.zzeu("Time parameter missing from currentTime video GMSG.");
                        return;
                    }
                    try {
                        zzxg2.seekTo((int) (Float.parseFloat(str10) * 1000.0f));
                    } catch (NumberFormatException unused4) {
                        String str11 = "Could not parse time parameter from currentTime video GMSG: ";
                        String valueOf2 = String.valueOf(str10);
                        zzaug.zzeu(valueOf2.length() != 0 ? str11.concat(valueOf2) : new String(str11));
                    }
                } else if (MessengerShareContentUtility.SHARE_BUTTON_HIDE.equals(str)) {
                    zzxg2.setVisibility(4);
                } else if ("load".equals(str)) {
                    zzxg2.zzhk();
                } else if ("loadControl".equals(str)) {
                    zza(zzxg2, map);
                } else {
                    String str12 = "muted";
                    if (str12.equals(str)) {
                        if (Boolean.parseBoolean((String) map.get(str12))) {
                            zzxg2.zzxa();
                        } else {
                            zzxg2.zzxb();
                        }
                    } else if ("pause".equals(str)) {
                        zzxg2.pause();
                    } else if ("play".equals(str)) {
                        zzxg2.play();
                    } else if ("show".equals(str)) {
                        zzxg2.setVisibility(0);
                    } else {
                        String str13 = "src";
                        if (str13.equals(str)) {
                            String str14 = (String) map.get(str13);
                            String[] strArr = {str14};
                            String str15 = (String) map.get("demuxed");
                            if (str15 != null) {
                                try {
                                    JSONArray jSONArray = new JSONArray(str15);
                                    String[] strArr2 = new String[jSONArray.length()];
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        strArr2[i2] = jSONArray.getString(i2);
                                    }
                                    strArr = strArr2;
                                } catch (JSONException unused5) {
                                    String str16 = "Malformed demuxed URL list for playback: ";
                                    String valueOf3 = String.valueOf(str15);
                                    zzaug.zzeu(valueOf3.length() != 0 ? str16.concat(valueOf3) : new String(str16));
                                    strArr = new String[]{str14};
                                }
                            }
                            zzxg2.zzc(str14, strArr);
                        } else if ("touchMove".equals(str)) {
                            Context context3 = zzazj.getContext();
                            zzxg2.zza((float) zza(context3, map, "dx", 0), (float) zza(context3, map, "dy", 0));
                            if (!this.zzedc) {
                                zzazj.zzsv();
                                this.zzedc = true;
                            }
                        } else {
                            String str17 = "volume";
                            if (str17.equals(str)) {
                                String str18 = (String) map.get(str17);
                                if (str18 == null) {
                                    zzaug.zzeu("Level parameter missing from volume video GMSG.");
                                    return;
                                }
                                try {
                                    zzxg2.setVolume(Float.parseFloat(str18));
                                } catch (NumberFormatException unused6) {
                                    String str19 = "Could not parse volume parameter from volume video GMSG: ";
                                    String valueOf4 = String.valueOf(str18);
                                    zzaug.zzeu(valueOf4.length() != 0 ? str19.concat(valueOf4) : new String(str19));
                                }
                            } else if ("watermark".equals(str)) {
                                zzxg2.zzxc();
                            } else {
                                String str20 = "Unknown video action: ";
                                String valueOf5 = String.valueOf(str);
                                zzaug.zzeu(valueOf5.length() != 0 ? str20.concat(valueOf5) : new String(str20));
                            }
                        }
                    }
                }
            }
        }
    }
}
