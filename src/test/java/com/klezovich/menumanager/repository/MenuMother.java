package com.klezovich.menumanager.repository;

import com.klezovich.menumanager.domain.entity.Menu;

import java.util.List;

public class MenuMother {

    static Menu.Builder valid() {
        return new Menu.Builder()
            .description("Test Menu")
            .description("Sample Menu")
            .menuItems(
                List.of(
                    MenuItemMother.valid().build(),
                    MenuItemMother.valid().description("Rice").build()
                ));
    }
}
