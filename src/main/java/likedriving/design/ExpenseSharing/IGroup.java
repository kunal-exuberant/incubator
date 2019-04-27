package likedriving.design.ExpenseSharing;

public interface IGroup {
    void createGroup();
    void addUser(User user);
    void addBill();
    void removeGroup(Group group);
    void settleGroup(Group group);
}
