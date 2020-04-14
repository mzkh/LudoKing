package com.facebook.unity;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.AppGroupCreationContent.AppGroupPrivacy;
import com.facebook.share.model.AppGroupCreationContent.Builder;
import com.facebook.share.widget.CreateAppGroupDialog;
import com.facebook.share.widget.CreateAppGroupDialog.Result;
import java.util.Locale;

public class FBUnityCreateGameGroupActivity extends BaseActivity {
    public static String CREATE_GAME_GROUP_PARAMS = "create_game_group_params";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Builder builder = new Builder();
        Bundle bundleExtra = getIntent().getBundleExtra(CREATE_GAME_GROUP_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnGroupCreateComplete");
        String str = Constants.CALLBACK_ID_KEY;
        if (bundleExtra.containsKey(str)) {
            unityMessage.put(str, bundleExtra.getString(str));
        }
        String str2 = "name";
        if (bundleExtra.containsKey(str2)) {
            builder.setName(bundleExtra.getString(str2));
        }
        if (bundleExtra.containsKey("description")) {
            builder.setDescription(bundleExtra.getString(str2));
        }
        String str3 = ShareConstants.WEB_DIALOG_PARAM_PRIVACY;
        if (bundleExtra.containsKey(str3)) {
            String string = bundleExtra.getString(str3);
            AppGroupPrivacy appGroupPrivacy = AppGroupPrivacy.Closed;
            if (string.equalsIgnoreCase("closed")) {
                appGroupPrivacy = AppGroupPrivacy.Closed;
            } else if (string.equalsIgnoreCase("open")) {
                appGroupPrivacy = AppGroupPrivacy.Open;
            } else {
                unityMessage.sendError(String.format(Locale.ROOT, "Unknown privacy setting for group creation: %s", new Object[]{string}));
                finish();
            }
            builder.setAppGroupPrivacy(appGroupPrivacy);
        }
        CreateAppGroupDialog createAppGroupDialog = new CreateAppGroupDialog((Activity) this);
        createAppGroupDialog.registerCallback(this.mCallbackManager, new FacebookCallback<Result>() {
            public void onSuccess(Result result) {
                unityMessage.put("id", result.getId());
                unityMessage.send();
            }

            public void onCancel() {
                unityMessage.putCancelled();
                unityMessage.send();
            }

            public void onError(FacebookException facebookException) {
                unityMessage.sendError(facebookException.getLocalizedMessage());
            }
        });
        createAppGroupDialog.show(builder.build());
    }
}
