package hexlet.code.utils;

public class RandomInt {
    public static int get(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static int get(int max) {
        return get(0, max);
    }

    public static int get() {
        return get(0, 100);
    }
}
