package PP231.DAO;


import PP231.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{


    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void update(Long id, User user) {
        User userUpdate = show(id);
        userUpdate.setName(userUpdate.getName());
        userUpdate.setNickname(userUpdate.getNickname());
        userUpdate.setAge(userUpdate.getAge());
        em.merge(userUpdate);
        em.flush();
    }

    @Override
    public void delete(Long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User show(Long id) {
        return em.find(User.class, id);
    }
}
