package com.adcolony.sdk;

import androidx.annotation.NonNull;
import org.json.JSONObject;

public class AdColonyAdOptions {

    /* renamed from: a */
    boolean f64a;

    /* renamed from: b */
    boolean f65b;

    /* renamed from: c */
    AdColonyUserMetadata f66c;

    /* renamed from: d */
    JSONObject f67d = C0746u.m892a();

    public AdColonyAdOptions enableConfirmationDialog(boolean z) {
        this.f64a = z;
        C0746u.m913b(this.f67d, "confirmation_enabled", true);
        return this;
    }

    public AdColonyAdOptions enableResultsDialog(boolean z) {
        this.f65b = z;
        C0746u.m913b(this.f67d, "results_enabled", true);
        return this;
    }

    public AdColonyAdOptions setOption(@NonNull String str, boolean z) {
        if (C0543at.m325d(str)) {
            C0746u.m913b(this.f67d, str, z);
        }
        return this;
    }

    public Object getOption(@NonNull String str) {
        return C0746u.m889a(this.f67d, str);
    }

    public AdColonyAdOptions setOption(@NonNull String str, double d) {
        if (C0543at.m325d(str)) {
            C0746u.m900a(this.f67d, str, d);
        }
        return this;
    }

    public AdColonyAdOptions setOption(@NonNull String str, @NonNull String str2) {
        if (str != null && C0543at.m325d(str) && C0543at.m325d(str2)) {
            C0746u.m902a(this.f67d, str, str2);
        }
        return this;
    }

    public AdColonyAdOptions setUserMetadata(@NonNull AdColonyUserMetadata adColonyUserMetadata) {
        this.f66c = adColonyUserMetadata;
        C0746u.m904a(this.f67d, "user_metadata", adColonyUserMetadata.f128c);
        return this;
    }

    public AdColonyUserMetadata getUserMetadata() {
        return this.f66c;
    }
}
