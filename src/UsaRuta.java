public class UsaRuta {
    public static void main(String[] args) {
        Ruta ruta3Ubi = new Ruta(3);
        //Sense afegir Ubicacions
        System.out.println("La nostra ruta  abans d'afegir un ubicacions "+ruta3Ubi.toString());
        Ubicacio Ubi1 = new Ubicacio(10.0,15.2);
        ruta3Ubi.afegirUbicacio(Ubi1);
        Ubi1.setX(15.0);
        Ubi1.setY(20.2);
        ruta3Ubi.afegirUbicacio(Ubi1);
        Ubicacio Ubi2 = new Ubicacio(9.2,12.2);
        ruta3Ubi.afegirUbicacio(Ubi2);
        // Afegint Ubicacions
        System.out.println("La nostra ruta despres d'afegir  ubicacions "+ruta3Ubi.toString());


        validarUbicacionsIessimas(ruta3Ubi);
        modificarUbicacioIessima(ruta3Ubi, 1, new Ubicacio(20.0, 25.5));
        validarCalculDistancia(ruta3Ubi);
        validarNord(ruta3Ubi);

        
    }

    /**
     * Validar les ubicacions i-èssimes de la ruta
     */
    public static void validarUbicacionsIessimas(Ruta ruta) {
        System.out.println("\nValidació de les ubicacions i-èssimes:");
        for (int i = 0; i < ruta.getNumUbicacions(); i++) {
            Ubicacio ubi = ruta.getUbicacio(i);
            System.out.println("Ubicació " + i + ": (" + ubi.getX() + ", " + ubi.getY() + ")");
        }
    }
    /**
     * Modificar una ubicació i-èssima de la ruta
     */
    public static void modificarUbicacioIessima(Ruta ruta, int index, Ubicacio novaUbicacio) {
        System.out.println("\nModificant la ubicació " + index + "...");
        ruta.modificarUbicacio(index, novaUbicacio);
        System.out.println("Ubicació " + index + " modificada a: (" + novaUbicacio.getX() + ", " + novaUbicacio.getY() + ")");
    }

    /**
     * Validar el càlcul de la distància total de la ruta
     */
    public static void validarCalculDistancia(Ruta ruta) {
        System.out.println("\nValidació de la distància total de la ruta:");
        double distanciaTotal = ruta.calcularDistanciaTotal();
        System.out.println("La distància total de la ruta és: " + distanciaTotal + " km");
    }

    /**
     * Validar la ubicació més al nord de la ruta
     */
    public static void validarNord(Ruta ruta) {
        System.out.println("\nValidació de la ubicació més al nord:");
        Ubicacio ubicacioNord = ruta.getUbicacioMesAlNord();
        System.out.println("La ubicació més al nord és: (" + ubicacioNord.getX() + ", " + ubicacioNord.getY() + ")");
    }
}

