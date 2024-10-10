package hexlet.code.app.games;

import hexlet.code.app.Cli;
import hexlet.code.app.exeptions.GameExeption;
import hexlet.code.utils.TerminalIOMediator;

import java.util.Objects;

abstract class Game {
    protected int answerCount = 0;
    protected final int answerToWin = 3;
    protected String name;
    protected boolean endGame = false;

    Game() {
        this.name = Cli.greeting();
        rules();
    }

    protected void getQuestion() {
        TerminalIOMediator.print("Question: ");
        TerminalIOMediator.println(genQuestion());
    }

    public void run() throws GameExeption {
        while (!endGame) {
            getQuestion();
            handleAnswer();
            checkEndGameByAnswerCount();
        }
        getResult();
    }

    protected abstract void rules();

    protected abstract String genQuestion();

    protected abstract <T> T getAnswer();

    protected abstract <T> T getCorrectAnswer();

    protected <T> void handleAnswer() {
        T answer = getAnswer();
        T correctAnswer = getCorrectAnswer();
        if (Objects.equals(answer, correctAnswer)) {
            answerCount++;
            TerminalIOMediator.println("Correct!");
            return;
        }
        endGame = true;
        String errorMessage = "'" + answer.toString() + "' is wrong answer ;(. "
                + "Correct answer was '" + correctAnswer.toString() + "'.";
        TerminalIOMediator.println(errorMessage);
    }

    protected void getResult() {
        if (answerCount >= answerToWin) {
            TerminalIOMediator.println("Congratulations, " + name + "!");
            return;
        }
        TerminalIOMediator.println("Let's try again, " + name + "!");
    }

    protected void checkEndGameByAnswerCount() {
        if (answerCount >= answerToWin) {
            endGame = true;
        }
    }
}
