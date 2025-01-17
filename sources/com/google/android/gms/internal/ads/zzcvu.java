package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcvu {
    public final int height;
    public final int width;
    public final boolean zzgjv;

    public zzcvu(int i, int i2, boolean z) {
        this.width = i;
        this.height = i2;
        this.zzgjv = z;
    }

    static List<zzcvu> zze(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzcvu(i, i2, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
