package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.AudienceNetworkAds.InitListener;
import com.facebook.ads.AudienceNetworkAds.InitResult;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.common.Preconditions;
import dalvik.system.DexClassLoader;
import dalvik.system.InMemoryDexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Keep
public class DynamicLoaderFactory {
    private static final String AUDIENCE_NETWORK_CODE_PATH = "audience_network";
    private static final String AUDIENCE_NETWORK_DEX = "audience_network.dex";
    private static final String CODE_CACHE_DIR = "code_cache";
    static final String DEX_LOADING_ERROR_MESSAGE = "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.";
    private static final int DEX_LOAD_RETRY_COUNT = 3;
    private static final int DEX_LOAD_RETRY_DELAY_MS = 200;
    private static final String DYNAMIC_LOADING_BUILD_TYPE = "releaseDL";
    public static final boolean LOAD_FROM_ASSETS = "releaseDL".equals(BuildConfig.BUILD_TYPE);
    private static final String OPTIMIZED_DEX_PATH = "optimized";
    private static final AtomicReference<DynamicLoader> sDynamicLoader = new AtomicReference<>();
    private static boolean sFallbackMode;
    /* access modifiers changed from: private */
    public static final AtomicBoolean sInitializing = new AtomicBoolean();
    private static boolean sUseLegacyClassLoader = true;

    @SuppressLint({"CatchGeneralException"})
    public static synchronized DynamicLoader makeLoaderUnsafe() {
        synchronized (DynamicLoaderFactory.class) {
            if (sDynamicLoader.get() == null) {
                Context applicationContextViaReflection = getApplicationContextViaReflection();
                if (applicationContextViaReflection != null) {
                    DynamicLoader makeLoader = makeLoader(applicationContextViaReflection, true);
                    return makeLoader;
                }
                throw new RuntimeException("You must call AudienceNetworkAds.buildInitSettings(Context).initialize() before you can use Audience Network SDK.");
            }
            DynamicLoader dynamicLoader = (DynamicLoader) sDynamicLoader.get();
            return dynamicLoader;
        }
    }

