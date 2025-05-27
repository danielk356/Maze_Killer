import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private int xCoordinate;
    private int yCoordinate;
    private BufferedImage image;

    public Player() {
        xCoordinate = 0;
        yCoordinate = 0;
        image = ImageReader.readImage("images/Player.jpg");
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
