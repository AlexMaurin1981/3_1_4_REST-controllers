package REST_controller.boot_security.demo.controller;



import REST_controller.boot_security.demo.entetie.User;
import REST_controller.boot_security.demo.service.RoleService;
import REST_controller.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {
  final private UserService userService;
   final private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping

    public String showAllUsers(Model model, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("helloUser", principal.getName());
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("role",roleService.getRoles());
        return "admin/adminPanel";
    }
    @PostMapping("/update")
    public String updateUser (@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("newUser") User user) {

        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String deleteUser (@PathVariable("id") long id) {
       userService.deleteUserById(id);
        return "redirect:/admin";
    }



}


