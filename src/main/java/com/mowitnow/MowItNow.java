package com.mowitnow;

import com.mowitnow.Parser.MowItNowParser;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Surface;
import com.mowitnow.service.MowItNowService;
import com.mowitnow.service.impl.MowItNowServiceImpl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author amine
 */
public class MowItNow {

    public static void main(String[] args) throws IOException, InterruptedException {
        MowItNowParser parser = new MowItNowParser(Paths.get(args[0]));

        MowItNowService mowItNowService = new MowItNowServiceImpl();

        Surface surface = parser.getSurface();
        List<Mower> mowers = parser.getMowers();

        mowers = mowItNowService.getMowersPosition(mowers, surface);
        System.out.println("------------------------------------------------------");
        for (Mower mower : mowers) {
            System.out.println(mower);
        }
        System.out.println("------------------------------------------------------");
        Thread.sleep(3000);
    }
}
