package hexlet.code.app.games;

import hexlet.code.app.games.common.Game;
import hexlet.code.utils.TerminalIOMediator;

public class Even extends Game {
    private int questionNumber;

    protected void rules() {
        TerminalIOMediator.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    protected String genQuestion() {
        questionNumber = getRandomNumber();
        return String.valueOf(questionNumber);
    }

    protected String getAnswer() {
        return TerminalIOMediator.readString();
    }

    protected String getCorrectAnswer() {
        return questionNumber % 2 == 0 ? "yes" : "no";
    }
}
