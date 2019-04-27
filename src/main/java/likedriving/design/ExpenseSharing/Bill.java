package likedriving.design.ExpenseSharing;

import java.util.HashMap;
import java.util.Map;

public class Bill implements IBill{
    private long id;
    private String subject;
    private Map<User, Integer> usersInvolved = new HashMap<>();
    private SplittingMethod method;

    Bill(int id, String subject){
        this.id = id;
        this.subject = subject;
    }

    @Override
    public Bill createBill(int id, String subject) {
        Bill bill = new Bill(id, subject);
        return bill;
    }

    @Override
    public void settleBill() {

    }

    @Override
    public void removeBill() {

    }

    @Override
    public void addUser(User user) {
        this.usersInvolved.put(user, 0);
    }

    @Override
    public void removeUser(User user) {
        this.usersInvolved.remove(user);
    }
}