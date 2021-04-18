package algorithms.mazeGenerators;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int row, int column) {
        Maze m =new Maze(row,column);
        m.fillMaze();
      // m.fillRandom();
        Random r = new Random();
        Position up = new Position();
        Position down = new Position();
        Position left = new Position();
        Position right = new Position();
        Position cur;
        List<Position>posList= new ArrayList<>();
        List<Position>neighbors= new ArrayList<>();

        m.setStart(new Position(0,0));
        posList.add(m.getStartPosition());
        int i=0,j =0,index =0,it=0;

        while (i!=row-1 && j!=column-1){
            it++;
            if(i>0 ) {
                up.setAll(i - 1, j);
                neighbors.add(up);
            }
            if(j<column-1) {
                right.setAll(i, j + 1);
                neighbors.add(right);
            }
            if(i<row-1) {
                down.setAll(i + 1, j);
                neighbors.add(down);
            }
            if(j>0 ) {
                left.setAll(i, j - 1);
                neighbors.add(left);
            }

            cur = neighbors.get( r.nextInt(neighbors.size()));
            if(cur!=null) {
                i = cur.getRowIndex();
                j = cur.getColumnIndex();
                m.getM()[i][j] = 0;
                if (!posList.contains(cur)) {
                    posList.add(cur);
                    index++;
                }
                if (i == row - 1 || j == column - 1 ) {
                    m.setGoal(cur);
                    break;
                }
            }
            else{
                if (index>=1) {
                    index--;
                    i = posList.get(index).getRowIndex();
                    j = posList.get(index).getColumnIndex();
                    if ((i == row - 1 && j>0) || (j == column - 1 && i>0)) {
                        m.setGoal(new Position(i,j));
                        break;
                    }
                }
            }
            neighbors.clear();
        }
            return m;
    }
}
