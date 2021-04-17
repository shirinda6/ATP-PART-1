package algorithms.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DepthFirstSearch extends ASearchingAlgorithm{
    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

    @Override
    public Solution solve(ISearchable problem) {
        if(problem==null)
            return null;
        Set<AState> visited=new HashSet<>();
        AState start=problem.initial();
        Queue<AState> queue=new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()){
            numOfEvaluated++;
            AState state = queue.remove();

            for (AState s : problem.getAllPossibleStates(state)) {
                if (!visited.contains(s)) {
                    if (problem.TestGoal(s))
                        return buildSolution(s);
                    queue.add(s);
                    visited.add(s);
                }
            }
        }
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfEvaluated;
    }
}
