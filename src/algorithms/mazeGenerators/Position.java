package algorithms.mazeGenerators;

public class Position {
    private int Row;
    private int Column;

    public Position(int row, int column) {
        Row = row;
        Column = column;
    }

    public int getRowIndex(){
        return Row;
    }

    public int getColumnIndex(){
        return Column;
    }

}
