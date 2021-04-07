package algorithms.search;


import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState{
    private Position position;

    public MazeState( Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeState mazeState = (MazeState) o;
        return Objects.equals(position, mazeState.position);
    }
    public Object getState() {
        return position;
    }



    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
