package domain;

import java.io.IOException;

public class Coordinate {
    int x;
    int y;

    public Coordinate(String coordinateInput) throws IOException {
        //인풋값에서 괄호 없애기
        coordinateInput = removeFirstAndLastChar(coordinateInput);
        //,기준으로 잘라서 x,y좌표
        String[] splitCoordinate = coordinateInput.split(",");
        //좌표 크기 검증
        validateCoordinateSize(splitCoordinate);

        this.x = Integer.parseInt(splitCoordinate[0]);
        this.y = Integer.parseInt(splitCoordinate[1]);
    }

    /**
     * (10,13)에서 () 없애주는 메서드
     * @param coordinateInput : (10,13)
     * @return : 10,13
     */
    private String removeFirstAndLastChar(String coordinateInput){
        return coordinateInput.substring(1,coordinateInput.length()-1);
    }

    private void validateCoordinateSize(String[] splitCoordinate) throws IOException {
        for (String coordinate:splitCoordinate) {
            if (Integer.parseInt(coordinate)<0 || Integer.parseInt(coordinate)>24){
                throw new IOException("좌표값은 0부터 24까지만 입력해야합니다.");
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
