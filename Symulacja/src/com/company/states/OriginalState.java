package com.company.states;

import com.company.Person;
import com.company.Utils;

import java.awt.*;

public class OriginalState extends State {

    public OriginalState(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        int nextState = Utils.getRandomNumber(1, 10);

        if (nextState < 3) {
            person.state = new Resistant(person);
            person.color = Color.GREEN;
            return false;
        } else {
            person.state = new Sensitive(person);
            return true;
        }
    }
}
