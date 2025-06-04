import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalTrial
{
    private int[][] finalTrialRoom;
    private boolean finalTrialWin;

    public FinalTrial()
    {
        finalTrialWin = false;
    }

    public int[][] getFinalTrialRoom() {
        return finalTrialRoom;
    }

    public boolean isFinalTrialWin() {
        return finalTrialWin;
    }
}
