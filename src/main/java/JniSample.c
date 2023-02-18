//
// Created by tanghuijuan on 2023/2/18.
//
#include "JniSample.h"

JNIEXPORT jint JNICALL Java_JniSample_sum
        (JNIEnv *env,jobject obj,jint num1,jint num2){
        return num1+num2;
}
void main(){}