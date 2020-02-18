package likedriving.designpatterns.adapter;

public class AdapterMain {
    public static void main(String[] args) {
        IndianSocket indianSocket = new IndianSocket();
        IndianPlug indianPlug = new IndianPlug();
        indianSocket.connect(indianPlug);

        EuropeanSocket europeanSocket = new EuropeanSocket();
        EuropeanPlug europeanPlug = new EuropeanPlug();
        europeanSocket.connect(europeanPlug);

        // but now the problem to solve is how to connect indian plug in european socket ?

        EuropeanPlug adapter = new IndianPlugToEuropeanSocketAdapter(europeanSocket);
       // indianSocket.connect(adapter);
    }
}
