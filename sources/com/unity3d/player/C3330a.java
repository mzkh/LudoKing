package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.unity.purchasing.googleplay.GooglePlayPurchasing;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.a */
public final class C3330a {

    /* renamed from: b */
    private static CameraManager f7955b;

    /* renamed from: c */
    private static String[] f7956c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Semaphore f7957e = new Semaphore(1);

    /* renamed from: A */
    private CaptureCallback f7958A = new CaptureCallback() {
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            C3330a.this.m7701a(captureRequest.getTag());
        }

        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            StringBuilder sb = new StringBuilder("Camera2: Capture session failed ");
            sb.append(captureRequest.getTag());
            sb.append(" reason ");
            sb.append(captureFailure.getReason());
            C3342f.Log(5, sb.toString());
            C3330a.this.m7701a(captureRequest.getTag());
        }

        public final void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
        }

        public final void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
        }
    };

    /* renamed from: B */
    private final StateCallback f7959B = new StateCallback() {
        public final void onClosed(CameraDevice cameraDevice) {
            C3330a.f7957e.release();
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            C3342f.Log(5, "Camera2: CameraDevice disconnected.");
            C3330a.this.m7699a(cameraDevice);
            C3330a.f7957e.release();
        }

        public final void onError(CameraDevice cameraDevice, int i) {
            StringBuilder sb = new StringBuilder("Camera2: Error opeining CameraDevice ");
            sb.append(i);
            C3342f.Log(6, sb.toString());
            C3330a.this.m7699a(cameraDevice);
            C3330a.f7957e.release();
        }

        public final void onOpened(CameraDevice cameraDevice) {
            C3330a.this.f7963d = cameraDevice;
            C3330a.f7957e.release();
        }
    };

    /* renamed from: C */
    private final OnImageAvailableListener f7960C = new OnImageAvailableListener() {
        public final void onImageAvailable(ImageReader imageReader) {
            if (C3330a.f7957e.tryAcquire()) {
                Image acquireNextImage = imageReader.acquireNextImage();
                if (acquireNextImage != null) {
                    Plane[] planes = acquireNextImage.getPlanes();
                    if (acquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                        C3339c h = C3330a.this.f7962a;
                        ByteBuffer buffer = planes[0].getBuffer();
                        ByteBuffer buffer2 = planes[1].getBuffer();
                        ByteBuffer buffer3 = planes[2].getBuffer();
                        h.mo30542a(buffer, buffer2, buffer3, planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                    } else {
                        C3342f.Log(6, "Camera2: Wrong image format.");
                    }
                    if (C3330a.this.f7977s != null) {
                        C3330a.this.f7977s.close();
                    }
                    C3330a.this.f7977s = acquireNextImage;
                }
                C3330a.f7957e.release();
            }
        }
    };

    /* renamed from: D */
    private final OnFrameAvailableListener f7961D = new OnFrameAvailableListener() {
        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            C3330a.this.f7962a.mo30541a(surfaceTexture);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3339c f7962a = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CameraDevice f7963d;

    /* renamed from: f */
    private HandlerThread f7964f;

    /* renamed from: g */
    private Handler f7965g;

    /* renamed from: h */
    private Rect f7966h;

    /* renamed from: i */
    private Rect f7967i;

    /* renamed from: j */
    private int f7968j;

    /* renamed from: k */
    private int f7969k;

    /* renamed from: l */
    private float f7970l = -1.0f;

    /* renamed from: m */
    private float f7971m = -1.0f;

    /* renamed from: n */
    private int f7972n;

    /* renamed from: o */
    private int f7973o;

    /* renamed from: p */
    private boolean f7974p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Range f7975q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ImageReader f7976r = null;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Image f7977s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Builder f7978t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public CameraCaptureSession f7979u = null;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Object f7980v = new Object();

    /* renamed from: w */
    private int f7981w;

    /* renamed from: x */
    private SurfaceTexture f7982x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public Surface f7983y = null;

    /* renamed from: z */
    private int f7984z = C3336a.f7992c;

    /* renamed from: com.unity3d.player.a$a */
    private enum C3336a {
        ;

        static {
            f7993d = new int[]{f7990a, f7991b, f7992c};
        }
    }

    protected C3330a(C3339c cVar) {
        this.f7962a = cVar;
        m7716g();
    }

    /* renamed from: a */
    public static int m7690a(Context context) {
        return m7710c(context).length;
    }

    /* renamed from: a */
    public static int m7691a(Context context, int i) {
        try {
            return ((Integer) m7703b(context).getCameraCharacteristics(m7710c(context)[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e) {
            StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
            return 0;
        }
    }

    /* renamed from: a */
    private static int m7692a(Range[] rangeArr, int i) {
        int i2 = -1;
        double d = Double.MAX_VALUE;
        for (int i3 = 0; i3 < rangeArr.length; i3++) {
            int intValue = ((Integer) rangeArr[i3].getLower()).intValue();
            int intValue2 = ((Integer) rangeArr[i3].getUpper()).intValue();
            float f = (float) i;
            if (f + 0.1f > ((float) intValue) && f - 0.1f < ((float) intValue2)) {
                return i;
            }
            double min = (double) ((float) Math.min(Math.abs(i - intValue), Math.abs(i - intValue2)));
            if (min < d) {
                i2 = i3;
                d = min;
            }
        }
        return ((Integer) (i > ((Integer) rangeArr[i2].getUpper()).intValue() ? rangeArr[i2].getUpper() : rangeArr[i2].getLower())).intValue();
    }

    /* renamed from: a */
    private static Rect m7693a(Size[] sizeArr, double d, double d2) {
        Size[] sizeArr2 = sizeArr;
        double d3 = Double.MAX_VALUE;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < sizeArr2.length; i3++) {
            int width = sizeArr2[i3].getWidth();
            int height = sizeArr2[i3].getHeight();
            double d4 = (double) width;
            Double.isNaN(d4);
            double abs = Math.abs(Math.log(d / d4));
            double d5 = (double) height;
            Double.isNaN(d5);
            double abs2 = abs + Math.abs(Math.log(d2 / d5));
            if (abs2 < d3) {
                i = width;
                i2 = height;
                d3 = abs2;
            }
        }
        return new Rect(0, 0, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7699a(CameraDevice cameraDevice) {
        synchronized (this.f7980v) {
            this.f7979u = null;
        }
        cameraDevice.close();
        this.f7963d = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7701a(Object obj) {
        if (obj == "Focus") {
            this.f7974p = false;
            synchronized (this.f7980v) {
                if (this.f7979u != null) {
                    try {
                        this.f7978t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
                        this.f7978t.setTag("Regular");
                        this.f7979u.setRepeatingRequest(this.f7978t.build(), this.f7958A, this.f7965g);
                    } catch (CameraAccessException e) {
                        StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
                        sb.append(e);
                        C3342f.Log(6, sb.toString());
                    }
                }
            }
        } else if (obj == "Cancel focus") {
            synchronized (this.f7980v) {
                if (this.f7979u != null) {
                    m7722j();
                }
            }
        }
    }

    /* renamed from: a */
    private static Size[] m7702a(CameraCharacteristics cameraCharacteristics) {
        String str;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            str = "Camera2: configuration map is not available.";
        } else {
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
            if (outputSizes != null && outputSizes.length != 0) {
                return outputSizes;
            }
            str = "Camera2: output sizes for YUV_420_888 format are not avialable.";
        }
        C3342f.Log(6, str);
        return null;
    }

    /* renamed from: b */
    private static CameraManager m7703b(Context context) {
        if (f7955b == null) {
            f7955b = (CameraManager) context.getSystemService("camera");
        }
        return f7955b;
    }

    /* renamed from: b */
    private void m7705b(CameraCharacteristics cameraCharacteristics) {
        this.f7969k = ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
        if (this.f7969k > 0) {
            this.f7967i = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            float width = ((float) this.f7966h.width()) / ((float) this.f7966h.height());
            if (width > ((float) this.f7967i.width()) / ((float) this.f7967i.height())) {
                this.f7972n = 0;
                this.f7973o = (int) ((((float) this.f7967i.height()) - (((float) this.f7967i.width()) / width)) / 2.0f);
            } else {
                this.f7973o = 0;
                this.f7972n = (int) ((((float) this.f7967i.width()) - (((float) this.f7967i.height()) * width)) / 2.0f);
            }
            this.f7968j = Math.min(this.f7967i.width(), this.f7967i.height()) / 20;
        }
    }

    /* renamed from: b */
    public static boolean m7707b(Context context, int i) {
        try {
            return ((Integer) m7703b(context).getCameraCharacteristics(m7710c(context)[i]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e) {
            StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m7709c(Context context, int i) {
        try {
            return ((Integer) m7703b(context).getCameraCharacteristics(m7710c(context)[i]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e) {
            StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
            return false;
        }
    }

    /* renamed from: c */
    private static String[] m7710c(Context context) {
        if (f7956c == null) {
            try {
                f7956c = m7703b(context).getCameraIdList();
            } catch (CameraAccessException e) {
                StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
                sb.append(e);
                C3342f.Log(6, sb.toString());
                f7956c = new String[0];
            }
        }
        return f7956c;
    }

    /* renamed from: d */
    public static int[] m7712d(Context context, int i) {
        try {
            Size[] a = m7702a(m7703b(context).getCameraCharacteristics(m7710c(context)[i]));
            if (a == null) {
                return null;
            }
            int[] iArr = new int[(a.length * 2)];
            for (int i2 = 0; i2 < a.length; i2++) {
                int i3 = i2 * 2;
                iArr[i3] = a[i2].getWidth();
                iArr[i3 + 1] = a[i2].getHeight();
            }
            return iArr;
        } catch (CameraAccessException e) {
            StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
            return null;
        }
    }

    /* renamed from: g */
    private void m7716g() {
        this.f7964f = new HandlerThread("CameraBackground");
        this.f7964f.start();
        this.f7965g = new Handler(this.f7964f.getLooper());
    }

    /* renamed from: h */
    private void m7719h() {
        this.f7964f.quit();
        try {
            this.f7964f.join(4000);
            this.f7964f = null;
            this.f7965g = null;
        } catch (InterruptedException e) {
            this.f7964f.interrupt();
            StringBuilder sb = new StringBuilder("Camera2: Interrupted while waiting for the background thread to finish ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
        }
    }

    /* renamed from: i */
    private void m7721i() {
        try {
            if (!f7957e.tryAcquire(4, TimeUnit.SECONDS)) {
                C3342f.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.f7963d.close();
            try {
                if (!f7957e.tryAcquire(4, TimeUnit.SECONDS)) {
                    C3342f.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e) {
                StringBuilder sb = new StringBuilder("Camera2: Interrupted while waiting to close camera ");
                sb.append(e);
                C3342f.Log(6, sb.toString());
            }
            this.f7963d = null;
            f7957e.release();
        } catch (InterruptedException e2) {
            StringBuilder sb2 = new StringBuilder("Camera2: Interrupted while trying to lock camera for closing ");
            sb2.append(e2);
            C3342f.Log(6, sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m7722j() {
        try {
            if (this.f7969k != 0 && this.f7970l >= 0.0f && this.f7970l <= 1.0f && this.f7971m >= 0.0f) {
                if (this.f7971m <= 1.0f) {
                    this.f7974p = true;
                    int width = (int) ((((float) (this.f7967i.width() - (this.f7972n * 2))) * this.f7970l) + ((float) this.f7972n));
                    double height = (double) (this.f7967i.height() - (this.f7973o * 2));
                    double d = (double) this.f7971m;
                    Double.isNaN(d);
                    double d2 = 1.0d - d;
                    Double.isNaN(height);
                    double d3 = height * d2;
                    double d4 = (double) this.f7973o;
                    Double.isNaN(d4);
                    int i = (int) (d3 + d4);
                    int max = Math.max(this.f7968j + 1, Math.min(width, (this.f7967i.width() - this.f7968j) - 1));
                    int max2 = Math.max(this.f7968j + 1, Math.min(i, (this.f7967i.height() - this.f7968j) - 1));
                    Builder builder = this.f7978t;
                    Key key = CaptureRequest.CONTROL_AF_REGIONS;
                    MeteringRectangle meteringRectangle = new MeteringRectangle(max - this.f7968j, max2 - this.f7968j, this.f7968j * 2, this.f7968j * 2, GooglePlayPurchasing.ACTIVITY_REQUEST_CODE);
                    builder.set(key, new MeteringRectangle[]{meteringRectangle});
                    this.f7978t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
                    this.f7978t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
                    this.f7978t.setTag("Focus");
                    this.f7979u.capture(this.f7978t.build(), this.f7958A, this.f7965g);
                }
            }
            this.f7978t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
            this.f7978t.setTag("Regular");
            if (this.f7979u != null) {
                this.f7979u.setRepeatingRequest(this.f7978t.build(), this.f7958A, this.f7965g);
            }
        } catch (CameraAccessException e) {
            StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
        }
    }

    /* renamed from: k */
    private void m7723k() {
        try {
            if (this.f7979u != null) {
                this.f7979u.stopRepeating();
                this.f7978t.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
                this.f7978t.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
                this.f7978t.setTag("Cancel focus");
                this.f7979u.capture(this.f7978t.build(), this.f7958A, this.f7965g);
            }
        } catch (CameraAccessException e) {
            StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
        }
    }

    /* renamed from: a */
    public final Rect mo30694a() {
        return this.f7966h;
    }

    /* renamed from: a */
    public final boolean mo30695a(float f, float f2) {
        if (this.f7969k > 0) {
            if (!this.f7974p) {
                this.f7970l = f;
                this.f7971m = f2;
                synchronized (this.f7980v) {
                    if (!(this.f7979u == null || this.f7984z == C3336a.f7991b)) {
                        m7723k();
                    }
                }
                return true;
            }
            C3342f.Log(5, "Camera2: Setting manual focus point already started.");
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo30696a(Context context, int i, int i2, int i3, int i4, int i5) {
        String str = "Camera2: CameraAccessException ";
        try {
            CameraCharacteristics cameraCharacteristics = f7955b.getCameraCharacteristics(m7710c(context)[i]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                C3342f.Log(5, "Camera2: only LEGACY hardware level is supported.");
                return false;
            }
            Size[] a = m7702a(cameraCharacteristics);
            if (!(a == null || a.length == 0)) {
                this.f7966h = m7693a(a, (double) i2, (double) i3);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr == null || rangeArr.length == 0) {
                    C3342f.Log(6, "Camera2: target FPS ranges are not avialable.");
                } else {
                    int a2 = m7692a(rangeArr, i4);
                    this.f7975q = new Range(Integer.valueOf(a2), Integer.valueOf(a2));
                    try {
                        if (!f7957e.tryAcquire(4, TimeUnit.SECONDS)) {
                            C3342f.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                            return false;
                        }
                        try {
                            f7955b.openCamera(m7710c(context)[i], this.f7959B, this.f7965g);
                            try {
                                if (!f7957e.tryAcquire(4, TimeUnit.SECONDS)) {
                                    C3342f.Log(5, "Camera2: Timeout waiting to open camera.");
                                    return false;
                                }
                                f7957e.release();
                                this.f7981w = i5;
                                m7705b(cameraCharacteristics);
                                return this.f7963d != null;
                            } catch (InterruptedException e) {
                                StringBuilder sb = new StringBuilder("Camera2: Interrupted while waiting to open camera ");
                                sb.append(e);
                                C3342f.Log(6, sb.toString());
                            }
                        } catch (CameraAccessException e2) {
                            StringBuilder sb2 = new StringBuilder(str);
                            sb2.append(e2);
                            C3342f.Log(6, sb2.toString());
                            f7957e.release();
                            return false;
                        }
                    } catch (InterruptedException e3) {
                        StringBuilder sb3 = new StringBuilder("Camera2: Interrupted while trying to lock camera for opening ");
                        sb3.append(e3);
                        C3342f.Log(6, sb3.toString());
                        return false;
                    }
                }
            }
            return false;
        } catch (CameraAccessException e4) {
            StringBuilder sb4 = new StringBuilder(str);
            sb4.append(e4);
            C3342f.Log(6, sb4.toString());
            return false;
        }
    }

    /* renamed from: b */
    public final void mo30697b() {
        if (this.f7963d != null) {
            mo30700e();
            m7721i();
            this.f7958A = null;
            this.f7983y = null;
            this.f7982x = null;
            Image image = this.f7977s;
            if (image != null) {
                image.close();
                this.f7977s = null;
            }
            ImageReader imageReader = this.f7976r;
            if (imageReader != null) {
                imageReader.close();
                this.f7976r = null;
            }
        }
        m7719h();
    }

    /* renamed from: c */
    public final void mo30698c() {
        if (this.f7976r == null) {
            this.f7976r = ImageReader.newInstance(this.f7966h.width(), this.f7966h.height(), 35, 2);
            this.f7976r.setOnImageAvailableListener(this.f7960C, this.f7965g);
            this.f7977s = null;
            int i = this.f7981w;
            if (i != 0) {
                this.f7982x = new SurfaceTexture(i);
                this.f7982x.setDefaultBufferSize(this.f7966h.width(), this.f7966h.height());
                this.f7982x.setOnFrameAvailableListener(this.f7961D, this.f7965g);
                this.f7983y = new Surface(this.f7982x);
            }
        }
        try {
            if (this.f7979u == null) {
                this.f7963d.createCaptureSession(Arrays.asList(this.f7983y != null ? new Surface[]{this.f7983y, this.f7976r.getSurface()} : new Surface[]{this.f7976r.getSurface()}), new CameraCaptureSession.StateCallback() {
                    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                        C3342f.Log(6, "Camera2: CaptureSession configuration failed.");
                    }

                    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                        if (C3330a.this.f7963d != null) {
                            synchronized (C3330a.this.f7980v) {
                                C3330a.this.f7979u = cameraCaptureSession;
                                try {
                                    C3330a.this.f7978t = C3330a.this.f7963d.createCaptureRequest(1);
                                    if (C3330a.this.f7983y != null) {
                                        C3330a.this.f7978t.addTarget(C3330a.this.f7983y);
                                    }
                                    C3330a.this.f7978t.addTarget(C3330a.this.f7976r.getSurface());
                                    C3330a.this.f7978t.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, C3330a.this.f7975q);
                                    C3330a.this.m7722j();
                                } catch (CameraAccessException e) {
                                    StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
                                    sb.append(e);
                                    C3342f.Log(6, sb.toString());
                                }
                            }
                        }
                    }
                }, this.f7965g);
            } else if (this.f7984z == C3336a.f7991b) {
                this.f7979u.setRepeatingRequest(this.f7978t.build(), this.f7958A, this.f7965g);
            }
            this.f7984z = C3336a.f7990a;
        } catch (CameraAccessException e) {
            StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
        }
    }

    /* renamed from: d */
    public final void mo30699d() {
        synchronized (this.f7980v) {
            if (this.f7979u != null) {
                try {
                    this.f7979u.stopRepeating();
                    this.f7984z = C3336a.f7991b;
                } catch (CameraAccessException e) {
                    StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
                    sb.append(e);
                    C3342f.Log(6, sb.toString());
                }
            }
        }
    }

    /* renamed from: e */
    public final void mo30700e() {
        synchronized (this.f7980v) {
            if (this.f7979u != null) {
                try {
                    this.f7979u.abortCaptures();
                } catch (CameraAccessException e) {
                    StringBuilder sb = new StringBuilder("Camera2: CameraAccessException ");
                    sb.append(e);
                    C3342f.Log(6, sb.toString());
                }
                this.f7979u.close();
                this.f7979u = null;
                this.f7984z = C3336a.f7992c;
            }
        }
    }
}
