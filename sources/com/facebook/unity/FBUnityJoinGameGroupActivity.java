package com.facebook.unity;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.widget.JoinAppGroupDialog;
import com.facebook.share.widget.JoinAppGroupDialog.Result;

public class FBUnityJoinGameGroupActivity extends BaseActivity {
    public static String JOIN_GAME_GROUP_PARAMS = "join_game_group_params";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra(JOIN_GAME_GROUP_PARAMS);
        final UnityMessage unityMessage = new UnityMessage("OnJoinGroupComplete");
        String str = Constants.CALLBACK_ID_KEY;
        if (bundleExtra.containsKey(str)) {
            unityMessage.put(str, bundleExtra.getString(str));
        }
        String str2 = "id";
        String string = bundleExtra.containsKey(str2) ? bundleExtra.getString(str2) : "";
        JoinAppGroupDialog joinAppGroupDialog = new JoinAppGroupDialog((Activity) this);
        joinAppGroupDialog.registerCallback(this.mCallbackManager, new FacebookCallback<Result>() {
            public void onSuccess(Result result) {
                unityMessage.put(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETE_KEY, Boolean.valueOf(true));
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
        joinAppGroupDialog.show(string);
    }
}
