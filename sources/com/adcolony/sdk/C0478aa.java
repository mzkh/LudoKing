package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.adcolony.sdk.aa */
class C0478aa {

    /* renamed from: a */
    final String f155a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f156b;

    /* renamed from: c */
    private HashMap<Integer, MediaPlayer> f157c = new HashMap<>();

    /* renamed from: d */
    private HashMap<Integer, C0479a> f158d = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HashMap<Integer, Boolean> f159e = new HashMap<>();

    /* renamed from: f */
    private HashMap<Integer, Boolean> f160f = new HashMap<>();

    /* renamed from: g */
    private ArrayList<MediaPlayer> f161g = new ArrayList<>();

    /* renamed from: com.adcolony.sdk.aa$a */
    private class C0479a implements OnErrorListener, OnPreparedListener {

        /* renamed from: a */
        int f162a;

        /* renamed from: b */
        boolean f163b;

        C0479a(int i, boolean z) {
            this.f162a = i;
            this.f163b = z;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            JSONObject a = C0746u.m892a();
            C0746u.m912b(a, "id", this.f162a);
            C0746u.m902a(a, "ad_session_id", C0478aa.this.f155a);
            new C0480ab("AudioPlayer.on_error", C0478aa.this.f156b, a).mo8217b();
            return true;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setLooping(this.f163b);
            C0478aa.this.f159e.put(Integer.valueOf(this.f162a), Boolean.valueOf(true));
            JSONObject a = C0746u.m892a();
            C0746u.m912b(a, "id", this.f162a);
            C0746u.m902a(a, "ad_session_id", C0478aa.this.f155a);
            new C0480ab("AudioPlayer.on_ready", C0478aa.this.f156b, a).mo8217b();
        }
    }

    C0478aa(String str, int i) {
        this.f155a = str;
        this.f156b = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8205a(C0480ab abVar) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        JSONObject c = abVar.mo8220c();
        String str = "id";
        int c2 = C0746u.m914c(c, str);
        C0479a aVar = new C0479a(c2, C0746u.m918d(c, "repeats"));
        this.f157c.put(Integer.valueOf(c2), mediaPlayer);
        this.f158d.put(Integer.valueOf(c2), aVar);
        HashMap<Integer, Boolean> hashMap = this.f159e;
        Integer valueOf = Integer.valueOf(c2);
        Boolean valueOf2 = Boolean.valueOf(false);
        hashMap.put(valueOf, valueOf2);
        this.f160f.put(Integer.valueOf(c2), valueOf2);
        mediaPlayer.setOnErrorListener(aVar);
        mediaPlayer.setOnPreparedListener(aVar);
        try {
            mediaPlayer.setDataSource(C0746u.m908b(c, "filepath"));
        } catch (Exception unused) {
            JSONObject a = C0746u.m892a();
            C0746u.m912b(a, str, c2);
            C0746u.m902a(a, "ad_session_id", this.f155a);
            new C0480ab("AudioPlayer.on_error", this.f156b, a).mo8217b();
        }
        mediaPlayer.prepareAsync();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8204a() {
        this.f161g.clear();
        for (MediaPlayer mediaPlayer : this.f157c.values()) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                this.f161g.add(mediaPlayer);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8206b() {
        Iterator it = this.f161g.iterator();
        while (it.hasNext()) {
            ((MediaPlayer) it.next()).start();
        }
        this.f161g.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8207b(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        if (((Boolean) this.f160f.get(Integer.valueOf(c))).booleanValue()) {
            ((MediaPlayer) this.f157c.get(Integer.valueOf(c))).pause();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8209c(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        if (((Boolean) this.f159e.get(Integer.valueOf(c))).booleanValue()) {
            ((MediaPlayer) this.f157c.get(Integer.valueOf(c))).start();
            this.f160f.put(Integer.valueOf(c), Boolean.valueOf(true));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8210d(C0480ab abVar) {
        ((MediaPlayer) this.f157c.remove(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), "id")))).release();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8211e(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        if (((Boolean) this.f160f.get(Integer.valueOf(c))).booleanValue()) {
            MediaPlayer mediaPlayer = (MediaPlayer) this.f157c.get(Integer.valueOf(c));
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public HashMap<Integer, MediaPlayer> mo8208c() {
        return this.f157c;
    }
}
