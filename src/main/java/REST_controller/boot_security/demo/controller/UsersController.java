package REST_controller.boot_security.demo.controller;


import REST_controller.boot_security.demo.entetie.User;
import REST_controller.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UsersController {

    final private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUser(Principal principal, Model model) {
        User user = userService.getUserByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("role", user.getRoles());


        return "user/user";
    }
}
