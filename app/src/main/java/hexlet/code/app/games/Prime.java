package hexlet.code.app.games;

import hexlet.code.app.games.common.Game;
import hexlet.code.utils.RandomInt;
import hexlet.code.utils.TerminalIOMediator;

public class Prime extends Game {
    private Integer state;

    protected void rules() {
        TerminalIOMediator.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    protected String genQuestion() {
        state = RandomInt.get();
        return String.valueOf(state);
    }

    protected String getAnswer() {
        return TerminalIOMediator.readString();
    }

    protected String getCorrectAnswer() {
        return isPrime(state) ? "yes" : "no";
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
