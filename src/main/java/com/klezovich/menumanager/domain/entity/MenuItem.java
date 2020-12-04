package com.klezovich.menumanager.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private long id;
    private String description;

    private MenuItem(Builder builder) {
        setId(builder.id);
        setDescription(builder.description);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static final class Builder {

        private long id;
        private String description;

        public Builder() {}

        public Builder id(long val) {
            id = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public MenuItem build() {
            return new MenuItem(this);
        }
    }
}
