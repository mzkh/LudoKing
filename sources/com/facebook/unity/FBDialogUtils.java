package com.facebook.unity;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.model.ShareLinkContent.Builder;
import com.facebook.share.widget.ShareDialog.Mode;

class FBDialogUtils {
    FBDialogUtils() {
    }

    public static Builder createShareContentBuilder(Bundle bundle) {
        Builder builder = new Builder();
        String str = "content_title";
        if (bundle.containsKey(str)) {
            builder.setContentTitle(bundle.getString(str));
        }
        String str2 = "content_description";
        if (bundle.containsKey(str2)) {
            builder.setContentDescription(bundle.getString(str2));
        }
        String str3 = ShareConstants.STORY_DEEP_LINK_URL;
        if (bundle.containsKey(str3)) {
            builder.setContentUrl(Uri.parse(bundle.getString(str3)));
        }
        String str4 = "photo_url";
        if (bundle.containsKey(str4)) {
            builder.setImageUrl(Uri.parse(bundle.getString(str4)));
        }
        return builder;
    }

    public static ShareFeedContent.Builder createFeedContentBuilder(Bundle bundle) {
        ShareFeedContent.Builder builder = new ShareFeedContent.Builder();
        String str = "toId";
        if (bundle.containsKey(str)) {
            builder.setToId(bundle.getString(str));
        }
        String str2 = "link";
        if (bundle.containsKey(str2)) {
            builder.setLink(bundle.getString(str2));
        }
        String str3 = "linkName";
        if (bundle.containsKey(str3)) {
            builder.setLinkName(bundle.getString(str3));
        }
        String str4 = "linkCaption";
        if (bundle.containsKey(str4)) {
            builder.setLinkCaption(bundle.getString(str4));
        }
        String str5 = "linkDescription";
        if (bundle.containsKey(str5)) {
            builder.setLinkDescription(bundle.getString(str5));
        }
        String str6 = "picture";
        if (bundle.containsKey(str6)) {
            builder.setPicture(bundle.getString(str6));
        }
        String str7 = "mediaSource";
        if (bundle.containsKey(str7)) {
            builder.setMediaSource(bundle.getString(str7));
        }
        return builder;
    }

    public static Mode intToMode(int i) {
        if (i == 0) {
            return Mode.AUTOMATIC;
        }
        if (i == 1) {
            return Mode.NATIVE;
        }
        if (i == 2) {
            return Mode.WEB;
        }
        if (i != 3) {
            return null;
        }
        return Mode.FEED;
    }
}
