package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("System Wystartowal");
        MoveDirection[] directions = OptionsParser.parse(args);
        run(directions);
        System.out.println("System Zakonczyl dzialanie");
    }
    public static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD  -> System.out.println("Do przodu");
                case BACKWARD -> System.out.println("Do tylu");
                case LEFT     -> System.out.println("W lewo");
                case RIGHT    -> System.out.println("W prawo");
            }
        }
    }
}
