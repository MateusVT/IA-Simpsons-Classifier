package ExtratorBorda;
import java.awt.Color;

public class ExtratorBorda {

    Image image;

    public Integer[][] getContorno() {
        Color[][] imageColors = image.getColors();
        Integer[][] imageString = new Integer[imageColors.length][];
        int cont = 0;
        for (int i = 0; i < imageColors.    length; i++) {
            imageString[i] = new Integer[imageColors[i].length];
            for (int j = 0; j < imageColors[i].length; j++) {
                if (imageColors[i][j].getRGB() != -1) {
                    if (hasNeightbor(imageColors, i, j)) {
                        imageString[i][j] = 1;
                        cont++;
                    }
                }
            }
        }
        return imageString;
    }

    public Boolean hasNeightbor(Color[][] imageColors, int i, int j) {

        if (j > 0 && imageColors[i][j - 1] != null && imageColors[i][j - 1].getRGB() == -1) {
            return true;
        } else if (imageColors[i].length < (j + 1) && imageColors[i][j + 1] != null && imageColors[i][j + 1].getRGB() == -1) {
            return true;
        } else if (i > 0 && imageColors[i - 1][j] != null && imageColors[i - 1][j].getRGB() == -1) {
            return true;
        } else if (imageColors.length < (i + 1) && imageColors[i + 1][j] != null && imageColors[i + 1][j].getRGB() == -1) {
            return true;
        }
        return false;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getPerimetro() {
        int perimetro = 0;
        for (Integer[] integers : getContorno()) {
            for (Integer aInteger : integers) {
                if (aInteger != null && aInteger == 1) {
                    perimetro++;
                }
            }
        }
        return perimetro;
    }

    public Integer getCharacteristic() {
        return getPerimetro();
    }

}
