/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtratorBorda;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Image {

    private final Color[][] colors;

    public Image(String diretorio) {
        try {
//            BufferedImage bufferedImage = ImageIO.read(inputStream);
            BufferedImage bufferedImage = ImageIO.read(this.getClass().getResource(diretorio));
            colors = new Color[bufferedImage.getWidth()][bufferedImage.getHeight()];
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    Color c = new Color(bufferedImage.getRGB(x, y));
                    this.colors[x][y] = c;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Falha ao ler imagem");
        }
    }

    public Color[][] getColors() {
        return colors;
    }

}
