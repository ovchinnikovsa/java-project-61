package hexlet.code.app.games.calc;

public class CalcState {
    private final int x;
    private final int y;
    private final CalcOperations operation;

    public CalcState(int x, int y, CalcOperations operation) {
        this.x = x;
        this.y = y;
        this.operation = operation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CalcOperations getOperation() {
        return operation;
    }

}
