package pl.rob.springjpaotm.dao;

import pl.rob.springjpaotm.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;

@Transactional
public abstract class GenericDao<T, K> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;

    EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    GenericDao() {
        type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T get(K key) {
        T find = entityManager.find(type, key);
        return find;
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void remove(T entity) {
        T managedClient = entityManager.merge(entity);
        entityManager.remove(managedClient);

    }
}