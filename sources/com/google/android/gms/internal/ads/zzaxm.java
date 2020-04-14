package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaxm implements zzawz {
    @Nullable
    private final String zzber;

    public zzaxm() {
        this(null);
    }

    public zzaxm(@Nullable String str) {
        this.zzber = str;
    }

    @WorkerThread
    public final void zzei(String str) {
        HttpURLConnection httpURLConnection;
        String str2 = "Error while pinging URL: ";
        String str3 = ". ";
        String str4 = "Pinging URL: ";
        try {
            String valueOf = String.valueOf(str);
            zzaxi.zzdv(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzuv.zzoj();
            zzawy.zza(true, httpURLConnection, this.zzber);
            zzaxc zzaxc = new zzaxc();
            zzaxc.zza(httpURLConnection, (byte[]) null);
            int responseCode = httpURLConnection.getResponseCode();
            zzaxc.zza(httpURLConnection, responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                sb.append("Received non-success response code ");
                sb.append(responseCode);
                sb.append(" from pinging URL: ");
                sb.append(str);
                zzaxi.zzeu(sb.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            sb2.append("Error while parsing ping URL: ");
            sb2.append(str);
            sb2.append(str3);
            sb2.append(message);
            zzaxi.zzeu(sb2.toString());
        } catch (IOException e2) {
            String message2 = e2.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message2).length());
            sb3.append(str2);
            sb3.append(str);
            sb3.append(str3);
            sb3.append(message2);
            zzaxi.zzeu(sb3.toString());
        } catch (RuntimeException e3) {
            String message3 = e3.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
            sb4.append(str2);
            sb4.append(str);
            sb4.append(str3);
            sb4.append(message3);
            zzaxi.zzeu(sb4.toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
