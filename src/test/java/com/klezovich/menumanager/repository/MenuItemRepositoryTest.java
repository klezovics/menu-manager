package com.klezovich.menumanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@DataJpaTest
class MenuItemRepositoryTest {

    @Autowired
    MenuItemRepository repository;

    @Test
    void testCanSaveAndFindMenuItem() {
        var menuItem = MenuItemMother.valid().build();
        var id = repository.save(menuItem).getId();
        assertThat(id, is(notNullValue()));

        var menuItemFromDbOpt = repository.findById(id);
        assertThat(menuItemFromDbOpt.isPresent(), is(true));
        assertThat(menuItemFromDbOpt.get().getDescription(), is("Roast Chicken"));
    }
}