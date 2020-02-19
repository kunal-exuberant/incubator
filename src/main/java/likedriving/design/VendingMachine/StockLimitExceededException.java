package likedriving.design.VendingMachine;

public class StockLimitExceededException extends Throwable {
    public StockLimitExceededException(String message) {
        super(message);
    }
}
