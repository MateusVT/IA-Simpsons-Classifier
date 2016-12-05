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

    private void percorreImagem(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        int i, j = 0;
        qtdPixeis = (w * h);
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
