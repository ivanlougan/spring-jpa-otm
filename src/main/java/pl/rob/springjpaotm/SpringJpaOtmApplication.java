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

		Order order = new Order("extremely fast postage with an extra massage");

		Product product1 = new Product("Keyboard", 9999.0, "build in microwave");
		Product product2 = new Product("IPhone x69", 10.0, "cheap and crap, free brain illness included");
		order.getProduct().add(product1);
		order.getProduct().add(product2);
		client.addOrder(order);

		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);


		Client getClient = clientDao.get(client.getId());
		System.out.println("\n" + getClient);

		clientDao.removeAllOrders(client);


		ctx.close();
	}
}
