package com.klezovich.menumanager.controller;

import com.klezovich.menumanager.controller.dto.MenuDto;
import com.klezovich.menumanager.domain.entity.Menu;
import com.klezovich.menumanager.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final ModelMapper modelMapper;
    private final MenuService menuService;

    public MenuController(ModelMapper modelMapper, MenuService menuService) {
        this.modelMapper = modelMapper;
        this.menuService = menuService;
    }

    //TODO Add exception mapping
    //TODO Add bean validation
    //TODO Make menu name unique
    //TODO Add Swagger
    @PostMapping("/create")
    public MenuDto createMenu(@RequestBody CreateMenuDto createMenuDto) {
        return toDto(menuService.createMenu(createMenuDto.getMenuName()));
    }

    private static class CreateMenuDto {
        private String menuName;

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }
    }

    private MenuDto toDto(Menu menu) {
        return modelMapper.map(menu, MenuDto.class);
    }
}
