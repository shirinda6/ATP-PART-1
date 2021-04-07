package algorithms.search;

import java.util.List;

public interface ISearchable {
    List<AState> getAllPossibleStates(AState state);
    AState getStartState();
    Boolean isGoalState(AState state);
}
