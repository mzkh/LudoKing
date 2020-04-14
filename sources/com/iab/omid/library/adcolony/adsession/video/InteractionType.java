package com.iab.omid.library.adcolony.adsession.video;

import com.tapjoy.TJAdUnitConstants.String;

public enum InteractionType {
    CLICK(String.CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    

    /* renamed from: a */
    String f4004a;

    private InteractionType(String str) {
        this.f4004a = str;
    }

    public String toString() {
        return this.f4004a;
    }
}
