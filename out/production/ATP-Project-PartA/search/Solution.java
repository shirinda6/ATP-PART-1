package algorithms.search;

import java.util.ArrayList;

public class Solution {
    private ArrayList<AState> solutionPath;

    public ArrayList<AState> getSolutionPath() {
        return solutionPath;
    }
    public void AddToPath(AState state){ solutionPath.add(state); }
}
