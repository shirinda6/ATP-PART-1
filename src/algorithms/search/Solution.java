package algorithms.search;

import java.util.ArrayList;

/**
 *  common class for solving problems.
 *  used for calculating path which presenting the solution.
 */

public class Solution {
    private ArrayList<AState> solutionPath;

    public Solution() {
        this.solutionPath = new ArrayList<>();
    }

    public ArrayList<AState> getSolutionPath() {
        return solutionPath;
    }

    public void AddToPath(AState state){ solutionPath.add(0,state); }
}
