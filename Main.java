//Hay que importar las clases que vamos a usar
//Recordar que las clases estan dentro de los paquetes
import INDIVIDUOS.Niño;
import INDIVIDUOS.Persona;
import java.util.LinkedList;
import java.util.ListIterator;

import java.util.Scanner; //Usaremos Scanner


public class Main {
    public static void main(String[] args) {
   //Objeto de tipo Scanner
   Scanner sc=new Scanner(System.in);

    Niño ob1= new Niño("Juan Nada","Castro Lema","09943233","No Binario",14.5,"Guatemala",9);
        System.out.println(ob1.getNombres());

        System.out.println("Ingrese el dia de nacimiento");
        int dia=sc.nextInt();
        System.out.println("Ingrese el mes de nacimiento");
        int mes=sc.nextInt();
        System.out.println("Ingrese el año de nacimiento");
        int año=sc.nextInt();

        ob1.llenarNacimiento(dia, mes, año);
        System.out.println(ob1.fechaNacimiento);

        System.out.println("Ingrese el dia actual");
        int diaact=sc.nextInt();
        System.out.println("Ingrese el mes actual");
        int mesact=sc.nextInt();
        System.out.println("Ingrese el año actual");
        int añoact=sc.nextInt();

        ob1.calcularMesVida(diaact,mesact, añoact);
        System.out.println("Meses de vida del niño: "+ ob1.getMesesVida());


        System.out.println("");
        ob1.mostrarResumen();





    }
}
