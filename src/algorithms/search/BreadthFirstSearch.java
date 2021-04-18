package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    protected Queue<AState> queue;
    public BreadthFirstSearch() {
        super();
        queue=new LinkedList<>();
    }
    /**
     * solving the problem by breadth first search algorithm
     * @param problem: the problem to solve
     * @return a solution
     */

    public Solution solve(ISearchable problem) {
        if (problem == null)
            return null;
        Set<AState> visited = new HashSet<>();
        AState start = problem.initial();

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            AState state = (AState) queue.poll();
            numOfEvaluated++;
            List<AState> list = problem.getAllSuccessors(state);

            while (!list.isEmpty()) {
                AState s = list.remove(0);
                if (!visited.contains(s)) {
                    visited.add(s);
                    queue.add(s);
                }
                if (problem.TestGoal(s))
                    return buildSolution(s);
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfEvaluated;
    }
}