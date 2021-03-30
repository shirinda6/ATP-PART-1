package algorithms.mazeGenerators;
import java.util.Random;



public class SimpleMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int row, int column) {
        Maze m = new Maze(row,column);
        Random r = new Random();

        for (int i = 1; i <row ; i++) {
            for (int j = 0; j <column-1 ; j++) {
                m.getM()[i][j]=r.nextInt(2)+0;
            }
        }
            m.setStart(new Position(0,0));
            m.setGoal(new Position(row,column));
            return m;
    }
}
