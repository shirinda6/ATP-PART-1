package algorithms.search;

import java.util.*;

public class BestFirstSearch extends ASearchingAlgorithm {

    @Override
    public String getName() {
        String name = "BestFirstSearch";
        return name;
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
        Queue<AState> queue=new PriorityQueue<>((AState s1, AState s2)->{return (int)(s1.getCost()-s2.getCost());});

        queue.add(start);
        AState state;
        
        while (!queue.isEmpty()){
            numOfEvaluated++;
            state=queue.remove();
            visited.add(state);




        }
        return null;
    }

    @Override
    protected Solution buildSolution(AState state) {
        Solution solution = new Solution();



        return super.buildSolution(state);
    }
}