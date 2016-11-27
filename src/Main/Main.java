/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ExtratorQtdPixeis.ExtratorQtdPixeis;
import ExtratorBorda.ExtratorBorda;
import ExtratorQtdCores.ExtratorQtdColors;
import ExtratorBorda.Image;
import ExtratorCorPredominante.ColorPredominante;
import ExtratorCoresPredominantes.ColorsPredominantes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Torres
 */
public class Main {

    public static void main(String[] foo) throws IOException {
        String diretorio = null;
        FileWriter arquivo;
//        arquivo = new FileWriter(new File("treino.arff"));//78,61,33,30,24
        arquivo = new FileWriter(new File("verific.arff"));//35,25,13,12,10
        int i;
        //Treino
//        int bart=78;
//        int homer=61;
//        int lisa=33;
//        int maggie=30;
//        int marge=24;
        //
        //Test
//        int bart=35;
//        int homer=25;
//        int lisa=13;
//        int maggie=12;
//        int marge=10;
        //
        //Aux
        int bart=1;
        int homer=1;
        int lisa=1;
        int maggie=1;
        int marge=1;
        //
        
        Main main = new Main();
        ColorsPredominantes colors = new ColorsPredominantes();
        ExtratorBorda shape = new ExtratorBorda();
        ColorPredominante colorP = new ColorPredominante();
        ExtratorQtdColors qtdC = new ExtratorQtdColors();
        ExtratorQtdPixeis test = new ExtratorQtdPixeis();
        arquivo.write("@relation Simpsons\n");
        arquivo.write("@attribute qtdPixel numeric\n");
        arquivo.write("@attribute qtdColors numeric\n");
        arquivo.write("@attribute qtdPixeisBorda numeric\n");
        arquivo.write("@attribute corPredominante {247.99.16,0.8.132,189.173.107,0.107.173,255.0.0,0.156.222,0.66.132,149.189.30}\n");
        arquivo.write("@attribute color1 numeric\n");
        arquivo.write("@attribute color2 numeric\n");
        arquivo.write("@attribute color3 numeric\n");
        arquivo.write("@attribute color4 numeric\n");
        arquivo.write("@attribute color5 numeric\n");
        arquivo.write("@attribute class {Bart,Lisa,Marge,Maggie,Homer}\n");
        arquivo.write("@data\n\n");

        for (i = 1; i <= bart; i++) {
            System.out.println("Bart " + i);
//            diretorio = "/Data/Train/bart (" + i + ").bmp";
            diretorio = "/Data/Valid/bart (" + i + ").bmp";
            Image img = new Image(diretorio);
            test.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);

            arquivo.write(test.getQtdPixeis() + "," //qtdPieis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "." + //Cor Predominante
                    + colorP.getPredominantColor().getGreen()+ "." + //Cor Predominante
                    + colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + Integer.toString(Math.abs(colors.getColors().get(0).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(1).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(2).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(3).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(4).getRGB())) + "," //Rank 5 Cores Predominantes
                    + "Bart");
            arquivo.write("\r\n");
        }
        
        for (i = 1; i <= homer; i++) {
            System.out.println("Homer " + i);
//            diretorio = "/Data/Train/homer (" + i + ").bmp";
            diretorio = "/Data/Valid/homer (" + i + ").bmp";
            Image img = new Image(diretorio);
            test.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);

            
            arquivo.write(test.getQtdPixeis() + "," //qtdPieis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "." +//Cor Predominante
                    + colorP.getPredominantColor().getGreen()+ "." + //Cor Predominante
                    + colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + Integer.toString(Math.abs(colors.getColors().get(0).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(1).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(2).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(3).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(4).getRGB())) + "," //Rank 5 Cores Predominantes
                    + "Homer");
            arquivo.write("\r\n");
        }
        
        for (i = 1; i <= lisa; i++) {
            System.out.println("Lisa " + i);
//            diretorio = "/Data/Train/lisa (" + i + ").bmp";
            diretorio = "/Data/Valid/lisa (" + i + ").bmp";
            Image img = new Image(diretorio);
            test.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);

            arquivo.write(test.getQtdPixeis() + "," //qtdPieis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed()+ "." + //Cor Predominante
                    + colorP.getPredominantColor().getGreen()+ "." + //Cor Predominante
                    + colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + Integer.toString(Math.abs(colors.getColors().get(0).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(1).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(2).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(3).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(4).getRGB())) + "," //Rank 5 Cores Predominantes
                    + "Lisa");
            arquivo.write("\r\n");
        }
        
        for (i = 1; i <= maggie; i++) {
            System.out.println("Maggie " + i);
//            diretorio = "/Data/Train/maggie (" + i + ").bmp";
            diretorio = "/Data/Valid/maggie (" + i + ").bmp";
            Image img = new Image(diretorio);
            test.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);

            arquivo.write(test.getQtdPixeis() + "," //qtdPieis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "." +//Cor Predominante
                    + colorP.getPredominantColor().getGreen()+ "." + //Cor Predominante
                    + colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + Integer.toString(Math.abs(colors.getColors().get(0).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(1).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(2).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(3).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(4).getRGB())) + "," //Rank 5 Cores Predominantes 
                    + "Maggie");
            arquivo.write("\r\n");
        }
        
        for (i = 1; i <= marge; i++) {
            System.out.println("Marge " + i);
//            diretorio = "/Data/Train/marge (" + i + ").bmp";
            diretorio = "/Data/Valid/marge (" + i + ").bmp";
            Image img = new Image(diretorio);
            test.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);

            arquivo.write(test.getQtdPixeis() + "," //qtdPieis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "." +//Cor Predominante
                    + colorP.getPredominantColor().getGreen() + "." +//Cor Predominante
                    + colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + Integer.toString(Math.abs(colors.getColors().get(0).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(1).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(2).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(3).getRGB())) + "," //Rank 5 Cores Predominantes
                    + Integer.toString(Math.abs(colors.getColors().get(4).getRGB())) + "," //Rank 5 Cores Predominantes
                    + "Marge");
            arquivo.write("\r\n");
        }
//        
        arquivo.close();

    }

}
