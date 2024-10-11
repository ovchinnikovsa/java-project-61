package hexlet.code.app.games;

import hexlet.code.app.games.common.Game;
import hexlet.code.utils.RandomInt;
import hexlet.code.utils.TerminalIOMediator;

public class Progression extends Game {
    private int answerNumber;

    protected void rules() {
        TerminalIOMediator.println("What number is missing in the progression?");
    }

    protected String genQuestion() {
        int length = 10;
        int step = RandomInt.get(1, 10);
        int index = RandomInt.get(1, 10);
        int missingNumberIndex = RandomInt.get(length - 1);
        int[] numbers = new int[length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = index;
            sb.append(" ");
            if (i == missingNumberIndex) {
                answerNumber = index;
                sb.append("...");
            } else {
                sb.append(index);
            }
            index += step;
        }

        return sb.toString();
    }

    protected Integer getAnswer() {
        return TerminalIOMediator.readInt();
    }

    protected Integer getCorrectAnswer() {
        return answerNumber;
    }

}
