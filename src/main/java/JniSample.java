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
        int sum = sample.sum(5, 7);
        System.out.println("调用sum结果："+ sum);
        int product = sample.multiply(5, 7);
        System.out.println("调用multiply结果："+ product);
    }
}
