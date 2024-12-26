
#include <jni.h>
#include <sys/system_properties.h>
#include "hidden_api.h"
#include "Utils/elf_util.h"
#include "Log.h"

bool disable_hidden_api(JNIEnv *env) {
    char version_str[PROP_VALUE_MAX];
    if (!__system_property_get("ro.build.version.sdk", version_str)) {
        ALOGE("Failed to obtain SDK int");
        return JNI_ERR;
    }
    long android_version = std::strtol(version_str, nullptr, 10);

    // Hidden api introduced in sdk 29
    if (android_version < 29) {
        return true;
    }

    SandHook::ElfImg *elf_img = new SandHook::ElfImg("libart.so");

    void *addr = (void*)elf_img->getSymbAddress("_ZN3artL32VMRuntime_setHiddenApiExemptionsEP7_JNIEnvP7_jclassP13_jobjectArray");
    delete elf_img;
    if (!addr) {
        ALOGE("HiddenAPI: Didn't find setHiddenApiExemptions");
        return false;
    }

    jclass stringClass = env->FindClass("java/lang/String");
    // L is basically wildcard for everything
    jobjectArray args = env->NewObjectArray(1, stringClass, env->NewStringUTF("L"));

    auto func = reinterpret_cast<void (*)(JNIEnv *, jclass, jobjectArray)>(addr);
    // jclass arg is not used so pass string class for the memes
    func(env, stringClass, args);
    return true;
}