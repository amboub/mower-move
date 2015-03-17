package com.mowitnow.enums;

/**
 * @author amine
 */
public enum Orientation {
    N {
        @Override
        public Orientation orientate(Instruction instruction) {
            switch (instruction) {
                case D:
                    return E;
                case G:
                    return W;
                default:
                    throw new IllegalArgumentException("Value " + instruction + "is not supported");
            }
        }
    }, E {
        @Override
        public Orientation orientate(Instruction instruction) {
            switch (instruction) {
                case D:
                    return S;
                case G:
                    return N;
                default:
                    throw new IllegalArgumentException("Value " + instruction + "is not supported");
            }
        }
    }, W {
        @Override
        public Orientation orientate(Instruction instruction) {
            switch (instruction) {
                case D:
                    return N;
                case G:
                    return S;
                default:
                    throw new IllegalArgumentException("Value " + instruction + "is not supported");
            }
        }
    }, S {
        @Override
        public Orientation orientate(Instruction instruction) {
            switch (instruction) {
                case D:
                    return W;
                case G:
                    return E;
                default:
                    throw new IllegalArgumentException("Value " + instruction + "is not supported");
            }
        }
    };

    /**
     * Allow the mower to change orientation
     *
     * @param instruction    : the {@link com.mowitnow.enums.Instruction} to calculate the orientation
     *
     * @return  new {@link com.mowitnow.enums.Orientation}
     */
    public abstract Orientation orientate(Instruction instruction);
}
