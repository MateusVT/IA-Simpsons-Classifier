/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import ExtratorQtdPixeis.ExtratorQtdPixeis;
import ExtratorBorda.ExtratorBorda;
import ExtratorQtdCores.ExtratorQtdColors;
import ExtratorCoresEspec.ExtratorEsp;
import ExtratorBorda.Image;
import ExtratorCorPredominante.CorPredominante;
import ExtratorCoresPredominantes.CoresPredominantes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Torres
 */
public class Main {

    public static void main(String[] foo) throws IOException {

        System.out.println("Escolha a opção : ");
        System.out.println("1 - Gerar arquivo de treino");
        System.out.println("2 - Gerar arquivo de teste");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        String diretorio = null;
        int bart = 1;
        int homer = 1;
        int lisa = 1;
        int maggie = 1;
        int marge = 1;
        FileWriter arquivo;
        arquivo = new FileWriter(new File("amostra.arff"));
        if (op == 1) {
            arquivo = new FileWriter(new File("TREINO.arff"));//78,61,33,30,24
            bart = 78;
            homer = 61;
            lisa = 33;
            maggie = 30;
            marge = 24;
        }

        if (op == 2) {
            arquivo = new FileWriter(new File("TESTE.arff"));//35,25,13,12,10
            bart = 35;
            homer = 25;
            lisa = 13;
            maggie = 12;
            marge = 10;
        }
        int i;
        CoresPredominantes colors = new CoresPredominantes();
        ExtratorBorda shape = new ExtratorBorda();
        CorPredominante colorP = new CorPredominante();
        ExtratorQtdColors qtdC = new ExtratorQtdColors();
        ExtratorQtdPixeis qtdPix = new ExtratorQtdPixeis();
        ExtratorEsp qtdEsp = new ExtratorEsp();

        arquivo.write("@relation Simpsons\n");
        arquivo.write("@attribute qtdPixel numeric\n");
        arquivo.write("@attribute qtdColors numeric\n");
        arquivo.write("@attribute qtdPixeisBorda numeric\n");
        arquivo.write("@attribute corPredominante {247.99.16,0.8.132,189.173.107,0.107.173,255.0.0,0.156.222,0.66.132,149.189.30,0.189.0,82.140.24,8.165.255}\n");
        arquivo.write("@attribute color1 numeric\n");
        arquivo.write("@attribute color2 numeric\n");
        arquivo.write("@attribute color3 numeric\n");
        arquivo.write("@attribute color4 numeric\n");
        arquivo.write("@attribute color5 numeric\n");
        arquivo.write("@attribute qtdBranco numeric\n");
        arquivo.write("@attribute qtdPreto numeric\n");
        arquivo.write("@attribute qtdVermelho numeric\n");
        arquivo.write("@attribute qtdLaranja numeric\n");
        arquivo.write("@attribute qtdAzulEscuro numeric\n");
        arquivo.write("@attribute qtdAzulClaro numeric\n");
        arquivo.write("@attribute qtdMarromClaro numeric\n");
        arquivo.write("@attribute class {Bart,Lisa,Marge,Maggie,Homer}\n");
        arquivo.write("@data\n\n");

        for (i = 1; i <= bart; i++) {
            System.out.println("Bart " + i);
            diretorio = "/Data/Train/bart (" + i + ").bmp";
            if (op == 2) {
                diretorio = "/Data/Valid/bart (" + i + ").bmp";
            }
            Image img = new Image(diretorio);
            qtdPix.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);
            qtdEsp.carregarImg(diretorio);

            arquivo.write(qtdPix.getQtdPixeis() + "," //qtdPixeis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "."
                    + //Cor Predominante
                    +colorP.getPredominantColor().getGreen() + "."
                    + //Cor Predominante
                    +colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + colors.getColorsOrd().get(0).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(1).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(2).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(3).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(4).toString() + "," //Rank 5 Cores Predominantes
                    + qtdEsp.qtdPixelBranco() + "," //Qtd Pixeis Brancos
                    + qtdEsp.qtdPixelPreto() + "," //Qtd Pixeis Pretos
                    + qtdEsp.qtdPixelVermelho() + "," //Qtd Pixeis Vermelhos
                    + qtdEsp.qtdPixelLaranja() + "," //Qtd Pixeis Laranja
                    + qtdEsp.qtdPixelAzulEscuro() + "," //Qtd Pixeis Azul Escuro
                    + qtdEsp.qtdPixelAzulClaro() + "," //Qtd Pixeis Azul Claro
                    + qtdEsp.qtdPixelMarromClaro() + "," //Qtd Pixeis Marrom Claro
                    + "Bart");
            arquivo.write("\r\n");

            colors.free();
        }

        for (i = 1; i <= homer; i++) {
            System.out.println("Homer " + i);
            diretorio = "/Data/Train/homer (" + i + ").bmp";
            if (op == 2) {
                diretorio = "/Data/Valid/homer (" + i + ").bmp";
            }
            Image img = new Image(diretorio);
            qtdPix.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);
            qtdEsp.carregarImg(diretorio);

            arquivo.write(qtdPix.getQtdPixeis() + "," //qtdPixeis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "."
                    +//Cor Predominante
                    +colorP.getPredominantColor().getGreen() + "."
                    + //Cor Predominante
                    +colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + colors.getColorsOrd().get(0).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(1).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(2).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(3).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(4).toString() + "," //Rank 5 Cores Predominantes
                    + qtdEsp.qtdPixelBranco() + "," //Qtd Pixeis Brancos
                    + qtdEsp.qtdPixelPreto() + "," //Qtd Pixeis Pretos
                    + qtdEsp.qtdPixelVermelho() + "," //Qtd Pixeis Vermelhos
                    + qtdEsp.qtdPixelLaranja() + "," //Qtd Pixeis Laranja
                    + qtdEsp.qtdPixelAzulEscuro() + "," //Qtd Pixeis Azul Escuro
                    + qtdEsp.qtdPixelAzulClaro() + "," //Qtd Pixeis Azul Claro
                    + qtdEsp.qtdPixelMarromClaro() + "," //Qtd Pixeis Marrom Claro
                    + "Homer");
            arquivo.write("\r\n");

