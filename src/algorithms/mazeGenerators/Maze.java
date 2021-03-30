package algorithms.mazeGenerators;

import java.lang.reflect.Array;

public class Maze {
    private Position start;
    private Position goal;
    private int [][]maze;

    public Maze(int row,int column ) {
        this.maze= new int[row][column];
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public void setGoal(Position goal) {
        this.goal = goal;
    }

    public Position getStartPosition(){
        return start;
    }

    public Position getGoalPosition(){
        return goal;
    }

    public int[][] getM() {
        return maze ;
    }

    public void print() {
        Position p1 = getStartPosition();
        Position p2 = getGoalPosition();

        for (int i = 0; i < getM().length; i++) {
            for (int j = 0; j < getM()[0].length; j++) {
                if (p1.getRowIndex() == i && p1.getColumnIndex() == j)
                    System.out.print("S");
                else if (p2.getRowIndex() - 1 == i && p2.getColumnIndex() - 1 == j)
                    System.out.print("E");
                else
                    System.out.print(getM()[i][j]);
            }
            System.out.println();
        }
    }

}
