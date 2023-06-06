package PP231.dao;

import org.springframework.stereotype.Repository;
import PP231.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }


    @Override
    public void update(Long id, User user) {
        User users = entityManager.find(User.class, id);
        users.setId(user.getId());
        users.setName(user.getName());
        users.setNickname(user.getNickname());
        users.setAge(user.getAge());
        entityManager.merge(users);
    }


    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

}