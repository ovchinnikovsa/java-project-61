package hexlet.code.app;

import hexlet.code.utils.TerminalIOMediator;

public class Cli {
    public static String greeting() {
        TerminalIOMediator.print("Welcome to the Brain Games!\n" + "May I have your name? ");
        String name = TerminalIOMediator.readString();
        TerminalIOMediator.println("Hello, " + name + "!");

        return name;
    }
}
