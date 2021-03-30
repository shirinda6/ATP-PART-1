package algorithms.mazeGenerators;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class SimpleMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int row, int column) {
        Random r = new Random();
        Maze m = new Maze(row,column);
        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j <column-1 ; j++) {
                m.getM()[i][j]=1;
            }
        }
        m.setStart(new Position(0,0));
        List<Position>posList= new ArrayList<Position>();
        Position up = new Position(0,0);
        Position down = new Position(0,0);
        Position left = new Position(0,0);
        Position right = new Position(0,0);
        Position cur = new Position(0,0);
        boolean [][]visit= new boolean[row][column];


        int i=0,j =0;
        visit[0][0]=true;

        while (i!=row-1 && j!=column-1){
            if(i>0 && !visit[i-1][j]) {
                up.setAll(i - 1, j);
                posList.add(up);
            }
            if(j>0 && !visit[i][j-1]) {
                left.setAll(i, j - 1);
                posList.add(left);
            }
            if(i<row-1&& !visit[i+1][j]) {
                down.setAll(i + 1, j);
                posList.add(down);
            }
            if(j<column-1 && !visit[i][j+1]) {
                right.setAll(i, j + 1);
                posList.add(right);
            }
            if(posList.size()==0){
                cur.setAll(i,j);
                m.setGoal(cur);
                break;

            }
            if (posList.size()>=1) {
                cur = posList.get(r.nextInt(posList.size()));
                i = cur.getRowIndex();
                j = cur.getColumnIndex();
                visit[i][j] = true;
                m.getM()[i][j] = 0;
                posList.clear();

                if (i == row - 1 || j == column - 1) {
                    m.setGoal(cur);
                    break;
                }
            }
        }
            return m;
    }
}
