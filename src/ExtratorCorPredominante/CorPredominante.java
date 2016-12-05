package ExtratorCorPredominante;

import ExtratorBorda.Image;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class CorPredominante {

    Image image;
    int bartShirt;
    int bartHoddie;
    int bartShortsAndShoes;
    int bartSkate;
    int homerBeard;
    int homerPants;
    int lisaDress;
    int maggiePijamas;
    int maggiePijamas2;
    int margeHair;
    int margeDress;

    public void setImage(Image image) {
        this.image = image;
        this.bartShirt = 0;
        this.bartHoddie = 0;
        this.bartShortsAndShoes = 0;
        this.bartSkate = 0;
        this.homerBeard = 0;
        this.homerPants = 0;
        this.lisaDress = 0;
        this.maggiePijamas = 0;
        this.maggiePijamas2 = 0;
        this.margeHair = 0;
        this.margeDress = 0;
    }

    private int normalizeCharacteristic(int characteristic) {
        return characteristic / (image.getColors().length * image.getColors()[0].length);
    }

    public Color getPredominantColor() {
        if (image == null) {
            throw new RuntimeException("Error!");
        }

        Integer quantity;
        HashMap<Color, Integer> colorHasCounter = new HashMap<>();

        colorHasCounter.put(new Color(247, 99, 16), 0);//camiseta laranja do Bart
        colorHasCounter.put(new Color(0, 189, 0), 0);//moletom verde do Bart
        colorHasCounter.put(new Color(0, 8, 132), 0);//shorts do Bart
        colorHasCounter.put(new Color(82, 140, 24), 0);//skate do Bart

        colorHasCounter.put(new Color(189, 173, 107), 0);//rosto Homer
        colorHasCounter.put(new Color(0, 107, 173), 0);//calça do Homer

        colorHasCounter.put(new Color(255, 0, 0), 0);//vestido da Lisa

        colorHasCounter.put(new Color(0, 156, 222), 0);//vestido da Maggie
        colorHasCounter.put(new Color(8, 165, 255), 0);//vestido da Maggie2

        colorHasCounter.put(new Color(0, 66, 132), 0);//cabelo da Marge
        colorHasCounter.put(new Color(149, 189, 30), 0);//vestido da Marge

        for (Color[] line : image.getColors()) {
            for (Color color : line) {
                for (Map.Entry<Color, Integer> entry : colorHasCounter.entrySet()) {
                    if (compare(entry.getKey(), color) == 0) {
                        quantity = colorHasCounter.get(color);
                        if (quantity != null) {
                            quantity++;
                            colorHasCounter.put(color, quantity);
                        }
                    }
                }
            }
        }
        Map.Entry<Color, Integer> predominantColor = colorHasCounter.entrySet().iterator().next();
        for (Map.Entry<Color, Integer> entry : colorHasCounter.entrySet()) {
            if (entry.getValue() > predominantColor.getValue()) {
                predominantColor = entry;
            }
        }

        return predominantColor.getKey();
    }

    private int compare(Color gave, Color expected) {
        int tolerance = 20;
        Color base = new Color(expected.getRGB() - tolerance);
        Color topo = new Color(expected.getRGB() + tolerance);
        if (gave.getRGB() < base.getRGB()) {
            return -1;
        } else if (gave.getRGB() > topo.getRGB()) {
            return 1;
        } else {
            return 0;
        }
    }

}
