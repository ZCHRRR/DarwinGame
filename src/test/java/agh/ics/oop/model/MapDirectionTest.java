package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapDirectionTest {

    //given
    MapDirection DirectionNORTH = MapDirection.NORTH;
    MapDirection DirectionSOUTH = MapDirection.SOUTH;
    MapDirection DirectionWEST = MapDirection.WEST;
    MapDirection DirectionEAST = MapDirection.EAST;

    @Test
    void previousMapDirectionIsWorking() {
        //when
        DirectionNORTH = DirectionNORTH.previous();
        DirectionSOUTH = DirectionSOUTH.previous();
        DirectionWEST = DirectionWEST.previous();
        DirectionEAST = DirectionEAST.previous();

        //then
        assertEquals(MapDirection.EAST, DirectionNORTH);
        assertEquals(MapDirection.NORTH, DirectionSOUTH);
        assertEquals(MapDirection.SOUTH, DirectionWEST);
        assertEquals(MapDirection.WEST, DirectionEAST);
    }

    @Test
    void nextMapDirectionIsWorking() {
        //when
        DirectionNORTH = DirectionNORTH.next();
        DirectionSOUTH = DirectionSOUTH.next();
        DirectionWEST = DirectionWEST.next();
        DirectionEAST = DirectionEAST.next();

        //then
        assertEquals(MapDirection.SOUTH, DirectionNORTH);
        assertEquals(MapDirection.WEST, DirectionSOUTH);
        assertEquals(MapDirection.EAST, DirectionWEST);
        assertEquals(MapDirection.NORTH, DirectionEAST);
    }
}
