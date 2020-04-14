package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* renamed from: com.unity3d.player.j */
public final class C3346j extends Dialog implements TextWatcher, OnClickListener {

    /* renamed from: c */
    private static int f8008c = 1627389952;

    /* renamed from: d */
    private static int f8009d = -1;

    /* renamed from: e */
    private static int f8010e = 134217728;

    /* renamed from: f */
    private static int f8011f = 67108864;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f8012a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public UnityPlayer f8013b = null;

    public C3346j(Context context, UnityPlayer unityPlayer, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2, boolean z4) {
        super(context);
        this.f8012a = context;
        this.f8013b = unityPlayer;
        mo30724a(z4);
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final View createSoftInputView = createSoftInputView();
        setContentView(createSoftInputView);
        getWindow().setLayout(-1, -2);
        getWindow().clearFlags(2);
        if (C3345i.f8003a) {
            getWindow().clearFlags(f8010e);
            getWindow().clearFlags(f8011f);
        }
        EditText editText = (EditText) findViewById(1057292289);
        Button button = (Button) findViewById(1057292290);
        m7741a(editText, str, i, z, z2, z3, str2, i2);
        button.setOnClickListener(this);
        this.f8013b.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (createSoftInputView.isShown()) {
                    Rect rect = new Rect();
                    C3346j.this.f8013b.getWindowVisibleDisplayFrame(rect);
                    int[] iArr = new int[2];
                    C3346j.this.f8013b.getLocationOnScreen(iArr);
                    Point point = new Point(rect.left - iArr[0], rect.height() - createSoftInputView.getHeight());
                    Point point2 = new Point();
                    C3346j.this.getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
                    int height = C3346j.this.f8013b.getHeight() - point2.y;
                    int height2 = C3346j.this.f8013b.getHeight() - point.y;
                    if (height2 != height + createSoftInputView.getHeight()) {
                        C3346j.this.f8013b.reportSoftInputIsVisible(true);
                    } else {
                        C3346j.this.f8013b.reportSoftInputIsVisible(false);
                    }
                    C3346j.this.f8013b.reportSoftInputArea(new Rect(point.x, point.y, createSoftInputView.getWidth(), height2));
                }
            }
        });
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    C3346j.this.getWindow().setSoftInputMode(5);
                }
            }
        });
        editText.requestFocus();
    }

    /* renamed from: a */
    private static int m7738a(int i, boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 32768 : 524288) | (z2 ? 131072 : 0);
        if (z3) {
            i2 = 128;
        }
        int i4 = i3 | i2;
        if (i < 0 || i > 11) {
            return i4;
        }
        int[] iArr = {1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194};
        return (iArr[i] & 2) != 0 ? iArr[i] : iArr[i] | i4;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m7740a() {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString().trim();
    }

    /* renamed from: a */
    private void m7741a(EditText editText, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(f8008c);
        editText.setInputType(m7738a(i, z, z2, z3));
        editText.setImeOptions(33554432);
        if (i2 > 0) {
            editText.setFilters(new InputFilter[]{new LengthFilter(i2)});
        }
        editText.addTextChangedListener(this);
        editText.setSelection(editText.getText().length());
        editText.setClickable(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7743a(String str, boolean z) {
        ((EditText) findViewById(1057292289)).setSelection(0, 0);
        this.f8013b.reportSoftInputStr(str, 1, z);
    }

    /* renamed from: a */
    public final void mo30721a(int i) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            if (i > 0) {
                editText.setFilters(new InputFilter[]{new LengthFilter(i)});
                return;
            }
            editText.setFilters(new InputFilter[0]);
        }
    }

    /* renamed from: a */
    public final void mo30722a(int i, int i2) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            int i3 = i2 + i;
            if (editText.getText().length() >= i3) {
                editText.setSelection(i, i3);
            }
        }
    }

    /* renamed from: a */
    public final void mo30723a(String str) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    /* renamed from: a */
    public final void mo30724a(boolean z) {
        int i;
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.gravity = 8;
            i = 20000;
        } else {
            attributes.gravity = 80;
            i = 0;
        }
        attributes.x = i;
        attributes.y = i;
        window.setAttributes(attributes);
    }

    public final void afterTextChanged(Editable editable) {
        this.f8013b.reportSoftInputStr(editable.toString(), 0, false);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public final View createSoftInputView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f8012a);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(f8009d);
        C33493 r1 = new EditText(this.f8012a) {
            public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                if (i == 4) {
                    C3346j jVar = C3346j.this;
                    jVar.m7743a(jVar.m7740a(), true);
                    return true;
                } else if (i == 84) {
                    return true;
                } else {
                    return super.onKeyPreIme(i, keyEvent);
                }
            }

            /* access modifiers changed from: protected */
            public final void onSelectionChanged(int i, int i2) {
                C3346j.this.f8013b.reportSoftInputSelection(i, i2 - i);
            }

            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) C3346j.this.f8012a.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        r1.setLayoutParams(layoutParams);
        r1.setId(1057292289);
        relativeLayout.addView(r1);
        Button button = new Button(this.f8012a);
        button.setText(this.f8012a.getResources().getIdentifier("ok", "string", "android"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(1057292290);
        button.setBackgroundColor(0);
        relativeLayout.addView(button);
        ((EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    C3346j jVar = C3346j.this;
                    jVar.m7743a(jVar.m7740a(), false);
                }
                return false;
            }
        });
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    public final void onBackPressed() {
        m7743a(m7740a(), true);
    }

    public final void onClick(View view) {
        m7743a(m7740a(), false);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
