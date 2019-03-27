package ca.ubc.cs.cpsc210.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {

    private static List<Observer> observers = new ArrayList<>();

    public static void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void notifyObserver(String newprofilename) {
        for (Observer observer : observers) {
            observer.update(newprofilename); //newprofilename is what you are sending to the observer
        }
    }
}


