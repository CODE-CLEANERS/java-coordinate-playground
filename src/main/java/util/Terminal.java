package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static String in(String message) throws IOException {
        System.out.print(message);
        return BUFFERED_READER.readLine();
    }

    public static void out(String message) {
        System.out.println(message);
    }
}
