package REST_controller.demo.controller;


import REST_controller.demo.entetie.User;
import REST_controller.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/user")
public class UsersController {

    final private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity <User> showUser(@AuthenticationPrincipal User user) {
        return new  ResponseEntity<>(user, HttpStatus.OK);

    }


}
