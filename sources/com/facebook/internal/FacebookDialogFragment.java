package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;

public class FacebookDialogFragment extends DialogFragment {
    public static final String TAG = "FacebookDialogFragment";
    private Dialog dialog;

    public void setDialog(Dialog dialog2) {
        this.dialog = dialog2;
    }

    public void onCreate(Bundle bundle) {
        WebDialog webDialog;
        super.onCreate(bundle);
        if (this.dialog == null) {
            FragmentActivity activity = getActivity();
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(activity.getIntent());
            boolean z = methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false);
            String str = TAG;
            if (!z) {
                String string = methodArgumentsFromIntent.getString(NativeProtocol.WEB_DIALOG_ACTION);
                Bundle bundle2 = methodArgumentsFromIntent.getBundle(NativeProtocol.WEB_DIALOG_PARAMS);
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(str, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                webDialog = new Builder(activity, string, bundle2).setOnCompleteListener(new OnCompleteListener() {
                    public void onComplete(Bundle bundle, FacebookException facebookException) {
                        FacebookDialogFragment.this.onCompleteWebDialog(bundle, facebookException);
                    }
                }).build();
            } else {
                String string2 = methodArgumentsFromIntent.getString("url");
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(str, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                webDialog = FacebookWebFallbackDialog.newInstance(activity, string2, String.format("fb%s://bridge/", new Object[]{FacebookSdk.getApplicationId()}));
                webDialog.setOnCompleteListener(new OnCompleteListener() {
                    public void onComplete(Bundle bundle, FacebookException facebookException) {
                        FacebookDialogFragment.this.onCompleteWebFallbackDialog(bundle);
                    }
                });
            }
            this.dialog = webDialog;
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
        }
        return this.dialog;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog2 = this.dialog;
        if (dialog2 instanceof WebDialog) {
            ((WebDialog) dialog2).resize();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.dialog instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.dialog).resize();
        }
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    public void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    /* access modifiers changed from: private */
    public void onCompleteWebFallbackDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
