package enumeration;

import error.DmLawnException;
import error.ErrorMessages;

import java.util.Arrays;

public enum OrientationEnum {
    NORTH("N") {
        @Override
        public OrientationEnum right() {
            return EAST;
        }
        @Override
        public OrientationEnum left() {
            return WEST;
        }
    },
    EAST("E") {
        @Override
        public OrientationEnum right() {
            return SOUTH;
        }
        @Override
        public OrientationEnum left() {
            return NORTH;
        }
    },
    SOUTH("S") {
        @Override
        public OrientationEnum right() {
            return WEST;
        }
        @Override
        public OrientationEnum left() {
            return EAST;
        }
    },
    WEST("W") {
        @Override
        public OrientationEnum right() {
            return NORTH;
        }
        @Override
        public OrientationEnum left() {
            return SOUTH;
        }
    };

    OrientationEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static OrientationEnum getByLabel(final String label) {
        return Arrays.stream(values()).filter(item -> item.label.equals(label))
                .findFirst().orElseThrow(() -> new DmLawnException(ErrorMessages.ORIENTATION_ENUM_NOT_FOUND));
    }

    public abstract OrientationEnum right();
    public abstract OrientationEnum left();
    private final String label;

}
