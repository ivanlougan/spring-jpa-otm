package pl.rob.springjpaotm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.rob.springjpaotm.dao.ClientDao;
import pl.rob.springjpaotm.dao.OrderDao;
import pl.rob.springjpaotm.dao.ProductDao;
import pl.rob.springjpaotm.model.Client;
import pl.rob.springjpaotm.model.Order;
import pl.rob.springjpaotm.model.Product;

@SpringBootApplication
public class  SpringJpaOtmApplication {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtmApplication.class, args);

		Client client = new Client("Krzysiu", "Pierdzikowski", "Celarowska 60, Cracow");
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);

		Order order = new Order("extremely fast postage with an extra massage");
		order.setClient(client);
		OrderDao orderDao = ctx.getBean(OrderDao.class);
		orderDao.save(order);

		Product product1 = new Product("Keyboard", 9999.0, "build in microwave");
		Product product2 = new Product("IPhone x69", 10.0, "cheap and crap, free brain illness included");
		ProductDao productDao = ctx.getBean(ProductDao.class);
		productDao.save(product1);
		productDao.save(product2);

		orderDao.addProductsToOrder(order.getId(), product1, product2);

		Client getClient = clientDao.get(order.getId());
		System.out.println("\n" + getClient);

		ctx.close();
	}
}
