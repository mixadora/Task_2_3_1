package data.dao;

import data.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery(" from User ", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void change(User user) {
        entityManager.merge(user);
    }


    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }


}

