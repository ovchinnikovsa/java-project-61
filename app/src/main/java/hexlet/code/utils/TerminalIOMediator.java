package hexlet.code.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalIOMediator {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static int readInt() {
        int result;
        while (true) {
            try {
                result = SCANNER.nextInt();
                break;
            } catch (InputMismatchException e) {
                print("Enter correct integer");
                SCANNER.nextLine();
            }
        }
        SCANNER.nextLine();

        return result;
    }

    public static String readString() {
        String result;
        result = SCANNER.nextLine();

        return result;
    }
}

