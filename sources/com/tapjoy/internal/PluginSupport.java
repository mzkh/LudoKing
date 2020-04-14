package com.tapjoy.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@C1821ft
public final class PluginSupport {
    private PluginSupport() {
    }

    @C1821ft
    public static void trackUsage(String str, String str2, String str3) {
        TreeMap treeMap;
        C1812bn b;
        C1812bn b2;
        try {
            HashMap hashMap = null;
            if (!C2874al.m6573a(str2)) {
                treeMap = new TreeMap();
                b2 = C1812bn.m3464b(str2);
                b2.mo18054a((Map) treeMap);
                b2.close();
            } else {
                treeMap = null;
            }
            if (!C2874al.m6573a(str3)) {
                hashMap = new HashMap();
                b = C1812bn.m3464b(str3);
                b.mo18067h();
                while (b.mo18069j()) {
                    hashMap.put(b.mo18071l(), Long.valueOf(b.mo18076q()));
                }
                b.mo18068i();
                b.close();
            }
            C1823gf.m3517a(str, treeMap, (Map) hashMap);
        } catch (Exception unused) {
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }
}
