package pl.rob.springjpaotm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.rob.springjpaotm.model.Product;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {


}
