package algorithms.search;
import algorithms.mazeGenerators.*;

import java.util.List;

public class SearchableMaze implements ISearchable {
    private MazeState start_state;
    private MazeState end_state;


    public SearchableMaze(Maze maze) {

    }
    @Override
    public List<AState> getAllPossibleStates(AState state) {
       Position p = (Position)state.getState();

        return null;
    }

    @Override
    public AState getStartState() {
        return start_state;
    }

    @Override
    public Boolean isGoalState(AState state) {
        if(state.equals(end_state))
            return true;
        return false;
    }
}
