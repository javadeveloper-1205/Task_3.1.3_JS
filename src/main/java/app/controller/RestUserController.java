package app.controller;

import app.model.User;
import app.service.UserService;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;


//@RestController
//@RequestMapping("/api")
//public class RestUserController {
//
//    private UserService userService;
//
//    @Autowired
//    public RestUserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping(value = "/admin/saveUser")
//    public ResponseEntity<?> create(@RequestBody User user) {
//        userService.addUser(user);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping("/admin")
//    public ResponseEntity<List<User>> printAllUsers() {
//        final List<User> users = userService.findAllUsers();
//        return users != null && !users.isEmpty()
//                ? new ResponseEntity<>(users, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/user/{id}")
//    public ResponseEntity<User> read(@PathVariable(name = "id") int id) {
//        final User user = userService.findUserById(id);
//        return user != null
//                ? new ResponseEntity<>(user, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping("/admin/updateUser/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody User user) {
//        userService.editUser(user);
//        return ResponseEntity.ok(userService.findAllUsers());
//
//    }
//
//    @DeleteMapping(value = "/admin/delete/{id}")
//    public void delete(@PathVariable(name = "id") int id) {
//        userService.deleteUserById(id);
//
//    }
//}
