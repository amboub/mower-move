package com.mowitnow.model;

import com.mowitnow.enums.Instruction;
import com.mowitnow.enums.Orientation;

import java.util.List;

/**
 * Represent the mower
 *
 * @author amine
 */
public class Mower {
    /**
     * Position of the mower
     */
    private Position position;
    /**
     * Orientation of the mower
     */
    private Orientation orientation;
    /**
     * A list of instruction to move the mower
     */
    private List<Instruction> instructions;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Mower{" +
                "position=" + position +
                ", orientation=" + orientation +
                '}';
    }
}
