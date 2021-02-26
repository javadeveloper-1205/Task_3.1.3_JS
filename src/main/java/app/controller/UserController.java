package app.controller;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import app.service.UserService;

import java.util.Arrays;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/{id}")
    public ModelAndView viewUserForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("listUsers", userService.findUserById(id));
        return new ModelAndView("user-find-by-id");
    }

    @GetMapping("/admin")
    public String printAllUsers(Model model) {
        model.addAttribute("listUsers", userService.findAllUsers());
        model.addAttribute("user", new User());
        model.addAttribute("listRoles", userService.getAllRoles());
        return "all-users";
    }

    @GetMapping("/admin/addNewUser")
    public ModelAndView addNewUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listRoles", userService.getAllRoles());
        return new ModelAndView("user-info");
    }

    @PostMapping(value = "/admin/saveUser")
    public ModelAndView saveUser(@ModelAttribute("user") User user,
                                 @RequestParam(value = "roleNames", required = false) String[] roleNames) {
        System.out.println(Arrays.toString(roleNames));
        user.setRoles(userService.authorities(roleNames));
        userService.addUser(user);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/admin/updateUser/{id}")
    public ModelAndView editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("listRoles", userService.getAllRoles());
        return new ModelAndView("update-user");
    }


    @PostMapping("/admin/edit/{id}")
    public ModelAndView viewEditUserForm(@ModelAttribute("user") User user,
                                         @RequestParam(value = "roleNames", required = false) String[] roleNames) {
        System.out.println(Arrays.toString(roleNames));
        user.setRoles(userService.authorities(roleNames));
        userService.editUser(user);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/admin/delete/{id}")
    public ModelAndView deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUserById(id);
        return new ModelAndView("redirect:/admin");
    }
}

