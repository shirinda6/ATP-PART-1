package algorithms.mazeGenerators.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    private Position current_pos;

    public MazeState(AState predecessor, double cost, Position position) {
        super(predecessor, cost);
        current_pos=position;
    }
    
    public Position getCurrent_pos() {
        return current_pos;
    }

    @Override
    public String toString() {
        return null;
    }
}
