package com.company;

import com.company.states.OriginalState;
import com.company.states.Resistant;
import com.company.states.State;
import com.company.vector.Vector2D;

import java.awt.*;
import java.util.*;

public class Person {
    public State state;
    public double[] cords;
    public double velocity;
    public Vector2D direction;
    public Set<Person> neighbors = new HashSet<>();
    public DrawPerson drawPerson;
    public Color color;

    public Person() {
        state = new OriginalState(this);
        direction = Utils.generateVector();
        velocity = Utils.generateVelocity();
        cords = Utils.generateStartCords(Utils.WIDTH * Utils.SCALE, Utils.HEIGHT * Utils.SCALE);
        drawPerson = new DrawPerson(this);
        Population.set.add(this);
    }


    public void move() {
        velocity = Utils.generateVelocity();
        direction = Utils.generateVector();
        double x = cords[0];
        double y = cords[1];
        x = x + direction.getComponents()[0] * velocity;
        y = y + direction.getComponents()[1] * velocity;

        if (Utils.isOutOfBounds(x, Utils.WIDTH * Utils.SCALE) || Utils.isOutOfBounds(y, Utils.HEIGHT * Utils.SCALE)) {
            //System.out.println("usunieto");
            if (Utils.isLeaving()) {
                Population.removeList.add(this);
               // System.out.println("usunieto");
            } else {
                double[] vector = direction.getComponents();
                if (Utils.isOutOfBounds(x, Utils.WIDTH * Utils.SCALE)) {
                    direction = new Vector2D(-vector[0], vector[1]);
                    cords[0] = Utils.WIDTH * Utils.SCALE - (x - Utils.WIDTH * Utils.SCALE);
                } else {
                    direction = new Vector2D(vector[0], -vector[1]);
                    cords[1] = Utils.HEIGHT * Utils.SCALE - (y - Utils.HEIGHT * Utils.SCALE);
                }
                //negateDirection(direction);
            }
        } else {
            cords = new double[]{x, y};
        }
        checkNeighbours();
    }

    public void checkNeighbours() {
        Set<Person> set = new HashSet<>();
        for (Person person : Population.set) {
            if (Utils.getDistance(this.cords, person.cords) < 3 * Utils.SCALE) {
                PersonPair pair = new PersonPair(this, person);
                Map<PersonPair, Integer> tempMap = new HashMap<>();
                tempMap.put(pair, 0);
                    set.add(person);
                if (Population.mapOfPairs.containsKey(pair)) {
                    Population.mapOfPairs.put(pair, Population.mapOfPairs.get(pair) + 1);
                } else {
                    Population.mapOfPairs.put(pair, 0);
                }
            }
        }

        set.remove(this);
        neighbors = set;
    }

    public void draw(Graphics g) {
        drawPerson.draw(g);
    }


    public void curePerson(Person person) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //System.out.println("UZDROWIONO");
                person.state = new Resistant(person);
                person.state.handle();

            }
        }, 20000);
    }

}
