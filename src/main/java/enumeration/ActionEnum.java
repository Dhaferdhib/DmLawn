package enumeration;

import error.DmLawnException;
import error.ErrorMessages;

import java.util.Arrays;

public enum  ActionEnum {
    RIGHT("R"),
    LEFT("L"),
    FORWARD("F");

    private String label;

    public static ActionEnum getByLabel(final String label) {
        return Arrays.stream(values()).filter(item -> item.label.equals(label))
                .findFirst().orElseThrow(() -> new DmLawnException(ErrorMessages.ACTION_ENUM_NOT_FOUND));
    }

    ActionEnum(String label) {
        this.label = label;
    }
}
