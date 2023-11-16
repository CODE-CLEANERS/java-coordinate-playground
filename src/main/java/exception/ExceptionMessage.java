package exception;

public enum ExceptionMessage {
    NO_INPUT("No Input."),
    NO_TWO_DIMENSION_POINT("The input is not a two dimension point."),
    INPUT_NOT_NUMBER("The input is not a number."),
    INPUT_OUT_OF_RANGE("allow range for input is from %d to %d."),
    NO_LINE_OR_SHAPE("No Line or Shape."),
    NO_SHAPE("No %s.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
