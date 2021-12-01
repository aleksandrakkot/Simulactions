package com.company.states;

import com.company.Person;
import com.company.Utils;

import java.awt.*;

public class Infected extends State {
    public Infected(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        int nextState = Utils.getRandomNumber(1, 10);
        if (nextState < 2) {
            person.state = new InfectedWithoutSymptoms(person);
            person.color = Color.YELLOW;
            person.curePerson(person);
            return false;
        } else {
            person.state = new InfectedWithSymptoms(person);
            person.color = Color.RED;
            person.curePerson(person);
            return false;
        }
    }
}
