/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package colorespredominantes

class BuscadorKMeans {

    public static double distancia(Punto a, Punto b) {
        return Math.sqrt((a.x - b.x)**2 + (a.y - b.y)**2 + (a.z - b.z) ** 2 )
    }
    
    public static Punto calcularCentroide(List<Punto> puntos) {
        double cx = 0
        double cy = 0
        double cz = 0
        puntos.each{ p->
            cx += p.x
            cy += p.y
            cz += p.z
        }
        cx /= puntos.size()
        cy /= puntos.size()
        cz /= puntos.size()
        return new Punto(cx, cy, cz)
    }
    
    public static List<List<Punto>> distribuirPuntos(List<Punto> puntos, List<Punto> centroides) {
        def listas = new ArrayList<List<Punto>>()
        for (int i = 0; i < centroides.size(); i++) {
            listas.add(new ArrayList<Punto>())
        }
        
        puntos.each { p ->
            double distMinima = Double.MAX_VALUE
            double d
            int indiceMinima
            centroides.eachWithIndex { cent, ind ->
                d = distancia(p, cent)
                if (d < distMinima) {
                    distMinima = d
                    indiceMinima = ind
                }
            }
            listas[indiceMinima].add(p)
        }
        
        return listas
    }
    
    public static double distanciaCentroides(List<Punto> centroidesNuevos, List<Punto> centroidesAnteriores) {
        double sumDists = 0
        centroidesNuevos.eachWithIndex{ cn, i ->
            sumDists += distancia(cn, centroidesAnteriores[i])
        }
        return sumDists
    }
    
    public static List<Punto> generarCentroidesIniciales(int n, int minx, int miny, int minz, int  maxx, int maxy,  int maxz) {
        return GeneradorPuntos.generarPuntos(n, minx, miny, minx, maxx, maxy, maxz)
    }
    
    public static List<Double> obtenerLimites(List<Punto> puntos) {
        int minx = (puntos.min{ p -> p.x}).x
        int miny = (puntos.min{ p -> p.y}).y
        int minz = (puntos.min{ p -> p.z}).z
        int maxx = (puntos.max{ p -> p.x}).x
        int maxy = (puntos.max{ p -> p.y}).y
        int maxz = (puntos.max{ p -> p.z}).z
        return [minx, miny, minz, maxx, maxy, maxz]
    }
    
   
    
    
    
    class Graficar implements Runnable {
       public Graficar(){
           
       }

        @Override
        public void run() {
            int num = 10;
            while (num > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                num--;
                System.out.println(".");
            
            }
        }
    }
    
    
     public static List<Punto> buscarKCentroides(List<Punto> puntos, int k, double epsilon) {
        def limites = obtenerLimites(puntos)
        List<Punto> centroides = generarCentroidesIniciales(k, limites[0], limites[1], limites[2], limites[3], limites[4], limites[5] )
        while (true) {
            
            List<List<Punto>> puntosDistribuidos = distribuirPuntos(puntos, centroides)
            List<Punto> nuevosCentroides = puntosDistribuidos.collect { pd ->
                calcularCentroide(pd)
            }
            if (distanciaCentroides(nuevosCentroides, centroides) < epsilon) {
                return nuevosCentroides
            }
         
            
            
            centroides = nuevosCentroides
            
        }
    }
    
}




