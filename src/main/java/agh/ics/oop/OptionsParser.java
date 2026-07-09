package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args) {
        List<MoveDirection> resultList = new ArrayList<>();
        for (String arg : args) {
            MoveDirection direction = switch (arg.toLowerCase()) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default  -> null;
            };
            if (direction != null) {
                resultList.add(direction);
            }
        }
        return resultList.toArray(new MoveDirection[0]);
    }
}