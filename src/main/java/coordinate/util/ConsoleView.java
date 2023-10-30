package coordinate.util;

public class ConsoleView implements View {

    private static ConsoleView instance;

    private ConsoleView() {}

    public static ConsoleView getInstance() {
        if (instance == null) {
            instance = new ConsoleView();
        }

        return instance;
    }

    @Override
    public void print(Message message) {
        System.out.println(message);
    }


}
