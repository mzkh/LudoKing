package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.common.C1509R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.C1608R;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareContent;

public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, null, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return C1608R.style.com_facebook_button_share;
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        return RequestCodeOffset.Share.toRequestCode();
    }

    /* access modifiers changed from: protected */
    public FacebookDialogBase<ShareContent, Result> getDialog() {
        if (getFragment() != null) {
            return new ShareDialog(getFragment(), getRequestCode());
        }
        if (getNativeFragment() != null) {
            return new ShareDialog(getNativeFragment(), getRequestCode());
        }
        return new ShareDialog(getActivity(), getRequestCode());
    }

    /* access modifiers changed from: protected */
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), C1509R.C1510drawable.com_facebook_button_icon), null, null, null);
    }
}
