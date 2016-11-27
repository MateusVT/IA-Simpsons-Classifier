/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtratorCoresPredominantes;


import colorespredominantes.BuscadorKMeans;
import colorespredominantes.Punto;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Torres
 */
public class ColorsPredominantes {

    private EscalarImagen escalarImagen;
    private EscalarImagen escalarImagen2;
    public BufferedImage imagen;
    public BufferedImage imagen2;
//    String classe;
    List<Color> colors = new ArrayList<Color>();

    public List<Color> getColors() {
        return colors;
    }

    public void carregarImg(String diretorio) {
        // TODO add your handling code here:

        try {
            imagen = ImageIO.read(this.getClass().getResource(diretorio));
            escalarImagen = new EscalarImagen(imagen);
            escalarImagen.escalar(3);
            obterCores();
        } catch (IOException ex) {
        }
    }

    public void obterCores() {
        // TODO add your handling code here:
//        escalarImagen2 = new EscalarImagen(imagen);
//        imagen2 = escalarImagen2.escalarIm();
//        System.out.println("Width de la imagen original: " + +imagen.getWidth());
//        System.out.println("Width de la imagen renderizada: " + imagen2.getWidth());
//        System.out.println("Height de la imagen original: " + imagen.getHeight());
//        System.out.println("Height de la imagen renderizada: " + imagen2.getWidth());
        List<Punto> puntos = getArrayPixels(imagen);
        List<Punto> centroides = BuscadorKMeans.buscarKCentroides(puntos, 5, .5);
        showColors(centroides);
    }

    public void showColors(List<Punto> centroides) {
        List<Color> colores = new ArrayList<Color>();
        for (Punto p : centroides) {
            Color col = new Color(p.x, p.y, p.z);
            colores.add(col);
        }
        
        colors = colores;
//        System.out.println("Color 1 : "+"["+Math.abs(colores.get(0).getRGB())+"];");
//        System.out.println("Color 1 : "+"["+Math.abs(colores.get(1).getRGB())+"];");
//        System.out.println("Color 1 : "+"["+Math.abs(colores.get(2).getRGB())+"];");
//        System.out.println("Color 1 : "+"["+Math.abs(colores.get(3).getRGB())+"];");
//        System.out.println("Color 1 : "+"["+Math.abs(colores.get(4).getRGB())+"];");
        
//        System.out.println("RGB : "+"["+colores.get(0).getRed()+","+colores.get(0).getGreen()+","+colores.get(0).getBlue()+"];["+colores.get(1).getRed()+","+colores.get(1).getGreen()+","+colores.get(1).getBlue()+"];["+colores.get(2).getRed()+","+colores.get(2).getGreen()+","+colores.get(2).getBlue()+"];["+colores.get(3).getRed()+","+colores.get(3).getGreen()+","+colores.get(3).getBlue()+"];["+colores.get(4).getRed()+","+colores.get(4).getGreen()+","+colores.get(4).getBlue()+"];");
//        System.out.println();
//        System.out.println(colores.get(0).getRed()+","+colores.get(0).getGreen()+","+colores.get(0).getBlue()+";");
//        System.out.println(colores.get(1).getRed()+","+colores.get(1).getGreen()+","+colores.get(1).getBlue()+";");
//        System.out.println(colores.get(2).getRed()+","+colores.get(2).getGreen()+","+colores.get(2).getBlue()+";");
//        System.out.println(colores.get(3).getRed()+","+colores.get(3).getGreen()+","+colores.get(3).getBlue()+";");
//        System.out.println(colores.get(4).getRed()+","+colores.get(4).getGreen()+","+colores.get(4).getBlue()+";");
//        
//        System.out.println(colores.get(0));
//        System.out.println(colores.get(1));
//        System.out.println(colores.get(2));
//        System.out.println(colores.get(3));
//        System.out.println(colores.get(4));
    }
    public boolean pegarInteiros(String s ) {
// cria um array de char
char[] c = s.toCharArray();
boolean d = true;
for ( int i = 0; i < c.length; i++ )
    // verifica se o char não é um dígito
    if ( !Character.isDigit( c[ i ] ) ) {
        d = false;
        break;
    } return d;
 }

    public List<Punto> getArrayPixels(BufferedImage image) {
        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        List<Punto> puntos = new ArrayList<Punto>();
        int pixel;
        int red;
        int green;
        int blue;

        //System.out.println( pixels.length );
        //System.out.println(     image.getRGB(0,0) );
        //int pixel = image.getRGB(0, image.getHeight() );
        //La imagen debemos de redimensionarla a 200 x 200
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                pixel = image.getRGB(i, j);
                red = (pixel >> 16) & 0xFF;
                green = (pixel >> 8) & 0xFF;
                blue = pixel & 0xFF;
                puntos.add(new Punto(red, green, blue));
            }
        }

        return puntos;
    }
    public void saida() throws IOException{
    
     Scanner ler = new Scanner(System.in);
    int i, n;
 
    System.out.printf("Informe o número para a tabuada:\n");
    n = ler.nextInt();
 
    FileWriter arq = new FileWriter("/Data/tabuada.txt");
    PrintWriter gravarArq = new PrintWriter(arq);
 
    gravarArq.printf("+--Resultado--+%n");
    for (i=1; i<=10; i++) {
      gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n));
    }
    gravarArq.printf("+-------------+%n");
 
    arq.close();
 
    System.out.printf("\nTabuada do %d foi gravada com sucesso em \"d:\\tabuada.txt\".\n", n);
  }
    
    
//    public static void main(String[] foo) {
//        ColorsPredominantes m = new ColorsPredominantes();
//        m.carregarImg();
//    }
}
