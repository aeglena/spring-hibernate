package hiber.service;

import hiber.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserService {
    void add(User user);
    List<User> listUsers();
}
