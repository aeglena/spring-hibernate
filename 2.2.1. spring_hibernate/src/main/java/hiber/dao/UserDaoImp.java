package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void addCar(User user, Car car) {
        user.setCar(car);
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    public Car findCarByID(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car c where c.id = :id");
        query.setParameter("id", id);
        return (Car) ((org.hibernate.query.Query<?>) query).uniqueResult();
    }

    public User getUserByModelAndSerial(Car car) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select u from User u inner join u.car c where c.model = :model and c.series= :serial");
        query.setParameter("model", car.getModel());
        query.setParameter("serial", car.getSeries());
        return (User) ((org.hibernate.query.Query<?>) query).uniqueResult();
    }
}
