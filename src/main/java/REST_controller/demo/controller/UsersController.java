package REST_controller.demo.controller;


import REST_controller.demo.entetie.User;
import REST_controller.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;


@RestController
@RequestMapping("/user")
public class UsersController {

    final private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User showUser(Principal principal) {
        return userService.getUserByEmail(principal.getName());
    }
}
