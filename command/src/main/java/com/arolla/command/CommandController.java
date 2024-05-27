package com.arolla.command;

import com.arolla.autoconfig.LogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/commands")
@AllArgsConstructor
public class CommandController {

    private final LogService logService;

    @GetMapping
    public List<String> getAllCommands() {
        logService.log("This is get all commands request");
        return List.of("Command1", "Command2");
    }
}