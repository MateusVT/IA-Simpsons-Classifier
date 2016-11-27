/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtratorQtdPixeis;

import ExtratorBorda.ExtratorBorda;
import ExtratorQtdCores.ExtratorQtdColors;
import ExtratorBorda.Image;
import ExtratorCorPredominante.ColorPredominante;
import ExtratorCoresPredominantes.ColorsPredominantes;
import ExtratorQtdCores.ExtratorQtdColors;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class ExtratorQtdPixeis {

    public int qtdPixeis;

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
//          
        qtdPixeis = (i*j);
//        System.out.println("Qtd Pixel : " + i * j);
//        return Integer.toString(qtdPixeis);
    }

    public String getQtdPixeis() {
        return Integer.toString(qtdPixeis);
    }

    public ExtratorQtdPixeis() {
       
        

//            try {
                // get the BufferedImage, using the ImageIO class      
//                BufferedImage image = ImageIO.read(this.getClass().getResource(diretorio));
//                marchThroughImage(image);
//                System.out.println("Imagem Bart " + i);
//                qtdC.ContadorCores("/Data/Train/bart ("+i+").bmp");
//                color.carregarImg("/Data/Train/bart ("+i+").bmp");
//                Image img = new Image("/Data/Train/bart ("+i+").bmp");
//                shape.setImage(img);
//                System.out.println("Qtd Pixeis Borda : "+ shape.getCharacteristic().toString());
//                predominante.setImage(img);
//                System.out.println("Predominante : "+"["+predominante.getPredominantColor().getRed()+"-"+predominante.getPredominantColor().getGreen()+"-"+predominante.getPredominantColor().getBlue()+"]");
//                System.out.println();
//                
//                System.out.println("Imagem  Lisa" + i);
//                BufferedImage image2 = ImageIO.read(this.getClass().getResource(diretorio));
//                marchThroughImage(image2);
//                qtdC.ContadorCores("/Data/Train/lisa ("+i+").bmp");
//                color.carregarImg("/Data/Train/lisa ("+i+").bmp");
//                Image img2 = new Image("/Data/Train/lisa ("+i+").bmp");
//                shape.setImage(img2);
//                System.out.println("Qtd Pixeis Borda : "+ shape.getCharacteristic().toString());
//                predominante.setImage(img2);
//                System.out.println("Predominante : "+"["+predominante.getPredominantColor().getRed()+"-"+predominante.getPredominantColor().getGreen()+"-"+predominante.getPredominantColor().getBlue()+"]");
//                System.out.println();
//                
//                System.out.println("Imagem  Homer" + i);
//                BufferedImage image3 = ImageIO.read(this.getClass().getResource(diretorio));
//                marchThroughImage(image3);
//                qtdC.ContadorCores("/Data/Train/homer ("+i+").bmp");
//                color.carregarImg("/Data/Train/homer ("+i+").bmp");
//                Image img3 = new Image("/Data/Train/homer ("+i+").bmp");
//                shape.setImage(img3);
//                System.out.println("Qtd Pixeis Borda : "+ shape.getCharacteristic().toString());
//                predominante.setImage(img3);
//                System.out.println("Predominante : "+"["+predominante.getPredominantColor().getRed()+"-"+predominante.getPredominantColor().getGreen()+"-"+predominante.getPredominantColor().getBlue()+"]");

//            } catch (IOException e) {
//                System.err.println(e.getMessage());
//            }
        }
    
    
    public void setImage(String diretorio){
        try {
                BufferedImage image = ImageIO.read(this.getClass().getResource(diretorio));
                percorreImagem(image);

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    
    
    }
    

    
//
//}
