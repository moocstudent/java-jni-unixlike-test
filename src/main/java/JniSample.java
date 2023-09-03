public class JniSample {
    public native int sum(int num1,int num2);
    public native int multiply(int num1,int num2);

    static{
        System.setProperty("java.library.path",".");
//        System.loadLibrary("JniSample"); //round1
        System.loadLibrary("JniSample2"); //round2
    }

    public static void main(String[] args) {
        System.loadLibrary("JniSample2");
        JniSample sample = new JniSample();
        long current = System.currentTimeMillis();
        for (int i=0;i<100000000;i++){
            int sum = sample.sum(i, i+1);
        }
        long cExeTime = System.currentTimeMillis() - current;
        System.out.println(cExeTime);
        long current1 = System.currentTimeMillis();
        for (int i=0;i<100000000;i++){
            int sum = sum_java(i, i+1);
        }
        long javaExeTime = System.currentTimeMillis() - current1;
        System.out.println(javaExeTime);
        System.out.println("C比Java执行快"+(javaExeTime-cExeTime)+"毫秒");
        int product = sample.multiply(5, 7);
        System.out.println("调用multiply结果："+ product);

        System.out.println();
    }



    public static int sum_java(int num1,int num2){
        return num1+num2;
    }
    public static int multiply_java(int num1,int num2){
        return num1*num2;
    }
}
