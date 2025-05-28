import java.awt.image.BufferedImage;
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
    private BufferedImage mazeWall;
    private BufferedImage mazePath;
    private BufferedImage maze1StarEmpty;
    private BufferedImage maze1StarFill;
    private BufferedImage maze2StarEmpty;
    private BufferedImage maze2StarFill;
    private BufferedImage maze3StarEmpty;
    private BufferedImage maze3StarFill;

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
        mazeWall = ImageReader.readImage("images/StoneBrick.jpg");
        mazePath = ImageReader.readImage("images/Moss_Stone.png");
        maze1StarEmpty = ImageReader.readImage("images/Maze1StarEmpty.png");
        maze1StarFill = ImageReader.readImage("images/Maze1StarFill.png");
        maze2StarEmpty = ImageReader.readImage("images/Maze2StarEmpty.png");
        maze2StarFill = ImageReader.readImage("images/Maze2StarFill.png");
        maze3StarEmpty = ImageReader.readImage("images/Maze3StarEmpty.png");
        maze3StarFill = ImageReader.readImage("images/Maze3StarFill.png");
    }

    public BufferedImage getMazeWall() {
        return mazeWall;
    }

    public BufferedImage getMazePath() {
        return mazePath;
    }

    public BufferedImage getMaze1StarFill() {
        return maze1StarFill;
    }

    public BufferedImage getMaze1StarEmpty() {
        return maze1StarEmpty;
    }

    public BufferedImage getMaze2StarEmpty() {
        return maze2StarEmpty;
    }

    public BufferedImage getMaze2StarFill() {
        return maze2StarFill;
    }

    public BufferedImage getMaze3StarEmpty() {
        return maze3StarEmpty;
    }

    public BufferedImage getMaze3StarFill() {
        return maze3StarFill;
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

    public void setMaze1Win(boolean maze1Win) {
        this.maze1Win = maze1Win;
    }

    public void setMaze2Win(boolean maze2Win) {
        this.maze2Win = maze2Win;
    }

    public void setMaze3Win(boolean maze3Win) {
        this.maze3Win = maze3Win;
    }

    public ArrayList<int[][]> getMazes() {
        return mazes;
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
