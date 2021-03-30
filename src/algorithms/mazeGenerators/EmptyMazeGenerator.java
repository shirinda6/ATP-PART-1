package algorithms.mazeGenerators;

import java.lang.reflect.Array;

public class EmptyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int row, int column) {
        Maze m = new Maze(row,column);
        m.setStart(new Position(0,0));
        m.setGoal(new Position(row,column));
        return m;
    }

}
