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
       Car car1 = new Car("BMW1", 1);
       Car car2 = new Car("BMW2", 2);
       Car car3 = new Car("BMW3", 3);
       userService.add(new User("User1", "Lastname1", "user1@mail.ru",car1));
       userService.add(new User("User2", "Lastname2", "user2@mail.ru",car2));
       userService.add(new User("User3", "Lastname3", "user3@mail.ru",car3));

       System.out.println(userService.userCar("BMW1" ,1));

      context.close();

   }
}
