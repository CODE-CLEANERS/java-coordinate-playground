import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String[] regexArray = {
                "\\d{3}-\\d{2}-\\d{4}",   // 예: 123-45-6789
                "\\d{4}-\\d{3}-\\d{3}",   // 예: 1234-567-890
                "\\w+@\\w+\\.\\w+"       // 예: example@email.com
        };

        String userInput = "123-45-6789"; // 사용자 입력값

        boolean isValid = false;

        for (String regex : regexArray) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(userInput);

            if (matcher.matches()) {
                isValid = true;
                break; // 하나라도 일치하면 루프 종료
            }
        }

        if (isValid) {
            System.out.println("입력값이 올바른 패턴 중 하나와 일치합니다.");
        } else {
            System.out.println("올바른 패턴과 일치하지 않습니다.");
        }
    }
    }
