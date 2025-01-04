package top.niunaijun.blackbox.utils.compat;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageParser;
import android.content.pm.PackageParser.Package;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.List;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.reflect.Reflector;
import top.niunaijun.blackbox.reflect.android.content.pm.BRPackageParser;
import top.niunaijun.blackbox.reflect.android.content.pm.BRPackageParserLollipop;
import top.niunaijun.blackbox.reflect.android.content.pm.BRPackageParserLollipop22;
import top.niunaijun.blackbox.reflect.android.content.pm.BRPackageParserMarshmallow;
import top.niunaijun.blackbox.reflect.android.content.pm.BRPackageParserNougat;
import top.niunaijun.blackbox.reflect.android.content.pm.BRPackageParserPie;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static android.os.Build.VERSION_CODES.LOLLIPOP_MR1;
import static android.os.Build.VERSION_CODES.M;
import static android.os.Build.VERSION_CODES.N;

import org.lsposed.hiddenapibypass.HiddenApiBypass;

public class PackageParserCompat {
    private static final int API_LEVEL = Build.VERSION.SDK_INT;

    public static PackageParser createParser(File packageFile) {
        if (API_LEVEL >= M) {
            return BRPackageParserMarshmallow._new.newInstance();
        } else if (API_LEVEL >= LOLLIPOP_MR1) {
            return BRPackageParserLollipop22._new.newInstance();
        } else if (API_LEVEL >= LOLLIPOP) {
            return BRPackageParserLollipop._new.newInstance();
        }
        return null;
    }

    public static Package parsePackage(PackageParser parser, File packageFile, int flags) {
        if (BuildCompat.isPie()) {
            return BRPackageParserPie.parsePackage.call(parser, packageFile, flags);
        } else if (API_LEVEL >= M) {
            return BRPackageParserMarshmallow.parsePackage.call(parser, packageFile, flags);
        } else if (API_LEVEL >= LOLLIPOP_MR1) {
            return BRPackageParserLollipop22.parsePackage.call(parser, packageFile, flags);
        } else if (API_LEVEL >= LOLLIPOP) {
            return BRPackageParserLollipop.parsePackage.call(parser, packageFile, flags);
        }else{
            return BRPackageParser.parsePackage.call(parser, packageFile, null, new DisplayMetrics(), flags);
        }
    }

    public static void collectCertificates(PackageParser parser, Package p, int flags) {
        if (BuildCompat.isPie()) {
            BRPackageParserPie.collectCertificates.call(p, true);
        } else if (API_LEVEL >= N) {
            BRPackageParserNougat.collectCertificates.call(p, flags);
        } else if (API_LEVEL >= M) {
            BRPackageParserMarshmallow.collectCertificates.call(parser, p, flags);
        } else if (API_LEVEL >= LOLLIPOP_MR1) {
            BRPackageParserLollipop22.collectCertificates.call(parser, p, flags);
        } else if (API_LEVEL >= LOLLIPOP) {
            BRPackageParserLollipop.collectCertificates.call(parser, p, flags);
        }else{
            BRPackageParser.collectCertificates.call(parser, p, flags);
        }

//        Reflector REF = Reflector.on("android.content.pm.PackageParser");
//        Log.d("YSG","REF:" + REF);
//        Reflector.MethodWrapper<Void> collectCertificates = REF.method("collectCertificates", android.content.pm.PackageParser.Package.class, int.class);
//        Log.d("YSG","collectCertificates:" + collectCertificates);
//        Log.d("YSG","member:" + collectCertificates.member);
//
//        Method method = Reflector.findMethodNoChecks(android.content.pm.PackageParser.class,"collectCertificates",android.content.pm.PackageParser.Package.class, int.class);
//        Log.d("YSG","method:" + method);
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
//            Log.d("YSG","aaaaaaaaaa");
//            List<Executable> allMethods = HiddenApiBypass.getDeclaredMethods(ApplicationInfo.class);
//            for (Executable allMethod : allMethods) {
//                if(allMethod.getName().contains("collectCertificates")){
//                    Log.d("YSG","bbbbbbbbb " + allMethod.getName());
//                }
//            }
//            Method method2 = HiddenApiBypass.getDeclaredMethod(android.content.pm.PackageParser.class, "collectCertificates", android.content.pm.PackageParser.Package.class, int.class);
//            Log.d("YSG","method2:" + method2);
//        }else{
//            Log.d("YSG","no use HiddenApiBypass:" + android.os.Build.VERSION.SDK_INT + ":" + android.os.Build.VERSION_CODES.P);
//        }
//        if(BuildCompat.isPie()){
//            BRPackageParser.collectCertificatesBool.call(parser, p, flags != 0);
//        }else{
//            BRPackageParser.collectCertificatesInt.call(parser, p, flags);
//        }
    }
}
