package domain;

import enumeration.ActionEnum;
import enumeration.OrientationEnum;
import error.DmLawnException;

import java.util.List;

import static java.lang.String.format;

public class Mower implements Movable {
    private Position position;
    private OrientationEnum orientation;
    private List<ActionEnum> actionEnumList;

    public Mower(int x, int y, OrientationEnum orientation, List<ActionEnum> actionEnumList) {
        this.position = new Position(x, y);
        this.orientation = orientation;
        this.actionEnumList = actionEnumList;
    }

    public Mower(int x, int y, OrientationEnum orientation) {
        this.position = new Position(x, y);
        this.orientation = orientation;
    }

    @Override
    public void turnRight() {
        System.out.println("turing right");
        this.orientation = this.orientation.right();
    }

    @Override
    public void turnLeft() {
        System.out.println("turing left");
        this.orientation = this.orientation.left();

    }

    @Override
    public void moveForward(int width, int height) {
        if (authorizedMove(width, height)) {

            switch (orientation) {
                case EAST:
                    position.incrementX();
                    break;
                case WEST:
                    position.decrementX();
                    break;
                case NORTH:
                    position.incrementY();
                    break;
                case SOUTH:
                    position.decrementY();
                    break;
            }
        }
    }

    public void executeActions(int width, int height) {
        if (actionEnumList.size() == 0)
            throw new DmLawnException(String.format("Actions provided to Mower at %s at position is Empty", getLocation()));

        for (ActionEnum action : actionEnumList
        ) {
            executeAction(action, width, height);
        }
        System.out.println(getLocation());
    }

    private void executeAction(ActionEnum action, int width, int height) {
        switch (action) {
            case LEFT:
                this.turnLeft();
                break;
            case RIGHT:
                this.turnRight();
                break;
            case FORWARD:
                this.moveForward(width, height);
        }
    }

    private boolean authorizedMove(int width, int height) {
        return !(((width == position.getX()) && orientation.equals(OrientationEnum.EAST)) ||
                (position.getX() == 0 && orientation.equals(OrientationEnum.WEST)) ||
                (height == position.getY() && orientation.equals(OrientationEnum.NORTH)) ||
                (position.getY() == 0 && orientation.equals(OrientationEnum.SOUTH)));

    }


    public String getLocation() {
        return format("(%s, %s, %s)", position.getX(), position.getY(), orientation.getLabel());
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }
}
