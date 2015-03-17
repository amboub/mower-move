package com.mowitnow.handler;

import com.mowitnow.enums.Orientation;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Position;
import com.mowitnow.model.Surface;
import org.testng.annotations.Test;

import static com.mowitnow.handler.PositionHandler.isInSurface;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PositionHandlerTest {

    @Test
    public void should_not_cross_the_surface_limit_when_moving() throws Exception {
        Mower mower = new Mower();
        mower.setOrientation(Orientation.S);
        mower.setPosition(new Position(5, 0));
        Surface surface = new Surface("10", "10");

        PositionHandler.handle(mower, surface);
        assertEquals(mower.getPosition(), new Position(5, 0));

        mower.setPosition(new Position(10, 10));
        mower.setOrientation(Orientation.N);
        PositionHandler.handle(mower, surface);
        assertEquals(mower.getPosition(), new Position(10, 10));
    }

    @Test
    public void test_if_a_position_is_in_the_surface() throws Exception {
        assertTrue(isInSurface(new Position(1, 5), new Surface("5", "5")));
        assertFalse(isInSurface(new Position(11, 9), new Surface("11", "8")));
        assertFalse(isInSurface(new Position(-4, 4), new Surface("4", "4")));
    }
}