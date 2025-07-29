package INDIVIDUOS;

//Persona es la clase padre de Niño y Madre
//Persona sera una clase Abstracta
public abstract class Persona {

//Definimos atributos de la clase persona como PROTECTED
    protected String nombres;
    protected String apellidos;
    protected String cedula;
    protected String sexo;

    //Creamos un CONSTRUCTOR
    //Este constructor podra ser usado por las clases hijas
    //Recordar que una clase abstracta no puede ser instanciada
    public Persona(String nombres, String apellidos, String cedula, String sexo) {
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.cedula=cedula;
        this.sexo=sexo;
    }

    //Getter para acceder a los nombres
    //Debido a que estamos usando atributos de Tipo Protected
    //Necesitamos hacer getters para accederlos desde otras clases fuera de las clases hijas
    public String getNombres(){
        return nombres;
    }

    //Metodos abstractos
    //Son metodos solo Declarados sin cuerpo
    public abstract Boolean validarDatos();
    public abstract String mostrarResumen();

}
