package pl.rob.springjpaotm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.rob.springjpaotm.dao.ClientDao;
import pl.rob.springjpaotm.model.Client;
import pl.rob.springjpaotm.model.Order;

@SpringBootApplication
public class  SpringJpaOtmApplication {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtmApplication.class, args);

		Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);

		Order order = new Order("extremely fast postage with extra flowers");
		order.setClient(client);
		OrderDao orderDao = ctx.getBean(OrderDao.class);
		orderDao.save(order);

		Client getClient = clientDao.get(1L);
		System.out.println(getClient);

		ctx.close();
	}
}
