package KPIs;

import INDIVIDUOS.Niño;

public class Rotavirus implements Vacuna {

    //ATRIBUTOS
    private Niño niño; //OBJETO DE TIPO NIÑO
    private String nombreVacuna;
    private int dosisAdministradas;
    private int dosisRequeridas;
    private double porcentajeVacunacion;

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
    public double calcularPorcentajeVacunacion(){

        int dosiscompletas=2; //Solo son 2 dosis de Rotavirus
        porcentajeVacunacion= ((double)dosisAdministradas/dosiscompletas)*100;
        porcentajeVacunacion = Math.round(porcentajeVacunacion); // Redondeo a solo parte entera

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

    public void setDosisRequeridas() {
        dosisRequeridas =calcularDosisRequeridas() ;//Llamamos al metodo que calcula las Dosis Requeridas

    }


    public void verificarAlertaDosis() {
        int dosisRequeridas = calcularDosisRequeridas();
        if (dosisAdministradas != dosisRequeridas) {
            System.out.println("Alerta: El niño no ha recibido todas las dosis de Rotavirus requeridas para su mes de vida");
            System.out.println("Dosis administradas: " + dosisAdministradas);
            System.out.println(", Dosis requeridas: " + dosisRequeridas);
        } else {
            System.out.println("El esquema de vacunación de Rotavirus está completo y al día segun el mes de vida del niño");
        }
    }








    public double getPorcentajeVacunacion() {

        return porcentajeVacunacion;
    }










}
