package com.tapjoy;

import android.net.Uri;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSignature {

    /* renamed from: a */
    private String f6222a;

    /* renamed from: b */
    private String f6223b;

    public HmacSignature(String str, String str2) {
        this.f6222a = str;
        this.f6223b = str2;
    }

    public String sign(String str, Map map) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.f6223b.getBytes(), this.f6222a);
            Mac instance = Mac.getInstance(this.f6222a);
            instance.init(secretKeySpec);
            Uri parse = Uri.parse(str);
            StringBuilder sb = new StringBuilder();
            sb.append(parse.getScheme());
            sb.append("://");
            sb.append(parse.getHost());
            String sb2 = sb.toString();
            if (!((parse.getScheme().equals("http") && parse.getPort() == 80) || (parse.getScheme().equals("https") && parse.getPort() == 443)) && -1 != parse.getPort()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append(":");
                sb3.append(parse.getPort());
                sb2 = sb3.toString();
            }
            String lowerCase = sb2.toLowerCase();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(lowerCase);
            sb4.append(parse.getPath());
            String sb5 = sb4.toString();
            String a = m6427a(map);
            StringBuilder sb6 = new StringBuilder("POST&");
            sb6.append(Uri.encode(sb5));
            sb6.append("&");
            sb6.append(Uri.encode(a));
            String sb7 = sb6.toString();
            StringBuilder sb8 = new StringBuilder("Base Url: ");
            sb8.append(sb7);
            TapjoyLog.m6554v("HmacSignature", sb8.toString());
            byte[] doFinal = instance.doFinal(sb7.getBytes());
            StringBuilder sb9 = new StringBuilder();
            for (byte b : doFinal) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb9.append('0');
                }
                sb9.append(hexString);
            }
            return sb9.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean matches(String str, Map map, String str2) {
        return sign(str, map).equals(str2);
    }

    /* renamed from: a */
    private static String m6427a(Map map) {
        TreeSet treeSet = new TreeSet(map.keySet());
        StringBuilder sb = new StringBuilder();
        Iterator it = treeSet.iterator();
        while (true) {
            String str = "&";
            if (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = (String) map.get(str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append("=");
                sb2.append(str3);
                sb2.append(str);
                sb.append(sb2.toString());
            } else {
                sb.deleteCharAt(sb.lastIndexOf(str));
                StringBuilder sb3 = new StringBuilder("Unhashed String: ");
                sb3.append(sb.toString());
                TapjoyLog.m6554v("HmacSignature", sb3.toString());
                return sb.toString();
            }
        }
    }
}
