
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;



/**
*  El método run() funcionará como nuestro método principal
*  No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*  Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Producto {

    // ------------------ < Atributos > ------------------

    /**
    *  Codigo identificador producto (Entero)
    */
    private final int codigo;

    /**
    *  Nombre del producto (String)
    */
    private final String nombre;

    /**
    *  Precio del producto (Decimal)
    */
    private final double precio;

    /**
    *  Cantidad de inventario (Entero)
    */
    private final int inventario;
    


    
    // ------------------ < Constructor > ------------------

    /**
    *  Constructor Producto
    */
    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;  
    }
    
    // ------------------ < Metodos > ------------------
    public Integer getCodigo() {
        return codigo;   
    }

    public String getNombre() {
        return nombre;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public Integer getInventario() {
        return inventario;
    }
    
    @Override
    public String toString() {
        return codigo + " " + nombre + " " + precio + " " + inventario;
    }
    
}




/**
*  Clase que contiene los datos de los productos
*/
class BaseDatosProductos {
    
    /**
    *  Hashmap como base de datos
    */
    public Map<Integer, Producto> listaProductos = new HashMap<>();
    
    
    // ------------------ < Metodos > ------------------

    /**
    *  Devuelve un boolean si hay o no dicho producto
    */
    public boolean verificarExistencia(Integer codigo) {
        boolean productobool = false;
        
        if (listaProductos.containsKey(codigo)) {
            productobool = true;
        }
        return productobool;
    }
    

    /**
    *  Agregar
    */
    void agregar(Integer codigo, Producto prod) {
        listaProductos.put(codigo, prod);
    }


    /**
    *  Actualizar
    */
    void actualizar(Integer codigo, Producto prod) {
        listaProductos.replace(codigo, prod);
    }


    /**
    *  Eliminar
    */
    void eliminar(Integer codigo) {
        listaProductos.remove(codigo);
    }


    /**
    *  Informe de productos
    */
    public String generarInforme(boolean msjerror) {
        if (msjerror) {
            return "ERROR";
        } else {
            
            int dickeys = listaProductos.size();
            
            // Dividimos cada item en listas
            int codigos[] = new int [dickeys];
            String nombres[] = new String[dickeys];
            double precios[] = new double[dickeys];
            int inventarios[] = new int[dickeys];
            
            
            int ivariable = 0;
            for (Entry<Integer, Producto> e : listaProductos.entrySet()) {

                Producto aprod = e.getValue();
                String xprod = aprod.toString();
                String yprod[] = xprod.split(" ");
                
                int cprod = Integer.parseInt(yprod[0]);
                double pprod = Double.parseDouble(yprod[2]);
                int inprod = Integer.parseInt(yprod[3]);
                
                codigos[ivariable] = cprod;
                nombres[ivariable] = yprod[1];
                precios[ivariable] = pprod;
                inventarios[ivariable] = inprod;
                
                ivariable++;
            }
            

            // Hallamos los max y min
            double max = Arrays.stream(precios).max().getAsDouble();
            double min = Arrays.stream(precios).min().getAsDouble();

            String maxstr;
            String minstr;
            maxstr = null;
            minstr = null;
            

            // Producto con precio mayor
            for (int k = 0; k < precios.length; k++) {
                if (precios[k] == max) {
                    maxstr = nombres[k];
                }
            }
            
            // Producto con precio menor
            for (int l = 0; l < precios.length; l++) {
                if (precios[l] == min) {
                    minstr = nombres[l];
                }
            } 
            
            double promedio = 0;
            double suma = 0;
            double inventario = 0;
            
            // Promedio de precios
            for (int m = 0; m < dickeys; m++) {
                suma += precios[m];
            }
            
            
            // Valor del inventario
            for (int n = 0; n < dickeys; n++) {
                inventario += precios[n] * inventarios[n];
            }
            
            
            // Formateamos las salidas
            promedio += suma / (double)dickeys;
            
            DecimalFormatSymbols punto = new DecimalFormatSymbols();
            punto.setDecimalSeparator('.');
            DecimalFormat formateo = new DecimalFormat("#.0", punto);
            
            String promedion = formateo.format(promedio);
            String inventarion = formateo.format(inventario);
            
            
            
            return maxstr + " " + minstr + " " + promedion + " " + inventarion;
        }
    }

}
 



/**
*  Clase que contiene el main y lo principal
*/
class Reto2 {

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);
    

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read() {
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
    public void run() {
        
        /*
        solución propuesta
        */

        // ------------------ < Datos > ------------------
        
        Producto pro1 = new Producto(1, "Mango", 7000.0, 99);
        Producto pro2 = new Producto(2, "Limones", 3600.0, 95);
        Producto pro3 = new Producto(3, "Peras", 2700.0, 85);
        Producto pro4 = new Producto(4, "Arandanos", 8300.0, 74);
        Producto pro5 = new Producto(5, "Tomates", 8400.0, 44);
        Producto pro6 = new Producto(6, "Fresas", 7100.0, 99);
        Producto pro7 = new Producto(7, "Helado", 4400.0, 98);
        Producto pro8 = new Producto(8, "Galletas", 400.0, 99);
        Producto pro9 = new Producto(9, "Chocolates", 4500.0, 90);
        Producto pro10 = new Producto(10, "Jamon", 17000.0, 89);
        
        BaseDatosProductos base = new BaseDatosProductos();
        
        base.listaProductos.put(pro1.getCodigo(), pro1);
        base.listaProductos.put(pro2.getCodigo(), pro2);
        base.listaProductos.put(pro3.getCodigo(), pro3);
        base.listaProductos.put(pro4.getCodigo(), pro4);
        base.listaProductos.put(pro5.getCodigo(), pro5);
        base.listaProductos.put(pro6.getCodigo(), pro6);
        base.listaProductos.put(pro7.getCodigo(), pro7);
        base.listaProductos.put(pro8.getCodigo(), pro8);
        base.listaProductos.put(pro9.getCodigo(), pro9);
        base.listaProductos.put(pro10.getCodigo(), pro10);
        
        
   
        
        // ------------------ < Entradas > ------------------
        
        String entrada1 = read();
        String entrada2 = read();
        
        String lista[] = entrada2.split(" ");
        
        int codigo = Integer.parseInt(lista[0]);
        String nombre = lista[1];
        double precio = Integer.parseInt(lista[2]);
        int inventario = Integer.parseInt(lista[3]);
        
        Producto pro11 = new Producto(codigo, nombre, precio, inventario);
        
        
        
        // ------------------ < Programa > ------------------
        
        boolean averif = base.verificarExistencia(codigo);
        boolean errora = false;
        
        
        switch (entrada1) {
            
            case "ACTUALIZAR":
                if (averif == false) {
                    errora = true;  
                    break;
                }
                
                base.agregar(codigo, pro11);
                break;
                
            case "BORRAR":
                if (averif == false) {
                    errora = true;
                    break;
                }
                
                base.eliminar(codigo);
                break;
           
            case "AGREGAR":
                if (averif) {
                    errora = true;
                    break;
                }
                
                base.agregar(codigo, pro11);
                break;
            
            default:
                errora = true;
                
        }
        
        
        
        // ------------------ < Salida > ------------------
        
        System.out.println(base.generarInforme(errora));
        
        
    }


    
    /*public static void main(String[] args) {

        Reto2 codigo = new Reto2();
        codigo.run();

    }*/

}


