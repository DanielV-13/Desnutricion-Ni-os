package KPIs;

import INDIVIDUOS.Niño;

import java.util.HashMap;

public class TallaEdad {
    //Atributos
    private Niño niño;
    private double tallaIdeal=0;
    private double desviacionEstandar;
    private double zScore;


    // HashMap para almacenar talla ideal y desviación estándar por edad en meses
    private static HashMap<Integer, Double[]> tablaTallaEdad = new HashMap<>();

    //Guardo un entero, que representa el mes de vida del infante

    //Y un arreglo double, donde el indice 0 es La talla ideal
    //Y el indice 0 es la desviacion standar
    //Desviacion estandar = talla ideal -(talla ideal-2DS)

    //La razon de hacer este HashMap static es que es algo propio de la Clase TallaEdad, no de los objetos de la misma
    //Entonces conviene que sea static
    //Para que asi cada vez que se cree un objeto, no se vuelva a generar el Hashmap de forma innecesaria

    static {
        tablaTallaEdad.put(0,  new Double[]{49.9, 49.9 - 46.1});
        tablaTallaEdad.put(1,  new Double[]{54.7, 54.7 - 50.8});
        tablaTallaEdad.put(2,  new Double[]{58.4, 58.4 - 54.4});
        tablaTallaEdad.put(3,  new Double[]{61.4, 61.4 - 57.3});
        tablaTallaEdad.put(4,  new Double[]{63.9, 63.9 - 59.8});
        tablaTallaEdad.put(5,  new Double[]{65.9, 65.9 - 61.8});
        tablaTallaEdad.put(6,  new Double[]{67.6, 67.6 - 63.5});
        tablaTallaEdad.put(7,  new Double[]{69.2, 69.2 - 65.0});
        tablaTallaEdad.put(8,  new Double[]{70.6, 70.6 - 66.4});
        tablaTallaEdad.put(9,  new Double[]{72.0, 72.0 - 67.7});
        tablaTallaEdad.put(10, new Double[]{73.3, 73.3 - 69.0});
        tablaTallaEdad.put(11, new Double[]{74.5, 74.5 - 70.2});
        tablaTallaEdad.put(12, new Double[]{75.7, 75.7 - 71.3});
        tablaTallaEdad.put(13, new Double[]{76.9, 76.9 - 72.5});
        tablaTallaEdad.put(14, new Double[]{78.0, 78.0 - 73.6});
        tablaTallaEdad.put(15, new Double[]{79.1, 79.1 - 74.6});
        tablaTallaEdad.put(16, new Double[]{80.2, 80.2 - 75.7});
        tablaTallaEdad.put(17, new Double[]{81.2, 81.2 - 76.7});
        tablaTallaEdad.put(18, new Double[]{82.3, 82.3 - 77.7});
        tablaTallaEdad.put(19, new Double[]{83.2, 83.2 - 78.7});
        tablaTallaEdad.put(20, new Double[]{84.2, 84.2 - 79.6});
        tablaTallaEdad.put(21, new Double[]{85.1, 85.1 - 80.5});
        tablaTallaEdad.put(22, new Double[]{86.0, 86.0 - 81.4});
        tablaTallaEdad.put(23, new Double[]{86.9, 86.9 - 82.3});
        tablaTallaEdad.put(24, new Double[]{87.8, 87.8 - 83.2});
    }
    //Constructor de TallaEdad
    public TallaEdad(Niño niño){
        this.niño=niño;
    }

    //METODOS

    public double calcularzScore() {
        int edad = niño.getMesesVida();

        // Verifica si hay datos para la edad del niño
        if (tablaTallaEdad.containsKey(edad)) {
            // Extrae talla ideal y desviación estándar desde el mapa
            tallaIdeal = tablaTallaEdad.get(edad)[0]; //Funciona como un diccionario en Python
            desviacionEstandar = tablaTallaEdad.get(edad)[1];

            // Calcula el Z-Score con la fórmula estándar de la OMS
            zScore = (niño.getTalla() - tallaIdeal) / desviacionEstandar;
        } else {
            // Si no hay datos, se deja Z-Score en 0
            System.out.println("No hay datos de referencia para la edad de " + edad + " meses.");
            zScore = 0;
        }

        return zScore; //Devuelve el zScore
    }


    //Metodo para analizar el Zscore
    public void analizarZScore() {
        double z = calcularzScore();

        if (z < -3) {
            System.out.println(" El niño presenta retraso severo en el crecimiento (Z < -3)");
            System.out.println("Se recomienda atención médica inmediata y evaluación nutricional");

        } else if (z >= -3 && z < -2) {
            System.out.println(" El niño presenta retraso en el crecimiento (-3 ≤ Z < -2)");
            System.out.println("Es necesario un seguimiento pediátrico y revisión de su dieta");

        } else if (z >= -2 && z <= 2) {
            System.out.println(" El niño tiene un crecimiento normal para su edad (-2 ≤ Z ≤ +2)");
            System.out.println("Continuar con controles regulares y alimentación balanceada");

        } else if (z > 2) {
            System.out.println("El niño tiene una talla superior a la media para su edad (Z > +2)");
            System.out.println("Esto no es preocupante si no hay otros síntomas");

        } else {
            System.out.println(" Z-score fuera de rango esperado. Verifique los datos ingresados");
        }
    }

    public double getzScore() {
        return zScore;
    }

    public double getTallaIdeal() {
        return tallaIdeal;
    }
    public void mostrarKPI() {
        double zScore = calcularzScore();
        System.out.println("\nESTOS SON LOS KPIs");
        System.out.println("El niño tiene " + niño.getMesesVida() + " meses de edad");
        System.out.println("La talla ideal del niño es de: "+ tallaIdeal);
        System.out.println("La talla actual del niño es: "+niño.getTalla());
        System.out.println("El Z-Score del niño es " + zScore);
        analizarZScore();
    }


}
