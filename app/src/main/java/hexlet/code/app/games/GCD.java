package hexlet.code.app.games;

import hexlet.code.app.games.common.Game;
import hexlet.code.app.games.common.IntPair;
import hexlet.code.utils.RandomInt;
import hexlet.code.utils.TerminalIOMediator;

public class GCD extends Game {
    private IntPair state;

    protected void rules() {
        TerminalIOMediator.println("Find the greatest common divisor of given numbers.");
    }

    protected String genQuestion() {
        int x = RandomInt.get();
        int y = RandomInt.get();
        state = new IntPair(x, y);
        return x + " " + y;
    }

    protected Integer getAnswer() {
        return TerminalIOMediator.readInt();
    }

    protected Integer getCorrectAnswer() {
        return getMaxCommonDivisors(state.getX(), state.getY());
    }

    private Integer getMaxCommonDivisors(Integer x, Integer y) {
        Integer max = x;
        Integer min = y;
        if (x < y) {
            max = y;
            min = x;
        }
        return algorithmOfEuclid(max, min);
    }

    private Integer algorithmOfEuclid(Integer max, Integer min) {
        int reminder = max % min;
        if (reminder == 0) {
            return min;
        } else {
            return algorithmOfEuclid(min, reminder);
        }
    }
}
