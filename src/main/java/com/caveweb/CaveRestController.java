package com.caveweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CaveRestController {

    private static final String template = "Hello, %s! Born in %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    MenuOptions menuOptions;

    @RequestMapping("/menuOptions")
    public MenuOptions menuOptions() {

        String[] options = {"Greeting", "Popular Movies App", "XML Example", "JSON Example"};

        menuOptions.setMenuOption(options);

        return menuOptions;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
                             @RequestParam(value = "year", defaultValue = "19XX") String year) {

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name, year));
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }
}
