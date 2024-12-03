package REST_controller.demo.controller;



import REST_controller.demo.entetie.Role;
import REST_controller.demo.entetie.User;
import REST_controller.demo.service.RoleService;
import REST_controller.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;


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

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {

        User userEdit = userService.getUserById(id);
        if (userEdit == null){
            throw new NoSuchElementException("User with ID = " + id + " not found");
        }
        User userUpdate = userService.updateUser(user);
            return new ResponseEntity<>(userUpdate, HttpStatus.OK);
        }


    @PostMapping("/users")
    public ResponseEntity <HttpStatus> saveUser(@RequestBody User user) {
    userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser (@PathVariable("id") long id) {
         userService.deleteUserById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/roles")
    public List<Role> getRoles(){
    return roleService.getRoles();
    }

}




