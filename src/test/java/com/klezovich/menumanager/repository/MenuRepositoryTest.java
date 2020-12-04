package com.klezovich.menumanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

@DataJpaTest
class MenuRepositoryTest {

    @Autowired
    MenuRepository repository;

    @Test
    void testCanSaveAndFindMenuWithMenuItems() {
        var menu = MenuMother.valid().build();
        var id = repository.save(menu).getId();

        assertThat(id, is(notNullValue()));

        var menuFromDbOpt = repository.findById(id);
        assertThat(menuFromDbOpt.isPresent(), is(true));
        var menuFromDb = menuFromDbOpt.get();
        assertThat(menuFromDb.getDescription(), is("Sample Menu"));
        assertThat(menuFromDb.getMenuItems(), hasSize(2));
    }
}
