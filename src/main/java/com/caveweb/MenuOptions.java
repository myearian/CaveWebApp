package com.caveweb;

import org.springframework.stereotype.Component;

/**
 * Created by YearianYoga on 5/31/2016.
 */
@Component
public class MenuOptions {
    private String[] menuOption;

    public String[] getMenuOption() {
        return menuOption;
    }

    public void setMenuOption(String[] menuOption) {
        this.menuOption = menuOption;
    }

}
