package algorithms.mazeGenerators.search;

public interface ISearchingAlgorithm {
    Solution solve(ISearchable problem);
    int getNumberOfNodesEvaluated();
    String getName();
}
