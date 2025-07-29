package INDIVIDUOS;

import java.util.LinkedList;

public class Madre extends Persona {
    //Atributos propios de la madre
    private String telefono;
    private String domicilio;
    private int sesionesEducacion;

    //Constructor usando los atributos de la clase Persona y de Madre
    public Madre(String nombres, String apellidos, String cedula, String sexo,String telefono,String domicilio, int sesionesEducacion) {
        super(nombres, apellidos, cedula, sexo); //Constructor de la clase Persona
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.sesionesEducacion = 0; //Inicializamos meses de vida en 0
    }


    //Implementar metodos abstractos

    public void mostrarResumen() {
        System.out.println("Estos son los datos de la madre");
        System.out.println("Nombres: "+nombres);
        System.out.println("Apellidos: "+apellidos);
        System.out.println("Cedula: "+cedula);
        System.out.println("Sexo: "+sexo);
        System.out.println("Telefono: "+telefono);
        System.out.println("Domicilio: "+domicilio);
        System.out.println("Sesiones Educacion: "+ sesionesEducacion);
    }

    //HACER UN METODO PARA VALIDAR EL NUMERO DE SESIONES DE EDUCACION SEGUN LA EDAD DEL NIÑO

}
