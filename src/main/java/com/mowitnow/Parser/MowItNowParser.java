package com.mowitnow.Parser;

import com.mowitnow.enums.Instruction;
import com.mowitnow.model.Mower;
import com.mowitnow.enums.Orientation;
import com.mowitnow.model.Position;
import com.mowitnow.model.Surface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parser class to easely extract the surface and the instructions from the source
 *
 * @author amine
 */
public class MowItNowParser {
    private static final String SEPARATOR = " ";

    private final List<String> lines;

    public MowItNowParser(Path path) throws IOException {
        lines = Files.readAllLines(path);
    }

    public MowItNowParser(InputStream inputStream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            lines = br.lines().collect(Collectors.toList());
        }
    }

    public MowItNowParser(List<String> lines) {
        this.lines = lines;
    }

    public Surface getSurface() throws IOException {
        String[] coordinates = lines.get(0).split(SEPARATOR);
        return new Surface(coordinates[0], coordinates[1]);
    }

    public List<Mower> getMowers() {
        List<Mower> mowers = new ArrayList<>();
        for (int i = 1; i < lines.size(); i+=2) {
            String[] mowerCoordinates = lines.get(i).split(SEPARATOR);
            List<Instruction> instructions = lines.get(i + 1).chars()
                    .mapToObj(c -> Instruction.fromChar((char) c))
                    .collect(Collectors.toList());

            Mower mower = new Mower();
            mower.setInstructions(instructions);
            mower.setPosition(new Position(mowerCoordinates[0], mowerCoordinates[1]));
            mower.setOrientation(Orientation.valueOf(mowerCoordinates[2]));

            mowers.add(mower);
        }
        return mowers;
    }
}
