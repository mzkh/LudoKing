package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.zzb;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.metadata.internal.zzo;
import com.google.android.gms.drive.metadata.internal.zzs;
import com.google.android.gms.drive.metadata.internal.zzt;
import com.google.android.gms.drive.metadata.internal.zzu;
import java.util.Collections;

public final class zzhp {
    public static final MetadataField<DriveId> zziv = zzij.zzkt;
    public static final MetadataField<String> zziw = new zzt("alternateLink", GmsVersion.VERSION_JARLSBERG);
    public static final zzhs zzix = new zzhs(GmsVersion.VERSION_LONGHORN);
    public static final MetadataField<String> zziy = new zzt("description", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<String> zziz = new zzt("embedLink", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<String> zzja = new zzt("fileExtension", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<Long> zzjb = new zzi("fileSize", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<String> zzjc = new zzt("folderColorRgb", GmsVersion.VERSION_QUESO);
    public static final MetadataField<Boolean> zzjd = new zzb("hasThumbnail", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<String> zzje = new zzt("indexableText", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<Boolean> zzjf = new zzb("isAppData", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<Boolean> zzjg = new zzb("isCopyable", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<Boolean> zzjh = new zzb("isEditable", GmsVersion.VERSION_HALLOUMI);
    public static final MetadataField<Boolean> zzji;
    public static final MetadataField<Boolean> zzjj = new zzb("isLocalContentUpToDate", GmsVersion.VERSION_REBLOCHON);
    public static final zzht zzjk = new zzht("isPinned", GmsVersion.VERSION_HALLOUMI);
    public static final MetadataField<Boolean> zzjl = new zzb("isOpenable", GmsVersion.VERSION_PARMESAN);
    public static final MetadataField<Boolean> zzjm = new zzb("isRestricted", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<Boolean> zzjn = new zzb("isShared", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<Boolean> zzjo = new zzb("isGooglePhotosFolder", GmsVersion.VERSION_ORLA);
    public static final MetadataField<Boolean> zzjp = new zzb("isGooglePhotosRootFolder", GmsVersion.VERSION_ORLA);
    public static final MetadataField<Boolean> zzjq = new zzb("isTrashable", GmsVersion.VERSION_KENAFA);
    public static final MetadataField<Boolean> zzjr = new zzb("isViewed", GmsVersion.VERSION_JARLSBERG);
    public static final zzhu zzjs = new zzhu(GmsVersion.VERSION_HALLOUMI);
    public static final MetadataField<String> zzjt = new zzt("originalFilename", GmsVersion.VERSION_JARLSBERG);
    public static final com.google.android.gms.drive.metadata.zzb<String> zzju = new zzs("ownerNames", GmsVersion.VERSION_JARLSBERG);
    public static final zzu zzjv = new zzu("lastModifyingUser", GmsVersion.VERSION_MANCHEGO);
    public static final zzu zzjw = new zzu("sharingUser", GmsVersion.VERSION_MANCHEGO);
    public static final zzo zzjx = new zzo(GmsVersion.VERSION_HALLOUMI);
    public static final zzhv zzjy = new zzhv("quotaBytesUsed", GmsVersion.VERSION_JARLSBERG);
    public static final zzhx zzjz = new zzhx("starred", GmsVersion.VERSION_HALLOUMI);
    public static final MetadataField<BitmapTeleporter> zzka = new zzhr("thumbnail", Collections.emptySet(), Collections.emptySet(), GmsVersion.VERSION_KENAFA);
    public static final zzhy zzkb = new zzhy("title", GmsVersion.VERSION_HALLOUMI);
    public static final zzhz zzkc;
    public static final MetadataField<String> zzkd = new zzt("webContentLink", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<String> zzke = new zzt("webViewLink", GmsVersion.VERSION_JARLSBERG);
    public static final MetadataField<String> zzkf = new zzt("uniqueIdentifier", GmsVersion.VERSION_LONGHORN);
    public static final zzb zzkg = new zzb("writersCanShare", GmsVersion.VERSION_MANCHEGO);
    public static final MetadataField<String> zzkh = new zzt("role", GmsVersion.VERSION_MANCHEGO);
    public static final MetadataField<String> zzki = new zzt("md5Checksum", GmsVersion.VERSION_ORLA);
    public static final zzhw zzkj = new zzhw(GmsVersion.VERSION_ORLA);
    public static final MetadataField<String> zzkk = new zzt("recencyReason", GmsVersion.VERSION_SAGA);
    public static final MetadataField<Boolean> zzkl = new zzb("subscribed", GmsVersion.VERSION_SAGA);

    static {
        String str = "trashed";
        zzji = new zzhq("isExplicitlyTrashed", Collections.singleton(str), Collections.emptySet(), GmsVersion.VERSION_ORLA);
        zzkc = new zzhz(str, GmsVersion.VERSION_HALLOUMI);
    }
}
