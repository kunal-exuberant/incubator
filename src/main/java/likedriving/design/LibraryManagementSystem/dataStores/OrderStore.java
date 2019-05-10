package likedriving.design.LibraryManagementSystem.dataStores;

import likedriving.design.LibraryManagementSystem.models.Order;
import lombok.Synchronized;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class OrderStore {

    private long lastOrderId = 0;

    @Singleton
    private Map<Long, Order> orderStore = new HashMap<>();

    @Synchronized
    public void persistOrder(Order order){
        orderStore.put(order.getId(), order);
        lastOrderId = order.getId();
    }

    public Order fetchOrderDetails(Long orderId){
        return orderStore.get(orderId);
    }

    @Synchronized
    public Long getNextOrderId(){
        return lastOrderId+1;
    }
}
