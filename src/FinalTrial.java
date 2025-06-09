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
}
