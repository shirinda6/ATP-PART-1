package Server;

import IO.MyCompressorOutputStream;
import IO.SimpleCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy{
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(outToClient);
            ObjectInputStream fromServer = new ObjectInputStream(inFromClient);
            int[] dim = (int[]) fromServer.readObject();
            MyMazeGenerator generator = new MyMazeGenerator();
            Maze maze = generator.generate(dim[0], dim[1]);
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            MyCompressorOutputStream compressorOutputStream = new MyCompressorOutputStream(byteOut);
            byte[] compressed = maze.toByteArray();
            compressorOutputStream.write(compressed);
            out.writeObject(byteOut.toByteArray());
        }
        catch (IOException e) {
            //e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }
}
