package pers.pan.springHW.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pers.pan.springHW.bank.User;
import pers.pan.springHW.employee.Employee;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Qualifier("SKUService")
    @Autowired
    private SKUService skuService;

    @GetMapping("/order/{orderId}")
    public Order getOrderInfo(@PathVariable(value = "orderId") long id,
                          Model model) {
        //GET /order/{orderId} – This API give the order details for an order
        return orderService.getOrderById(id);
    }
    @GetMapping("/catalog/sku/{skuId}")
    public SKU getSKUInfo(@PathVariable(value = "skuId") long id,
                          Model model) {
        // GET /catalog/sku/{skuId} – This API give the sku details for a given sku
        return skuService.getSKUById(id);
    }

    @PostMapping("/orderactions/acceptShipDate")
    public void acceptShipDate(@ModelAttribute("order") Order order) {
        //    POST /orderactions/acceptShipDate – This API is to accept the user consent on the new ship date
        //TODO not sure is my understanding correct?
        orderService.saveOrder(order);
    }

    @PostMapping("/orderactions/cancelItem")
    public void cancelItem(@ModelAttribute("order") Order order,
                           @ModelAttribute("item") Item item) {
        //POST /orderactions/cancelItem – This API is to cancel the item on the order
        orderService.updateItemToOrderById(order.getId(), item.getSKUId(),0);
    }
    @PostMapping("/orderactions/cancelOrder")
    public void cancelOrder(@ModelAttribute("order") Order order) {
        //    POST /orderactions/cancelOrder – This API is to cancel all the items on the order
        orderService.deleteAllItemFromOrderById(order.getId());
    }
}
