package com.klezovich.menumanager.repository;

import com.klezovich.menumanager.domain.entity.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
}
