package com.mowitnow.service.impl;

import com.mowitnow.enums.Instruction;
import com.mowitnow.enums.Orientation;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Position;
import com.mowitnow.model.Surface;
import com.mowitnow.service.MowItNowService;
import org.testng.annotations.Test;

import java.util.List;

import static com.mowitnow.enums.Instruction.A;
import static com.mowitnow.enums.Instruction.D;
import static com.mowitnow.enums.Instruction.G;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class MowItNowServiceImplTest {
    @Test
    public void testMowItNow() throws Exception {
        MowItNowService service = new MowItNowServiceImpl();

        List<Mower> mowers = asList(buildMower(new Position(1, 2), Orientation.N, asList(G, A, G, A, G, A, G, A, A)),
                buildMower(new Position(3, 3), Orientation.E, asList(A, A, D, A, A, D, A, D, D, A)));

        mowers = service.getMowersPosition(mowers, new Surface("5", "5"));

        Mower mower1 = mowers.get(0);
        assertEquals(mower1.getPosition(), new Position(1, 3));
        assertEquals(mower1.getOrientation(), Orientation.N);

        Mower mower2 = mowers.get(1);
        assertEquals(mower2.getPosition(), new Position(5, 1));
        assertEquals(mower2.getOrientation(), Orientation.E);
    }

    private static Mower buildMower(Position position, Orientation orientation, List<Instruction> instructions) {
        Mower mower = new Mower();
        mower.setPosition(position);
        mower.setOrientation(orientation);
        mower.setInstructions(instructions);
        return mower;
    }
}