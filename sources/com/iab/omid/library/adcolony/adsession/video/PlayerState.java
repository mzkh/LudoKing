package com.iab.omid.library.adcolony.adsession.video;

public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN("fullscreen");
    

    /* renamed from: a */
    private final String f4006a;

    private PlayerState(String str) {
        this.f4006a = str;
    }

    public String toString() {
        return this.f4006a;
    }
}
