package com.klezovich.menumanager.service;

import com.klezovich.menumanager.domain.entity.Menu;
import com.klezovich.menumanager.domain.entity.MenuItem;
import com.klezovich.menumanager.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {this.menuRepository = menuRepository;}

    public List<Menu> getAllMenus() {
        List<Menu> allMenus = new ArrayList<>();
        menuRepository.findAll().forEach(menu -> allMenus.add(menu));
        return allMenus;
    }

    public Menu createMenu(String menuName) {
        var menu = new Menu();
        menu.setName(menuName);
        menu.setMenuItems(new ArrayList<>());
        //TODO Error handling ?
        return menuRepository.save(menu);
    }

    public void addMenuItem(long menuId, MenuItem menuItem) {
        //TODO How to name optionals
        var menuOpt = menuRepository.findById(menuId);
        if (menuOpt.isEmpty()) {
            throw new MenuServiceException("Menu with id " + menuId + "not found");
        }

        var menu = menuOpt.get();
        menu.getMenuItems().add(menuItem);
        menuRepository.save(menu);
    }

    public void removeMenuItem(long menuId, long menuItemId) {
        //TODO How to name optionals
        var menuOpt = menuRepository.findById(menuId);
        if (menuOpt.isEmpty()) {
            //TODO Whats the best way to handle this ?
            throw new MenuServiceException("Menu with id " + menuId + "not found");
        }

        var menu = menuOpt.get();
        var menuItems = menu.getMenuItems().stream()
            .filter(menuItem -> menuItem.getId() != menuId)
            .collect(toList());

        menu.setMenuItems(menuItems);

        menuRepository.save(menu);
    }

    static class MenuServiceException extends RuntimeException {

        MenuServiceException(String message) {
            super(message);
        }
    }
}
