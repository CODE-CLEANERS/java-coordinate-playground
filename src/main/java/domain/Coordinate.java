package domain;

public class Coordinate {
    int x;
    int y;

    public Coordinate(String coordinateInput) {
        removeFirstAndLastChar(coordinateInput);
        String[] splitCoordinate = coordinateInput.split(",");
        this.x = Integer.parseInt(splitCoordinate[0]);
        this.y = Integer.parseInt(splitCoordinate[1]);
    }

    /**
     * (10,13)에서 () 없애주는 메서드
     * @param coordinateInput : (10,13)
     * @return : 10,13
     */
    private String removeFirstAndLastChar(String coordinateInput){
        return coordinateInput.substring(1,coordinateInput.length() - 1);
    }
}
