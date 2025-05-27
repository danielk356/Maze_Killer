import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {

    public static BufferedImage readImage(String file) {
        try {
            BufferedImage image;
            image = ImageIO.read(new File(file));
            return image;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }


}
