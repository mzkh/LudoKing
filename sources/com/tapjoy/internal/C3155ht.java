package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tapjoy.internal.ht */
public final class C3155ht {

    /* renamed from: a */
    public static final C3155ht f7479a = new C3155ht();

    /* renamed from: b */
    public Context f7480b;

    /* renamed from: c */
    public SharedPreferences f7481c = null;

    /* renamed from: d */
    public SharedPreferences f7482d = null;

    /* renamed from: e */
    ExecutorService f7483e;

    /* renamed from: f */
    private File f7484f;

    /* renamed from: a */
    public static boolean m7292a(long j) {
        return j >= 3600;
    }

    private C3155ht() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f7483e = threadPoolExecutor;
    }

    /* renamed from: a */
    public final void mo30223a() {
        this.f7483e.submit(new Runnable() {
            public final void run() {
                if (C3155ht.this.f7480b != null) {
                    C3155ht.this.m7295c();
                }
            }
        });
    }

    /* renamed from: a */
    public final File mo30222a(URL url) {
        if (this.f7480b == null) {
            return null;
        }
        synchronized (this) {
            String b = mo30225b(url);
            File a = mo30221a(b);
            if (!a.exists()) {
                return null;
            }
            long b2 = C3256v.m7569b();
            long j = this.f7481c.getLong(b, 0);
            if (j >= b2) {
                Object[] objArr = {b, url};
                return a;
            }
            Object[] objArr2 = {b, Long.valueOf(b2), Long.valueOf(j)};
            if (j != 0) {
                this.f7481c.edit().remove(b).commit();
                this.f7482d.edit().remove(b).commit();
            }
            a.delete();
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final synchronized String mo30225b(URL url) {
        String sb;
        String string;
        String url2 = url.toString();
        String convertToHex = TapjoyUtil.convertToHex(C2922ch.m6677a(url2.getBytes()));
        String string2 = this.f7482d.getString(convertToHex, null);
        if (string2 == null) {
            this.f7482d.edit().putString(convertToHex, url2).commit();
            return convertToHex;
        } else if (string2.equals(url2)) {
            return convertToHex;
        } else {
            int i = 0;
            do {
                i++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(convertToHex);
                sb2.append("_");
                sb2.append(i);
                sb = sb2.toString();
                string = this.f7482d.getString(sb, null);
                if (string == null) {
                    break;
                }
            } while (!string.equals(url2));
            this.f7482d.edit().putString(sb, url2).commit();
            return sb;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final File mo30224b() {
        File file = this.f7484f;
        if (file == null) {
            file = new File(this.f7480b.getCacheDir(), "tapjoy_mm_cache");
            this.f7484f = file;
        }
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final File mo30221a(String str) {
        return new File(mo30224b(), str);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m7295c() {
        long b = C3256v.m7569b();
        File[] listFiles = mo30224b().listFiles();
        HashMap hashMap = new HashMap();
        if (listFiles != null) {
            for (File file : listFiles) {
                hashMap.put(file.getName(), file);
            }
        }
        Editor edit = this.f7481c.edit();
        Editor edit2 = this.f7482d.edit();
        HashMap hashMap2 = new HashMap(this.f7481c.getAll());
        HashMap hashMap3 = new HashMap(this.f7482d.getAll());
        Iterator it = hashMap2.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) ((Entry) it.next()).getKey();
            if (!hashMap3.containsKey(str)) {
                it.remove();
                edit.remove(str);
                new Object[1][0] = str;
                z = true;
            }
        }
        Iterator it2 = hashMap3.entrySet().iterator();
        while (it2.hasNext()) {
            String str2 = (String) ((Entry) it2.next()).getKey();
            if (!hashMap2.containsKey(str2)) {
                it2.remove();
                edit2.remove(str2);
                new Object[1][0] = str2;
                z = true;
            }
        }
        Iterator it3 = hashMap2.entrySet().iterator();
        while (it3.hasNext()) {
            Entry entry = (Entry) it3.next();
            String str3 = (String) entry.getKey();
            if (((Long) entry.getValue()).longValue() < b) {
                it3.remove();
                edit.remove(str3);
                edit2.remove(str3);
                z = true;
            } else {
                hashMap.remove(str3);
            }
        }
        for (Entry value : hashMap.entrySet()) {
            File file2 = (File) value.getValue();
            file2.delete();
            new Object[1][0] = file2;
        }
        if (hashMap2.size() > 30) {
            int size = hashMap2.size() - 30;
            LinkedList linkedList = new LinkedList(hashMap2.entrySet());
            Collections.sort(linkedList, new Comparator() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((Long) ((Entry) obj).getValue()).compareTo((Long) ((Entry) obj2).getValue());
                }
            });
            Iterator it4 = linkedList.iterator();
            for (int i = 0; i < size && it4.hasNext(); i++) {
                Entry entry2 = (Entry) it4.next();
                String str4 = (String) entry2.getKey();
                Long l = (Long) entry2.getValue();
                edit.remove(str4);
                edit2.remove(str4);
                File a = mo30221a(str4);
                a.delete();
                Object[] objArr = {a, l};
            }
            z = true;
        }
        if (z) {
            edit.commit();
            edit2.commit();
        }
    }
}
