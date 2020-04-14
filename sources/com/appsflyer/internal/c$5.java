package com.appsflyer.internal;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;

class c$5 extends HashMap<String, String> {

    /* renamed from: ˏ$5b41b771 reason: contains not printable characters */
    private /* synthetic */ Object f8124$5b41b771;

    public c$5(Object obj) {
        this.f8124$5b41b771 = obj;
        put(AppEventsConstants.EVENT_PARAM_VALUE_NO, "ro.arch");
        put("1", "ro.chipname");
        put("2", "ro.dalvik.vm.native.bridge");
        put(ExifInterface.GPS_MEASUREMENT_3D, "persist.sys.nativebridge");
        put("4", "ro.enable.native.bridge.exec");
        put("5", "dalvik.vm.isa.x86.features");
        put("6", "dalvik.vm.isa.x86.variant");
        put("7", "ro.zygote");
        put("8", "ro.allow.mock.location");
        put("9", "ro.dalvik.vm.isa.arm");
        put("10", "dalvik.vm.isa.arm.features");
        put("11", "dalvik.vm.isa.arm.variant");
        put("12", "dalvik.vm.isa.arm64.features");
        put("13", "dalvik.vm.isa.arm64.variant");
        put("14", "vzw.os.rooted");
        put("15", "ro.build.user");
        put("16", "ro.kernel.qemu");
        put("17", "ro.hardware");
        put("18", "ro.product.cpu.abi");
        put("19", "ro.product.cpu.abilist");
        put("20", "ro.product.cpu.abilist32");
        put("21", "ro.product.cpu.abilist64");
    }
}
