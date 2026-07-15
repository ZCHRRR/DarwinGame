package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.model.RectangularMap;

import java.util.ArrayList;
import java.util.List;

public class World {
    static void main(String[] args) {
        System.out.println("System Wystartowal");
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new RectangularMap(4, 4);
                
        Simulation simulation = new Simulation(positions, directions, map);
        System.out.println("Stan początkowy mapy:");
        System.out.println(map);
        System.out.println("========================================");
        simulation.run();
        System.out.println("System Zakonczyl dzialanie");
    }

    public static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("Do przodu");
                case BACKWARD -> System.out.println("Do tylu");
                case LEFT -> System.out.println("W lewo");
                case RIGHT -> System.out.println("W prawo");
            }
        }
    }
}

