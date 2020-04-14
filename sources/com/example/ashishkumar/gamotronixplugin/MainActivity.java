package com.example.ashishkumar.gamotronixplugin;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.NotificationCompat.Builder;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TapjoyConstants;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.jsoup.Jsoup;

public class MainActivity extends UnityPlayerActivity {
    static Signature[] sign = null;
    static byte[] signatureBytes = null;
    static TextToSpeech ttsObj = null;
    public static String version = "";

    public static int Addition(int i, int i2) {
        return i + i2;
    }

    public static void GetConnectionQuality() {
    }

    public static boolean isConnectionFast(int i, int i2) {
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            switch (i2) {
                case 1:
                case 2:
                    break;
                case 3:
                    return true;
                case 4:
                    return false;
                case 5:
                case 6:
                    return true;
                case 7:
                    return false;
                case 8:
                case 9:
                case 10:
                    return true;
                case 11:
                    return false;
                case 12:
                case 13:
                case 14:
                case 15:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toast.makeText(UnityPlayer.currentActivity.getBaseContext(), "Oncreate is calleddd", 1).show();
        Intent intent = getIntent();
        intent.getData();
        if (intent.getType().indexOf("image/") != -1) {
            Toast.makeText(UnityPlayer.currentActivity.getBaseContext(), "intent starts with Image", 1).show();
        } else if (intent.getType().equals("text/plain")) {
            Toast.makeText(UnityPlayer.currentActivity.getBaseContext(), "intent starts with text", 1).show();
        }
    }

    public static String checkAppSignature() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            sign = UnityPlayer.currentActivity.getBaseContext().getPackageManager().getPackageInfo(UnityPlayer.currentActivity.getBaseContext().getPackageName(), 64).signatures;
            signatureBytes = sign[0].toByteArray();
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(sign[0].toByteArray());
            stringBuffer.append(Base64.encodeToString(instance.digest(), 0));
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public byte[] toByteArray(Signature[] signatureArr) {
        byte[] bArr = new byte[signatureArr.length];
        System.arraycopy(signatureArr, 0, bArr, 0, signatureArr.length);
        return bArr;
    }

    public static String doFingerprint(String str) {
        String str2 = "";
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(signatureBytes);
            byte[] digest = instance.digest();
            for (int i = 0; i < digest.length; i++) {
                if (i != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(":");
                    str2 = sb.toString();
                }
                String hexString = Integer.toHexString(digest[i] & 255);
                if (hexString.length() == 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    str2 = sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append(hexString);
                str2 = sb3.toString();
            }
        } catch (NoSuchAlgorithmException unused) {
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return r0;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:7:? A[ExcHandler: ClassNotFoundException (unused java.lang.ClassNotFoundException), SYNTHETIC, Splitter:B:4:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getSystemProperty(java.lang.String r7) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{  }
            java.lang.String r2 = "get"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 0
            r4[r6] = r5     // Catch:{ ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021 }
            java.lang.reflect.Method r2 = r1.getMethod(r2, r4)     // Catch:{ ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021 }
            r3[r6] = r7     // Catch:{ ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021 }
            java.lang.Object r7 = r2.invoke(r1, r3)     // Catch:{ ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021, ClassNotFoundException -> 0x0021 }
            r0 = r7
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ashishkumar.gamotronixplugin.MainActivity.getSystemProperty(java.lang.String):java.lang.String");
    }

    public static void WhatsAppSharing(String str) {
        Intent intent = new Intent("android.intent.action.SEND", Uri.parse("package:com.whatsapp"));
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        try {
            UnityPlayer.currentActivity.getBaseContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(UnityPlayer.currentActivity.getBaseContext(), "Whatsapp have not been installed.", 1).show();
        }
    }

    public static boolean checkEmulator() {
        boolean equalsIgnoreCase = Build.BRAND.equalsIgnoreCase(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("isEmulator ");
        sb.append(equalsIgnoreCase);
        Log.d(TapjoyConstants.TJC_PLUGIN, sb.toString());
        return equalsIgnoreCase;
    }

    public static boolean isStoreVersion() {
        boolean z = false;
        try {
            String installerPackageName = UnityPlayer.currentActivity.getBaseContext().getPackageManager().getInstallerPackageName(UnityPlayer.currentActivity.getBaseContext().getPackageName());
            if (installerPackageName.matches("com.amazon.venezia") || installerPackageName.matches("com.android.vending")) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isStoreVersion ");
        sb.append(z);
        Log.d(TapjoyConstants.TJC_PLUGIN, sb.toString());
        return z;
    }

    public static void UninstallApplication() {
        String packageName = UnityPlayer.currentActivity.getBaseContext().getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(packageName);
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse(sb.toString()));
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        UnityPlayer.currentActivity.getBaseContext().startActivity(intent);
    }

    public static void UninstallApplication(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(str);
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse(sb.toString()));
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        UnityPlayer.currentActivity.getBaseContext().startActivity(intent);
    }

    public static boolean isPackageInstalled(String str) {
        try {
            UnityPlayer.currentActivity.getBaseContext().getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public static void createShortCut(String str) {
        String str2 = TapjoyConstants.TJC_PLUGIN;
        Log.i(str2, "call create shortcut");
        Intent intent = new Intent();
        intent.setClassName(UnityPlayer.currentActivity.getPackageName(), UnityPlayer.currentActivity.getLocalClassName());
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(UnityPlayer.currentActivity.getBaseContext(), UnityPlayer.currentActivity.getBaseContext().getApplicationInfo().icon));
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        UnityPlayer.currentActivity.getBaseContext().sendBroadcast(intent2);
        Log.i(str2, "end create shortcut");
    }

    public static boolean isDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }

    private static boolean checkRootMethod1() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean checkRootMethod2() {
        for (String file : new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRootMethod3() {
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null) {
                if (exec != null) {
                    exec.destroy();
                }
                return true;
            }
            if (exec != null) {
                exec.destroy();
            }
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public static float PlayStoreVersion() {
        new Thread(new Runnable() {
            String str = "";

            public void run() {
                try {
                    Jsoup.connect("https://play.google.com/store/apps/details?id=com.fingersoft.hillclimb&hl=en").get();
                    this.str = "";
                } catch (Exception unused) {
                    this.str = ",";
                }
                String str2 = this.str;
            }
        }).start();
        return 1.0f;
    }

    public static NetworkInfo getNetworkInfo() {
        return ((ConnectivityManager) UnityPlayer.currentActivity.getBaseContext().getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean isConnectedFast() {
        UnityPlayer.currentActivity.getBaseContext();
        NetworkInfo networkInfo = getNetworkInfo();
        return networkInfo != null && networkInfo.isConnected() && isConnectionFast(networkInfo.getType(), networkInfo.getSubtype());
    }

    public static void ShowNotification(String str, String str2, int i, String str3) {
        Context baseContext = UnityPlayer.currentActivity.getBaseContext();
        Builder contentText = new Builder(baseContext).setSmallIcon(UnityPlayer.currentActivity.getBaseContext().getApplicationInfo().icon).setContentTitle(str).setAutoCancel(true).setDefaults(1).setContentText(str2);
        Intent launchIntentForPackage = baseContext.getPackageManager().getLaunchIntentForPackage(baseContext.getPackageName());
        launchIntentForPackage.setFlags(603979776);
        contentText.setContentIntent(PendingIntent.getActivity(baseContext, 0, launchIntentForPackage, 134217728));
        ((NotificationManager) baseContext.getSystemService("notification")).notify(i, contentText.build());
    }

    public static void InitTTS() {
        ttsObj = new TextToSpeech(UnityPlayer.currentActivity.getBaseContext(), new OnInitListener() {
            public void onInit(int i) {
                if (i == 0) {
                    int language = MainActivity.ttsObj.setLanguage(Locale.US);
                }
            }
        });
    }

    public static void SetTTSPitch(float f) {
        TextToSpeech textToSpeech = ttsObj;
        if (textToSpeech != null) {
            textToSpeech.setPitch(f);
        }
    }

    public static void SetTTSSpeechRate(float f) {
        TextToSpeech textToSpeech = ttsObj;
        if (textToSpeech != null) {
            textToSpeech.setSpeechRate(f);
        }
    }

    public static void StopTTS() {
        TextToSpeech textToSpeech = ttsObj;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }

    public static void TextToSpeechM(String str) {
        TextToSpeech textToSpeech = ttsObj;
        if (textToSpeech != null) {
            textToSpeech.setLanguage(Locale.US);
            if (VERSION.SDK_INT >= 21) {
                ttsObj.speak(str, 0, null, null);
            } else {
                ttsObj.speak(str, 0, null);
            }
        }
    }
}
