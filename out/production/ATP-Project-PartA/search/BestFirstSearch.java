package algorithms.search;

import java.util.*;

public class BestFirstSearch extends ASearchingAlgorithm {

    @Override
    public String getName() {
        return "BestFirstSearch";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfEvaluated;
    }

    @Override
    public Solution solve(ISearchable problem) {
        if(problem==null)
            return null;
        Set<AState> visited=new HashSet<>();
        AState start=problem.initial();
        Queue<AState> queue=new PriorityQueue<>((AState s1, AState s2)->(int)(s1.getCost()-s2.getCost()));

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            numOfEvaluated++;
            AState state = queue.remove();
            for (AState s: problem.getAllPossibleStates(state)) {
                if (!visited.contains(state)) {
                    if (problem.TestGoal(s))
                        return buildSolution(s);
                    queue.add(s);
                    visited.add(s);
                }
            }
        }
        return null;
    }
}