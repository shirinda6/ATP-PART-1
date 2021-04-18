package algorithms.search;
import algorithms.mazeGenerators.*;
import java.util.ArrayList;

/**
 * class which turn maze problem to searchable problem
 */

public class SearchableMaze implements ISearchable {
    private Maze maze;

    public SearchableMaze(Maze maze_1){
        maze = maze_1;
    }

    @Override
    public AState initial() {
        MazeState m = new MazeState(null,0, maze.getStartPosition());
        return m;
    }

    /**
     * function which return all neighbors from a given position
     * @param current : position in the maze
     * @return list of all his neighbors
     */

    @Override
    public ArrayList<AState> getAllSuccessors(AState current) {
        if (!(current instanceof MazeState))
            return null;
        int[][] m1 = maze.getM();
        MazeState mazeState = (MazeState) current;
        Position position = mazeState.getCurrent_pos();
        ArrayList<AState> ans = new ArrayList<>();
        for (int i=-1; i<2; i++){
            if (i==0)
                continue;
            //column
            if (position.getColumnIndex() + i >= 0  && position.getColumnIndex() + i <= m1[0].length - 1) {
                if (m1[position.getRowIndex()][position.getColumnIndex() + i] == 0)
                    ans.add(new MazeState(current, current.getCost()+1, new Position(position.getRowIndex(), position.getColumnIndex() + i)));
            }
            //row
            if (position.getRowIndex() + i >= 0 && position.getRowIndex() + i <= m1.length - 1) {
                if (m1[position.getRowIndex() + i][position.getColumnIndex()] == 0)
                    ans.add(new MazeState(current, current.getCost()+1, new Position( position.getRowIndex() + i, position.getColumnIndex())));
            }
            //diagonally
            for (int j = -1; j < 2; j++) {
                if (j==0)
                    continue;
                if (position.getRowIndex() + i >= 0 && position.getColumnIndex() + j >= 0 && position.getRowIndex() + i <= m1.length - 1 && position.getColumnIndex() + j <= m1[0].length - 1) {
                    if (m1[position.getRowIndex() + i][position.getColumnIndex() + j] == 0)
                        ans.add(new MazeState(current, current.getCost()+1.5, new Position(position.getRowIndex() + i, position.getColumnIndex() + j)));
                }
            }
        }
        return ans;
    }

    @Override
    public boolean TestGoal(AState state) {
        return ((state instanceof MazeState) && ((MazeState) state).getCurrent_pos().equals(maze.getGoalPosition()));
    }
}
