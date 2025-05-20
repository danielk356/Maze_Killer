import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
    private int[][] maze1;
    private int[][] maze2;
    private int[][] maze3;
    private boolean maze1Win;
    private boolean maze2Win;
    private boolean maze3Win;
    private ArrayList<int[][]> mazes;

    public Maze() {
        maze1 = getMaze("mazes/Maze1");
        maze2 = getMaze("mazes/Maze2");
        maze3 = getMaze("mazes/Maze3");
        mazes = new ArrayList<>();
        mazes.add(maze1);
        mazes.add(maze2);
        mazes.add(maze3);
        maze1Win = false;
        maze2Win = false;
        maze3Win = false;
    }

    public int[][] getMaze1() {
        return maze1;
    }

    public int[][] getMaze2() {
        return maze2;
    }

    public int[][] getMaze3() {
        return maze3;
    }

    public boolean isMaze1Win() {
        return maze1Win;
    }

    public boolean isMaze2Win() {
        return maze2Win;
    }

    public boolean isMaze3Win() {
        return maze3Win;
    }

    public ArrayList<int[][]> getMazes() {
        return mazes;
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
