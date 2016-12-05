package ExtratorCoresPredominantes;

import colorespredominantes.BuscadorKMeans;
import colorespredominantes.Punto;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Torres
 */
public class CoresPredominantes {

//    private Imagem escalarImagem;
//    private Imagem escalarImagem2;
    public BufferedImage imagem;
    public BufferedImage imagem2;
    List<Color> colors = new ArrayList<Color>();
    List<Integer> colorsOrd = new ArrayList<Integer>();

    public List<Color> getColors() {
        return colors;
    }
    
     public void ordenarListColors(){
     for(int i = 0; i < colors.size();i++){
    colorsOrd.add(Math.abs(colors.get(i).getRGB()));
    }     
    Collections.sort(colorsOrd);
    }

    public List<Integer> getColorsOrd() {
        return colorsOrd;
    }
    public void free() {
     colors.clear();
     colorsOrd.clear();
    }
    
    public void carregarImg(String diretorio) {

        try {
            imagem = ImageIO.read(this.getClass().getResource(diretorio));
            obterCores();
        } catch (IOException ex) {
        }
    }


    public void showColors(List<Punto> centroides) {
        List<Color> colores = new ArrayList<Color>();
        for (Punto p : centroides) {
            Color col = new Color(p.x, p.y, p.z);
            colores.add(col);
        }

        colors = colores;
        ordenarListColors();
    }
    
    

    public List<Punto> getArrayPixels(BufferedImage image) {
        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        List<Punto> pontos = new ArrayList<Punto>();
        int pixel;
        int red;
        int green;
        int blue;

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                pixel = image.getRGB(i, j);
                red = (pixel >> 16) & 0xFF;
                green = (pixel >> 8) & 0xFF;
                blue = pixel & 0xFF;
                pontos.add(new Punto(red, green, blue));
            }
        }

        return pontos;
    }
    
    public void obterCores() {
        List<Punto> pontos = getArrayPixels(imagem);
        List<Punto> centroides = BuscadorKMeans.buscarKCentroides(pontos, 5, .5);
        showColors(centroides);
    }

}
