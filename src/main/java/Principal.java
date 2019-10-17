import domain.Ground;
import utils.Parser;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.util.Objects.nonNull;

public class Principal {

    private final static String DEFAULT_FILE_PATH = "src/main/resources/automower.txt";

    public static void main(String[] args) throws IOException{
            File file = new File(getFilePath(Arrays.asList(args)));
            Ground ground = Parser.parseToGround(file);
            ground.execute();
    }
    private static String getFilePath(final List<String> args) {
        return nonNull(args) && args.size() == 1 ?
                args.get(0) :
                DEFAULT_FILE_PATH;
    }



}
