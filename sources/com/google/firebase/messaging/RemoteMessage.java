package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.Map.Entry;

@Class(creator = "RemoteMessageCreator")
@Reserved({1})
/* compiled from: com.google.firebase:firebase-messaging@@19.0.1 */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Creator<RemoteMessage> CREATOR = new zzl();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @Field(mo15151id = 2)
    Bundle zza;
    private Map<String, String> zzb;
    private Notification zzc;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.firebase:firebase-messaging@@19.0.1 */
    public @interface MessagePriority {
    }

    /* compiled from: com.google.firebase:firebase-messaging@@19.0.1 */
    public static class Builder {
        private final Bundle zza = new Bundle();
        private final Map<String, String> zzb = new ArrayMap();

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                String str2 = "Invalid to: ";
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            this.zza.putString("google.to", str);
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Entry entry : this.zzb.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            bundle.putAll(this.zza);
            this.zza.remove("from");
            return new RemoteMessage(bundle);
        }

        public Builder addData(String str, String str2) {
            this.zzb.put(str, str2);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.zzb.clear();
            this.zzb.putAll(map);
            return this;
        }

        public Builder clearData() {
            this.zzb.clear();
            return this;
        }

        public Builder setMessageId(String str) {
            this.zza.putString("google.message_id", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.zza.putString("message_type", str);
            return this;
        }

        public Builder setTtl(@IntRange(from = 0, mo668to = 86400) int i) {
            this.zza.putString("google.ttl", String.valueOf(i));
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.zza.putString("collapse_key", str);
            return this;
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@19.0.1 */
    public static class Notification {
        private final String zza;
        private final String zzb;
        private final String[] zzc;
        private final String zzd;
        private final String zze;
        private final String[] zzf;
        private final String zzg;
        private final String zzh;
        private final String zzi;
        private final String zzj;
        private final String zzk;
        private final String zzl;
        private final String zzm;
        private final Uri zzn;

        private Notification(Bundle bundle) {
            String str = "gcm.n.title";
            this.zza = zza.zza(bundle, str);
            this.zzb = zza.zzc(bundle, str);
            this.zzc = zza(bundle, str);
            String str2 = "gcm.n.body";
            this.zzd = zza.zza(bundle, str2);
            this.zze = zza.zzc(bundle, str2);
            this.zzf = zza(bundle, str2);
            this.zzg = zza.zza(bundle, "gcm.n.icon");
            this.zzi = zza.zzc(bundle);
            this.zzj = zza.zza(bundle, "gcm.n.tag");
            this.zzk = zza.zza(bundle, "gcm.n.color");
            this.zzl = zza.zza(bundle, "gcm.n.click_action");
            this.zzm = zza.zza(bundle, "gcm.n.android_channel_id");
            this.zzn = zza.zzd(bundle);
            this.zzh = zza.zza(bundle, "gcm.n.image");
        }

        private static String[] zza(Bundle bundle, String str) {
            Object[] zzb2 = zza.zzb(bundle, str);
            if (zzb2 == null) {
                return null;
            }
            String[] strArr = new String[zzb2.length];
            for (int i = 0; i < zzb2.length; i++) {
                strArr[i] = String.valueOf(zzb2[i]);
            }
            return strArr;
        }

        @Nullable
        public String getTitle() {
            return this.zza;
        }

        @Nullable
        public String getTitleLocalizationKey() {
            return this.zzb;
        }

        @Nullable
        public String[] getTitleLocalizationArgs() {
            return this.zzc;
        }

        @Nullable
        public String getBody() {
            return this.zzd;
        }

        @Nullable
        public String getBodyLocalizationKey() {
            return this.zze;
        }

        @Nullable
        public String[] getBodyLocalizationArgs() {
            return this.zzf;
        }

        @Nullable
        public String getIcon() {
            return this.zzg;
        }

        @Nullable
        public Uri getImageUrl() {
            String str = this.zzh;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        @Nullable
        public String getSound() {
            return this.zzi;
        }

        @Nullable
        public String getTag() {
            return this.zzj;
        }

        @Nullable
        public String getColor() {
            return this.zzk;
        }

        @Nullable
        public String getClickAction() {
            return this.zzl;
        }

        @Nullable
        public String getChannelId() {
            return this.zzm;
        }

        @Nullable
        public Uri getLink() {
            return this.zzn;
        }
    }

    @Constructor
    public RemoteMessage(@Param(mo15154id = 2) Bundle bundle) {
        this.zza = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final String getFrom() {
        return this.zza.getString("from");
    }

    @Nullable
    public final String getTo() {
        return this.zza.getString("google.to");
    }

    public final Map<String, String> getData() {
        if (this.zzb == null) {
            Bundle bundle = this.zza;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.zzb = arrayMap;
        }
        return this.zzb;
    }

    @Nullable
    public final String getCollapseKey() {
        return this.zza.getString("collapse_key");
    }

    @Nullable
    public final String getMessageId() {
        String string = this.zza.getString("google.message_id");
        return string == null ? this.zza.getString("message_id") : string;
    }

    @Nullable
    public final String getMessageType() {
        return this.zza.getString("message_type");
    }

    public final long getSentTime() {
        Object obj = this.zza.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid sent time: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        return 0;
    }

    public final int getTtl() {
        Object obj = this.zza.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
                sb.append("Invalid TTL: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        return 0;
    }

    public final int getOriginalPriority() {
        String string = this.zza.getString("google.original_priority");
        if (string == null) {
            string = this.zza.getString("google.priority");
        }
        return zza(string);
    }

    public final int getPriority() {
        String string = this.zza.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.zza.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.zza.getString("google.priority");
        }
        return zza(string);
    }

    private static int zza(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public final Notification getNotification() {
        if (this.zzc == null && zza.zzb(this.zza)) {
            this.zzc = new Notification(this.zza);
        }
        return this.zzc;
    }

    @KeepForSdk
    public final Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.zza);
        return intent;
    }
}
