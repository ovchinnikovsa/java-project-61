package hexlet.code;

import hexlet.code.app.Cli;
import hexlet.code.app.exeptions.GameExeption;
import hexlet.code.app.games.Game;
import hexlet.code.app.games.calc.CalcOperations;
import hexlet.code.utils.GameSelect;
import hexlet.code.utils.TerminalIOMediator;

public class Main {
    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            TerminalIOMediator.print(CalcOperations.getRandomOperation().getSymbol());
        }
        TerminalIOMediator.println("Please enter the game number and press Enter.");
        for (GameSelect option : GameSelect.values()) {
            if (option.getId() == null) {
                continue;
            }
            TerminalIOMediator.println(option.getId() + " - " + option.getTitle());
        }
        TerminalIOMediator.print("Your choice: ");
        int choice = TerminalIOMediator.readInt();

        GameSelect selected = GameSelect.getFromId(choice);
        Game game = selected.getGame();
        if (game == null) {
            if (selected.getId() == 1) {
                Cli.greeting();
            }
            System.exit(0);
        } else {
            try {
                game.run();
            } catch (GameExeption e) {
                TerminalIOMediator.print(e.getMessage());
            } catch (Exception e) {
                TerminalIOMediator.println("Critical error occurred. " + e.getMessage());
            }
        }

    }
}
