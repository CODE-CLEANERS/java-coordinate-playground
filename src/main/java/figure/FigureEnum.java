package figure;

public enum FigureEnum {
    LINE("Line", 2),
    TRIANGLE("Triangle", 3),
    SQUARE("Square", 4);

    private final String name;
    private final int size;
    FigureEnum(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize(){
        return this.size;
    }
}
