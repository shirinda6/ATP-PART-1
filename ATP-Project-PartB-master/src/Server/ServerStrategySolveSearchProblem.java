package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.*;
import java.io.*;

public class ServerStrategySolveSearchProblem implements IServerStrategy {
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException {
        try {
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            ObjectInputStream fromServer = new ObjectInputStream(inFromClient);

            Maze maze = (Maze) fromServer.readObject();
            SearchableMaze searchableMaze = new SearchableMaze(maze);
            ISearchingAlgorithm searcher = new BreadthFirstSearch();
            Solution solution = searcher.solve(searchableMaze);
            toClient.writeObject(solution);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
