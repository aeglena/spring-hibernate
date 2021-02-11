package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    void add(User user);

    List<User> listUsers();

    void add(User user, Car car);

    Car findCarByID(Long id);

    User getUserByModelAndSerial(Car car);

}
