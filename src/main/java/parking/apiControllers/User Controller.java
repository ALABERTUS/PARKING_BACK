package apiControllers.controllers;

import apiControllers.domain.models.User;
import apiControllers.domain.services.UserService;
import apiControllers.springframework.beans.factory.annotation.Autowired;
import apiControllers.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/parking/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public void addUserController(@RequestBody User user) {
        userService.addUser(user);
    }
}