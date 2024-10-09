package hexlet.code.app.games;

import hexlet.code.app.games.calc.CalcOperations;
import hexlet.code.app.games.calc.CalcState;
import hexlet.code.app.exeptions.GameExeption;
import hexlet.code.utils.TerminalIOMediator;

import java.util.function.BinaryOperator;

public class Calculator extends Game {
    private CalcState state;

    public void run() throws GameExeption {
        while (!endGame) {
            getQuestion();
            checkAnswer();
            checkEndGameByAnswerCount();
        }
        getResult();
    }

    protected void rules() {
        TerminalIOMediator.println("What is the result of the expression?");
    }

    private void getQuestion() {
        TerminalIOMediator.print("Question: ");
        int x = getRandomNumber();
        int y = getRandomNumber();
        CalcOperations calcOperations = CalcOperations.getRandomOperation();
        state = new CalcState(x, y, calcOperations);

        TerminalIOMediator.println(x
                + " " + calcOperations.getSymbol()
                + " " + y);
    }

    private void checkAnswer() throws GameExeption {
        if (state == null) {
            throw new GameExeption("Something went wrong. Game state is null.");
        }
        int answer = TerminalIOMediator.readInt();

        BinaryOperator<Integer> fn = state.getOperation().getOperation();
        int correctAnswer = fn.apply(state.getX(), state.getY());

        if (answer == correctAnswer) {
            answerCount++;
            TerminalIOMediator.println("Correct!");
            return;
        }
        endGame = true;
        String errorMessage = "'" + answer + "' is wrong answer ;(. "
                + "Correct answer was '" + correctAnswer + "'.";
        TerminalIOMediator.println(errorMessage);
    }

    private void checkEndGameByAnswerCount() {
        if (answerCount >= answerToWin) {
            endGame = true;
        }
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 100);
    }
}
