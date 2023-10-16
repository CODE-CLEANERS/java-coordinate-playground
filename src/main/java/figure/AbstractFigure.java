package figure;

import java.util.List;

public abstract class AbstractFigure implements Figure{
    private final List<Dot> dotList;

    protected AbstractFigure(List<Dot> dotList) {
        if (dotList.size() != this.size()){
            throw new IllegalArgumentException();
        }
        this.dotList = dotList;
    }
    public Dot getDot(int index){
        return this.dotList.get(index);
    }
    @Override
    public List<Dot> getDots(){
        return this.dotList;
    }
}
