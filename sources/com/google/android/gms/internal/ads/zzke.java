package com.google.android.gms.internal.ads;

import android.util.Log;
import com.appsflyer.share.Constants;
import com.google.android.gms.internal.ads.zzkx.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzke {
    private static final int zzavv = zzof.zzbi("nam");
    private static final int zzavw = zzof.zzbi("trk");
    private static final int zzavx = zzof.zzbi("cmt");
    private static final int zzavy = zzof.zzbi("day");
    private static final int zzavz = zzof.zzbi("ART");
    private static final int zzawa = zzof.zzbi("too");
    private static final int zzawb = zzof.zzbi("alb");
    private static final int zzawc = zzof.zzbi("com");
    private static final int zzawd = zzof.zzbi("wrt");
    private static final int zzawe = zzof.zzbi("lyr");
    private static final int zzawf = zzof.zzbi("gen");
    private static final int zzawg = zzof.zzbi("covr");
    private static final int zzawh = zzof.zzbi("gnre");
    private static final int zzawi = zzof.zzbi("grp");
    private static final int zzawj = zzof.zzbi("disk");
    private static final int zzawk = zzof.zzbi("trkn");
    private static final int zzawl = zzof.zzbi("tmpo");
    private static final int zzawm = zzof.zzbi("cpil");
    private static final int zzawn = zzof.zzbi("aART");
    private static final int zzawo = zzof.zzbi("sonm");
    private static final int zzawp = zzof.zzbi("soal");
    private static final int zzawq = zzof.zzbi("soar");
    private static final int zzawr = zzof.zzbi("soaa");
    private static final int zzaws = zzof.zzbi("soco");
    private static final int zzawt = zzof.zzbi("rtng");
    private static final int zzawu = zzof.zzbi("pgap");
    private static final int zzawv = zzof.zzbi("sosn");
    private static final int zzaww = zzof.zzbi("tvsh");
    private static final int zzawx = zzof.zzbi("----");
    private static final String[] zzawy = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static zza zzd(zzoc zzoc) {
        zza zza;
        int position = zzoc.getPosition() + zzoc.readInt();
        int readInt = zzoc.readInt();
        int i = readInt >>> 24;
        String str = "und";
        String str2 = "TCON";
        String str3 = "MetadataUtil";
        zza zza2 = null;
        if (i == 169 || i == 65533) {
            int i2 = 16777215 & readInt;
            if (i2 == zzavx) {
                int readInt2 = zzoc.readInt();
                if (zzoc.readInt() == zzjs.zzauc) {
                    zzoc.zzbh(8);
                    String zzbi = zzoc.zzbi(readInt2 - 16);
                    zza2 = new zzkz(str, zzbi, zzbi);
                } else {
                    String str4 = "Failed to parse comment attribute: ";
                    String valueOf = String.valueOf(zzjs.zzao(readInt));
                    Log.w(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                }
                zzoc.zzbg(position);
                return zza2;
            }
            if (i2 != zzavv) {
                if (i2 != zzavw) {
                    if (i2 != zzawc) {
                        if (i2 != zzawd) {
                            if (i2 == zzavy) {
                                zzld zza3 = zza(readInt, "TDRC", zzoc);
                                zzoc.zzbg(position);
                                return zza3;
                            } else if (i2 == zzavz) {
                                zzld zza4 = zza(readInt, "TPE1", zzoc);
                                zzoc.zzbg(position);
                                return zza4;
                            } else if (i2 == zzawa) {
                                zzld zza5 = zza(readInt, "TSSE", zzoc);
                                zzoc.zzbg(position);
                                return zza5;
                            } else if (i2 == zzawb) {
                                zzld zza6 = zza(readInt, "TALB", zzoc);
                                zzoc.zzbg(position);
                                return zza6;
                            } else if (i2 == zzawe) {
                                zzld zza7 = zza(readInt, "USLT", zzoc);
                                zzoc.zzbg(position);
                                return zza7;
                            } else if (i2 == zzawf) {
                                zzld zza8 = zza(readInt, str2, zzoc);
                                zzoc.zzbg(position);
                                return zza8;
                            } else if (i2 == zzawi) {
                                zzld zza9 = zza(readInt, "TIT1", zzoc);
                                zzoc.zzbg(position);
                                return zza9;
                            }
                        }
                    }
                    zzld zza10 = zza(readInt, "TCOM", zzoc);
                    zzoc.zzbg(position);
                    return zza10;
                }
            }
            zzld zza11 = zza(readInt, "TIT2", zzoc);
            zzoc.zzbg(position);
            return zza11;
        }
        try {
            if (readInt == zzawh) {
                int zze = zze(zzoc);
                String str5 = (zze <= 0 || zze > zzawy.length) ? null : zzawy[zze - 1];
                if (str5 != null) {
                    zza = new zzld(str2, null, str5);
                } else {
                    Log.w(str3, "Failed to parse standard genre code");
                    zza = null;
                }
                return zza;
            } else if (readInt == zzawj) {
                zzld zzb = zzb(readInt, "TPOS", zzoc);
                zzoc.zzbg(position);
                return zzb;
            } else if (readInt == zzawk) {
                zzld zzb2 = zzb(readInt, "TRCK", zzoc);
                zzoc.zzbg(position);
                return zzb2;
            } else if (readInt == zzawl) {
                zzle zza12 = zza(readInt, "TBPM", zzoc, true, false);
                zzoc.zzbg(position);
                return zza12;
            } else if (readInt == zzawm) {
                zzle zza13 = zza(readInt, "TCMP", zzoc, true, true);
                zzoc.zzbg(position);
                return zza13;
            } else if (readInt == zzawg) {
                int readInt3 = zzoc.readInt();
                if (zzoc.readInt() == zzjs.zzauc) {
                    int zzan = zzjs.zzan(zzoc.readInt());
                    String str6 = zzan == 13 ? "image/jpeg" : zzan == 14 ? "image/png" : null;
                    if (str6 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(zzan);
                        Log.w(str3, sb.toString());
                    } else {
                        zzoc.zzbh(4);
                        byte[] bArr = new byte[(readInt3 - 16)];
                        zzoc.zze(bArr, 0, bArr.length);
                        zza2 = new zzky(str6, null, 3, bArr);
                    }
                } else {
                    Log.w(str3, "Failed to parse cover art attribute");
                }
                zzoc.zzbg(position);
                return zza2;
            } else if (readInt == zzawn) {
                zzld zza14 = zza(readInt, "TPE2", zzoc);
                zzoc.zzbg(position);
                return zza14;
            } else if (readInt == zzawo) {
                zzld zza15 = zza(readInt, "TSOT", zzoc);
                zzoc.zzbg(position);
                return zza15;
            } else if (readInt == zzawp) {
                zzld zza16 = zza(readInt, "TSO2", zzoc);
                zzoc.zzbg(position);
                return zza16;
            } else if (readInt == zzawq) {
                zzld zza17 = zza(readInt, "TSOA", zzoc);
                zzoc.zzbg(position);
                return zza17;
            } else if (readInt == zzawr) {
                zzld zza18 = zza(readInt, "TSOP", zzoc);
                zzoc.zzbg(position);
                return zza18;
            } else if (readInt == zzaws) {
                zzld zza19 = zza(readInt, "TSOC", zzoc);
                zzoc.zzbg(position);
                return zza19;
            } else if (readInt == zzawt) {
                zzle zza20 = zza(readInt, "ITUNESADVISORY", zzoc, false, false);
                zzoc.zzbg(position);
                return zza20;
            } else if (readInt == zzawu) {
                zzle zza21 = zza(readInt, "ITUNESGAPLESS", zzoc, false, true);
                zzoc.zzbg(position);
                return zza21;
            } else if (readInt == zzawv) {
                zzld zza22 = zza(readInt, "TVSHOWSORT", zzoc);
                zzoc.zzbg(position);
                return zza22;
            } else if (readInt == zzaww) {
                zzld zza23 = zza(readInt, "TVSHOW", zzoc);
                zzoc.zzbg(position);
                return zza23;
            } else if (readInt == zzawx) {
                Object obj = null;
                String str7 = null;
                int i3 = -1;
                int i4 = -1;
                while (zzoc.getPosition() < position) {
                    int position2 = zzoc.getPosition();
                    int readInt4 = zzoc.readInt();
                    int readInt5 = zzoc.readInt();
                    zzoc.zzbh(4);
                    if (readInt5 == zzjs.zzaua) {
                        obj = zzoc.zzbi(readInt4 - 12);
                    } else if (readInt5 == zzjs.zzaub) {
                        str7 = zzoc.zzbi(readInt4 - 12);
                    } else {
                        if (readInt5 == zzjs.zzauc) {
                            i3 = position2;
                            i4 = readInt4;
                        }
                        zzoc.zzbh(readInt4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(obj) && "iTunSMPB".equals(str7)) {
                    if (i3 != -1) {
                        zzoc.zzbg(i3);
                        zzoc.zzbh(16);
                        zza2 = new zzkz(str, str7, zzoc.zzbi(i4 - 16));
                    }
                }
                zzoc.zzbg(position);
                return zza2;
            }
        } finally {
            zzoc.zzbg(position);
        }
        String str8 = "Skipped unknown metadata entry: ";
        String valueOf2 = String.valueOf(zzjs.zzao(readInt));
        Log.d(str3, valueOf2.length() != 0 ? str8.concat(valueOf2) : new String(str8));
        zzoc.zzbg(position);
        return null;
    }

    private static zzld zza(int i, String str, zzoc zzoc) {
        int readInt = zzoc.readInt();
        if (zzoc.readInt() == zzjs.zzauc) {
            zzoc.zzbh(8);
            return new zzld(str, null, zzoc.zzbi(readInt - 16));
        }
        String str2 = "Failed to parse text attribute: ";
        String valueOf = String.valueOf(zzjs.zzao(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return null;
    }

    private static zzle zza(int i, String str, zzoc zzoc, boolean z, boolean z2) {
        int zze = zze(zzoc);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze < 0) {
            String str2 = "Failed to parse uint8 attribute: ";
            String valueOf = String.valueOf(zzjs.zzao(i));
            Log.w("MetadataUtil", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        } else if (z) {
            return new zzld(str, null, Integer.toString(zze));
        } else {
            return new zzkz("und", str, Integer.toString(zze));
        }
    }

    private static zzld zzb(int i, String str, zzoc zzoc) {
        int readInt = zzoc.readInt();
        if (zzoc.readInt() == zzjs.zzauc && readInt >= 22) {
            zzoc.zzbh(10);
            int readUnsignedShort = zzoc.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzoc.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append(Constants.URL_PATH_DELIMITER);
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzld(str, null, sb2);
            }
        }
        String str2 = "Failed to parse index/count attribute: ";
        String valueOf2 = String.valueOf(zzjs.zzao(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        return null;
    }

    private static int zze(zzoc zzoc) {
        zzoc.zzbh(4);
        if (zzoc.readInt() == zzjs.zzauc) {
            zzoc.zzbh(8);
            return zzoc.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
