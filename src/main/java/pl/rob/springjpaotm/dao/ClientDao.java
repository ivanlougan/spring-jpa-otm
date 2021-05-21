package pl.rob.springjpaotm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.rob.springjpaotm.model.Client;
import pl.rob.springjpaotm.model.Order;

import javax.persistence.EntityManager;

//@SuppressWarnings("ALL")
@Repository
public class ClientDao extends GenericDao<Client, Long>{

//    public void addOrder(Client client, Order order) {
//        //into managed state
//        Client updateClient = getEntityManager().find(Client.class, client.getId());
//        //persist order to avoid transient exception
//        getEntityManager().persist(order);
//        //just add order to collection, will be saved with transaction commit -
//        //method execution
//        updateClient.getOrders().add(order);
//    }
//
//    @Override
//    public Client get(Long key) {
//        Client client = (Client) super.get(key);
//        //primitive solution for lazy loading
//        client.getOrders().size();
//        return client;
//    }
}
