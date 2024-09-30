package REST_controller.demo.controller;



import REST_controller.demo.entetie.User;
import REST_controller.demo.service.RoleService;
import REST_controller.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
  final private UserService userService;
   final private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        List <User>user=userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> showUser(@PathVariable("id") long id) {
       User user =userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("users/user")
    public ResponseEntity<User> getUser(@AuthenticationPrincipal User user){
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users")
    public User updateUser (@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/users")
    public String saveUser(@RequestBody User user) {

        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser (@PathVariable("id") long id) {

        return  userService.deleteUserById(id);
    }



}


