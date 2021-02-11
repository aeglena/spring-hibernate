package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("kia", 1));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("samsung", 5));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("model = " + userService.findCarByID(user.getId()).getModel());
            System.out.println("serial = " + userService.findCarByID(user.getId()).getSeries());
            System.out.println();
        }
        Car car = new Car("samsung", 5);
        System.out.println("User = " + userService.getUserByModelAndSerial(car).toString());
        context.close();
    }
}
