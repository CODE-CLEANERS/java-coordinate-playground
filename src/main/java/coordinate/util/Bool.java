package coordinate.util;

public class Bool {
    private boolean value;

    public Bool(boolean value) {
        this.value = value;
    }

    public void toFalse() {
        value = false;
    }

    public void toTrue() {
        value = true;
    }

    public boolean get() {
        return value;
    }
}
