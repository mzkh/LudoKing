package com.google.games.bridge;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TokenPendingResult extends PendingResult<TokenResult> {
    private static final String TAG = "TokenPendingResult";
    private CountDownLatch latch = new CountDownLatch(1);
    TokenResult result = new TokenResult();
    private ResultCallback<? super TokenResult> resultCallback;

    @NonNull
    public TokenResult await() {
        try {
            this.latch.await();
        } catch (InterruptedException unused) {
            setResult(null, null, null, 14);
        }
        return getResult();
    }

    @NonNull
    public TokenResult await(long j, @NonNull TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j, timeUnit)) {
                setResult(null, null, null, 15);
            }
        } catch (InterruptedException unused) {
            setResult(null, null, null, 14);
        }
        return getResult();
    }

    public void cancel() {
        setResult(null, null, null, 16);
        this.latch.countDown();
    }

    public boolean isCanceled() {
        return getResult() != null && getResult().getStatus().isCanceled();
    }

    public void setResultCallback(@NonNull ResultCallback<? super TokenResult> resultCallback2) {
        if (this.latch.getCount() == 0) {
            resultCallback2.onResult(getResult());
        } else {
            setCallback(resultCallback2);
        }
    }

    public void setResultCallback(@NonNull ResultCallback<? super TokenResult> resultCallback2, long j, @NonNull TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j, timeUnit)) {
                setResult(null, null, null, 15);
            }
        } catch (InterruptedException unused) {
            setResult(null, null, null, 14);
        }
        resultCallback2.onResult(getResult());
    }

    private synchronized void setCallback(ResultCallback<? super TokenResult> resultCallback2) {
        this.resultCallback = resultCallback2;
    }

    private synchronized ResultCallback<? super TokenResult> getCallback() {
        return this.resultCallback;
    }

    private synchronized void setResult(String str, String str2, String str3, int i) {
        if (this.result != null && str == null) {
            str = this.result.getAuthCode();
        }
        if (this.result != null && str3 == null) {
            str3 = this.result.getIdToken();
        }
        if (this.result != null && str2 == null) {
            str2 = this.result.getEmail();
        }
        this.result = new TokenResult(str, str2, str3, i);
    }

    private synchronized TokenResult getResult() {
        return this.result;
    }

    public void setStatus(int i) {
        this.result.setStatus(i);
        this.latch.countDown();
        ResultCallback callback = getCallback();
        TokenResult result2 = getResult();
        if (callback != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calling onResult for result: ");
            sb.append(result2);
            Log.d(TAG, sb.toString());
            getCallback().onResult(result2);
        }
    }

    public void setEmail(String str) {
        this.result.setEmail(str);
    }

    public void setAuthCode(String str) {
        this.result.setAuthCode(str);
    }

    public void setIdToken(String str) {
        this.result.setIdToken(str);
    }
}
