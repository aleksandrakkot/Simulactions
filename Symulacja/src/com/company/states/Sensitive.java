package com.company.states;

import com.company.Person;
import com.company.Utils;

import java.awt.*;

public class Sensitive extends State{

    Sensitive(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        int nextState = Utils.getRandomNumber(1, 10);
        if (nextState  == 2) {
            person.state = new Infected(person);
            return true;
        } else {
            person.state = new Healthy(person);
            person.color = Color.GREEN;
            return false;
        }
    }
}
