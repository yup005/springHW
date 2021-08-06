package pers.pan.springHW.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getOrderById(long id) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = null;
        if (optional.isPresent()) {
            order = optional.get();
        } else {
            throw new RuntimeException(" Order not found for id :: " + id);
        }
        return order;
    }

    @Override
    public void deleteOrderById(long id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public void updateItemToOrderById(long id, long SKUId, int nums) {
        if(nums < 0) {
            throw new RuntimeException("Wrong input.");
        }
        Item item = null;
        for (Item items : itemRepository.findByOrderId(id)) {
            if (items.getSKUId() == SKUId) { item = items; }
        }
        if (nums == 0) {
            if (item != null) itemRepository.delete(item);
            return;
        }
        if (item == null) {
            item = new Item();
            item.setOrderId(id);
            item.setSKUId(SKUId);
        }
        item.setNums(nums);
        //only change item repository. it includes order id
        itemRepository.save(item);
    }

    @Override
    public void deleteAllItemFromOrderById(long id) {
        for (Item items : itemRepository.findByOrderId(id)) {
            itemRepository.deleteById(items.getId());
        }
    }

    @Override
    public void updateTrackToOrderById(long id, String tracking) {
        Order order = getOrderById(id);
        order.setTracking(tracking);
        orderRepository.save(order);
    }

    @Override
    public void updateAddressToOrderById(long id, String address) {
        Order order = getOrderById(id);
        order.setAddress(address);
        orderRepository.save(order);
    }

    @Override
    public void updateStatusToOrderById(long id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        orderRepository.save(order);
    }
}
