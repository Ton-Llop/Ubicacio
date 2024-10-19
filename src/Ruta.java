public class Ruta {
    private Ubicacio[] ubicacions;
    private int numUbicacions;
    private boolean rutaAcabada;


/**
 * 
 * @param ubicacions numero de ubicacions que tindra la nostra ruta
 */
public Ruta (int nUbicacions){
    ubicacions = new Ubicacio[nUbicacions];
    numUbicacions = 0;
    rutaAcabada = false;
}
/**
 * Getter del num d'ubicacions
 * @return el num d'ubicacions
 */
public int getNumUbicacions(){
    return numUbicacions;
}
/**
 * Ens permet modificar una Ubicacio de la ruta 
 * @param index posicio
 * @param U nou valor
 */
public void modificarUbicacio(int index, Ubicacio U){
    if (index < numUbicacions){
        ubicacions[index].setX((U.getX()));
        ubicacions[index].setY((U.getY()));
    }
}
/**
* Consultar la ubicació i-èssima de la ruta.
*
* @param index Índex de la ubicació a consultar
* @return La ubicació a l'índex especificat
*/
public Ubicacio getUbicacio(int index){
    if (index >= 0 && index < numUbicacions) {        
        return ubicacions[index].Copia();
    }else
        return null;
}
// Setter per tancar la ruta
 public void tancarRuta() {
    rutaAcabada = true;
}
// Getter per saber si la ruta està tancada
public boolean isRutaAcabada() {
    return rutaAcabada;
}
/**
 * Afegir Ubicacio a la Ruta
 * 
 * @param ubi nova ubi a afegir
 */
public void afegirUbicacio(Ubicacio ubi){
    if (numUbicacions < ubicacions.length){
        ubicacions[numUbicacions] = ubi.Copia();
        numUbicacions ++;
    }
}
/*
 * Metode String
 */
public String toString(){
    String aux;
    aux = "Ruta => numUbicacions: " + numUbicacions;
    for (int i = 0; i<numUbicacions; i++){
        aux = aux + "\n\t["+ i +"] " + ubicacions[i];
    }
    return aux;
}
public double calcularDistanciaTotal() {
    double distanciaTotal = 0.0;
    // Recorre totes les ubicacions de la ruta i calcula la distància entre ubicacions consecutives
    for (int i = 0; i < numUbicacions - 1; i++) {
        distanciaTotal += ubicacions[i].DistanciaEntreDosPunts(ubicacions[i], ubicacions[i + 1].getX(), ubicacions[i + 1].getY());
    }
    // Si la ruta és tancada, suma la distància entre l'última ubicació i la primera
    if (rutaAcabada && numUbicacions > 1) {
        distanciaTotal += ubicacions[numUbicacions - 1].DistanciaEntreDosPunts(ubicacions[numUbicacions - 1], ubicacions[0].getX(), ubicacions[0].getY());
    }
    return distanciaTotal;
}
public Ubicacio getUbicacioMesAlNord() {
    Ubicacio ubicacioMesAlNord = null;
    if (numUbicacions > 0) {
        ubicacioMesAlNord = ubicacions[0]; 
        // Recorre la resta de les ubicacions per trobar la que té la latitud més alta
        for (int i = 1; i < numUbicacions; i++) {
            if (ubicacions[i].getX() > ubicacioMesAlNord.getX()) {
                ubicacioMesAlNord = ubicacions[i];
            }
        }
    }
    return ubicacioMesAlNord; 
}
}
