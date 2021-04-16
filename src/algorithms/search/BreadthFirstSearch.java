package algorithms.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    public BreadthFirstSearch() {
        super();
    }
    /**
     * solving the problem by breadth first search algorithm
     * @param problem: the problem to solve
     * @return a solution
     */

    public Solution solve(ISearchable problem) {
        if(problem==null)
            return null;
        Set<AState> visited=new HashSet<>();
        AState start=problem.initial();
        Queue<AState> queue=new LinkedList<>();

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            numOfEvaluated++;
            AState current = queue.poll();
            for (AState state : problem.getAllPossibleStates(current)) {
                if (!visited.contains(state)) {
                    if(problem.TestGoal(state)) {
                        return buildSolution(state);
                    }
                    visited.add(state);
                    queue.add(state);
                }
            }
        }
        System.out.println("BFS: cant find solution!!!!!");
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