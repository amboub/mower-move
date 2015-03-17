package com.mowitnow.enums;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrientationTest {

    @Test
    public void testOriantationChanges() throws Exception {
        assertEquals(Orientation.N.orientate(Instruction.D), Orientation.E);
        assertEquals(Orientation.N.orientate(Instruction.G), Orientation.W);

        assertEquals(Orientation.E.orientate(Instruction.D), Orientation.S);
        assertEquals(Orientation.E.orientate(Instruction.G), Orientation.N);

        assertEquals(Orientation.W.orientate(Instruction.D), Orientation.N);
        assertEquals(Orientation.W.orientate(Instruction.G), Orientation.S);

        assertEquals(Orientation.S.orientate(Instruction.D), Orientation.W);
        assertEquals(Orientation.S.orientate(Instruction.G), Orientation.E);
    }
}