package alan.analizador;

import alan.analizador.interfaz.Instrucciones;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Alan
 */
public class Main {

    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {}

        Instrucciones n = new Instrucciones();
        n.setLocationRelativeTo(null);
        n.setExtendedState(n.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        n.setVisible(true);
    }
}
