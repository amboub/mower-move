package com.mowitnow.service;

import com.mowitnow.model.Surface;
import com.mowitnow.service.impl.MowItNowServiceImpl;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created with IntelliJ IDEA.
 * User: amine
 * Date: 3/15/15
 * Time: 7:02 PM
 */
public class MowItNowServiceTest {
    private static final String SEPARATOR = " ";

    @Test
    public void should_return() throws Exception {
        Path path = Paths.get("/Users/kizam/Documents", "data.txt");


        MowItNowService userTest = new MowItNowServiceImpl();
    }

    private static Surface getSurface(Stream<String> lines) throws IOException {
            List<String> coordinates = lines.findFirst()
                    .map(line -> asList(line.split(SEPARATOR, 2)))
                    .get();

            return new Surface(coordinates.get(0), coordinates.get(1));
    }
}
