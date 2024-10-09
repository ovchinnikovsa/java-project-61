package hexlet.code.app.games.calc;

import java.util.function.BinaryOperator;

public enum CalcOperations {
    NULL(null, null),
    PLUS('+', Integer::sum),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b);

    private final Character symbol;
    private final BinaryOperator<Integer> operation;

    CalcOperations(Character symbol, BinaryOperator<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public char getSymbol() {
        return symbol;
    }

    public BinaryOperator<Integer> getOperation() {
        return operation;
    }

    public static CalcOperations getRandomOperation() {
        CalcOperations[] values = CalcOperations.values();
        return values[(int) (Math.random() * values.length)];
    }
}
