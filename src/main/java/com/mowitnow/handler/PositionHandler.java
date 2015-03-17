package com.mowitnow.handler;

import com.mowitnow.enums.Orientation;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Position;
import com.mowitnow.model.Surface;

/**
 * @author amine
 */
public class PositionHandler {
    /**
     * Set the new position of the mower after moving it forward by one case <p/>
     * This position should be in the surface otherwise no position is set
     *
     * @param mower      the mower to move
     * @param surface    the surface to mow
     */
    public static void handle(Mower mower, Surface surface) {
        Position previousPosition = mower.getPosition();
        Orientation orientation = mower.getOrientation();

        Position newPosition;
        switch (orientation) {
            case N:
                newPosition = new Position(previousPosition.getX(), previousPosition.getY() + 1);
                break;
            case E:
                newPosition = new Position(previousPosition.getX() + 1, previousPosition.getY());
                break;
            case W:
                newPosition = new Position(previousPosition.getX() - 1, previousPosition.getY());
                break;
            case S:
                newPosition = new Position(previousPosition.getX(), previousPosition.getY() - 1);
                break;
            default:
                throw new IllegalArgumentException("Value " + orientation + " is not supported");
        }
        if (isInSurface(newPosition, surface)) {
            mower.setPosition(newPosition);
        }
    }

    /**
     * Check if the given position is in the surface or not
     *
     * @param position    the position to check
     * @param surface     the surface
     *
     * @return true if the position is valid, false otherwise
     */
    public static boolean isInSurface(Position position, Surface surface) {
        return compareCoordinates(position.getX(), surface.getX()) &&
                compareCoordinates(position.getY(), surface.getY());
    }

    private static boolean compareCoordinates(int posCoo, int surCoo) {
        return posCoo <= surCoo && posCoo >= 0;
    }
}
