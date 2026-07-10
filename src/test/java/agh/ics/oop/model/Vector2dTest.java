package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    //given
    Vector2d a = new Vector2d(1,2);
    Vector2d b = new Vector2d(-2,1);
    // opposite().

    @Test
    void cheksIfGivenVectorsAreEqual(){
        //then
        boolean areTheyEqual = a.equals(b);
        assertFalse(areTheyEqual);
    }
    @Test
    void turnsVectorValuesTypesIntoString(){
        //when
        String aString = a.toString();
        String bString = b.toString();

        //then
        assertEquals("(1, 2)",aString);
        assertEquals("(-2, 1)",bString);
    }
    @Test
    void checksIfPointIsPrecedingAnother() {

        //when
        boolean precedingTest1 = a.precedes(b);
        boolean precedingTest2 = b.precedes(a);

        //Then
        assertFalse(precedingTest1);
        assertTrue(precedingTest2);
    }
    @Test
    void checksIfPointIsFollowingAnother() {
        //when
        boolean followingTest1 = a.follows(b);
        boolean followingTest2 = b.follows(a);

        //then
        assertTrue(followingTest1);
        assertFalse(followingTest2);
    }
    @Test
    void calculatesUpperRightAndLowerLeftPoints() {
        //when
        int aX = a.getX();
        int bX = b.getX();
        int aY = a.getY();
        int bY = b.getY();

        //given
        Vector2d vector1 = new Vector2d(Math.max(aX, bX), Math.max(aY, bY));
        Vector2d vector2 = a.upperRight(b);
        Vector2d vector3 = new Vector2d(Math.min(aX, bX), Math.min(aY, bY));
        Vector2d vector4 = a.lowerLeft(b);

        //then
        assertEquals(vector1, vector2);
        assertEquals(vector3, vector4);
    }
    @Test
    void doesMathOperationsOnVectors() {

        //when
        int aX = a.getX();
        int bX = b.getX();
        int aY = a.getY();
        int bY = b.getY();

        //given
        Vector2d aPlusb = a.add(b);
        Vector2d aMinusb = a.subtract(b);
        Vector2d aOpposite = a.opposite();
        Vector2d bOpposite = b.opposite();

        Vector2d aPlusb2 = new Vector2d(aX+bX, aY+bY);
        Vector2d aMinusb2 = new Vector2d(aX-bX, aY-bY);
        Vector2d aOpposite2 = new Vector2d(aX*-1, aY*-1);
        Vector2d bOpposite2 = new Vector2d(bX*-1, bY*-1);

        //then
        assertEquals(aPlusb, aPlusb2);
        assertEquals(aMinusb, aMinusb2);
        assertEquals(aOpposite, aOpposite2);
        assertEquals(bOpposite, bOpposite2);
    }
}
