package PP221.dao;

import PP221.model.Car;
import PP221.model.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Users users, Car car) {
        sessionFactory.getCurrentSession().save(users);
        sessionFactory.getCurrentSession().save(car);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Users> listUsers() {
        TypedQuery<Users> query=sessionFactory.getCurrentSession().createQuery("from Users");
        return query.getResultList();
    }

    @Override
    public Users getUserByCar(String model, int series) {
        TypedQuery<Users> q = sessionFactory.getCurrentSession().createQuery("from Users u where u.car.model = :m and u.car.series = :o");
        q.setParameter("m", model);
        q.setParameter("o", series);
        return  q.setMaxResults(1).getSingleResult();
    }

}