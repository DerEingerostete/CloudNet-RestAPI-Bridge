package api.endsurve.restapi.validation;

/**
 * @author DerEingerostete
 * @since 1.0
 */
public class Validate {

    public static <T> void notNull(T object, String message) {
        if (object == null) throw new NullPointerException(message);
    }

    public static <T> void notEmpty(T[] array, String message) {
        notNull(array, "The validated object is null");
        if (array.length == 0) throw new IllegalArgumentException(message);
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) throw new IllegalArgumentException(message);
    }

}
