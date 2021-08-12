import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


/**
*  El método run() funcionará como nuestro método principal
*  No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*  Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto1 {
    
    /**
    *  Único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);


    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read() {
        return scanner.nextLine();
    }
 

    /**
    * método principal
    */
    public void run() {
        /*
        solución propuesta
        */


        // ------------------ < Entradas > ------------------
        String datos = read();
        String lista[] = datos.split(" ");
        
        double peso = Double.parseDouble(lista[0]);
        double altura = Double.parseDouble(lista[1]);
        int edad = Integer.parseInt(lista[2]);
        


        // ------------------ < Programa > ------------------
        
        double valorimc = peso / Math.pow(altura, 2);
        String estadoimc;


        if (valorimc < 22 && edad < 45) {
            estadoimc = "BAJO";

        } else if (valorimc < 22 && edad >= 45 || valorimc >= 22 && edad < 45) {
            estadoimc = "MEDIO";

        } else {
            estadoimc = "ALTO";

        }

        

        // ------------------ < Salida > ------------------
        
        if (peso < 0 || peso > 105 || altura < 0.5 || altura > 2.1 || edad < 1 || edad > 100) {
            System.out.println("ERROR");
            
        } else {
            DecimalFormatSymbols punto = new DecimalFormatSymbols();
            punto.setDecimalSeparator('.');
            DecimalFormat formateo = new DecimalFormat("#.000", punto);

            System.out.println(formateo.format(valorimc) + " " + estadoimc);

        }

    }
    
    /*
    public static void main(String[] args) {

        Reto1 codigo = new Reto1();
        codigo.run();

    }*/

}

