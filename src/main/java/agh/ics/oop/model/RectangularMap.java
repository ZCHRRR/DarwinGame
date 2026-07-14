package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {

    Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width = 4;
    private final int height = 4;
    private final Vector2d mapUpperLimit;
    private final Vector2d mapLowerLimit;

    private RectangularMap(int width, int height) {

        this.mapUpperLimit = new Vector2d(width, height);
        this.mapLowerLimit = new Vector2d(0, 0);

        MapVisualizer visualizer = new MapVisualizer(this);
        String map = visualizer.draw(mapUpperLimit, mapLowerLimit);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (!isOccupied(position)) {
            animals.put(position, animal);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {

        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);

        Vector2d newPosition = animal.getPosition();
        if (!oldPosition.equals(newPosition)) {
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return this.animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        return position.precedes(mapLowerLimit) &&
                position.follows(mapUpperLimit) &&
                !isOccupied(position);
    }
}
