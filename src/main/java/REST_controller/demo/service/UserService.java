package REST_controller.demo.service;

import REST_controller.demo.entetie.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService  extends UserDetailsService {
    User getUserByEmail(String email);

      void saveUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);

    void updateUser(User user);
    List<User> getAllUsers();

}

