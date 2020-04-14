package com.tapjoy.internal;

import java.util.List;

/* renamed from: com.tapjoy.internal.aw */
public final class C2885aw {
    /* renamed from: a */
    public static void m6588a(List list, int i) {
        if (i >= 0) {
            if (i > 0) {
                int size = list.size();
                if (i <= size) {
                    if (i != size) {
                        while (true) {
                            int i2 = i - 1;
                            if (i <= 0) {
                                break;
                            }
                            list.remove(0);
                            i = i2;
                        }
                    } else {
                        list.clear();
                        return;
                    }
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
