package algorithms.search;
import algorithms.mazeGenerators.*;

import java.util.ArrayList;

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

    @Override
    public ArrayList<AState> getAllPossibleStates(AState current) {
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
            if (position.getColumnIndex() + i >= 0) {
                if (m1[position.getColumnIndex() + i][position.getRowIndex()] == 1)
                    ans.add(new MazeState(current, 1, new Position(position.getColumnIndex() + i, position.getRowIndex())));
            }
            //row
            if (position.getRowIndex() + i >= 0) {
                if (m1[position.getColumnIndex()][position.getRowIndex() + i] == 1)
                    ans.add(new MazeState(current, 1, new Position(position.getColumnIndex(), position.getRowIndex() + i)));
            }
            //diagonally
            for (int j = -1; j < 2; j++) {
                if (j==0)
                    continue;
                if (position.getColumnIndex() + i >= 0 && position.getRowIndex() + j >= 0) {
                    if (m1[position.getColumnIndex() + i][position.getRowIndex() + j] == 1)
                        ans.add(new MazeState(current, 1, new Position(position.getColumnIndex(), position.getRowIndex() + i)));
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
