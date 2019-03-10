
package programa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import programa.Programa.Fruta;


class Maquina {

    private double credito;
    private double precio;
    private int numeroCasillas;
    private ArrayList<Premio> Premios;
    
    Maquina(int NumeroCasillas, double Precio, Premio premio1, Premio premio2) {
        
        this.numeroCasillas = NumeroCasillas;
        this.precio = Precio;
        Premios = new ArrayList<Premio>();
        Collections.addAll(Premios, premio1,premio2);
        
    }
    
    public double getCredito (){
        return credito;
    }
    
    void incrementarCredito(double credito) {
        this.credito += credito;
    }

    public ArrayList<Fruta> jugar(){
       disminuircredito();
       ArrayList<Fruta> combinacion = generarCombinacion();
       verificar(combinacion);
       return combinacion;
    }
    
    private ArrayList<Fruta> generarCombinacion() {

        ArrayList<Fruta> combinacion = new ArrayList<Fruta>(this.numeroCasillas);

        Random random = new Random();
        Fruta[] todas = Fruta.values();

        for (int i = 0; i < this.numeroCasillas; i++) {
            Fruta fruta = todas[random.nextInt(todas.length)];
            combinacion.add(fruta);
        }

        return combinacion;
    }

    private void disminuircredito() {
        if((credito- precio)<0){
            credito = 0;
        }else{
            credito -= precio;  
        }
    }

    private void verificar(ArrayList<Fruta> combinacion) {
        for(Premio i : Premios){
            if((i.getCombinaciones()).equals(combinacion)){
                credito += i.getCantidad();
            }
        }
    }

}


//Jose David De la valle Acuña - 2015114083
//John Steven Rubio Castellanos - 2015214126