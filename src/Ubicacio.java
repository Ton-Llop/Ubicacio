public class Ubicacio {
    private double x;
    private double y;

/**
 * Constructor per defecte sense parametres
 */
public Ubicacio(){
        x=0.0;
        y=0.0;
    }
/**
 * Constructor amb parametres
 */
public Ubicacio(double x, double y){
    if (esCorrecteLatitud(x) && esCorrecteLongitud(y)){
    this.x = x;
    this.y = y;
} else {
    this.x = 0;
    this.y = 0;
}
}
/**
 * Metodos auxiliares
 * @param x
 * @return
 */
public boolean esCorrecteLatitud(double x){
    return (x >= -180 && x <= 180);
}
/**
 * Metodos auxiliares
 * @param y
 * @return
 */
public boolean esCorrecteLongitud(double y){
    return (y >= -180 && y <= 180);
}

/**
 * Getter
 * @return coord X
 */
public double getX(){
    return x;
}
/**
 * Getter
 * @return coord y
 */
public double getY(){
    return y;
}
/**
 * Setter per validar X
 * @param x
 */
public void setX(double x){
    this.x = x;

}
/**
 * Setter per validar y
 * @param x
 */
public void setY(double y){
    this.y = y;
}
/**
 * Metode que retorna una copia d'un punt
 * @return nou punt
 */
public Ubicacio Copia(){
    return new Ubicacio(x,y);
}
/** 
 * Metode que comprova si son iguals per mirar els 4 decimals multipliquem per 10000
*/
public boolean EsIgual(Ubicacio ubi){
    if(this.x * 10000 == ubi.x * 10000 && this.y * 10000 == ubi.y * 10000){
        return true;
    }else
    return false;
}
/**
 * Metode que calcula distancia entre dos punts 
 * @return formulafinal
 */
public double DistanciaEntreDosPunts(Ubicacio ubi, double x, double y){
    double RadiTerra = 6378.137;
    // Convertir les coordenades a radians
    double lat1 = ubi.x * Math.PI / 180;
    double lon1 = ubi.y * Math.PI / 180;
    double lat2 = x * Math.PI / 180.0;
    double lon2 = y * Math.PI / 180.0;
    // Diferències de latitud i longitud
    double difLat = lat2 - lat1;
    double difLon = lon2 - lon1;
    double formulaA = Math.sin(difLat / 2) * Math.sin(difLat / 2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(difLon / 2) * Math.sin(difLon / 2);
    double formulaB = 2 * Math.atan2(Math.sqrt(formulaA), Math.sqrt(1 - formulaA));
    return RadiTerra * formulaB;
}
/**
     * Mètode toString per mostrar les coordenades
     */
    @Override
    public String toString() {
        return "Ubicacio [latitud=" + x + ", longitud=" + y + "]";
    }
}
