package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> simulationEntities = new ArrayList<>();
    private final List<MoveDirection> directions;
    private final List<Vector2d> positions;
    private final WorldMap map; // Pola dla mapy

    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap map) {
        this.directions = directions;
        this.positions = positions;
        this.map = map;

        for (Vector2d position : positions) {
            Animal animal = new Animal(position);
            if (this.map.place(animal)) {
                this.simulationEntities.add(animal);
            } else {
                System.out.println("Pozycja " + position + " jest już zajęta lub poza mapą. Nie dodano zwierzęcia.");
            }
        }
    }

    public void run() {
        int entityNumber = simulationEntities.size();
        if (entityNumber == 0) {
            System.out.println("Brak zwierząt do przeprowadzenia symulacji.");
            return;
        }

        int directionsCount = directions.size();
        int directionIndex = 0;
        int entityIndex = 0;

        while (directionIndex < directionsCount) {
            Animal currentAnimal = simulationEntities.get(entityIndex);
            MoveDirection currentDirection = directions.get(directionIndex);
            this.map.move(currentAnimal, currentDirection);

            System.out.println("Zwierzę " + entityIndex + " wykonało ruch: " + currentDirection);
            System.out.println(this.map);
            System.out.println("----------------------------------------");

            directionIndex++;
            entityIndex++;
            if (entityIndex == entityNumber) {
                entityIndex = 0;
            }
        }
    }
}