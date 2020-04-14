package com.moat.analytics.mobile.inm;

import android.media.MediaPlayer;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.inm.u */
class C2743u extends C2713h implements NativeVideoTracker {

    /* renamed from: m */
    private WeakReference<MediaPlayer> f6152m;

    C2743u(String str) {
        super(str);
        String str2 = "NativeVideoTracker";
        C2735p.m6310a(3, str2, (Object) this, "In initialization method.");
        if (str == null || str.isEmpty()) {
            StringBuilder sb = new StringBuilder("PartnerCode is ");
            sb.append(str == null ? "null" : "empty");
            String sb2 = sb.toString();
            C2735p.m6311a("[ERROR] ", 3, str2, this, "NativeDisplayTracker creation problem, ".concat(String.valueOf(sb2)));
            this.f6015a = new C2726m(sb2);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(mo28998a());
        sb3.append(" created");
        C2735p.m6313a("[SUCCESS] ", sb3.toString());
    }

    /* renamed from: a */
    private void m6339a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.getCurrentPosition();
            } catch (Exception unused) {
                throw new C2726m("Playback has already completed");
            }
        } else {
            throw new C2726m("Null player instance");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo28998a() {
        return "NativeVideoTracker";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29002a(List<String> list) {
        if (!mo29037n()) {
            list.add("Player is null");
        }
        super.mo29002a(list);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public Map<String, Object> mo29020i() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f6152m.get();
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(mediaPlayer.getVideoWidth()));
        hashMap.put("height", Integer.valueOf(mediaPlayer.getVideoHeight()));
        hashMap.put("duration", Integer.valueOf(mediaPlayer.getDuration()));
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public boolean mo29037n() {
        WeakReference<MediaPlayer> weakReference = this.f6152m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public Integer mo29038o() {
        return Integer.valueOf(((MediaPlayer) this.f6152m.get()).getCurrentPosition());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public boolean mo29040q() {
        return ((MediaPlayer) this.f6152m.get()).isPlaying();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public Integer mo29041r() {
        return Integer.valueOf(((MediaPlayer) this.f6152m.get()).getDuration());
    }

    public boolean trackVideoAd(Map<String, String> map, MediaPlayer mediaPlayer, View view) {
        try {
            mo29004c();
            mo29006d();
            m6339a(mediaPlayer);
            this.f6152m = new WeakReference<>(mediaPlayer);
            return super.mo29018a(map, view);
        } catch (Exception e) {
            C2726m.m6274a(e);
            String a = C2726m.m6272a("trackVideoAd", e);
            if (this.f6018d != null) {
                this.f6018d.onTrackingFailedToStart(a);
            }
            C2735p.m6310a(3, "NativeVideoTracker", (Object) this, a);
            StringBuilder sb = new StringBuilder();
            sb.append(mo28998a());
            sb.append(" ");
            sb.append(a);
            C2735p.m6313a("[ERROR] ", sb.toString());
            return false;
        }
    }
}
