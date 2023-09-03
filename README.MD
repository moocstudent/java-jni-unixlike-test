通过切换到java目录
执行
```cmd
javac -h ./ JniSample.java
```
编译源文件并生成head文件JniSample.h

在类UNIX系统下，
使用命令生成动态链接库：
```gcc
gcc -dynamiclib -I /Users/username/Library/Java/JavaVirtualMachines/corretto-17.0.6/Contents/Home/include JniSample.c -o libSample.jnilib
```
其中指定Java路径时指定到include，在获取编译文件时，
```cmd
libSample.jnilib
```
其名称要与JniSample中 
```java
System.loadLibrary("JniSample");
```
加载的库名前面加入lib字眼。（类UNIX加载lib时会默认加上）

在编译时如果报错关于jni_md.h
用以下命令将这个文件copy一个
```cmd
sudo cp /Users/username/Library/Java/JavaVirtualMachines/corretto-17.0.6/Contents/Home/include/darwin/jni_md.h /Users/username/Library/Java/JavaVirtualMachines/corretto-17.0.6/Contents/Home/include
```

在正确生成该lib***.jnilib后，将文件移入Java Library库：
可以通过java获取：
```java
System.out.println(System.getProperty("java.library.path"));
```

至此，Java使用JNI调用C代码demo完成

在项目java目录下执行
```java
java JniSample
```
```java
username@usernameMacBook-Pro java % java JniSample                                                                                                                                 
12
```

强化学习以下：
1. 更改JniSample.java文件，新增乘法，并把load的库改为原名2。
2. javac JniSample.java生成class文件。
3. 使用一个.cpp文件来替代原来的.c文件，并加入乘法multiply。
4. 生成c类头文件，
```java
javac -h ./ JniSample.java
```
5. gcc编译
```gcc
gcc -dynamiclib -I /Users/username/Library/Java/JavaVirtualMachines/corretto-17.0.6/Contents/Home/include JniSample.cpp -o libJniSample2.jnilib
```
6. 现在如果没有将动态库文件放入该放入的位置，应该还是报错。
7. 一切就绪后执行java JniSample

```java
调用sum结果：12
调用multiply结果：35
```

在这个代码示例中，Java比C语言执行得快的原因可能是因为以下几点：

1. JIT编译器优化：Java的JIT（Just-In-Time）编译器可以在运行时对Java字节码进行实时编译和优化。这使得Java代码在执行之前可以进行更多的优化，从而提高执行速度。

2. 内存管理：Java具有自动内存管理机制，即垃圾回收器。这意味着Java开发人员不需要手动管理内存，而是由垃圾回收器负责自动释放不再使用的内存。相比之下，C语言需要手动分配和释放内存，这可能会导致内存泄漏或错误的内存操作，从而影响执行速度。

3. 平台无关性：Java是一种跨平台的语言，它的字节码可以在不同的操作系统和硬件上运行。为了实现这种平台无关性，Java代码在执行时需要通过Java虚拟机（JVM）进行解释和执行。虽然这可能会导致一些性能损失，但它也允许Java代码在不同的环境中运行，而无需重新编译。

需要注意的是，这只是一种可能的解释，并且执行速度的比较还受到许多其他因素的影响，例如具体的代码实现、编译器优化等。在不同的情况下，C语言可能会比Java更快。
打完收工

参考文献
https://www.cnblogs.com/chenmo-xpw/p/7501325.html
https://blog.csdn.net/TYZ0604/article/details/51099222/
http://events.jianshu.io/p/d920b69308de
https://blog.csdn.net/Stars_in_rain/article/details/122662153
https://www.cnblogs.com/sun-in-sky/p/16313522.html
https://www.icourse163.org/learn/ECNU-1003718005?tid=1467043511#/learn/content?type=detail&id=1247502119&sm=1
https://learn.microsoft.com/en-us/cpp/cpp/header-files-cpp?view=msvc-170
