package com.company.states;

import com.company.Person;

import java.awt.*;

public class Resistant extends State {

    public Resistant(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        person.color = Color.GREEN;
        return false;
    }
}
