package utils;

/**
 * Utility methods to be used across the program
 */
public class Utility {
    /**
     * It prints the escape sequence \033\143 to the console, which is the ANSI escape sequence for
     * clearing the screen
     */
    public static void clearConsoleScreen() {
        System.out.print("\033\143");
        System.out.println("BPO Management System");
    }
    /**
     * It waits for the user to press a key.
     */
    public static void getch() {
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Internal error: " + e.getMessage());
        }
    }
    /**
     * It prints three dots, each separated by 200 + 200 milliseconds
     */
    public static void loadingDots() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Internal error: " + e.getMessage());
            }
            System.out.print(".");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Internal error: " + e.getMessage());
            }
        }
    }
}
