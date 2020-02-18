package likedriving.designpatterns.adapter;

public class IndianPlugToEuropeanSocketAdapter extends EuropeanPlug{

    private EuropeanSocket europeanSocket;

    public IndianPlugToEuropeanSocketAdapter(EuropeanSocket europeanSocket){
        this.europeanSocket = europeanSocket;
    }

    void connect(){
        europeanSocket.connect(this);
    }
}
