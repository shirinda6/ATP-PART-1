package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int numOfEvaluated;

    protected Solution buildSolution(AState state){
        Solution solution = new Solution();
        while (state.getPredecessor()!=null){
            solution.AddToPath(state);
            state=state.getPredecessor();
        }
        return solution;
    }
}
