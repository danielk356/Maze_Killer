import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalTrial
{
    private int[][] finalTrialRoom;
    private boolean finalTrialWin;
    private boolean finalTrialTrigger;

    public FinalTrial()
    {
        finalTrialRoom = getFinalTrialRoom("finalTrialRoom/FinalTrialRoom");
        finalTrialWin = false;
        finalTrialTrigger = false;
    }

    public int[][] getFinalTrialRoom() {
        return finalTrialRoom;
    }

    public boolean isFinalTrialWin() {
        return finalTrialWin;
    }

    public boolean isFinalTrialTrigger() {
        return finalTrialTrigger;
    }

    public void setFinalTrialWin(boolean finalTrialWin)
    {
        this.finalTrialWin = finalTrialWin;
    }

    public void setFinalTrialTrigger(boolean finalTrialTrigger) {
        this.finalTrialTrigger = finalTrialTrigger;
    }

    private int[][] getFinalTrialRoom(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        int[][] room = new int[15][20];
        for (int row = 0; row < room.length; row++) {
            if (s.hasNextLine()) {
                String[] rowString = s.nextLine().split(",");
                int[] rowInt = new int[rowString.length];
                for (int i = 0; i < rowInt.length; i++) {
                    rowInt[i] = Integer.parseInt(rowString[i]);
                }
                room[row] = rowInt;
            }
        }
        return room;
    }
}
