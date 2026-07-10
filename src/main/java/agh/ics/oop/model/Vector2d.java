package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    boolean precedes(Vector2d other){
        if (this.x <= other.x && this.y <= other.y) {
            return true;
        } else {
            return false;
        }
    }
    boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y) {
            return true;
        } else {
            return false;
        }
    }
    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x+other.x, this.y+other.y);
    }
    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x-other.x, this.y-other.y);
    }
    public Vector2d upperRight(Vector2d other){
        int higherX = Math.max(this.x, other.x);
        int higherY = Math.max(this.y, other.y);
        return new Vector2d(higherX, higherY);
    }
    public Vector2d lowerLeft(Vector2d other) {
        int lowerX = Math.min(this.x, other.x);
        int lowerY = Math.min(this.y, other.y);
        return new Vector2d(lowerX, lowerY);
    }
    public Vector2d opposite() {
        return new Vector2d(this.x * -1, this.y * -1);
    }
}


