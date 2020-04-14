package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdtj {
    static String zzdc(zzdpm zzdpm) {
        zzdtm zzdtm = new zzdtm(zzdpm);
        StringBuilder sb = new StringBuilder(zzdtm.size());
        for (int i = 0; i < zzdtm.size(); i++) {
            byte zzfm = zzdtm.zzfm(i);
            if (zzfm == 34) {
                sb.append("\\\"");
            } else if (zzfm == 39) {
                sb.append("\\'");
            } else if (zzfm != 92) {
                switch (zzfm) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzfm >= 32 && zzfm <= 126) {
                            sb.append((char) zzfm);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzfm >>> 6) & 3) + 48));
                            sb.append((char) (((zzfm >>> 3) & 7) + 48));
                            sb.append((char) ((zzfm & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