    public static void initialize(final Context context, @Nullable final MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable final InitListener initListener, final boolean z) {
        if (z || !sInitializing.getAndSet(true)) {
            new Thread(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
                    r5 = r1;
                 */
                @android.annotation.SuppressLint({"CatchGeneralException"})
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                        android.content.Context r0 = r2
                        com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener.registerActivityCallbacks(r0)
                        java.lang.Class<com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory> r0 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.class
                        monitor-enter(r0)
                        r1 = 0
                        r2 = 0
                        r6 = r1
                        r3 = 0
                    L_0x000c:
                        r4 = 3
                        if (r3 >= r4) goto L_0x003a
                        android.content.Context r4 = r2     // Catch:{ Throwable -> 0x0016 }
                        com.facebook.ads.internal.dynamicloading.DynamicLoader r1 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.doMakeLoader(r4, r2)     // Catch:{ Throwable -> 0x0016 }
                        goto L_0x003a
                    L_0x0016:
                        r4 = move-exception
                        r5 = 2
                        if (r3 != r5) goto L_0x0032
                        boolean r5 = r5     // Catch:{ all -> 0x004f }
                        if (r5 != 0) goto L_0x0030
                        android.content.Context r5 = r2     // Catch:{ all -> 0x004f }
                        java.lang.String r6 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.createErrorMessage(r4)     // Catch:{ all -> 0x004f }
                        r7 = 4591870180066957722(0x3fb999999999999a, double:0.1)
                        com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.reportDexLoadingIssue(r5, r6, r7)     // Catch:{ all -> 0x004f }
                        r5 = 1
                        com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.setFallbackMode(r5)     // Catch:{ all -> 0x004f }
                    L_0x0030:
                        r6 = r4
                        goto L_0x0037
                    L_0x0032:
                        r4 = 200(0xc8, double:9.9E-322)
                        android.os.SystemClock.sleep(r4)     // Catch:{ all -> 0x004f }
                    L_0x0037:
                        int r3 = r3 + 1
                        goto L_0x000c
                    L_0x003a:
                        r5 = r1
                        monitor-exit(r0)     // Catch:{ all -> 0x004f }
                        android.content.Context r4 = r2
                        boolean r7 = r5
                        com.facebook.ads.internal.settings.MultithreadedBundleWrapper r8 = r3
                        com.facebook.ads.AudienceNetworkAds$InitListener r9 = r4
                        com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.doCallInitialize(r4, r5, r6, r7, r8, r9)
                        java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.sInitializing
                        r0.set(r2)
                        return
                    L_0x004f:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x004f }
                        throw r1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.C14391.run():void");
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    public static void doCallInitialize(Context context, @Nullable DynamicLoader dynamicLoader, @Nullable final Throwable th, boolean z, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable final InitListener initListener) {
        if (th != null) {
            if (initListener != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        initListener.onInitialized(DynamicLoaderFactory.createErrorInitResult(th));
                    }
                }, 100);
            } else {
                Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th);
            }
        } else if (dynamicLoader == null) {
        } else {
            if (z) {
                dynamicLoader.createAudienceNetworkAdsApi().onContentProviderCreated(context);
            } else {
                dynamicLoader.createAudienceNetworkAdsApi().initialize(context, multithreadedBundleWrapper, initListener);
            }
        }
    }

    /* access modifiers changed from: private */
    public static InitResult createErrorInitResult(final Throwable th) {
        return new InitResult() {
            public boolean isSuccess() {
                return false;
            }

            public String getMessage() {
                return DynamicLoaderFactory.createErrorMessage(th);
            }
        };
    }

    /* access modifiers changed from: private */
    public static String createErrorMessage(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.\n");
        sb.append(stackTraceToString(th));
        return sb.toString();
    }

    public static synchronized DynamicLoader makeLoader(Context context) {
        DynamicLoader makeLoader;
        synchronized (DynamicLoaderFactory.class) {
            makeLoader = makeLoader(context, true);
        }
        return makeLoader;
    }

    @SuppressLint({"CatchGeneralException"})
    public static synchronized DynamicLoader makeLoader(Context context, boolean z) {
        DynamicLoader doMakeLoader;
        synchronized (DynamicLoaderFactory.class) {
            Preconditions.checkNotNull(context, "Context can not be null.");
            try {
                doMakeLoader = doMakeLoader(context, z);
            } catch (Throwable th) {
                Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th);
                DexLoadErrorReporter.reportDexLoadingIssue(context, createErrorMessage(th), 0.1d);
                DynamicLoader makeFallbackLoader = DynamicLoaderFallback.makeFallbackLoader();
                sDynamicLoader.set(makeFallbackLoader);
                sFallbackMode = true;
                return makeFallbackLoader;
            }
        }
        return doMakeLoader;
    }

    /* access modifiers changed from: private */
    public static DynamicLoader doMakeLoader(Context context, boolean z) throws Exception {
        DynamicLoader dynamicLoader = (DynamicLoader) sDynamicLoader.get();
        if (dynamicLoader == null) {
            if (!LOAD_FROM_ASSETS) {
                dynamicLoader = (DynamicLoader) Class.forName(DynamicLoaderImpl.class.getName()).newInstance();
            } else {
                DynamicLoader dynamicLoader2 = (DynamicLoader) makeAdsSdkClassLoader(context.getApplicationContext()).loadClass("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
                long currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("SDK dex loading time: ");
                sb.append(currentTimeMillis);
                Log.d(AudienceNetworkAds.TAG, sb.toString());
                dynamicLoader = dynamicLoader2;
            }
            if (z) {
                dynamicLoader.maybeInitInternally(context);
            }
            sDynamicLoader.set(dynamicLoader);
        }
        return dynamicLoader;
    }

    public static synchronized void setFallbackMode(boolean z) {
        synchronized (DynamicLoaderFactory.class) {
            if (z) {
                sDynamicLoader.set(DynamicLoaderFallback.makeFallbackLoader());
                sFallbackMode = true;
            } else {
                sDynamicLoader.set(null);
                sFallbackMode = false;
            }
        }
    }

    public static void setUseLegacyClassLoader(boolean z) {
        sUseLegacyClassLoader = z;
    }

    public static synchronized boolean isFallbackMode() {
        boolean z;
        synchronized (DynamicLoaderFactory.class) {
            z = sFallbackMode;
        }
        return z;
    }

    @Nullable
    public static DynamicLoader getDynamicLoader() {
        return (DynamicLoader) sDynamicLoader.get();
    }

    private static DexClassLoader makeLegacyAdsSdkClassLoader(Context context) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        sb.append(File.separator);
        String str = AUDIENCE_NETWORK_DEX;
        sb.append(str);
        String sb2 = sb.toString();
        InputStream open = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(sb2);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return new DexClassLoader(sb2, context.getDir(OPTIMIZED_DEX_PATH, 0).getPath(), null, DynamicLoaderFactory.class.getClassLoader());
            }
        }
    }

    private static ClassLoader makeAdsSdkClassLoader(Context context) throws Exception {
        if (VERSION.SDK_INT >= 26) {
            return createInMemoryClassLoader(context);
        }
        if (sUseLegacyClassLoader) {
            return makeLegacyAdsSdkClassLoader(context);
        }
        File secondaryDir = getSecondaryDir(getCodeCacheDir(context, new File(context.getApplicationInfo().dataDir)));
        StringBuilder sb = new StringBuilder();
        sb.append(secondaryDir.getPath());
        sb.append(File.separator);
        String str = AUDIENCE_NETWORK_DEX;
        sb.append(str);
        String sb2 = sb.toString();
        InputStream open = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(sb2);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(secondaryDir.getPath());
                sb3.append(File.separator);
                sb3.append(OPTIMIZED_DEX_PATH);
                File file = new File(sb3.toString());
                mkdirChecked(file);
                return new DexClassLoader(sb2, file.getPath(), null, context.getClassLoader());
            }
        }
    }

    @TargetApi(26)
    private static ClassLoader createInMemoryClassLoader(Context context) throws IOException {
        InputStream open = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return new InMemoryDexClassLoader(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()), DynamicLoaderFactory.class.getClassLoader());
            }
        }
    }

    @SuppressLint({"PrivateApi", "CatchGeneralException"})
    @Nullable
    private static Context getApplicationContextViaReflection() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th) {
            Log.e(AudienceNetworkAds.TAG, "Failed to fetch Context from  ActivityThread. Audience Network SDK won't work unless you call AudienceNetworkAds.buildInitSettings().withListener(InitListener).initialize().", th);
            return null;
        }
    }

    private static File getCodeCacheDir(Context context, File file) throws IOException {
        if (VERSION.SDK_INT >= 21) {
            return context.getCodeCacheDir();
        }
        return getCacheCodeDirLegacy(context, file);
    }

    private static File getCacheCodeDirLegacy(Context context, File file) throws IOException {
        String str = CODE_CACHE_DIR;
        File file2 = new File(file, str);
        try {
            mkdirChecked(file2);
            return file2;
        } catch (IOException unused) {
            File dir = context.getDir(str, 0);
            mkdirChecked(dir);
            return dir;
        }
    }

    private static File getSecondaryDir(File file) throws IOException {
        File file2 = new File(file, AUDIENCE_NETWORK_CODE_PATH);
        mkdirChecked(file2);
        return file2;
    }

    private static void mkdirChecked(File file) throws IOException {
        String str;
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            String str2 = "Failed to create dir ";
            if (parentFile == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(file.getPath());
                sb.append(". Parent file is null.");
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(file.getPath());
                sb2.append(". parent file is a dir ");
                sb2.append(parentFile.isDirectory());
                sb2.append(", a file ");
                sb2.append(parentFile.isFile());
                sb2.append(", exists ");
                sb2.append(parentFile.exists());
                sb2.append(", readable ");
                sb2.append(parentFile.canRead());
                sb2.append(", writable ");
                sb2.append(parentFile.canWrite());
                str = sb2.toString();
            }
            Log.e(AudienceNetworkAds.TAG, str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create directory ");
            sb3.append(file.getPath());
            sb3.append(", detailed message: ");
            sb3.append(str);
            throw new IOException(sb3.toString());
        }
    }

    private static String stackTraceToString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
