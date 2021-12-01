package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

public class MyFrame extends JFrame {

    public MyFrame() {
        super("Symulation");
        Generator generator = new Generator();

        add(generator);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
