package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

   public enum Fruta{
       FRESA, SANDIA, PLATANO,MELOCOTON, PERA;
   };
   
    public static void main(String[] args) {
        // 1. Declara y construye dos premios
            System.out.println(Fruta.FRESA.toString()+ " --- " );
        
        Premio premio1 = new Premio(20,Fruta.FRESA, Fruta.FRESA, Fruta.FRESA);
        Premio premio2 = new Premio(10,Fruta.SANDIA, Fruta.FRESA, Fruta.SANDIA);
 

        Maquina maquina = new Maquina(3, 0.5, premio1, premio2);

        /* 3. Solicita al usuario que introduzca por teclado la cantidad
         * de crédito para jugar.
         */
        System.out.println("Introduzca el crédito: ");
        Scanner teclado = new Scanner(System.in);
        double credito = teclado.nextDouble();
        teclado.nextLine();
        maquina.incrementarCredito(credito);

        // 4. Jugamos mientras haya crédito disponible
        while (maquina.getCredito() > 0) {
            //4.1 Realiza la jugada
            ArrayList<Fruta> combinacion = maquina.jugar();

            //4.2 Muestra la combinación obtenida y el crédito
            System.out.println(combinacion.toString()+ " --- " + maquina.getCredito());
            //4.3 Pide al usuario que pulse intro para continuar
            System.out.println("Pulse Intro para volver a jugar");
            teclado.nextLine();
        }
        teclado.close();
        System.out.println("---se quedo sin creditos");

    }

}


//Jose David De la valle Acuña - 2015114083
//John Steven Rubio Castellanos - 2015214126