package coordinate.util;

public enum Message {
    INPUT_INFO_MESSAGE("좌표를 입력하세요."),
    NOT_ENOUGH_INPUT("올바른 개수의 좌표값을 입력해주세요."),
    NO_NUMBER("올바른 개수의 좌표값을 입력해주세요."),
    OUT_OF_RANGE("X, Y좌표 모두 최소 1, 최대 24까지만 입력할 수 있습니다.");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
