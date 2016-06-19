package com.caveweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CaveRestController {

    private static final String template = "Hello, %s! Born in %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    MenuOptions menuOptions;

    @RequestMapping("/")
    public MenuOptions menuOptions(){

        String[] options = {"Greeting","Popular Movies App", "XML Example", "JSON Example"};

        menuOptions.setMenuOption(options);

        return menuOptions;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World")String name,
                             @RequestParam(value="number", defaultValue ="19XX")String number){

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name, number));
    }
}
