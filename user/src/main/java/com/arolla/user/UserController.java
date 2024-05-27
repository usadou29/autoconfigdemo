package com.arolla.user;

import com.arolla.autoconfig.LogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final LogService logService;

    @GetMapping
    public List<String> getAllUsers() {
        logService.log("This is get all users request");
        return List.of("User1", "User2");
    }
}
