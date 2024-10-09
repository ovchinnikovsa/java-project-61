package hexlet.code.app.games;

import hexlet.code.utils.TerminalIOMediator;

public class Even extends Game {
    public void run() {
        while (!endGame) {
            int answer = getQuestion();
            checkAnswer(answer);
            checkEndGameByAnswerCount();
        }
        getResult();
    }

    protected void rules() {
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

    private int getRandomNumber() {
        return (int) (Math.random() * 100);
    }
}
