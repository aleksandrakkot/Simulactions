package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Generator extends JPanel {

    public Generator() {
        setPreferredSize(new Dimension((Utils.WIDTH + 1) * Utils.SCALE, (Utils.HEIGHT + 1) * Utils.SCALE));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Population.set.forEach(person -> person.draw(g));
    }

}
