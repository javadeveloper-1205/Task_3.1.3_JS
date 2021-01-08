package controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

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

    @GetMapping("/admin/")
    public ModelAndView printAllUsers(Model model) {
        model.addAttribute("listUsers", userService.findAllUsers());
        return new ModelAndView("all-users");
    }

    @GetMapping("/admin/addNewUser")
    public ModelAndView addNewUser(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("user-info");
    }

    @PostMapping(value = "/admin/saveUser")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return new ModelAndView("redirect:/admin/");
    }

    @GetMapping("/admin/updateUser/{id}")
    public ModelAndView editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUserById(id));
        return new ModelAndView("update-user");
    }

    @PostMapping("/admin/edit/{id}")
    public ModelAndView viewEditUserForm(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return new ModelAndView("redirect:/admin/");
    }

    @GetMapping("/admin/delete/{id}")
    public ModelAndView deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUserById(id);
        return new ModelAndView("redirect:/admin/");
    }
}

