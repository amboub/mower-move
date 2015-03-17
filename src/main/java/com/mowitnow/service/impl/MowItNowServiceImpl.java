package com.mowitnow.service.impl;

import com.mowitnow.enums.Instruction;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Surface;
import com.mowitnow.service.MowItNowService;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to call to move the mowers in the surface
 *
 * @author amine
 */
public class MowItNowServiceImpl implements MowItNowService {

    @Override
    public List<Mower> getMowersPosition(List<Mower> mowers, Surface surface) {
        List<Mower> result = new ArrayList<>(mowers.size());
        for (Mower mower : mowers) {
            List<Instruction> instructions = mower.getInstructions();
            result.add(instructions.stream()
                    .map(instruction -> instruction.execute(mower, surface))
                    .reduce((previous, current) -> current)
                    .get());
        }
        return result;
    }

}
