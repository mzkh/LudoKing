package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzo {
    public final List<zzk> allHeaders;
    public final byte[] data;
    public final int statusCode;
    public final Map<String, String> zzab;
    public final boolean zzac;
    private final long zzad;

    @Deprecated
    public zzo(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        List arrayList;
        if (map == null) {
            arrayList = null;
        } else if (map.isEmpty()) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(map.size());
            for (Entry entry : map.entrySet()) {
                arrayList.add(new zzk((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        List list = arrayList;
        this(i, bArr, map, list, z, j);
    }

    public zzo(int i, byte[] bArr, boolean z, long j, List<zzk> list) {
        Map treeMap;
        if (list == null) {
            treeMap = null;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzk zzk : list) {
                treeMap.put(zzk.getName(), zzk.getValue());
            }
        }
        Map map = treeMap;
        this(i, bArr, map, list, z, j);
    }

    @Deprecated
    public zzo(byte[] bArr, Map<String, String> map) {
        this((int) Callback.DEFAULT_DRAG_ANIMATION_DURATION, bArr, map, false, 0);
    }

    private zzo(int i, byte[] bArr, Map<String, String> map, List<zzk> list, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzab = map;
        if (list == null) {
            this.allHeaders = null;
        } else {
            this.allHeaders = Collections.unmodifiableList(list);
        }
        this.zzac = z;
        this.zzad = j;
    }
}
