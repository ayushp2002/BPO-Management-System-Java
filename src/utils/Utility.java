package utils;

public class Utility {
    public static void clearConsoleScreen() {
        System.out.print("\033\143");
        System.out.println("BPO Management System");
    }
    public static void getch() {
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Internal error: " + e.getMessage());
        }
    }
    public static void loadingDots() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println("Internal error: " + e.getMessage());
            }
            System.out.print(".");
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println("Internal error: " + e.getMessage());
            }
        }
    }
}
