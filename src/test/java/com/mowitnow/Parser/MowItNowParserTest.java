package com.mowitnow.Parser;

import com.mowitnow.enums.Orientation;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Position;
import com.mowitnow.model.Surface;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.mowitnow.enums.Instruction.A;
import static com.mowitnow.enums.Instruction.D;
import static com.mowitnow.enums.Instruction.G;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class MowItNowParserTest {
    private List<String> lines;

    @BeforeMethod
    public void setUp() throws Exception {
        lines = asList("5 5", "1 2 S", "AADAAGAGADDDA");
    }

    @Test
    public void testSurfaceValues() throws Exception {
        MowItNowParser underTest = new MowItNowParser(lines);

        assertEquals(underTest.getSurface(), new Surface("5", "5"));
    }

    @Test
    public void testMowersValues() throws Exception {
        MowItNowParser underTest = new MowItNowParser(lines);

        List<Mower> mowers = underTest.getMowers();

        Mower mower = mowers.iterator().next();

        assertEquals(mower.getPosition(), new Position(1, 2));
        assertEquals(mower.getOrientation(), Orientation.S);
        assertEquals(mower.getInstructions(), asList(A, A, D, A, A, G, A, G, A, D, D, D, A));
    }
}