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

打完收工

参考文献
https://www.cnblogs.com/chenmo-xpw/p/7501325.html
https://blog.csdn.net/TYZ0604/article/details/51099222/
http://events.jianshu.io/p/d920b69308de
https://blog.csdn.net/Stars_in_rain/article/details/122662153
https://www.cnblogs.com/sun-in-sky/p/16313522.html
https://www.icourse163.org/learn/ECNU-1003718005?tid=1467043511#/learn/content?type=detail&id=1247502119&sm=1
https://learn.microsoft.com/en-us/cpp/cpp/header-files-cpp?view=msvc-170
