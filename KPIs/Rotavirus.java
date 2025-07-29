package KPIs;

import INDIVIDUOS.Niño;

public class Rotavirus implements Vacuna {

    //ATRIBUTOS
    private Niño niño; //OBJETO DE TIPO NIÑO
    private String nombreVacuna;
    private int dosisAdministradas;
    private int dosisRequeridas;
    private float porcentajeVacunacion;

    //CONSTRUCTOR
    public Rotavirus(Niño niño,int dosisAdministradas) {
        this.niño = niño;
        this.dosisAdministradas = dosisAdministradas;
        nombreVacuna = "Rotavirus"; //Valor fijo
        dosisRequeridas = 0; //Inicializamos las dosis requeridas en 0
        porcentajeVacunacion = 0; //Inicializamos el porcentajeVacunacion
    }

    //METODOS
    //Metodo de la Interfaz
    @Override
    public float calcularPorcentajeVacunacion(){

        int dosiscompletas=2; //Solo son 2 dosis de Rotavirus
        porcentajeVacunacion= (dosisAdministradas/dosiscompletas)*100;
        System.out.println("El porcentaje de Vacunacion de Rotavirus del Niño es de: ");

        return porcentajeVacunacion;
    }

    public int calcularDosisRequeridas(){
        int meses = niño.getMesesVida();  // accedemos a los meses de vida del niño

        if (meses < 2) {
            return 0;
        } else if (meses >= 2 && meses < 4) {
            return 1;
        } else {
            return 2; // desde los 4 meses en adelante ya debería tener las 2 dosis
        }
    }

    public void setDosisRequeridas(int dosisRequeridas) {
        this.dosisRequeridas =calcularDosisRequeridas() ; //Llamamos al metodo que calcula las Dosis Requeridas
    }

    public float getPorcentajeVacunacion() {

        return porcentajeVacunacion;
    }










}
