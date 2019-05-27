package likedriving.Java;


/*
1. Java implictly assumes call to cuurent object when called without this reference
2. Static member methods cannot access non static members - both methods or fields
3. Instance or non static member methods can access both static member methods as well as non static members
 */
public class MethodCall {

    private int a = 10;

    private static int b = 20;

    MethodCall methodCall = new MethodCall();

    //methodCall.getClass();

    private void method1(){
        method1();
        //MethodCall methodCall = new MethodCall();
        methodCall.method1();
        System.out.println(b);
        System.out.println("hello method 1");
        this.method3();
    }

    private void method3() {
        System.out.println("Hello method 3");
    }

    private static void method2() {
        System.out.println(b);
        System.out.println("hello method 2");
        new MethodCall().method1();
    }

    public static void main(String[] args) {
        //MethodCall methodCall = new MethodCall();

        //methodCall.method1();

        method2();
    }

}
