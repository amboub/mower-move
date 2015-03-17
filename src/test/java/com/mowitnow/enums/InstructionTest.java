package com.mowitnow.enums;

import com.mowitnow.model.Mower;
import com.mowitnow.model.Position;
import com.mowitnow.model.Surface;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InstructionTest {


    @Test
    public void testMowerPosition() throws Exception {
        Mower mower = new Mower();
        mower.setOrientation(Orientation.N);
        mower.setPosition(new Position(5, 1));
        Surface surface = new Surface("10", "10");

        mower = Instruction.A.execute(mower, surface);
        assertEquals(mower.getPosition(), new Position(5, 2));
        assertEquals(mower.getOrientation(), Orientation.N);

        mower = Instruction.D.execute(mower, surface);
        assertEquals(mower.getPosition(), new Position(5, 2));
        assertEquals(mower.getOrientation(), Orientation.E);

        mower = Instruction.G.execute(mower, surface);
        assertEquals(mower.getPosition(), new Position(5, 2));
        assertEquals(mower.getOrientation(), Orientation.N);

        mower.setPosition(new Position(10, 10));
        mower = Instruction.A.execute(mower, surface);
        assertEquals(mower.getPosition(), new Position(10, 10));
        assertEquals(mower.getOrientation(), Orientation.N);

        mower.setOrientation(Orientation.E);
        mower = Instruction.A.execute(mower, surface);
        assertEquals(mower.getPosition(), new Position(10, 10));
        assertEquals(mower.getOrientation(), Orientation.E);
    }


}