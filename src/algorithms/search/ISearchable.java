package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {
    AState initial();

    ArrayList<AState> getAllSuccessors(AState current);

    boolean TestGoal(AState state);
}
