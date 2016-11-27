/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package colorespredominantes

public class GeneradorPuntos {
    
    public static List<Punto> generarPuntos(int n, 
        int minx, int miny, int minz,
        int maxx, int maxy, int maxz) {
        
        Random rnd = new Random()
        return (1..n).collect{
            def xr = (int) minx + rnd.nextDouble() * (maxx - minx)
            def yr = (int) miny + rnd.nextDouble() * (maxy - miny)
            def zr = (int) minz + rnd.nextDouble() * (maxz - minz)
            return new Punto(xr, yr, zr)
        }
    }
}

