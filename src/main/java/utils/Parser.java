package utils;

import domain.Ground;
import domain.Mower;
import enumeration.ActionEnum;
import enumeration.OrientationEnum;
import error.DmLawnException;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static error.ErrorMessages.*;

public class Parser {
    public static Ground parseToGround(File file) throws IOException {
        if (!file.isFile())
            throw new DmLawnException(FILE_NOT_FOUND);

        Scanner in = new Scanner(file);
        Set<Mower> mowerSet = new HashSet<>();
        int width = in.nextInt(), height = in.nextInt();
        if ((width < 0 || height < 0) ||(width == 0 && height == 0) )
            throw new DmLawnException(NEGATIVE_DIMENSIONS);

        while (in.hasNext()) {
            mowerSet.add(parseMower(in));
        }
        return new Ground(width, height, mowerSet);

    }

    private static Mower parseMower(Scanner in) {
        int x = in.nextInt(), y = in.nextInt();
        OrientationEnum mowerOrientation = OrientationEnum.getByLabel(in.next());
        String actions = in.next();
        if (actions.length() == 0)
            throw new DmLawnException(NO_ACTIONS_FOUND);

        List<String> actionList = Arrays.asList(actions.split(""));
        List<ActionEnum> actionEnumList = actionList.stream().map(ActionEnum::getByLabel).collect(Collectors.toList());
        return new Mower(x, y, mowerOrientation, actionEnumList);

    }
}
