package com.facebook.unity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.GameRequestContent.ActionType;
import com.facebook.share.model.GameRequestContent.Builder;
import com.facebook.share.model.GameRequestContent.Filters;
import com.facebook.share.widget.GameRequestDialog;
import com.facebook.share.widget.GameRequestDialog.Result;
import java.util.Arrays;
import java.util.Locale;

public class FBUnityGameRequestActivity extends BaseActivity {
    public static final String GAME_REQUEST_PARAMS = "game_request_params";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(GAME_REQUEST_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnAppRequestsComplete");
        String str = Constants.CALLBACK_ID_KEY;
        if (bundleExtra.containsKey(str)) {
            unityMessage.put(str, bundleExtra.getString(str));
        }
        Builder builder = new Builder();
        String str2 = "message";
        if (bundleExtra.containsKey(str2)) {
            builder.setMessage(bundleExtra.getString(str2));
        }
        String str3 = ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE;
        if (bundleExtra.containsKey(str3)) {
            String string = bundleExtra.getString(str3);
            try {
                builder.setActionType(ActionType.valueOf(string));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown action type: ");
                sb.append(string);
                unityMessage.sendError(sb.toString());
                finish();
                return;
            }
        }
        String str4 = "object_id";
        if (bundleExtra.containsKey(str4)) {
            builder.setObjectId(bundleExtra.getString(str4));
        }
        String str5 = "to";
        if (bundleExtra.containsKey(str5)) {
            builder.setRecipients(Arrays.asList(bundleExtra.getString(str5).split(",")));
        }
        String str6 = ShareConstants.WEB_DIALOG_PARAM_FILTERS;
        if (bundleExtra.containsKey(str6)) {
            String upperCase = bundleExtra.getString(str6).toUpperCase(Locale.ROOT);
            try {
                builder.setFilters(Filters.valueOf(upperCase));
            } catch (IllegalArgumentException unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unsupported filter type: ");
                sb2.append(upperCase);
                unityMessage.sendError(sb2.toString());
                finish();
                return;
            }
        }
        String str7 = "data";
        if (bundleExtra.containsKey(str7)) {
            builder.setData(bundleExtra.getString(str7));
        }
        String str8 = "title";
        if (bundleExtra.containsKey(str8)) {
            builder.setTitle(bundleExtra.getString(str8));
        }
        GameRequestContent build = builder.build();
        GameRequestDialog gameRequestDialog = new GameRequestDialog((Activity) this);
        gameRequestDialog.registerCallback(this.mCallbackManager, new FacebookCallback<Result>() {
            public void onSuccess(Result result) {
                unityMessage.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, result.getRequestId());
                unityMessage.put("to", TextUtils.join(",", result.getRequestRecipients()));
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
        try {
            gameRequestDialog.show(build);
        } catch (IllegalArgumentException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected exception encountered: ");
            sb3.append(e.toString());
            unityMessage.sendError(sb3.toString());
            finish();
        }
    }
}
