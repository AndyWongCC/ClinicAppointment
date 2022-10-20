package tools;
/**
 * @author Andy
 *
 * @version Lab5
 *
 * @see
 */
import java.util.Random;

public class Utils {
    public static int nextID(int low, int high) {
        Random r = new Random();
        return (r.nextInt(high - low) + low);
    }

    public static boolean checklength(String input, int min, int max) {
        if (input.length() >= min && input.length() <= max) {
            return true;
        }
        else { return false; }
    }
}