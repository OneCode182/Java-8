// - - - - - - - - - - <  > - - - - - - - - - -
package Swing;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author One Code
 */
public class MoverVentana extends JFrame {
    
    
    private JLabel label; // Label el cual sera la barra para mover la ventana
    private int x, y; // Coordenadas del mouse
    
    /**
     * 
     * @param args 
     * Metodo main
     */
    public static void main(String[] args) {
        new MoverVentana().setVisible(true);
        
    }
    
    /**
     * Constructor default
     */
    public MoverVentana() {
        initGUI();
        
    }

    /**
     * Componentes iniciales
     */
    private void initGUI() {
        
        // - - - - - - - - - - < Config ventana > - - - - - - - - - -
        this.setLayout(null);
        this.setTitle("Mover ventana");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        // - - - - - - - - - - < Label > - - - - - - - - - -
        label = new JLabel();
        label.setBounds(0, 230, 500, 50);
        label.setOpaque(true);
        label.setBackground(Color.RED);
        
        
        /**
         * Manejador de evento de presionar el mouse
         */
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                
                clickLabel(evt);
                
            }
        });
        
        /**
         * Manejador de evento de mantener el mouse
         */
        label.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                
                sostenerLabel(evt);
                
            }
        });
        
        add(label);
        
    }
    
    /**
     * 
     * @param evt 
     * Al clickear, este metodo guarda las coordenadas del mouse
     */
    private void clickLabel(MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
        
    }
    
    /**
     * 
     * @param evt 
     * Este metodo, implementa el algoritmo de mover ventana
     * Utiliza las coordenadas del metodo 'clickLabel' y hace que sean paralelas
     * a la ventana.
     * Como son eventos, este evento de mantener es un bucle si se mantiene el
     * mouse presionado
     */
    private void sostenerLabel(MouseEvent evt) {
        this.setLocation(this.getLocation().x + evt.getX() - x,
        this.getLocation().y + evt.getY() - y);
        
    }
    
}
