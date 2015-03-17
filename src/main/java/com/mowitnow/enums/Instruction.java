package com.mowitnow.enums;

import com.mowitnow.handler.PositionHandler;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Surface;

/**
 * @author amine
 */
public enum Instruction {
    D {
        @Override
        public Mower execute(Mower mower, Surface surface) {
            mower.setOrientation(mower.getOrientation().orientate(this));
            return mower;
        }
    },
    G {
        @Override
        public Mower execute(Mower mower, Surface surface) {
            mower.setOrientation(mower.getOrientation().orientate(this));
            return mower;
        }
    },
    A {
        @Override
        public Mower execute(Mower mower, Surface surface) {
            PositionHandler.handle(mower, surface);
            return mower;
        }
    };

    public static Instruction fromChar(Character c) {
        return valueOf(c.toString());
    }

    /**
     * Allow the mower to move and change direction inside the surface
     *
     * @param mower      The mower to move
     * @param surface    The Surface to mow
     *
     * @return  the given with updated position and direction
     */
    public abstract Mower execute(Mower mower, Surface surface);
}
