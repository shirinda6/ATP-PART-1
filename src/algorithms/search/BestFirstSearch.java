package algorithms.search;

import java.util.*;

class StComp implements Comparator<AState> {
    @Override
    public int compare(AState st1, AState st2) {
        return Double.compare(st1.getCost(), st2.getCost());
    }
}

public class BestFirstSearch extends BreadthFirstSearch {
    public BestFirstSearch() {
        super();
        queue = new PriorityQueue<>(new StComp());
    }

    @Override
    public String getName() {
        return "BestFirstSearch";
    }
}
