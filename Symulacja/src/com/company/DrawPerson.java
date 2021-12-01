package com.company;

import java.awt.*;

public class DrawPerson implements Drawable {

    private Person person;

    public DrawPerson(Person person) {
        this.person = person;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(person.color);
        g2d.fillOval((int) person.cords[0], (int) person.cords[1], Utils.SCALE, Utils.SCALE);
    }
}
