package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.C1509R;

@Deprecated
public class LikeBoxCountView extends FrameLayout {
    private int additionalTextPadding;
    private Paint borderPaint;
    private float borderRadius;
    private float caretHeight;
    private LikeBoxCountViewCaretPosition caretPosition = LikeBoxCountViewCaretPosition.LEFT;
    private float caretWidth;
    private TextView likeCountLabel;
    private int textPadding;

    /* renamed from: com.facebook.share.internal.LikeBoxCountView$1 */
    static /* synthetic */ class C16461 {

        /* renamed from: $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition */
        static final /* synthetic */ int[] f3667x5851190f = new int[LikeBoxCountViewCaretPosition.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition[] r0 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3667x5851190f = r0
                int[] r0 = f3667x5851190f     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition r1 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3667x5851190f     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition r1 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3667x5851190f     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition r1 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3667x5851190f     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.facebook.share.internal.LikeBoxCountView$LikeBoxCountViewCaretPosition r1 = com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.LikeBoxCountView.C16461.<clinit>():void");
        }
    }

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        initialize(context);
    }

    @Deprecated
    public void setText(String str) {
        this.likeCountLabel.setText(str);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.caretPosition = likeBoxCountViewCaretPosition;
        int i = C16461.f3667x5851190f[likeBoxCountViewCaretPosition.ordinal()];
        if (i == 1) {
            setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
        } else if (i == 2) {
            setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
        } else if (i == 3) {
            setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
        } else if (i == 4) {
            setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int i = C16461.f3667x5851190f[this.caretPosition.ordinal()];
        if (i == 1) {
            paddingLeft = (int) (((float) paddingLeft) + this.caretHeight);
        } else if (i == 2) {
            paddingTop = (int) (((float) paddingTop) + this.caretHeight);
        } else if (i == 3) {
            width = (int) (((float) width) - this.caretHeight);
        } else if (i == 4) {
            height = (int) (((float) height) - this.caretHeight);
        }
        drawBorder(canvas, (float) paddingLeft, (float) paddingTop, (float) width, (float) height);
    }

    private void initialize(Context context) {
        setWillNotDraw(false);
        this.caretHeight = getResources().getDimension(C1509R.dimen.com_facebook_likeboxcountview_caret_height);
        this.caretWidth = getResources().getDimension(C1509R.dimen.com_facebook_likeboxcountview_caret_width);
        this.borderRadius = getResources().getDimension(C1509R.dimen.com_facebook_likeboxcountview_border_radius);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(getResources().getColor(C1509R.color.com_facebook_likeboxcountview_border_color));
        this.borderPaint.setStrokeWidth(getResources().getDimension(C1509R.dimen.com_facebook_likeboxcountview_border_width));
        this.borderPaint.setStyle(Style.STROKE);
        initializeLikeCountLabel(context);
        addView(this.likeCountLabel);
        setCaretPosition(this.caretPosition);
    }

    private void initializeLikeCountLabel(Context context) {
        this.likeCountLabel = new TextView(context);
        this.likeCountLabel.setLayoutParams(new LayoutParams(-1, -1));
        this.likeCountLabel.setGravity(17);
        this.likeCountLabel.setTextSize(0, getResources().getDimension(C1509R.dimen.com_facebook_likeboxcountview_text_size));
        this.likeCountLabel.setTextColor(getResources().getColor(C1509R.color.com_facebook_likeboxcountview_text_color));
        this.textPadding = getResources().getDimensionPixelSize(C1509R.dimen.com_facebook_likeboxcountview_text_padding);
        this.additionalTextPadding = getResources().getDimensionPixelSize(C1509R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    private void setAdditionalTextPadding(int i, int i2, int i3, int i4) {
        TextView textView = this.likeCountLabel;
        int i5 = this.textPadding;
        textView.setPadding(i + i5, i2 + i5, i3 + i5, i5 + i4);
    }

    private void drawBorder(Canvas canvas, float f, float f2, float f3, float f4) {
        Path path = new Path();
        float f5 = this.borderRadius * 2.0f;
        float f6 = f + f5;
        float f7 = f2 + f5;
        path.addArc(new RectF(f, f2, f6, f7), -180.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP) {
            float f8 = f3 - f;
            path.lineTo(((f8 - this.caretWidth) / 2.0f) + f, f2);
            path.lineTo((f8 / 2.0f) + f, f2 - this.caretHeight);
            path.lineTo(((f8 + this.caretWidth) / 2.0f) + f, f2);
        }
        path.lineTo(f3 - this.borderRadius, f2);
        float f9 = f3 - f5;
        path.addArc(new RectF(f9, f2, f3, f7), -90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT) {
            float f10 = f4 - f2;
            path.lineTo(f3, ((f10 - this.caretWidth) / 2.0f) + f2);
            path.lineTo(this.caretHeight + f3, (f10 / 2.0f) + f2);
            path.lineTo(f3, ((f10 + this.caretWidth) / 2.0f) + f2);
        }
        path.lineTo(f3, f4 - this.borderRadius);
        float f11 = f4 - f5;
        path.addArc(new RectF(f9, f11, f3, f4), 0.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM) {
            float f12 = f3 - f;
            path.lineTo(((this.caretWidth + f12) / 2.0f) + f, f4);
            path.lineTo((f12 / 2.0f) + f, this.caretHeight + f4);
            path.lineTo(((f12 - this.caretWidth) / 2.0f) + f, f4);
        }
        path.lineTo(this.borderRadius + f, f4);
        path.addArc(new RectF(f, f11, f6, f4), 90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT) {
            float f13 = f4 - f2;
            path.lineTo(f, ((this.caretWidth + f13) / 2.0f) + f2);
            path.lineTo(f - this.caretHeight, (f13 / 2.0f) + f2);
            path.lineTo(f, ((f13 - this.caretWidth) / 2.0f) + f2);
        }
        path.lineTo(f, f2 + this.borderRadius);
        canvas.drawPath(path, this.borderPaint);
    }
}
