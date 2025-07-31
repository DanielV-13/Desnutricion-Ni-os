package KPIs;

import INDIVIDUOS.Niño;
import java.util.Scanner; //Usaremos Scanner en esta clase

public class Neumococo implements Vacuna {
    //ATRIBUTOS
    private Niño niño; //OBJETO DE TIPO NIÑO
    private String nombreVacuna;
    private int dosisAdministradas;
    private int dosisRequeridas;
    private double porcentajeVacunacion;

    //CONSTRUCTOR
    public Neumococo(Niño niño,int dosisAdministradas) {
        this.niño = niño;
        this.dosisAdministradas = dosisAdministradas;
        nombreVacuna = "Neumococo"; //Valor fijo
        dosisRequeridas = 0; //Inicializamos las dosis requeridas en 0
        porcentajeVacunacion = 0; //Inicializamos el porcentajeVacunacion
    }
        //METODOS
        //Metodo de la Interfaz
        @Override
        public double calcularPorcentajeVacunacion(){

            int dosiscompletas=3;
            porcentajeVacunacion= ((double)dosisAdministradas/dosiscompletas)*100;
            porcentajeVacunacion = Math.round(porcentajeVacunacion); // Redondeo a solo parte entera

            return porcentajeVacunacion;
        }


        //Otros metodos

    public int calcularDosisRequeridas(){
        int meses = niño.getMesesVida();  // accedemos a los meses de vida del niño

        if (meses < 2) {
            return 0;
        } else if (meses >= 2 && meses < 4) {
            return 1;
        } else if (meses >= 4 && meses < 6) {
            return 2;
        } else {
            return 3; // desde los 6 meses en adelante ya debería tener las 3 dosis
        }
    }

    public void setDosisRequeridas() {
        dosisRequeridas =calcularDosisRequeridas() ; //Llamamos al metodo que calcula las Dosis Requeridas
    }


    public void verificarAlertaDosis() {
        int dosisRequeridas = calcularDosisRequeridas();
        if (dosisAdministradas != dosisRequeridas) {
            System.out.println("Alerta: El niño no ha recibido todas las dosis de Neumococo requeridas para su mes de vida");
            System.out.println("Dosis administradas: " + dosisAdministradas);
            System.out.println("Dosis requeridas: " + dosisRequeridas);

        } else {
            System.out.println("El esquema de vacunación de Neumococo está completo y al día, segun el mes de vida del niño");
        }
    }

    //Metodo que llama a los demas metodos para procesar los datos de la vacuna
    //Metodo void que hace los calculos por detras
    public void procesarVacuna() {
        this.setDosisRequeridas();
        this.verificarAlertaDosis();
        this.calcularPorcentajeVacunacion();
    }


}




