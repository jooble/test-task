package ru.jooble.controllers.form;

import ru.jooble.domain.Cupboard;

public class CupboardForm {
    private String id;
    private String name;

    public CupboardForm() {

    }

    public CupboardForm(Cupboard cupboard) {
        this.id = Integer.toString(cupboard.getId());
        this.name = cupboard.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
