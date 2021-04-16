package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {
    AState initial();

    ArrayList<AState> getAllPossibleStates(AState current);

    boolean TestGoal(AState state);
}
