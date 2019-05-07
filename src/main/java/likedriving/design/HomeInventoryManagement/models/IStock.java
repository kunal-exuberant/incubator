package likedriving.design.HomeInventoryManagement.models;

public interface IStock {
    void addStock(Item item, Quantity quantity);
    Quantity getStock(Item item);
}
