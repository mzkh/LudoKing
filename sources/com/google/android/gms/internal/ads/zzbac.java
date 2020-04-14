package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbac extends SSLSocketFactory {
    private SSLSocketFactory zzeca = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    private final /* synthetic */ zzazz zzecb;

    zzbac(zzazz zzazz) {
        this.zzecb = zzazz;
    }

    public final String[] getDefaultCipherSuites() {
        return this.zzeca.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzeca.getSupportedCipherSuites();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return zzb(this.zzeca.createSocket(socket, str, i, z));
    }

    public final Socket createSocket(String str, int i) throws IOException {
        return zzb(this.zzeca.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return zzb(this.zzeca.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return zzb(this.zzeca.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return zzb(this.zzeca.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private final Socket zzb(Socket socket) throws SocketException {
        if (this.zzecb.zzebt > 0) {
            socket.setReceiveBufferSize(this.zzecb.zzebt);
        }
        this.zzecb.zza(socket);
        return socket;
    }
}
