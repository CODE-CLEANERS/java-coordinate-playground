package domain;

public enum Type {

    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private final int count;

    Type(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
