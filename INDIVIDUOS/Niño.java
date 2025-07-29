package INDIVIDUOS;

//Declaramos Niño como clase Hijo de Persona
public class Niño extends Persona {

    //Atributos propios de niño
    private double talla;
    private String lugarNacimiento;
    private int mesesVida;

    //Constructor usando la clase Persona
    public Niño(String nombres, String apellidos, String cedula, String sexo,double talla, String lugarNacimiento, int mesesVida) {
        super(nombres, apellidos, cedula, sexo); //Constructor de la clase Persona
        this.lugarNacimiento=lugarNacimiento;
        this.talla=talla;
        this.mesesVida=mesesVida;
    }

    //Implementar metodos abstractos
    public Boolean validarDatos(){
        Boolean verdad= Boolean.TRUE;
        return verdad;
    }


    public String mostrarResumen(){
        String mensaje="Mensaje xd";
        return mensaje;
    }



}
