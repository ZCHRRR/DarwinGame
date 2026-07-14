package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation{

    private final List<Animal> simulationEntities = new ArrayList<>();
    private final List<MoveDirection> directions;
    private final List<Vector2d> positions;

    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap map) {

        for (Vector2d position : positions){
            simulationEntities.add(new Animal(position));
        }
        this.directions = directions;
        this.positions = positions;
    }

    public void run() {

        int entityNumber = simulationEntities.size();
        int directionsCount = directions.size();
        int directionIndex = 0;
        int entityIndex = 0;

            while (directionIndex <= directionsCount - 1) {
                simulationEntities.get(entityIndex).move(directions.get(directionIndex));
                System.out.println("Zwierzę " + entityIndex + " : " + simulationEntities.get(entityIndex).toString());
                directionIndex ++;
                entityIndex ++;
                if (entityIndex == entityNumber) {
                    entityIndex = 0;
                }
            }
    }
}



