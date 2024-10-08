package hexlet.code.app.games;

import hexlet.code.app.Cli;
import hexlet.code.utils.TerminalIOMediator;

public class Even {
    private int answerCount = 0;
    private final int answerToWin = 3;
    private final String name;
    private boolean endGame = false;

    public Even() {
        this.name = Cli.greeting();
        rules();
    }

    public void run() {
        while (!endGame) {
            int questionNumber = getQuestion();
            checkAnswer(questionNumber);
            checkEndGameByAnswerCount();
        }
        getResult();
    }

    private void rules() {
        TerminalIOMediator.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private int getQuestion() {
        TerminalIOMediator.print("Question: ");
        int questionNumber = getRandomNumber();
        TerminalIOMediator.println(String.valueOf(questionNumber));

        return questionNumber;
    }

    private void checkAnswer(int questionNumber) {
        String answer = TerminalIOMediator.readString();
        String correctAnswer = questionNumber % 2 == 0 ? "yes" : "no";
        if (answer.equals(correctAnswer)) {
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

    private void getResult() {
        if (answerCount >= answerToWin) {
            TerminalIOMediator.println("Congratulations, " + name + "!");
            return;
        }
        TerminalIOMediator.println("Let's try again, " + name + "!");
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 100);
    }
}
