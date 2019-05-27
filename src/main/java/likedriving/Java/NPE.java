package likedriving.Java;

class A{
    String z(){
        System.out.println("a");
        return "sauarbh";
    }
}
class B{
    A a;
    A x(){
        return a;
    }
}
public class NPE {
    public static void main(String[] args) {
        B b = new B();
        A a1 = b.x();
        a1.z();
    }
}
