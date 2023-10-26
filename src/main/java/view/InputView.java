package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;



    /**
     * 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
     * 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
     * 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
     * (10,10)-(14,15) 이렇게 입력하면 선길이 구하는것,
     * (10,10)-(22,10)-(22,18)-(10,18) 이렇게 입력하면 면길이,
     * (10,10)-(14,15)-(20,8) 이렇게 입력하면 삼각형 넓이
     * ! 정규식을 이용해서 입력값을 검증하자..
     *
     */

    public void creatCoordinate() throws IOException {
        System.out.println("좌표를 입력하세요");
        input = br.readLine();

    }


}
