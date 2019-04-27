package likedriving.design.ExpenseSharing;

import java.util.HashMap;
import java.util.Map;

public class Split {
    private long id;
    private SplittingMethod method;
    private Map<User, Double> payers = new HashMap<>();

    private Map<User, Double> participants = new HashMap<>();


    void createSplit(Map<User, Double> payers, SplittingMethod method) throws ArithmeticException{
        User user1 = new User();

        User user2 = new User();

        User user3 = new User();

        Double amt1 = 100.0;

        payers.put(user1, amt1);

        payers.put(user2, 200.0);

        switch (method){
            case SHARE:

                break;

            case EQUALLY:
                double totalAmount=0.0;
                for(Map.Entry<User, Double> p: payers.entrySet()) {
                     totalAmount += p.getValue();
                }
                double share = totalAmount/payers.size();
                break;

            case PERCENTAGE:

                break;

            case EXACT_AMOUNT:

                break;
        }

    }
}
