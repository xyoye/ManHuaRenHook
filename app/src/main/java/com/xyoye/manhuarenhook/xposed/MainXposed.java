package com.xyoye.manhuarenhook.xposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

/**
 * Created by xyoye on 2019-05-24 上午 10:59
 */

public class MainXposed implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if ("com.ilike.cartoon".equals(loadPackageParam.packageName)){
            XposedBridge.log("----------hook ManHuaRen start");
            Class<?> hookClass  =  findClass("com.ilike.cartoon.bean.YqUserAgentBean",  loadPackageParam.classLoader);
            findAndHookMethod(hookClass, "setCy", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0] = "TW";
                    super.beforeHookedMethod(param);
                }
            });
        }
    }
}