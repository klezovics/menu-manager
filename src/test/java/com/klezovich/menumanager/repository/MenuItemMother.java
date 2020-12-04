package com.klezovich.menumanager.repository;

import com.klezovich.menumanager.domain.entity.MenuItem;

public class MenuItemMother {

    static MenuItem.Builder valid() {
        return new MenuItem.Builder()
            .description("Roast Chicken");
    }
}
