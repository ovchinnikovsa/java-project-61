package hexlet.code.app.games;

import hexlet.code.app.games.calc.CalcOperations;
import hexlet.code.app.games.calc.CalcState;
import hexlet.code.utils.TerminalIOMediator;

import java.util.function.BinaryOperator;

public class Calculator extends Game {
    private CalcState state;

    protected void rules() {
        TerminalIOMediator.println("What is the result of the expression?");
    }

    protected String genQuestion() {
        int x = getRandomNumber();
        int y = getRandomNumber();
        CalcOperations calcOperations = CalcOperations.getRandomOperation();
        state = new CalcState(x, y, calcOperations);

        return x + " " + calcOperations.getSymbol() + " " + y;
    }

    protected Integer getAnswer() {
        return TerminalIOMediator.readInt();
    }

    protected Integer getCorrectAnswer() {
        BinaryOperator<Integer> fn = state.getOperation().getOperation();
        return fn.apply(state.getX(), state.getY());
    }
}
