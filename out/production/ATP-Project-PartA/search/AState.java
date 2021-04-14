package algorithms.search;

import java.io.Serializable;

/**
 * represents a state in a problem - with the previous state and the cost
 */
public abstract class AState implements Serializable{
    private AState predecessor;
    private double cost;

    public AState(AState predecessor, double cost) {
        this.predecessor = predecessor;
        this.cost = cost;
    }

    public AState getPredecessor(){
        return predecessor;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public abstract String toString();
}