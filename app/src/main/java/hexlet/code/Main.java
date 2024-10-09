package hexlet.code;

import hexlet.code.app.Cli;
import hexlet.code.app.games.Calculator;
import hexlet.code.app.games.Even;
import hexlet.code.app.exeptions.GameExeption;
import hexlet.code.utils.TerminalIOMediator;

public class Main {
    public static void main(String[] args) {
        String entrance = "Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calculator\n"
                + "0 - Exit\n"
                + "Your choice: ";
        TerminalIOMediator.print(entrance);
        int choice = TerminalIOMediator.readInt();

        // TODO: create game factory of games
        //  and options by enum
        try {
            switch (choice) {
                case 1:
                    Cli.greeting();
                    break;
                case 2:
                    Even evenGame = new Even();
                    evenGame.run();
                    break;
                case 3:
                    Calculator calcGame = new Calculator();
                    calcGame.run();
                    break;
                default:
                    System.exit(0);
            }
        } catch (GameExeption e) {
            TerminalIOMediator.print(e.getMessage());
        } catch (Exception e) {
            TerminalIOMediator.println("Critical error occurred. " + e.getMessage());
        }

    }
}
