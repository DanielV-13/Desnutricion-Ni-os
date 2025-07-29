package INDIVIDUOS;

//Hay que hacer los imports para poder usar LinkedList y el iterador
import java.util.LinkedList;
import java.util.ListIterator;

//Declaramos Niño como clase Hijo de Persona
public class Niño extends Persona {

    //Atributos propios de niño
    private double talla;
    private String lugarNacimiento;
    private int mesesVida;
    //LinkedList para fecha de Nacimiento con su respectivo Iterador
    public LinkedList<Integer>fechaNacimiento;
    public ListIterator<Integer>iterador;


    //Constructor usando la clase Persona
    public Niño(String nombres, String apellidos, String cedula, String sexo,double talla, String lugarNacimiento) {
        super(nombres, apellidos, cedula, sexo); //Constructor de la clase Persona
        this.lugarNacimiento=lugarNacimiento;
        this.talla=talla;
        this.mesesVida=0; //Inicializamos meses de vida en 0
        this.fechaNacimiento = new LinkedList<>(); //Inicializar la linkedList
    }


    //Implementar metodos abstractos

    //FALTA ESTO
    public Boolean validarDatos(){
        Boolean verdad= Boolean.TRUE;
        return verdad;
    }

    public void mostrarResumen(){
        System.out.println("Estos son los datos del niño");
        System.out.println("Nombres: "+nombres);
        System.out.println("Apellidos: "+apellidos);
        System.out.println("Cedula: "+cedula);
        System.out.println("Sexo: "+sexo);
        System.out.println("Talla: "+talla);
        System.out.println("Lugar de Nacimiento: "+lugarNacimiento);
        System.out.println("Meses de Vida: "+ mesesVida);
        System.out.println("dia, mes, año (Nacimiento) :"+fechaNacimiento);
    }


    //------OTROS METODOS DE LA CLASE NIÑO------

    //Getters para acceder a atributos privados fuera de la clase
    //Necesitamos hacer getters para accederlos desde otras clases fuera de las clases hijas
    public double getTalla(){
        return talla;
    }

    public int getMesesVida(){
        return mesesVida;
    }

    //Otros Metodos

    public void llenarNacimiento(int dia, int mes, int año){
       fechaNacimiento.add(0,dia);
       fechaNacimiento.add(1,mes);
       fechaNacimiento.add(2,año);
    }


    public void calcularMesVida(int diaActual, int mesActual, int añoActual){
        int diaNacimiento = fechaNacimiento.get(0); //METODO .get para acceder a los valores de la LinkedLisT
        int mesNacimiento = fechaNacimiento.get(1);
        int añoNacimiento = fechaNacimiento.get(2);

        //Debemos calcular los meses totales que ha vivido el niño
        int totalMeses = (añoActual - añoNacimiento) * 12  + (mesActual - mesNacimiento);

        //Ejemplo es Julio de 2025 y el niño nacio en Octubre de 2025
        //(2025-2005)*12 + (7-10)
        //Total de meses vivido por el "niño" = 237 meses

        // Si el día actual es menor que el día de nacimiento, aún no ha cumplido ese mes
        if (diaActual < diaNacimiento) {
            totalMeses -= 1;
        }
        //En el ejemplo anterior digamos que estamos 7 de Julio y el niño nacio un 13 de Octubre
        //Por lo tanto, todavia no cumpliria otro mes de vida en Julio
        //Se le resta -1 al total de meses vividos

        if (totalMeses < 0) {
            System.out.println("Error: La fecha actual es anterior a la fecha de nacimiento.");
            mesesVida = 0;
        } else {
            mesesVida = totalMeses;
        }
    }



}
