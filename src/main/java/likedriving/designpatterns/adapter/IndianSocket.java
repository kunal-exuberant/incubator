package likedriving.designpatterns.adapter;

public class IndianSocket {
    void connect(IndianPlug plug){
        System.out.println("Indian plug got connected "+plug.name());
    }
}
