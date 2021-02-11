package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    void addCar(User user, Car car);

    Car findCarByID(Long id);

    User getUserByModelAndSerial(Car car);

}
