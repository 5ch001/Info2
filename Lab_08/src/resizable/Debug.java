package resizable;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * set PRINT_TRACE to true
 * to switch on the print() method.
 */
public class Debug {
    static boolean PRINT_TRACE = false;

    public static void print(String message) {
        if (PRINT_TRACE) {
            System.out.println(message);
        }
    }

    public static void printStackTrace(String message) {
        if (!PRINT_TRACE) return;
        try {
            throw new Exception(message);
        } catch (Exception e) {
            System.out.println("----------------------");
            System.out.println(Thread.currentThread().getName());
            System.out.println("----------- start  " + e.getMessage());
            String stackTrace = Arrays.stream(e.getStackTrace()).map(ste -> ste.toString()).collect(Collectors.joining("\n"));
            System.out.println(stackTrace);
            System.out.println("----------- end    " + e.getMessage());
            System.out.println(Thread.currentThread().getName());
            System.out.println("----------------------");
        }
    }
}
