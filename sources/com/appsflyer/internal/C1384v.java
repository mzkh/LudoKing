package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.appsflyer.internal.v */
final class C1384v {

    /* renamed from: com.appsflyer.internal.v$c */
    static final class C1385c {

        /* renamed from: ˊ */
        final boolean f3600;

        /* renamed from: ˎ */
        final String f3601;

        C1385c(String str, boolean z) {
            this.f3601 = str;
            this.f3600 = z;
        }
    }

    /* renamed from: com.appsflyer.internal.v$d */
    static final class C1386d implements ServiceConnection {

        /* renamed from: ˋ */
        final LinkedBlockingQueue<IBinder> f3602;

        /* renamed from: ॱ */
        boolean f3603;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private C1386d() {
            this.f3602 = new LinkedBlockingQueue<>(1);
            this.f3603 = false;
        }

        /* synthetic */ C1386d(byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f3602.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: com.appsflyer.internal.v$e */
    static final class C1387e implements IInterface {

        /* renamed from: ॱ */
        private IBinder f3604;

        C1387e(IBinder iBinder) {
            this.f3604 = iBinder;
        }

        public final IBinder asBinder() {
            return this.f3604;
        }

        /* renamed from: ˏ */
        public final String mo10844() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3604.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˋ */
        public final boolean mo10843() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.f3604.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    C1384v() {
    }

    /* renamed from: ˎ */
    static C1385c m3350(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                C1386d dVar = new C1386d(0);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (!context.bindService(intent, dVar, 1)) {
                        if (context != null) {
                            context.unbindService(dVar);
                        }
                        throw new IOException("Google Play connection failed");
                    } else if (!dVar.f3603) {
                        dVar.f3603 = true;
                        C1387e eVar = new C1387e((IBinder) dVar.f3602.take());
                        C1385c cVar = new C1385c(eVar.mo10844(), eVar.mo10843());
                        if (context != null) {
                            context.unbindService(dVar);
                        }
                        return cVar;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    if (context != null) {
                        context.unbindService(dVar);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }
}
