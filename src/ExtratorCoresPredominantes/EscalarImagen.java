/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtratorCoresPredominantes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Fernando
 */
public class EscalarImagen extends JPanel {
    
    private Image FOTO_ORIGINAL;
    private Image FOTO_tmp;
    private BufferedImage Imagen_en_memoria;
    private Graphics2D g2D;
    private boolean con_foto = false;   
    
    private int valEscalaX=0;
    private int valEscalaY=0;
    
    public EscalarImagen(BufferedImage f){
        this.FOTO_ORIGINAL = f;
        this.FOTO_tmp = f;
        this.setSize(f.getWidth(),f.getHeight());
        this.setVisible(true);
        this.con_foto=true;
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        if(this.con_foto){
            Imagen_en_memoria = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
            g2D = Imagen_en_memoria.createGraphics();
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //se añade la foto
            g2D.drawImage(FOTO_tmp,0, 0, FOTO_tmp.getWidth(this), FOTO_tmp.getHeight(this), this);
            g2.drawImage(Imagen_en_memoria, 0, 0, this);            
      }
    }
    public void escalar(int valor){
        valEscalaX =  (int) (FOTO_tmp.getWidth(this) * escalaImage(valor) );
        valEscalaY =  (int) (FOTO_tmp.getHeight(this) * escalaImage(valor) );
        this.FOTO_tmp = FOTO_tmp.getScaledInstance((int) (FOTO_tmp.getWidth(this) - valEscalaX), (int) (FOTO_tmp.getHeight(this) - valEscalaY), Image.SCALE_AREA_AVERAGING);
        resize();
    }
    
    public BufferedImage escalarIm(){
        valEscalaX =  (int) (FOTO_tmp.getWidth(this) * escalaImage(9) );
        valEscalaY =  (int) (FOTO_tmp.getHeight(this) * escalaImage(9) );
        this.FOTO_tmp = FOTO_tmp.getScaledInstance((int) (FOTO_tmp.getWidth(this) - valEscalaX), (int) (FOTO_tmp.getHeight(this) - valEscalaY), Image.SCALE_AREA_AVERAGING);
        resize();
        BufferedImage bi = new BufferedImage(FOTO_tmp.getWidth(null), FOTO_tmp.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(FOTO_tmp, 0, 0, null);
        bg.dispose();
        return bi;
    }    

    private float escalaImage(int v){
        return  v/10f;
    }
    
    private void resize(){
        this.setSize(FOTO_tmp.getWidth(this),FOTO_tmp.getHeight(this));
    }
}
