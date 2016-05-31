package com.caveweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by YearianYoga on 5/30/2016.
 */

@RestController
public class CaveRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    MenuOptions menuOptions = null;

    @RequestMapping("/")
    public MenuOptions menuOptions(){

        String[] options = {"Greeting","Movie API", "XML Example", "JSON Example"};

        menuOptions.setMenuOption(options);

        return menuOptions;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}