package ExtratorQtdCores;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Torres
 */
public class ExtratorQtdColors {

    public String ContadorCores(String diretorio) {
        BufferedImage image = null;
        ArrayList<Color> colors = new ArrayList<>();
        try {
            image = ImageIO.read(this.getClass().getResource(diretorio));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        int w = image.getWidth();
        int h = image.getHeight();
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixel = image.getRGB(x, y);
                int red = (pixel & 0x00ff0000) >> 16;
                int green = (pixel & 0x0000ff00) >> 8;
                int blue = pixel & 0x000000ff;
                Color color = new Color(red, green, blue);

                //add the first color on array
                if (colors.isEmpty()) {
                    colors.add(color);
                } //check for redudancy
                else if (!(colors.contains(color))) {
                    colors.add(color);
                }
            }
        }

        return Integer.toString(colors.size());
    }
}
