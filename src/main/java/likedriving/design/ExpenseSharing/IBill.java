package likedriving.design.ExpenseSharing;

public interface IBill {
    IBill createBill(int id, String subject);
    void settleBill();
    void removeBill();
    void addUser(User user);
    void removeUser( User user);
}
