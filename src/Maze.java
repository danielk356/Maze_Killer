import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
    private int[][] maze1;
    private ArrayList<int[][]> mazes;

    public Maze() {
        maze1 = getMaze("mazes/Maze1");
    }

    public int[][] getMaze1() {
        return maze1;
    }

    // testing if getMaze works
    public void printMaze() {
        for (int[] row : maze1) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // get the maze from files
    private int[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        int[][] maze = new int[15][20];
        for (int row = 0; row < maze.length; row++) {
            if (s.hasNextLine()) {
                String[] rowString = s.nextLine().split(",");
                int[] rowInt = new int[rowString.length];
                for (int i = 0; i < rowInt.length; i++) {
                    rowInt[i] = Integer.parseInt(rowString[i]);
                }
                maze[row] = rowInt;
            }
        }
        return maze;
    }

}
