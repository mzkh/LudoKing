package com.facebook.unity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareDialog;
import com.facebook.share.widget.ShareDialog.Mode;
import java.util.Locale;

public class FBUnityDialogsActivity extends BaseActivity {
    public static final String DIALOG_TYPE = "dialog_type";
    public static final String FEED_DIALOG_PARAMS = "feed_dialog_params";
    public static final String SHARE_DIALOG_PARAMS = "share_dialog_params";
    private static String TAG = "com.facebook.unity.FBUnityDialogsActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        ShareContent shareContent;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = SHARE_DIALOG_PARAMS;
        if (intent.hasExtra(str)) {
            bundle2 = intent.getBundleExtra(str);
            shareContent = FBDialogUtils.createShareContentBuilder(bundle2).build();
        } else {
            String str2 = FEED_DIALOG_PARAMS;
            if (intent.hasExtra(str2)) {
                bundle2 = intent.getBundleExtra(str2);
                shareContent = FBDialogUtils.createFeedContentBuilder(bundle2).build();
            } else {
                Log.e(TAG, String.format(Locale.ROOT, "Failed to find extra %s or %s", new Object[]{str, str2}));
                finish();
                return;
            }
        }
        ShareDialog shareDialog = new ShareDialog((Activity) this);
        final UnityMessage unityMessage = new UnityMessage("OnShareLinkComplete");
        String str3 = Constants.CALLBACK_ID_KEY;
        String string = bundle2.getString(str3);
        if (string != null) {
            unityMessage.put(str3, string);
        }
        shareDialog.registerCallback(this.mCallbackManager, new FacebookCallback<Result>() {
            public void onSuccess(Result result) {
                if (result.getPostId() != null) {
                    unityMessage.putID(result.getPostId());
                }
                unityMessage.put("posted", Boolean.valueOf(true));
                unityMessage.send();
            }

            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
            }

            public void onError(FacebookException facebookException) {
                unityMessage.sendError(facebookException.getMessage());
            }
        });
        shareDialog.show(shareContent, (Mode) getIntent().getSerializableExtra(DIALOG_TYPE));
    }
}
