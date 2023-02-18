
#include "jni.h"
#include "JniSample.h"

JNIEXPORT jint JNICALL Java_JniSample_sum
        (JNIEnv *env,jobject obj,jint num1,jint num2){
        return num1+num2;
}

JNIEXPORT jint JNICALL Java_JniSample_multiply
        (JNIEnv *env,jobject obj,jint num1,jint num2){
        return num1*num2;
}
int main(){}