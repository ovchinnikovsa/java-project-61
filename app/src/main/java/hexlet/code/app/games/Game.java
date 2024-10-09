package hexlet.code.app.games;

import hexlet.code.app.Cli;
import hexlet.code.app.exeptions.GameExeption;
import hexlet.code.utils.TerminalIOMediator;

// TODO: create more realisations of methods that a common for all games
abstract class Game {
    protected int answerCount = 0;
    protected final int answerToWin = 3;
    protected String name;
    protected boolean endGame = false;

    Game() {
        this.name = Cli.greeting();
        rules();
    }

    abstract void run() throws GameExeption;

    abstract void rules();

    protected void getResult() {
        if (answerCount >= answerToWin) {
            TerminalIOMediator.println("Congratulations, " + name + "!");
            return;
        }
        TerminalIOMediator.println("Let's try again, " + name + "!");
    }
}
