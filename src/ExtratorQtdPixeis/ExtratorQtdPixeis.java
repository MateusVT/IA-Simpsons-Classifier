/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtratorQtdPixeis;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ExtratorQtdPixeis {

    public int qtdPixeis;

    public ExtratorQtdPixeis() {

    }

    public void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;

//    System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }

    private void percorreImagem(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
//    System.out.println("width, height: " + w + ", " + h);
        int i, j = 0;
        for (i = 0; i < h; i++) {
            for (j = 0; j < w; j++) {
//        System.out.println("x,y: " + j + ", " + i);
                int pixel = image.getRGB(j, i);
                printPixelARGB(pixel);
//        System.out.println("");
            }
        }
        qtdPixeis = (i * j);
    }

    public String getQtdPixeis() {
        return Integer.toString(qtdPixeis);
    }

    public void setImage(String diretorio) {
        try {
            BufferedImage image = ImageIO.read(this.getClass().getResource(diretorio));
            percorreImagem(image);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
