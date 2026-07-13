package agh.ics.oop.model;


public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    private static final Vector2d MAP_MIN_LIMIT = new Vector2d(0, 0);
    private static final Vector2d MAP_MAX_LIMIT = new Vector2d(4, 4);

    public Animal(Vector2d initialPosition) {
        this.position = initialPosition;
    }

    public Animal() {
        this.position = new Vector2d(2, 2);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "orientation=" + orientation +
                ", position=" + position +
                '}';
    }
    boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public void move(MoveDirection direction) {

        this.orientation = getOrientation();
        Vector2d newPosition = getPosition();
        Vector2d unitVector = orientation.toUnitVector();

        switch (direction){
            case RIGHT -> this.orientation = orientation.next();
            case LEFT -> this.orientation = orientation.previous();
            case FORWARD -> newPosition = newPosition.add(unitVector);
            case BACKWARD -> newPosition = newPosition.subtract(unitVector);
        }
        if (newPosition.precedes(MAP_MAX_LIMIT) && newPosition.follows(MAP_MIN_LIMIT)) {
            this.position = newPosition;
        }


    }
}

