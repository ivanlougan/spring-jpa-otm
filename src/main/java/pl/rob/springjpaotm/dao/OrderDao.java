package pl.rob.springjpaotm.dao;

import org.springframework.stereotype.Repository;
import pl.rob.springjpaotm.model.Order;
import pl.rob.springjpaotm.model.Product;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long>{

    public void addProductsToOrder(Long orderId, Product... products) {
        Order order = get(orderId);
        for (Product product : products) {
            order.getProduct().add(product);
        }
    }
}
