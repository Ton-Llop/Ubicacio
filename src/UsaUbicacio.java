public class UsaUbicacio {

    public static void main(String[] args) {
        // Creació d'instàncies d'Ubicacio
        Ubicacio u1 = new Ubicacio(41.3851, 2.1734); // Barcelona
        Ubicacio u2 = new Ubicacio(40.4168, -3.7038); // Madrid

        // Provar el mètode toString
        System.out.println("Ubicació 1: " + u1);
        System.out.println("Ubicació 2: " + u2);

        // Provar el mètode EsIgual
        boolean sonIguals = u1.EsIgual(u2);
        System.out.println("Les ubicacions són iguals? " + sonIguals);


        // Provar el mètode Copia
        Ubicacio copiaDeU1 = u1.Copia();
        System.out.println("Còpia de la ubicació 1: " + copiaDeU1);

        // Modificar la còpia i mostrar-la
        copiaDeU1.setX(40.0);
        copiaDeU1.setY(3.0);
        System.out.println("Ubicació modificada de la còpia: " + copiaDeU1);

        // Calcular la distància entre Barcelona i Madrid
        double distancia = u1.DistanciaEntreDosPunts(u1, u2.getX(), u2.getY());
        System.out.println("Distància entre Barcelona i Madrid: " + distancia + " km");
    }
}
