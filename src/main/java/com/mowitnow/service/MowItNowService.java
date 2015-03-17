package com.mowitnow.service;

import com.mowitnow.model.Mower;
import com.mowitnow.model.Surface;

import java.util.List;

/**
 * @author amine
 */
public interface MowItNowService {

    /**
     * Call this method to move the given mowers in the given surface
     *
     * @param mowers     Mowers to move
     * @param surface    Surface to mow
     *
     * @return  A mowers with new coordinates and orientation
     */
    public List<Mower> getMowersPosition(List<Mower> mowers, Surface surface);
}
