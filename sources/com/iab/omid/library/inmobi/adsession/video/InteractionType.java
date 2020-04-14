package com.iab.omid.library.inmobi.adsession.video;

import com.tapjoy.TJAdUnitConstants.String;

public enum InteractionType {
    CLICK(String.CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    
    String interactionType;

    private InteractionType(String str) {
        this.interactionType = str;
    }

    public final String toString() {
        return this.interactionType;
    }
}
