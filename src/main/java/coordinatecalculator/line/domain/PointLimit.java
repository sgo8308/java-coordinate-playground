package coordinatecalculator.line.domain;

public enum PointLimit {
    LOWER_LIMIT(0),
    UPPER_LIMIT(24);

    int value;
    PointLimit(int value) {
       this.value = value;
    }

    public static boolean isInsideLimit(int number) {
        return number >= LOWER_LIMIT.value && number <= UPPER_LIMIT.value;
    }
}
