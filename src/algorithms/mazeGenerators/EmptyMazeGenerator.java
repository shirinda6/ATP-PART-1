package algorithms.mazeGenerators;

import java.lang.reflect.Array;
import java.util.Random;

public class EmptyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int row, int column) {
        Random r = new Random();
        Maze m = new Maze(row,column);
        m.setStart(new Position(0,r.nextInt(column-1)));
        int x = r.nextInt(3);
        if(x == 0){
            m.setGoal(new Position(r.nextInt(row-1),column-1));
        }
        else if(x == 1){
            m.setGoal(new Position(r.nextInt(row-1)+1,0));
        }
        else {
            m.setGoal(new Position(row-1,r.nextInt(column-1)));
        }

        return m;
    }

}
