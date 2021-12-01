package com.company;

public class Main {

    public static void main(String[] args) {

        int numberOfPeople = 100;
        int currentNumber;

        for (int i = 0; i < numberOfPeople; i++) {
            Person person = new Person();
            while(person.state.handle()) { }
        }
        MyFrame frame = new MyFrame();
        while (true) {

            Population.set.forEach(Person::move);
            Population.removeCandidates();
            currentNumber = numberOfPeople - Population.set.size();
            for (int j = 0; j < currentNumber; j++) {
                Person person = new Person();
                while(person.state.handle()) {}
            }
            Population.changeStates();
            frame.repaint();
        }




    }
}
