/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtratorCoresEspec;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Torres
 */
public class ExtratorEsp {
    public BufferedImage imagem;
    public void carregarImg(String diretorio) {

        try {
            imagem = ImageIO.read(this.getClass().getResource(diretorio));
        } catch (IOException ex) {
        }
    }
    public int qtdPixelBranco(){
        
                
		int qtdPixelBranco = 0;
                int x,y;
		for (y = 0; y<imagem.getHeight(); y++)
			for (x = 0; x<imagem.getWidth(); x++)
			{
				Color pixel = new Color(imagem.getRGB(x, y));
				if ((pixel.getRed() > 235) && (pixel.getGreen() > 235) && (pixel.getBlue() > 235)){
					qtdPixelBranco++;
                                }
			}
                
                return qtdPixelBranco;
	}
    public int qtdPixelPreto(){
        
                
		int qtdPixelPreto = 0;
                int x,y;
		for (y = 0; y<imagem.getHeight(); y++)
			for (x = 0; x<imagem.getWidth(); x++)
			{
				Color pixel = new Color(imagem.getRGB(x, y));
				if ((pixel.getRed() < 20) && (pixel.getGreen() < 20) && (pixel.getBlue() < 20)){
					qtdPixelPreto++;
                                }
			}              
                
                return qtdPixelPreto;
	}
    public int qtdPixelVermelho(){
        
                
		int qtdPixelVermelho = 0;
                int x,y;
		for (y = 0; y<imagem.getHeight(); y++)
			for (x = 0; x<imagem.getWidth(); x++)
			{
				Color pixel = new Color(imagem.getRGB(x, y));
				if ((pixel.getRed() > 200) && (pixel.getGreen() == 0) && (pixel.getBlue() == 0)){
					qtdPixelVermelho++;
                                }
			}         
                
                return qtdPixelVermelho;
	}
    
    public int qtdPixelLaranja(){
        
                
		int qtdPixelLaranja = 0;
                int x,y;
		for (y = 0; y<imagem.getHeight(); y++)
			for (x = 0; x<imagem.getWidth(); x++)
			{
				Color pixel = new Color(imagem.getRGB(x, y));
				if ((pixel.getRed() > 230) && ((pixel.getGreen() > 76)&&(pixel.getGreen() < 115))&& ((pixel.getBlue() >= 0)&&(pixel.getBlue()<25))){
					qtdPixelLaranja++;
                                }
			}         
                
                return qtdPixelLaranja;
	}
    public int qtdPixelAzulEscuro(){
        
                
		int qtdPixelAzulEscuro = 0;
                int x,y;
		for (y = 0; y<imagem.getHeight(); y++)
			for (x = 0; x<imagem.getWidth(); x++)
			{
				Color pixel = new Color(imagem.getRGB(x, y));
				if ((pixel.getRed() < 10) && ((pixel.getGreen() < 80)&&(pixel.getGreen() > 10)) && ((pixel.getBlue() < 140)&&(pixel.getBlue() > 110))){
					qtdPixelAzulEscuro++;
                                }
			}         
                
                return qtdPixelAzulEscuro;
	}
    public int qtdPixelAzulClaro(){
        
                
		int qtdPixelAzulClaro = 0;
                int x,y;
		for (y = 0; y<imagem.getHeight(); y++)
			for (x = 0; x<imagem.getWidth(); x++)
			{
				Color pixel = new Color(imagem.getRGB(x, y));
				if ((pixel.getRed() < 15) && ((pixel.getGreen() > 150)&&(pixel.getGreen() < 170)) && (pixel.getBlue() > 220)){
					qtdPixelAzulClaro++;
                                }
			}         
                
                return qtdPixelAzulClaro;
	}
    public int qtdPixelMarromClaro(){
        
                
		int qtdPixelMarromClaro = 0;
                int x,y;
		for (y = 0; y<imagem.getHeight(); y++)
			for (x = 0; x<imagem.getWidth(); x++)
			{
				Color pixel = new Color(imagem.getRGB(x, y));
				if (((pixel.getRed() > 180)&&(pixel.getRed() < 210)) && ((pixel.getGreen() > 150)&&(pixel.getGreen() < 180)) && ((pixel.getBlue() > 100)&&(pixel.getBlue() < 130))){
					qtdPixelMarromClaro++;
                                }
			}         
                
                return qtdPixelMarromClaro;
	}
    
}
