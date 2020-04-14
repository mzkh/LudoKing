package com.google.games.bridge;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class TokenFragment extends Fragment {
    private static final String FRAGMENT_TAG = "gpg.AuthTokenSupport";
    private static final int RC_ACCT = 9002;
    private static final String TAG = "TokenFragment";
    private static TokenFragment helperFragment;
    private static final Object lock = new Object();
    private static boolean mStartUpSignInCheckPerformed = false;
    private static TokenRequest pendingTokenRequest;
    private GoogleSignInClient mGoogleSignInClient;

    private static class TokenRequest {
        /* access modifiers changed from: private */
        public String accountName;
        /* access modifiers changed from: private */
        public boolean doAuthCode;
        /* access modifiers changed from: private */
        public boolean doEmail;
        /* access modifiers changed from: private */
        public boolean doIdToken;
        private boolean forceRefresh;
        /* access modifiers changed from: private */
        public boolean hidePopups;
        private TokenPendingResult pendingResponse = new TokenPendingResult();
        /* access modifiers changed from: private */
        public Scope[] scopes;
        private boolean silent;
        private String webClientId;

        public TokenRequest(boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, String[] strArr, boolean z6, String str2) {
            this.silent = z;
            this.doAuthCode = z2;
            this.doEmail = z3;
            this.doIdToken = z4;
            this.webClientId = str;
            this.forceRefresh = z5;
            if (strArr == null || strArr.length <= 0) {
                this.scopes = null;
            } else {
                this.scopes = new Scope[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.scopes[i] = new Scope(strArr[i]);
                }
            }
            this.hidePopups = z6;
            this.accountName = str2;
        }

        public boolean canReuseAccount() {
            return !this.doAuthCode && !this.doIdToken;
        }

        public PendingResult<TokenResult> getPendingResponse() {
            return this.pendingResponse;
        }

        public boolean getSilent() {
            return this.silent;
        }

        public void setResult(int i) {
            this.pendingResponse.setStatus(i);
        }

        public void setEmail(String str) {
            this.pendingResponse.setEmail(str);
        }

        public void cancel() {
            this.pendingResponse.cancel();
        }

        public void setAuthCode(String str) {
            this.pendingResponse.setAuthCode(str);
        }

        public void setIdToken(String str) {
            this.pendingResponse.setIdToken(str);
        }

        public String getEmail() {
            return this.pendingResponse.result.getEmail();
        }

        public String getIdToken() {
            return this.pendingResponse.result.getIdToken();
        }

        public String getAuthCode() {
            return this.pendingResponse.result.getAuthCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(hashCode()));
            sb.append(" (a:");
            sb.append(this.doAuthCode);
            sb.append(" e:");
            sb.append(this.doEmail);
            sb.append(" i:");
            sb.append(this.doIdToken);
            sb.append(" wc: ");
            sb.append(this.webClientId);
            sb.append(" f: ");
            sb.append(this.forceRefresh);
            sb.append(")");
            return sb.toString();
        }

        public String getWebClientId() {
            String str = this.webClientId;
            return str == null ? "" : str;
        }

        public boolean getForceRefresh() {
            return this.forceRefresh;
        }
    }

    public static PendingResult fetchToken(Activity activity, boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, String[] strArr, boolean z6, String str2) {
        boolean z7;
        TokenRequest tokenRequest = new TokenRequest(z, z2, z3, z4, str, z5, strArr, z6, str2);
        synchronized (lock) {
            if (pendingTokenRequest == null) {
                pendingTokenRequest = tokenRequest;
                z7 = true;
            } else {
                z7 = false;
            }
        }
        if (!z7) {
            StringBuilder sb = new StringBuilder();
            sb.append("Already a pending token request (requested == ): ");
            sb.append(tokenRequest);
            Log.e(TAG, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Already a pending token request: ");
            sb2.append(pendingTokenRequest);
            Log.e(TAG, sb2.toString());
            tokenRequest.setResult(10);
            return tokenRequest.getPendingResponse();
        }
        TokenFragment tokenFragment = (TokenFragment) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (tokenFragment == null) {
            try {
                Log.d(TAG, "Creating fragment");
                TokenFragment tokenFragment2 = new TokenFragment();
                FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                beginTransaction.add(tokenFragment2, FRAGMENT_TAG);
                beginTransaction.commit();
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Cannot launch token fragment:");
                sb3.append(th.getMessage());
                Log.e(TAG, sb3.toString(), th);
                tokenRequest.setResult(13);
                synchronized (lock) {
                    pendingTokenRequest = null;
                }
            }
        } else {
            Log.d(TAG, "Fragment exists.. calling processRequests");
            tokenFragment.processRequest();
        }
        return tokenRequest.getPendingResponse();
    }

    public static void signOut(Activity activity) {
        TokenFragment tokenFragment = (TokenFragment) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (tokenFragment != null) {
            tokenFragment.reset();
        }
        synchronized (lock) {
            pendingTokenRequest = null;
        }
    }

    private void reset() {
        GoogleSignInClient googleSignInClient = this.mGoogleSignInClient;
        if (googleSignInClient != null) {
            googleSignInClient.signOut();
            this.mGoogleSignInClient = null;
        }
    }

    /* access modifiers changed from: private */
    public void signIn() {
        final TokenRequest tokenRequest;
        Log.d(TAG, "signIn");
        synchronized (lock) {
            tokenRequest = pendingTokenRequest;
        }
        final GoogleSignInClient googleSignInClient = this.mGoogleSignInClient;
        if (!(googleSignInClient == null || tokenRequest == null)) {
            if (tokenRequest.canReuseAccount()) {
                final GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getActivity());
                if (GoogleSignIn.hasPermissions(lastSignedInAccount, tokenRequest.scopes)) {
                    Log.d(TAG, "Checking the last signed-in account if it can be used.");
                    Games.getGamesClient(getActivity(), lastSignedInAccount).getAppId().addOnCompleteListener(new OnCompleteListener<String>() {
                        public void onComplete(@NonNull Task<String> task) {
                            if (task.isSuccessful()) {
                                Log.d(TokenFragment.TAG, "Signed-in with the last signed-in account.");
                                TokenFragment.this.onSignedIn(0, lastSignedInAccount);
                                return;
                            }
                            googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                                public void onComplete(@NonNull Task<Void> task) {
                                    boolean isSuccessful = task.isSuccessful();
                                    String str = TokenFragment.TAG;
                                    if (isSuccessful) {
                                        Log.d(str, "Can't reuse the last signed-in account. Second attempt after sign out.");
                                        TokenFragment.this.signIn();
                                        return;
                                    }
                                    Log.e(str, "Can't reuse the last signed-in account and sign out failed.");
                                    TokenFragment.this.onSignedIn(4, null);
                                }
                            });
                        }
                    });
                    return;
                }
            }
            Log.d(TAG, "signInClient.silentSignIn");
            googleSignInClient.silentSignIn().addOnSuccessListener(getActivity(), (OnSuccessListener<? super TResult>) new OnSuccessListener<GoogleSignInAccount>() {
                public void onSuccess(GoogleSignInAccount googleSignInAccount) {
                    Log.d(TokenFragment.TAG, "silentSignIn.onSuccess");
                    TokenFragment.this.onSignedIn(0, googleSignInAccount);
                }
            }).addOnFailureListener(getActivity(), (OnFailureListener) new OnFailureListener() {
                public void onFailure(Exception exc) {
                    String str = TokenFragment.TAG;
                    Log.d(str, "silentSignIn.onFailure");
                    int statusCode = exc instanceof ApiException ? ((ApiException) exc).getStatusCode() : 8;
                    if (statusCode != 4 && statusCode != 8 && statusCode != 6) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Sign-in failed with status code: ");
                        sb.append(statusCode);
                        Log.e(str, sb.toString());
                        TokenFragment.this.onSignedIn(statusCode, null);
                    } else if (!tokenRequest.getSilent()) {
                        TokenFragment.this.startActivityForResult(googleSignInClient.getSignInIntent(), 9002);
                    } else {
                        Log.i(str, "Sign-in failed. Run in silent mode and UI sign-in required.");
                        TokenFragment.this.onSignedIn(4, null);
                    }
                }
            });
        }
    }

    private void processRequest() {
        TokenRequest tokenRequest;
        synchronized (lock) {
            tokenRequest = pendingTokenRequest;
        }
        if (tokenRequest != null) {
            if (buildClient(getActivity(), tokenRequest)) {
                signIn();
            } else {
                synchronized (lock) {
                    pendingTokenRequest = null;
                }
            }
            Log.d(TAG, "Done with processRequest, result is pending.");
        }
    }

    private boolean buildClient(Activity activity, TokenRequest tokenRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append("Building client for: ");
        sb.append(tokenRequest);
        String sb2 = sb.toString();
        String str = TAG;
        Log.d(str, sb2);
        Builder builder = new Builder();
        String str2 = "__WEB_CLIENTID__";
        if (tokenRequest.doAuthCode) {
            if (tokenRequest.getWebClientId().isEmpty() || tokenRequest.getWebClientId().equals(str2)) {
                Log.e(str, "Web client ID is needed for Auth Code");
                tokenRequest.setResult(10);
                return false;
            }
            builder.requestServerAuthCode(tokenRequest.getWebClientId(), tokenRequest.getForceRefresh());
        }
        if (tokenRequest.doEmail) {
            builder.requestEmail();
        }
        if (tokenRequest.doIdToken) {
            if (tokenRequest.getWebClientId().isEmpty() || tokenRequest.getWebClientId().equals(str2)) {
                Log.e(str, "Web client ID is needed for ID Token");
                tokenRequest.setResult(10);
                return false;
            }
            builder.requestIdToken(tokenRequest.getWebClientId());
        }
        if (tokenRequest.scopes != null) {
            for (Scope requestScopes : tokenRequest.scopes) {
                builder.requestScopes(requestScopes, new Scope[0]);
            }
        }
        if (tokenRequest.hidePopups) {
            Log.d(str, "hiding popup views for games API");
            builder.addExtension(GamesOptions.builder().setShowConnectingPopup(false).build());
        }
        if (tokenRequest.accountName != null && !tokenRequest.accountName.isEmpty()) {
            builder.setAccountName(tokenRequest.accountName);
        }
        this.mGoogleSignInClient = GoogleSignIn.getClient(activity, builder.build());
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9002) {
            GoogleSignInResult signInResultFromIntent = Auth.GoogleSignInApi.getSignInResultFromIntent(intent);
            if (signInResultFromIntent != null && signInResultFromIntent.isSuccess()) {
                onSignedIn(signInResultFromIntent.getStatus().getStatusCode(), signInResultFromIntent.getSignInAccount());
            } else if (i2 == 0) {
                onSignedIn(16, null);
            } else {
                String str = TAG;
                if (signInResultFromIntent != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GoogleSignInResult error status code: ");
                    sb.append(signInResultFromIntent.getStatus());
                    Log.e(str, sb.toString());
                    onSignedIn(signInResultFromIntent.getStatus().getStatusCode(), null);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Google SignIn Result is null, resultCode is ");
                    sb2.append(i2);
                    sb2.append("(");
                    sb2.append(GoogleSignInStatusCodes.getStatusCodeString(i2));
                    sb2.append(")");
                    Log.e(str, sb2.toString());
                    onSignedIn(13, null);
                }
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: private */
    public void onSignedIn(int i, GoogleSignInAccount googleSignInAccount) {
        TokenRequest tokenRequest;
        synchronized (lock) {
            tokenRequest = pendingTokenRequest;
            pendingTokenRequest = null;
        }
        if (tokenRequest != null) {
            if (googleSignInAccount != null) {
                tokenRequest.setAuthCode(googleSignInAccount.getServerAuthCode());
                tokenRequest.setEmail(googleSignInAccount.getEmail());
                tokenRequest.setIdToken(googleSignInAccount.getIdToken());
            }
            if (i != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Setting result error status code to: ");
                sb.append(i);
                Log.e(TAG, sb.toString());
            }
            tokenRequest.setResult(i);
        }
    }

    public void onResume() {
        Log.d(TAG, "onResume called");
        super.onResume();
        if (helperFragment == null) {
            helperFragment = this;
        }
        processRequest();
    }

    public static boolean checkGooglePlayServicesAvailable() {
        GooglePlayServicesUtil.isGooglePlayServicesAvailable(null);
        return false;
    }

    public static View createInvisibleView(Activity activity) {
        View view = new View(activity);
        view.setVisibility(4);
        view.setClickable(false);
        return view;
    }
}
