package likedriving.designpatterns.adapter;

public class EuropeanSocket {

    void connect(EuropeanPlug europeanPlug){
        System.out.println("European plug connected to european socket "+europeanPlug.name());
    }

}
