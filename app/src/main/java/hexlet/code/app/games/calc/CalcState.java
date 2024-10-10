package hexlet.code.app.games.calc;

import hexlet.code.app.games.common.IntPair;

public class CalcState extends IntPair {
    private final CalcOperations operation;

    public CalcState(int x, int y, CalcOperations operation) {
        super(x, y);
        this.operation = operation;
    }


    public CalcOperations getOperation() {
        return operation;
    }

}
