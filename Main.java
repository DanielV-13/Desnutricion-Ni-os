//Hay que importar las clases que vamos a usar
//Recordar que las clases estan dentro de los paquetes
import INDIVIDUOS.Niño;
import INDIVIDUOS.Madre;
import KPIs.Neumococo;
import KPIs.Rotavirus;
import KPIs.TallaEdad;

import java.util.Scanner; //Usaremos Scanner

public class Main {
    public static void main(String[] args) {
   //Objeto de tipo Scanner
   Scanner sc=new Scanner(System.in);

   //------N I Ñ O ---------------
   //INGRESAMOS DATOS DEL NIÑO

   System.out.println("Ingrese los datos del niño");
   System.out.print("Nombres: ");
   String nombres=sc.nextLine();
   System.out.print("Apellidos: ");
   String apellidos=sc.nextLine();
   System.out.print("Cedula (10 digitos): ");
   String cedula=sc.nextLine();
   System.out.print("Sexo (Masculino/Femenino): ");
   String sexo=sc.nextLine();
   System.out.print("Lugar Nacimiento: ");
   String lugarNacimiento=sc.nextLine();
   System.out.print("Talla (en cm): ");
   double talla=sc.nextDouble();

   //CONSTRUCTOR DE NIÑO
        //Objeto se llama niño (en minuscula)
    Niño niño= new Niño(nombres,apellidos,cedula,sexo,talla,lugarNacimiento);

    //-----INGRESO de FECHAS-----
        System.out.println("");
        System.out.println("Ahora proporcione los datos de fecha");

        //FECHA NACIMIENTO
// Validar día entre 1 y 31
        System.out.print("Ingrese el día de nacimiento (1-31): ");
        int dia = sc.nextInt();
        while (dia < 1 || dia > 31) {       // || operador OR
            System.out.println("Error: El día debe estar entre 1 y 31.");
            System.out.print("Ingrese el día de nacimiento (1-31): ");
            dia = sc.nextInt();
        }

// Validar mes entre 1 y 12
        System.out.print("Ingrese el mes de nacimiento (1-12): ");
        int mes = sc.nextInt();
        while (mes < 1 || mes > 12) {  // ||operador OR
            System.out.println("Error: El mes debe estar entre 1 y 12.");
            System.out.print("Ingrese el mes de nacimiento (1-12): ");
            mes = sc.nextInt();
        }

// Año de nacimiento
        System.out.print("Ingrese el año de nacimiento: ");
        int año = sc.nextInt();

//Llenamos los datos en la LinkedList fechaNacimiento
        niño.llenarNacimiento(dia, mes, año);

//---------------FECHA ACTUAL---------------
        System.out.println("");

        // Validar día entre 1 y 31
        System.out.print("Ingrese el día actual (1-31): ");
        int diaact = sc.nextInt();
        while (diaact < 1 || diaact > 31) {       // || operador OR
            System.out.println("Error: El día debe estar entre 1 y 31.");
            System.out.print("Ingrese el día actual (1-31): ");
            diaact = sc.nextInt();
        }

        // Validar mes entre 1 y 12
        System.out.print("Ingrese el mes actual (1-12): ");
        int mesact = sc.nextInt();
        while (mesact < 1 || mesact > 12) {  // ||operador OR
            System.out.println("Error: El mes debe estar entre 1 y 12.");
            System.out.print("Ingrese el mes actual (1-12): ");
            mesact = sc.nextInt();
        }

       //Año actual
        System.out.print("Ingrese el año actual: ");
        int añoact=sc.nextInt();

       //Calculamos los meses de vida del niño
        niño.calcularMesVida(diaact,mesact, añoact);

//-------M A D R E ------

        // --- LIMPIAR BUFFER ANTES DE USAR nextLine ---
        sc.nextLine(); // <<< ESTA LÍNEA ES CLAVE

        System.out.println("");
        System.out.println("Ingrese los datos de la madre");
        System.out.print("Nombres: ");
        String names=sc.nextLine();
        System.out.print("Apellidos: ");
        String lastname=sc.nextLine();
        System.out.print("Cedula (10 digitos): ");
        String ID=sc.nextLine();
        System.out.print("Domocilio: ");
        String domicilio=sc.nextLine();
        System.out.print("Numero de Telefono: ");
        String telefono=sc.nextLine();
        System.out.print("Sesiones de Educacion: ");
        int sesionesEducacion=sc.nextInt();

        //CONSTRUCTOR DE MADRE
        //Objeto se llama ob2
        Madre ob2= new Madre(names,lastname,ID,telefono,domicilio,sesionesEducacion);

        //--------KPIS-----------
        // ------TALLA EDAD-------
        // Crear objeto TallaEdad con el niño
        TallaEdad tallaEdad = new TallaEdad(niño);
        tallaEdad.mostrarKPI(); // Muestra mensajes según Z-score


//       ------ROTAVIRUS-------
// Pedir dosis para Rotavirus
        System.out.println("");
        System.out.print("Ingrese el número de dosis administradas de Rotavirus: ");
        int dosisRotavirus = sc.nextInt();
        Rotavirus rotavirus = new Rotavirus(niño,dosisRotavirus); //OBJETO ROTAVIRUS

        rotavirus.procesarVacuna(); //Metodo que procesa lo datos ingresados

        double porcentajeRotavirus = rotavirus.calcularPorcentajeVacunacion();
        System.out.println("Porcentaje total de vacunación Rotavirus: " + porcentajeRotavirus + "%");

        //------NEUMOCOCO------
// Pedir dosis para Neumococo
        System.out.println("");
        System.out.print("Ingrese el número de dosis administradas de Neumococo: ");
        int dosisNeumococoadmin = sc.nextInt();
        //OBJETO NEUMOCOCO //Se ingresa como parametro las dosis administradas y un objeto de tipo Niño
        Neumococo neumococo = new Neumococo(niño,dosisNeumococoadmin);

        neumococo.procesarVacuna();

        double porcentajeNeumococo = neumococo.calcularPorcentajeVacunacion();
        System.out.println("Porcentaje total de vacunación Neumococo: " + porcentajeNeumococo + "%");

    }
}