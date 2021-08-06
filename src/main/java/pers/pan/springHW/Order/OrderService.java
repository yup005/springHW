package pers.pan.springHW.Order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order);
    Order getOrderById(long id);
    void deleteOrderById(long id);
    //include add, update, delete
    void updateItemToOrderById(long id, long SKUId, int nums);
    void deleteAllItemFromOrderById(long id);
    void updateTrackToOrderById(long id, String tracking);
    void updateAddressToOrderById(long id, String address);
    void updateStatusToOrderById(long id, String status);
}
