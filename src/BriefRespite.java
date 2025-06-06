import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BriefRespite
{
    private int[][] briefRespiteRoom;
    private boolean briefRespiteTrigger;
    private boolean talkingToVillager;
    private BufferedImage villagerImage;
    private BufferedImage roomFloorImage;

    public BriefRespite()
    {
        briefRespiteRoom = getBriefRespiteRoom("briefRespiteRoom/BriefRespiteRoom");
        villagerImage = ImageReader.readImage("images/villager.png");
        roomFloorImage = ImageReader.readImage("images/BriefRespiteFloor.jpg");
        talkingToVillager = false;
        briefRespiteTrigger = false;
    }

    public int[][] getBriefRespiteRoom() {
        return briefRespiteRoom;
    }

    public BufferedImage getVillagerImage() {
        return villagerImage;
    }

    public BufferedImage getRoomFloorImage() {
        return roomFloorImage;
    }

    public boolean isBriefRespiteTrigger() {
        return briefRespiteTrigger;
    }

    public void setBriefRespiteTrigger(boolean briefRespiteTrigger) {
        this.briefRespiteTrigger = briefRespiteTrigger;
    }

    private int[][] getBriefRespiteRoom(String fileName) {
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
