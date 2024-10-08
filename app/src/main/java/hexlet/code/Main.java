package hexlet.code;

import hexlet.code.app.Cli;
import hexlet.code.app.games.Even;
import hexlet.code.utils.TerminalIOMediator;

public class Main {
    public static void main(String[] args) {
        String entrance = "Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit\n"
                + "Your choice: ";
        TerminalIOMediator.print(entrance);
        int choice = TerminalIOMediator.readInt();

        switch (choice) {
            case 1:
                Cli.greeting();
                break;
            case 2:
                Even game = new Even();
                game.run();
            default:
                System.exit(0);
        }

    }
}
