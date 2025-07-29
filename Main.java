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

   System.out.println("Ingrese los datos del niño");
   System.out.println("Nombres");
   String nombres=sc.nextLine();
   System.out.println("Apellidos");
   String apellidos=sc.nextLine();
   System.out.println("Cedula");
   String cedula=sc.nextLine();
   System.out.println("Sexo");
   String sexo=sc.nextLine();
   System.out.println("Lugar Nacimiento");
   String lugarNacimiento=sc.nextLine();
   System.out.println("Talla");
   double talla=sc.nextDouble();

   System.out.println("");
   System.out.println("Ahora proporcione los datos de fecha");



    Niño ob1= new Niño(nombres,apellidos,cedula,sexo,talla,lugarNacimiento);
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
