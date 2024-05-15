package com.arolla.command;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/commands")
@AllArgsConstructor
public class CommandController {

    @GetMapping
    public List<String> getAllCommands() {
        return List.of("Command1", "Command2");
    }
}