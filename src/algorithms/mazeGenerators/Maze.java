package algorithms.mazeGenerators;

import java.util.Random;

public class Maze {
    /**
     * represents a maze : by 2-dimensional array
     */
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
        this.getM()[goal.getRowIndex()][goal.getColumnIndex()]=0;
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
        Position statP = getStartPosition();
        Position goalP = getGoalPosition();

        for (int i = 0; i < getM().length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < getM()[0].length; j++) {
                if (statP.getRowIndex() == i && statP.getColumnIndex() == j)
                    System.out.print("S ");
                else if (goalP.getRowIndex()  == i && goalP.getColumnIndex() == j)
                    System.out.print("E ");
                else
                    System.out.print(getM()[i][j]+ " ");
            }
            System.out.println("}");
        }
    }
    public Maze fillMaze() {
        //fill the maze with value 1 : Turns all the cells into walls
        for (int i = 0; i < getM().length ; i++) {
            for (int j = 0; j < getM()[0].length ; j++) {
                getM()[i][j] = 1;
            }
        }
        return this;
    }

    public void randomGoal(Maze m,int row,int column){
        //pick up a random cell for a goal
        Random r = new Random();
        int x = r.nextInt(3);
        if(x == 0){
            m.setGoal(new Position(r.nextInt(row-1),column-1));
        }
        else if(x == 1){
            m.setGoal(new Position(r.nextInt(row-1)+1,0));
        }
        else {
            m.setGoal(new Position(row-1,r.nextInt(column-1)));
        }

    }


}
