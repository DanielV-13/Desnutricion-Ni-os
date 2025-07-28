package INDIVIDUOS;

//Persona es la clase padre de Niño y Madre
public class Persona {

//Definimos atributos de la clase persona como PROTECTED
    protected String nombres;
    protected String apellidos;
    protected String cedula;
    protected String sexo;

    //Creamos un CONSTRUCTOR
    public Persona(String nombres, String apellidos, String cedula, String sexo) {
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.cedula=cedula;
        this.sexo=sexo;
    }

    //Getter para acceder a los nombres
    public String getNombres(){
        return nombres;
    }




}
