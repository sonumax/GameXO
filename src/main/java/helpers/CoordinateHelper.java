package helpers;

public class CoordinateHelper {

    public static final int MIN_COORDINATE = 0;

    public static final int MAX_COORDINATE = 2;

    public static boolean checkCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            return false;
        }
        return true;
    }
}
