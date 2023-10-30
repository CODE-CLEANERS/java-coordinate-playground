package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    public String[] creatCoordinate() throws IOException {
        System.out.println("(x,y)-(x,y)또는 (x,y)-(x,y)-(x,y)또는 (x,y)-(x,y)-(x,y)-(x,y)형식으로");
        System.out.println("좌표를 입력하세요");
        input = br.readLine();
        validateInput(input);
        return input.split("-");
    }

    private void validateInput(String input) throws IOException{
        String coordinateInput = "\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)";
        String triangleInput = "\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)";
        String quadrangleInput = "\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)-\\(\\d+,\\d+\\)";

        if(!(input.matches(coordinateInput)||input.matches(triangleInput)||input.matches(quadrangleInput))){
            throw new IOException("입력값을 형식에 맞게 입력해주세요.");
        }
    }













}
