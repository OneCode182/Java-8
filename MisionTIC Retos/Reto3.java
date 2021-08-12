// ------------------ <  > ------------------

import java.util.Scanner;
import java.util.HashMap;



/**
 * Clase del codigo principal
 */
class Reto3 {

    /**
     *  Único objeto de tipo Scanner en el código
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
     * Método principal
     */
    public void run() { 
        
    
        BaseDatosProductos base = new BaseDatosProductos();



        // ------------------ < Entradas > ------------------

        String entrada1 = read();
        String entrada2 = read();

        String lista[] = entrada2.split(" ");

        int codigo = Integer.parseInt(lista[0]);
        String nombre = lista[1];
        double precio = Integer.parseInt(lista[2]);
        int inventario = Integer.parseInt(lista[3]);



        // ------------------ < Programa > ------------------


        boolean verificarProducto = base.verificarExistencia(codigo);
        boolean errorEntradas = false;
        Producto productoNuevo = new Producto(codigo, nombre, precio, inventario);
        


        switch (entrada1) {
            
            case "AGREGAR":
                if (verificarProducto) {
                    errorEntradas = true;
                    break;
                }

                base.agregar(codigo, productoNuevo);
                break;

            case "ACTUALIZAR":
                if (verificarProducto == false) {
                    errorEntradas = true;
                    break;
                } 

                base.actualizar(codigo, productoNuevo);
                break;

            case "BORRAR":
                if (verificarProducto == false) {
                    errorEntradas = true;
                    break;
                }

                base.eliminar(codigo);
                break;

            default:
                errorEntradas = true;

        }




        // ------------------ < Salidas > ------------------
        
        System.out.println(base.generarInforme(errorEntradas));
       
    }


    /*public static void main(String[] args) {
        Reto3 code = new Reto3();
        code.run();
    }*/

}



/**
 * Contiene los datos del programa
 */
class BaseDatosProductos {

    // ------------------ < Hashmap > ------------------
    /**
     * Base de datos
     */
    private HashMap<Integer, Producto> listaProductos = new HashMap<>();

    // ------------------ < Metodos > ------------------
    /**
     * Constructor
     */
    public BaseDatosProductos() {

        listaProductos.put(1, new Producto(1, "Mango", 7000.0, 99));
        listaProductos.put(2, new Producto(2, "Limones", 3600.0, 95));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 85));
        listaProductos.put(4, new Producto(4, "Arandanos", 8300.0, 74));
        listaProductos.put(5, new Producto(5, "Tomates", 8400.0, 44));
        listaProductos.put(6, new Producto(6, "Fresas", 7100.0, 99));
        listaProductos.put(7, new Producto(7, "Helado", 4400.0, 98));
        listaProductos.put(8, new Producto(8, "Galletas", 400.0, 99));
        listaProductos.put(9, new Producto(9, "Chocolates", 4500.0, 90));
        listaProductos.put(10, new Producto(10, "Jamon", 17000.0, 89));

    }


    /**
     *  Agregar
     */
    public void agregar(Integer codigo, Producto prod) {
        listaProductos.put(codigo, prod);
    }


    /**
     *  Actualizar
     */
    public void actualizar(Integer codigo, Producto prod) {
        listaProductos.replace(codigo, prod);
    }


    /**
     *  Eliminar
     */
    public void eliminar(int codigo) {
        listaProductos.remove(codigo);
    }


    /**
     *  Verificar un producto
     */
    public boolean verificarExistencia(int codigo) {
        return listaProductos.containsKey(codigo);
    }


    /**
     *  Se crea la salida del programa
     */
    public String generarInforme(boolean mensajeError) {
        if (mensajeError) {
            return "ERROR";
        } 
        
        String[] productosM = new String[3];
        double[] preciosM = new double[3];
        

        for (int i = 0; i < 3; i++) {
            for (Producto item : listaProductos.values()) {

                if (i == 0) {
                    if (item.getPrecio() > preciosM[i]) {
                        
                        preciosM[i] = item.getPrecio();
                        productosM[i] = item.getNombre();

                    }

                } else if (i == 1) {
                    if (item.getPrecio() != preciosM[0] &&
                       item.getPrecio() > preciosM[i]) {

                        preciosM[i] = item.getPrecio();
                        productosM[i] = item.getNombre();

                    }


                } else if (i == 2) {
                    if (item.getPrecio() != preciosM[0] &&
                       item.getPrecio() != preciosM[1] &&
                       item.getPrecio() > preciosM[i]) {

                        preciosM[i] = item.getPrecio();
                        productosM[i] = item.getNombre();

                    }

                }

            }

        }

        return productosM[0] + " " +
               productosM[1] + " " +
               productosM[2];

    }

}




/**
 * Plantilla de un producto
 */
class Producto {

    // ------------------ < Atributos > ------------------
    /**
     * Codigo
     */
    private int codigo;

    /**
     * Nombre
     */
    private String nombre;

    /**
     * Precio
     */
    private Double precio;

    /**
     * Inventario
     */
    private int inventario;



    // ------------------ < Metodos > ------------------
    /**
     * Constructor
     */
    public Producto(Integer codigo, String nombre, Double precio, Integer inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    
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

    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    public void setNombre(String nombre) {
        this.codigo = codigo;
    }

    
    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public void setInventario(int inventario) {
        this.inventario = inventario;
    }


    /**
     * Obtener los atributos juntos
     */
    public String getAtributos() {
        return codigo + " " + nombre + " " + precio + " " + inventario;
    }

}

