package com.klezovich.menumanager.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<MenuItem> menuItems;

    public Menu() {}

    private Menu(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setDescription(builder.description);
        setMenuItems(builder.menuItems);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class Builder {

        private long id;
        private String name;
        private String description;
        private List<MenuItem> menuItems;

        public Builder() {}

        public Builder id(long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder menuItems(List<MenuItem> val) {
            menuItems = val;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}
