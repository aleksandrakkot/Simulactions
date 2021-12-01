package com.company;

import com.company.states.Healthy;
import com.company.states.Infected;
import com.company.states.InfectedWithSymptoms;
import com.company.states.InfectedWithoutSymptoms;

import java.util.*;
import java.util.List;

public class Population {

    public static Set<Person> set = Collections.synchronizedSet(new HashSet<>());
    public static List<Person> removeList = new LinkedList<>();
    public static Map<PersonPair, Integer> mapOfPairs = new HashMap<>();

    public static void removeCandidates() {
        set.removeAll(removeList);
    }


    public static void changeStates() {
        for (Person person : set) {
            if (person.state instanceof InfectedWithoutSymptoms || person.state instanceof InfectedWithSymptoms) {
                for (Person neighbour : person.neighbors) {
                    if (neighbour.state instanceof Healthy) {
                        if (person.state.handle()) {
                            if (Population.mapOfPairs.getOrDefault(new PersonPair(neighbour, person), 0) >= 450) {
                                neighbour.state = new Infected(neighbour);
                                neighbour.state.handle();
                            }
                            //System.out.println("zarazono z objawami");
                            neighbour.curePerson(neighbour);
                        } else {
                            if (Population.mapOfPairs.getOrDefault(new PersonPair(neighbour, person), 0) >= 400) {
                                int random = Utils.getRandomNumber(1, 10);
                                if (random < 6) {
                                  //  System.out.println("zarazono bez objawow");
                                    neighbour.state = new Infected(neighbour);
                                    neighbour.state.handle();
                                    neighbour.curePerson(neighbour);
                                }
                            }

                        }
                    }
                }
            }
        }
    }

}