            colors.free();
        }

        for (i = 1; i <= lisa; i++) {
            System.out.println("Lisa " + i);
            diretorio = "/Data/Train/lisa (" + i + ").bmp";
            if (op == 2) {
                diretorio = "/Data/Valid/lisa (" + i + ").bmp";
            }
            Image img = new Image(diretorio);
            qtdPix.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);
            qtdEsp.carregarImg(diretorio);

            arquivo.write(qtdPix.getQtdPixeis() + "," //qtdPixeis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "."
                    + //Cor Predominante
                    +colorP.getPredominantColor().getGreen() + "."
                    + //Cor Predominante
                    +colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + colors.getColorsOrd().get(0).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(1).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(2).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(3).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(4).toString() + "," //Rank 5 Cores Predominantes
                    + qtdEsp.qtdPixelBranco() + "," //Qtd Pixeis Brancos
                    + qtdEsp.qtdPixelPreto() + "," //Qtd Pixeis Pretos
                    + qtdEsp.qtdPixelVermelho() + "," //Qtd Pixeis Vermelhos
                    + qtdEsp.qtdPixelLaranja() + "," //Qtd Pixeis Laranja
                    + qtdEsp.qtdPixelAzulEscuro() + "," //Qtd Pixeis Azul Escuro
                    + qtdEsp.qtdPixelAzulClaro() + "," //Qtd Pixeis Azul Claro
                    + qtdEsp.qtdPixelMarromClaro() + "," //Qtd Pixeis Marrom Claro
                    + "Lisa");
            arquivo.write("\r\n");

            colors.free();
        }

        for (i = 1; i <= maggie; i++) {
            System.out.println("Maggie " + i);
            diretorio = "/Data/Train/maggie (" + i + ").bmp";
            if (op == 2) {
                diretorio = "/Data/Valid/maggie (" + i + ").bmp";
            }
            Image img = new Image(diretorio);
            qtdPix.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);
            qtdEsp.carregarImg(diretorio);

            arquivo.write(qtdPix.getQtdPixeis() + "," //qtdPixeis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "."
                    +//Cor Predominante
                    +colorP.getPredominantColor().getGreen() + "."
                    + //Cor Predominante
                    +colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + colors.getColorsOrd().get(0).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(1).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(2).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(3).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(4).toString() + "," //Rank 5 Cores Predominantes
                    + qtdEsp.qtdPixelBranco() + "," //Qtd Pixeis Brancos
                    + qtdEsp.qtdPixelPreto() + "," //Qtd Pixeis Pretos
                    + qtdEsp.qtdPixelVermelho() + "," //Qtd Pixeis Vermelhos
                    + qtdEsp.qtdPixelLaranja() + "," //Qtd Pixeis Laranja
                    + qtdEsp.qtdPixelAzulEscuro() + "," //Qtd Pixeis Azul Escuro
                    + qtdEsp.qtdPixelAzulClaro() + "," //Qtd Pixeis Azul Claro
                    + qtdEsp.qtdPixelMarromClaro() + "," //Qtd Pixeis Marrom Claro
                    + "Maggie");

            arquivo.write("\r\n");

            colors.free();
        }

        for (i = 1; i <= marge; i++) {
            System.out.println("Marge " + i);
            diretorio = "/Data/Train/marge (" + i + ").bmp";
            if (op == 2) {
                diretorio = "/Data/Valid/marge (" + i + ").bmp";
            }
            Image img = new Image(diretorio);
            qtdPix.setImage(diretorio);
            shape.setImage(img);
            colorP.setImage(img);
            colors.carregarImg(diretorio);
            qtdEsp.carregarImg(diretorio);

            arquivo.write(qtdPix.getQtdPixeis() + "," //qtdPixeis
                    + qtdC.ContadorCores(diretorio) + "," //qtdCores
                    + shape.getCharacteristic().toString() + "," //qtdPixelBorda
                    + colorP.getPredominantColor().getRed() + "."
                    +//Cor Predominante
                    +colorP.getPredominantColor().getGreen() + "."
                    +//Cor Predominante
                    +colorP.getPredominantColor().getBlue() + "," //Cor Predominante
                    + colors.getColorsOrd().get(0).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(1).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(2).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(3).toString() + "," //Rank 5 Cores Predominantes
                    + colors.getColorsOrd().get(4).toString() + "," //Rank 5 Cores Predominantes
                    + qtdEsp.qtdPixelBranco() + "," //Qtd Pixeis Brancos
                    + qtdEsp.qtdPixelPreto() + "," //Qtd Pixeis Pretos
                    + qtdEsp.qtdPixelVermelho() + "," //Qtd Pixeis Vermelhos  
                    + qtdEsp.qtdPixelLaranja() + "," //Qtd Pixeis Laranja
                    + qtdEsp.qtdPixelAzulEscuro() + "," //Qtd Pixeis Azul Escuro
                    + qtdEsp.qtdPixelAzulClaro() + "," //Qtd Pixeis Azul Claro
                    + qtdEsp.qtdPixelMarromClaro() + "," //Qtd Pixeis Marrom Claro
                    + "Marge");
            arquivo.write("\r\n");

            colors.free();
        }

        arquivo.close();

    }

}
